package edu.umass.cs.client;


import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import java.util.ArrayList;

import edu.umass.cs.ActivityClassifier;
import edu.umass.cs.accelerometer.ActivityFeatureExtractor;
import edu.umass.cs.accelerometer.Filter;
import edu.umass.cs.accelerometer.ReorientAxis;
import edu.umass.cs.voice.FeatureExtractor;
import edu.umass.cs.voice.MicrophoneRecorder;
import edu.umass.cs.voice.MicrophoneRecorder.MicrophoneListener;
import edu.umass.cs.voice.SpeechDetector;
import sql.GPSLocation;
import sql.LocationDAO;

//import voice stuff
//import database stuff

/**
 *
 * Context_Service: This is a sample class to reads sensor data (accelerometer).
 *
 * @author CS390MB
 *
 */
public class Context_Service extends Service implements SensorEventListener, MicrophoneListener, LocationListener{

	//my variables

	double dynamicThreshold = 0;
	int thresholdXYZ = 0; // 0 = x, 1 = y, 2 = z
	double[] maxThreshold ={0,0,0};
	double[] minThreshold = {100,100,100};
	int thresholdCounter = 0;
	long previousStep = 0;
	int thresholdReachedCounter = 0;

	double x = 0;
	double y = 0;
	double z = 0;

	double padding = 1.5;


	/**
	 * Class to orient axis
	 */

	private ReorientAxis orienter = null;
	/**
	 * Feature extractor
	 */
	private ActivityFeatureExtractor extractor = null;


	/**
	 * Notification manager to display notifications
	 */
	private NotificationManager nm;

	/**
	 * SensorManager
	 */
	private SensorManager mSensorManager;
	/**
	 * Accelerometer Sensor
	 */
	private Sensor mAccelerometer;

	//location manager
	LocationManager locationManager;

	//Microphone Recorder
	private MicrophoneRecorder microphoneRecorder;

	//List of bound clients/activities to this service
	ArrayList<Messenger> mClients = new ArrayList<Messenger>();

	//Message codes sent and received by the service
	static final int MSG_REGISTER_CLIENT = 1;
	static final int MSG_UNREGISTER_CLIENT = 2;
	static final int MSG_ACTIVITY_STATUS = 3;
	static final int MSG_STEP_COUNTER = 4;
	static final int MSG_ACCEL_VALUES = 5;
	static final int MSG_START_ACCELEROMETER = 6;
	static final int MSG_STOP_ACCELEROMETER = 7;
	static final int MSG_ACCELEROMETER_STARTED = 8;
	static final int MSG_ACCELEROMETER_STOPPED = 9;

	//New microphone variables
	static final int MSG_START_MICROPHONE = 10;
	static final int MSG_STOP_MICROPHONE = 11;
	static final int MSG_MICROPHONE_STARTED = 12;
	static final int MSG_MICROPHONE_STOPPED = 13;
	static final int MSG_SPEECH_VALUE = 14;

	//New location variables
	static final int MSG_START_LOCATION = 15;
	static final int MSG_STOP_LOCATION = 16;
	static final int MSG_LOCATION_STARTED = 17;
	static final int MSG_LOCATION_STOPPED = 18;
	static final int MSG_LOCATION_UPDATE = 19;
	private final int MIN_TIME = 5000;
	private final int MIN_DISTANCE = 0;

	static Context_Service sInstance = null;
	private static boolean isRunning = false;
	private static boolean isAccelRunning = false;
	private static boolean isMicrophoneRunning = false;
	private static boolean isLocationRunning = false;
	private static final int NOTIFICATION_ID = 777;

	LocationDAO locationDAO;

	/**
	 * Filter class required to filter noise from accelerometer
	 */
	private Filter filter = null;
	/**
	 * Step count to be displayed in UI
	 */
	private int stepCount = 0;
	/**
	 * Activity status to be displayed in UI
	 */
	private int activityStatus = 0;



	//Messenger used by clients
	final Messenger mMessenger = new Messenger(new IncomingHandler());

	public static boolean isMicrophoneRunning() {
		return isMicrophoneRunning;
	}

	public static boolean isLocationRunning() {
		return isLocationRunning;
	}

