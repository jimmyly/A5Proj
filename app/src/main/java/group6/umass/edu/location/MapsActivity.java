package group6.umass.edu.location;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

import DBScan.DBScan;
import edu.umass.cs.client.R;
import sql.GPSLocation;
import sql.LocationDAO;
import group6.umass.edu.location.FastConvexHull;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import DBScan.Cluster;

import static edu.umass.cs.client.R.layout.activity_maps;

public class MapsActivity extends FragmentActivity {
	
	private static final String TAG = "MapActivity";
    
    /**
     * Note that this may be null if the Google Play services APK is not available.
     */
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_maps);
        setUpMapIfNeeded();
    }

    
    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. 
     * <p>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
    	/*** 
    	 * This plots a polygon around UMass CS building **
    	PolygonOptions options = new PolygonOptions();
    	mMap.addMarker(new MarkerOptions().position(new LatLng(42.395456,-72.529517)).title("Marker"));
    	options.add(new LatLng(42.395456,-72.529517), new LatLng(42.395059,-72.530086), new LatLng(42.394592,-72.531685), new LatLng(42.394956,-72.532339), new LatLng(42.395511,-72.53206), new LatLng(42.395868,-72.53059));	
        options = options.strokeColor(Color.RED).fillColor(Color.BLUE);
    	mMap.addPolygon(options);
    	/***/
    	LocationDAO dao = new LocationDAO(getApplicationContext());
    	dao.openRead();
    	GPSLocation[] locations = dao.getAllLocations();
    	dao.close();
    	// adds the first point as a marker.


            for (GPSLocation gps : locations) {
                mMap.addMarker(new MarkerOptions().position(new LatLng(gps.latitude, gps.longitude)).title("Marker"));
                //TODO:: Cluster all locations. Instead of the call below that draws a convex hull around all your points,
                // 				you will draw a polygon from each cluster identified by the DBScan algorithm
                drawHullFromPoints(locations);
            }


    	/***/
    }
    private void drawHullFromPoints(GPSLocation[] locations) {
        //list of clusters

        GPSLocation[] wrapper = new GPSLocation[locations.length];
        List<Cluster<GPSLocation>> clusters = new ArrayList<Cluster<GPSLocation>>();


        DBScan<GPSLocation> scan = new DBScan<GPSLocation>(10,10);
        //wrapping GPSlocation to GPspt in order to compare each coordinate provided by GPSLocation
    
        clusters = scan.cluster( Arrays.asList(locations));

        for(Cluster<GPSLocation> c : clusters) {
            wrapper = c.getPoints().toArray(wrapper);


        ArrayList<GPSLocation> hull = FastConvexHull.execute(locations);
            //wrapper = new GPSLocation[locations.length];
        PolygonOptions options = new PolygonOptions();
        for(GPSLocation loc : hull){
            options.add(new LatLng(loc.latitude,loc.longitude));  
        }
        options = options.strokeColor(Color.RED).fillColor(Color.BLUE);
        mMap.addPolygon(options); // draw a polygon

    }




        }

        /*
        *unwrapping each cluster in the list of clusters,
        *then iterating through each unwrapped cluster (becomes type GPSLocation) and drawing the hulls of each cluster
        */





/*    	ArrayList<GPSLocation> hull = FastConvexHull.execute(locations);
    	PolygonOptions options = new PolygonOptions();
    	for(GPSLocation loc : hull){
    		options.add(new LatLng(loc.latitude-0.04,loc.longitude-0.05));	
    	}
        options = options.strokeColor(Color.RED).fillColor(Color.BLUE);
    	mMap.addPolygon(options); // draw a polygon
    }*/
} 