	@Override
	public void onLocationChanged(Location location) {

		if(isLocationRunning()) {

			locationDAO = new LocationDAO(Context_Service.this);
			locationDAO.openWrite();
			locationDAO.insert(new GPSLocation(location.getTime(), location.getLatitude(), location.getLongitude(), location.getAccuracy()));
			locationDAO.close();

			latitude = location.getLatitude();
			longitude = location.getLongitude();

			Log.d("Position", "" + latitude + " " + longitude);
		}
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {

	}

	@Override
	public void onProviderEnabled(String provider) {

	}

	@Override
	public void onProviderDisabled(String provider) {

	}

	/**
	 * Handler to handle incoming messages
	 */
	@SuppressLint("HandlerLeak")
	class IncomingHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case MSG_REGISTER_CLIENT:
					mClients.add(msg.replyTo);
					break;
				case MSG_UNREGISTER_CLIENT:
					mClients.remove(msg.replyTo);
					break;
				case MSG_START_ACCELEROMETER:
				{
					isAccelRunning = true;
					mSensorManager.registerListener(sInstance, mAccelerometer, SensorManager.SENSOR_DELAY_GAME);
					sendMessageToUI(MSG_ACCELEROMETER_STARTED);
					showNotification();
					//Set up filter
					//Following sets up smoothing filter from mcrowdviz
					int SMOOTH_FACTOR = 4;
					filter = new Filter(SMOOTH_FACTOR);
					//OR Use Butterworth filter from mcrowdviz
					//double CUTOFF_FREQUENCY = 0.3;
					//filter = new Filter(CUTOFF_FREQUENCY);
					stepCount = 0;
					activityStatus = 0;

					//Set up orienter
					orienter = new ReorientAxis();
					long WINDOW_IN_MILLISECONDS = 5000; //5seconds
					//Set up a feature extractor that extracts features every 5 seconds
					extractor = new ActivityFeatureExtractor(5000);
					break;
				}
				case MSG_STOP_ACCELEROMETER:
				{
					isAccelRunning = false;
					mSensorManager.unregisterListener(sInstance);
					sendMessageToUI(MSG_ACCELEROMETER_STOPPED);
					showNotification();
					//Free filter and step detector
					filter = null;

					orienter = null;
					extractor = null;

					break;
				}
				case MSG_START_MICROPHONE: {
					isMicrophoneRunning = true;
					microphoneRecorder = MicrophoneRecorder.getInstance();
					microphoneRecorder.registerListener(sInstance);
					microphoneRecorder.startRecording();
					sendMessageToUI(MSG_MICROPHONE_STARTED);
					showNotification();
					break;
				}

				case MSG_STOP_MICROPHONE:
				{
					isMicrophoneRunning = false;
					microphoneRecorder.stopRecording();
					microphoneRecorder.unregisterListener(sInstance);
					sendMessageToUI(MSG_MICROPHONE_STOPPED);
					showNotification();
					break;
				}
				case MSG_START_LOCATION: {
					//to show that this is running
					isLocationRunning = true;

					//instantiate the locationManager
					locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);



					//get location updates
					locationManager.requestLocationUpdates(
							LocationManager.NETWORK_PROVIDER,
							MIN_TIME,
							MIN_DISTANCE,
							sInstance,
							getMainLooper()

					);



					/*location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

					if(location != null){
						onLocationChanged(location);
					}*/

					sendMessageToUI(MSG_LOCATION_STARTED);
					showNotification();
					break;
				}

				case MSG_STOP_LOCATION:{
					//stop getting the location
					isLocationRunning = false;
					locationManager.removeUpdates(Context_Service.this);
					locationDAO = new LocationDAO(Context_Service.this);
					locationDAO.openWrite();
					locationDAO.deleteAll();
					locationDAO.close();
					sendMessageToUI(MSG_LOCATION_STOPPED);
					showNotification();
					break;
				}

				default:
					super.handleMessage(msg);
			}
		}
	}

	boolean isGPSEnabled = false;
	boolean isNetworkEnabled = false;
	boolean canGetLocation = false;
	Location location;
	Double latitude, longitude;

	private void getLocation() {


	}


	private void sendMessageToUI(int message) {
		for (int i=mClients.size()-1; i>=0; i--) {
			try {
				// Send message value
				mClients.get(i).send(Message.obtain(null, message));
			} catch (RemoteException e) {
				// The client is dead. Remove it from the list; we are going through the list from back to front so this is safe to do inside the loop.
				mClients.remove(i);
			}
		}
	}

	private void sendAccelValuesToUI(float accX, float accY, float accZ) {
		for (int i=mClients.size()-1; i>=0; i-- ) {
			try {

				//Send Accel Values
				Bundle b = new Bundle();
				b.putFloat("accx", accX);
				b.putFloat("accy", accY);
				b.putFloat("accz", accZ);
				Message msg = Message.obtain(null, MSG_ACCEL_VALUES);
				msg.setData(b);
				mClients.get(i).send(msg);

			} catch (RemoteException e) {
				// The client is dead. Remove it from the list; we are going through the list from back to front so this is safe to do inside the loop.
				mClients.remove(i);
			}
		}
	}

	private void sendSpeechStatusToUI(int speech){
		for (int i=mClients.size()-1; i>=0; i-- ) {
			try {

				//Send Speech Value
				Bundle b = new Bundle();
				b.putInt("speech", speech);
				Message msg = Message.obtain(null, MSG_SPEECH_VALUE);
				msg.setData(b);
				mClients.get(i).send(msg);

			} catch (RemoteException e) {
				// The client is dead. Remove it from the list; we are going through the list from back to front so this is safe to do inside the loop.
				mClients.remove(i);
			}
		}
	}

	private void sendUpdatedStepCountToUI() {
		for (int i=mClients.size()-1; i>=0; i-- ) {
			try {
				//Send Step Count
				Message msg = Message.obtain(null, MSG_STEP_COUNTER,stepCount,0);
				mClients.get(i).send(msg);

			} catch (RemoteException e) {
				// The client is dead. Remove it from the list; we are going through the list from back to front so this is safe to do inside the loop.
				mClients.remove(i);
			}
		}
	}

	private void sendUpdatedActivityToUI(String activity) {
		for (int i=mClients.size()-1; i>=0; i-- ) {
			try {
				//Send Activity Status
				Bundle b = new Bundle();
				Message msg = Message.obtain(null, MSG_ACTIVITY_STATUS);
				b.putString("activity", activity);
				msg.setData(b);
				mClients.get(i).send(msg);

			} catch (RemoteException e) {
				// The client is dead. Remove it from the list; we are going through the list from back to front so this is safe to do inside the loop.
				mClients.remove(i);
			}
		}
	}

	/**
	 * On Binding, return a binder
	 */
	@Override
	public IBinder onBind(Intent intent) {
		return mMessenger.getBinder();
	}





	//Start service automatically if we reboot the phone
	public static class Context_BGReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			Intent bootUp = new Intent(context,Context_Service.class);
			context.startService(bootUp);
		}
	}

	@SuppressWarnings("deprecation")
	private void showNotification() {
		//Cancel previous notification
		if(nm!=null)
			nm.cancel(NOTIFICATION_ID);
		else
			nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

		// The PendingIntent to launch our activity if the user selects this notification
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);

		// Use the commented block of code if your target environment is Android-16 or higher
      /*Notification notification = new Notification.Builder(this)
      .setContentTitle("Context Service")
      .setContentText("Running").setSmallIcon(R.drawable.icon)
      .setContentIntent(contentIntent)
      .build();

      nm.notify(NOTIFICATION_ID, notification); */

		/*//For lower versions of Android, the following code should work
		Notification notification = new Notification();
		notification.icon = R.drawable.icon;
		notification.tickerText = getString(R.string.app_name);
		notification.contentIntent = contentIntent;
		notification.when = System.currentTimeMillis();*/
		/*if(isAccelerometerRunning()) {
			//notification.setLatestEventInfo(getApplicationContext(), getString(R.string.app_name), "Accelerometer Running", contentIntent);
		}
		else
			notification.setLatestEventInfo(getApplicationContext(), getString(R.string.app_name), "Accelerometer Not Started", contentIntent);
*/
		// Send the notification.
		//nm.notify(NOTIFICATION_ID, notification);
	}

	/* getInstance() and isRunning() are required by the */
	static Context_Service getInstance(){
		return sInstance;
	}

	protected static boolean isRunning(){
		return isRunning;
	}

	protected static boolean isAccelerometerRunning() {
		return isAccelRunning;
	}



	@Override
	public void onCreate() {
		super.onCreate();
		showNotification();
		isRunning = true;
		sInstance = this;
		mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
		mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		nm.cancel(NOTIFICATION_ID); // Cancel the persistent notification.
		isRunning = false;
		//Don't let Context_Service die!
		Intent mobilityIntent = new Intent(this,Context_Service.class);
		startService(mobilityIntent);
	}



	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return START_STICKY; // run until explicitly stopped.
	}


	/* (non-Javadoc)
     * @see android.hardware.SensorEventListener#onAccuracyChanged(android.hardware.Sensor, int)
     */
	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {

	}

	/* (non-Javadoc)
     * @see android.hardware.SensorEventListener#onSensorChanged(android.hardware.SensorEvent)
     */
	@Override
	public void onSensorChanged(SensorEvent event) {
		if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

			float accel[] = event.values;
			sendAccelValuesToUI(accel[0], accel[1], accel[2]);




			/**
			 * TODO: Step Detection
			 */
			//First, Get filtered values
			double filtAcc[] = filter.getFilteredValues(accel[0], accel[1], accel[2]);

			setDynamicThreshold(filtAcc[0], filtAcc[1], filtAcc[2]);
			//Now, increment 'stepCount' variable if you detect any steps here
			stepCount += detectSteps(filtAcc[0], filtAcc[1], filtAcc[2]);
			//detectSteps() is not implemented



			//Add the following for the Classify Project
			long time = event.timestamp/1000000; //convert time to milliseconds from nanoseconds
			//Orient accelerometer
			double ortAcc[] =
					orienter.getReorientedValues(accel[0], accel[1], accel[2]);

			//Extract Features now
			Double features[] = extractor.extractFeatures(time, ortAcc[0], ortAcc[1], ortAcc[2], accel[0], accel[1], accel[2]);

			//Feature vector is not null only when it has buffered
			//at least 5 seconds of data

			if(features!=null) {
				//Classify
				try{
					double classId = ActivityClassifier.classify(features);

					//TODO: 1. The activity labels below will depend on activities in your data set
					String activity = null;
					if(classId == 0.0) activity= "walking";
					else if(classId == 1.0) activity = "stationary";
					else if(classId == 2.0) activity = "climb-up stairs";

					//TODO: 2. Send new activity label to UI
					sendUpdatedActivityToUI(activity);

				}catch(Exception e){
					e.printStackTrace();
				}
			}





			sendUpdatedStepCountToUI();

		}

	}

	/**
	 * This should return number of steps detected.
	 * @param filt_acc_x
	 * @param filt_acc_y
	 * @param filt_acc_z
	 * @return
	 */
	public int detectSteps(double filt_acc_x, double filt_acc_y, double filt_acc_z) {
		//Log.i("", "entered the detect steps");
		if(thresholdXYZ == 0) {
			//Log.i("", "entered the detect steps X PORTION!!: "+ Math.abs(filt_acc_x));
			//Log.i("","this is the dynamimc threshold: " + Math.abs(dynamicThreshold)+padding);
			if (Math.abs(filt_acc_x) > Math.abs(dynamicThreshold)+ padding && checkTime()) {
				//Log.i("", "entered the detect steps X PORTION!!: "+ Math.abs(filt_acc_x));
				//Log.i("","this is the dynamimc threshold: " + Math.abs(dynamicThreshold));
				return 1;
			}
		}
		if(thresholdXYZ == 1){
			if(Math.abs(filt_acc_y) > Math.abs(dynamicThreshold)+ padding && checkTime()){
				//Log.i("", "entered the detect steps Y PORTION!!");
				return 1;
			}
		}
		if(thresholdXYZ == 2){
			//Log.i("", "THIS IS THE VALUE OF THE THRESHOLD FOR Z: " + Math.abs(dynamicThreshold));
			if(Math.abs(filt_acc_z) > Math.abs(dynamicThreshold)+ padding && checkTime()){
				//Log.i("", "entered the detect steps z  INNER-part");
				return 1;
			}
		}


		return 0;
	}

	public void setDynamicThreshold(double filt_acc_x, double filt_acc_y, double filt_acc_z){
		//Log.i("", "Just entered the dynamimcThreshould call");
		if(thresholdCounter >= 25){
			thresholdReachedCounter++;
			if(thresholdReachedCounter == 1){
				stepCount = 0;
			}

			//Log.i("", "entered the 50 or more mark");
			//finding the max value out of the three


			x = (maxThreshold[0]+minThreshold[0])/2;
			y = (maxThreshold[1]+minThreshold[1])/2;
			z = (maxThreshold[2]+minThreshold[2])/2;



			if(x >= y && x >= z){
				//Log.i("", "set x");
				dynamicThreshold = x;
				thresholdXYZ = 0;
			}else if(y >= x && y >= z){
				//Log.i("", "set y");
				dynamicThreshold = y;
				thresholdXYZ = 1;
			}else{
				//Log.i("", "set z");
				dynamicThreshold = z;
				thresholdXYZ = 2;
			}

			thresholdCounter = 0;
			maxThreshold[0] = 0;
			maxThreshold[1] = 0;
			maxThreshold[2] = 0;
			minThreshold[0] = 100;
			minThreshold[1] = 100;
			minThreshold[2] = 100;

		}else{
			thresholdCounter++;
		}//this could be a problem, because when you hit the 50 and set to zero it will still go through this
		//For Max
		//Log.i("", "got to the max min area");
		if(filt_acc_x > maxThreshold[0]){
			maxThreshold[0] = filt_acc_x;
		}
		if(filt_acc_y > maxThreshold[1]){
			maxThreshold[1] = filt_acc_y;
		}
		if(filt_acc_z > maxThreshold[2]){
			maxThreshold[2] = filt_acc_z;
		}
		//For Min
		if(filt_acc_x < minThreshold[0]){
			minThreshold[0] = filt_acc_x;
		}
		if(filt_acc_y < minThreshold[1]){
			minThreshold[1] = filt_acc_y;
		}
		if(filt_acc_z < minThreshold[2]){
			minThreshold[2] = filt_acc_z;
		}

	}

	public boolean checkTime() {
		//Log.i("", "This is the time: " + System.currentTimeMillis());
		if (System.currentTimeMillis() - previousStep >= 300) {//&& System.currentTimeMillis()-previousStep < 2
			//this is a valid step
			previousStep = System.currentTimeMillis();
			return true;
		}
		return false;
	}

	private Object[] result = new Object[12];

	@Override
	//This method was declared in an interface in MicrophoneRecorder
	public void microphoneBuffer(short[] buffer, int window_size) {

		//You will break a chunk of one-second-long samples into multiple 25-ms windows.
		// Think about how many of 25-ms windows you will get for a second.

		//number of 25-ms-long windows that contains mostly voice in a second
		int voiced = 0;

		//TODO: Fill out appropriate numbers in the following for loop statement
		//set k < 1000, and added 25 at the beginning of each loop, giving us 40 windows/second
		for(int k=0;k<1000;k+=25){
			//TODO: replace ‘??’ with appropriate numbers below
			double[] features = FeatureExtractor.ComputeFeaturesForFrame(buffer,25,k);
			try{
				result = getObjectDoubleArray(features, result);
				//TODO: classify whether the window is voiced or not
				//If output of the classifier is 0.0d, increment ‘voiced’ variable. If output is 1.0d, it is unvoiced.
				// This is assuming that you have the order of classes written in arff file as: “speech{true,false}.”

				//Use the speech detector to
				double classId = SpeechDetector.classify(result);

				//if the classId is 0.0 add one to voiced
				if (classId == 0.0) voiced++;


			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//TODO: After you find the number of ‘voiced’ windows, determine whether a-second-long
		// audio mostly contain human voice or not by thresholding.
		// Test out different thresholds and choose whichever works the best.
		// Keep in mind that threshold should be less than the number of 25-ms-long windows that contain in a second.
		// If ‘voiced’ variable is greater than a certain threshold, call sendSpeechStatusToUI() with speech variable=1.

		//This gives us the percentage of voiced windows over 1 second
		double threshold = (voiced/40)*100;

		//if the threshold is greater than 50%, most likely they are talking for the one second window
		//need to change if doesn't work, threshold may too high with pauses in voice
		if(threshold > 50){
			sendSpeechStatusToUI(1);
		}else {
			sendSpeechStatusToUI(0);
		}

	}

	public static Object[] getObjectDoubleArray(double[] in,Object[] result){
		for (int i=0;i<in.length;i++){
			result[i] = new Double(in[i]);
		}
		return result;
	}

}













