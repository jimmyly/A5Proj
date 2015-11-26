package group6.umass.edu.location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import sql.GPSLocation;

// source: https://code.google.com/p/convex-hull/source/browse/Convex+Hull/src/algorithms/FastConvexHull.java?r=4
public class FastConvexHull 
{
        public static ArrayList<GPSLocation> execute(GPSLocation[] points) 
        {
                ArrayList<GPSLocation> xSorted = new ArrayList<GPSLocation>(Arrays.asList(points));
                Collections.sort(xSorted, new XCompare());
                
                int n = xSorted.size();
                
                GPSLocation[] lUpper = new GPSLocation[n];
                
                lUpper[0] = xSorted.get(0);
                lUpper[1] = xSorted.get(1);
                
                int lUpperSize = 2;
                
                for (int i = 2; i < n; i++)
                {
                        lUpper[lUpperSize] = xSorted.get(i);
                        lUpperSize++;
                        
                        while (lUpperSize > 2 && !rightTurn(lUpper[lUpperSize - 3], lUpper[lUpperSize - 2], lUpper[lUpperSize - 1]))
                        {
                                // Remove the middle GPSLocation of the three last
                                lUpper[lUpperSize - 2] = lUpper[lUpperSize - 1];
                                lUpperSize--;
                        }
                }
                
                GPSLocation[] lLower = new GPSLocation[n];
                
                lLower[0] = xSorted.get(n - 1);
                lLower[1] = xSorted.get(n - 2);
                
                int lLowerSize = 2;
                
                for (int i = n - 3; i >= 0; i--)
                {
                        lLower[lLowerSize] = xSorted.get(i);
                        lLowerSize++;
                        
                        while (lLowerSize > 2 && !rightTurn(lLower[lLowerSize - 3], lLower[lLowerSize - 2], lLower[lLowerSize - 1]))
                        {
                                // Remove the middle GPSLocation of the three last
                                lLower[lLowerSize - 2] = lLower[lLowerSize - 1];
                                lLowerSize--;
                        }
                }
                
                ArrayList<GPSLocation> result = new ArrayList<GPSLocation>();
                
                for (int i = 0; i < lUpperSize; i++)
                {
                        result.add(lUpper[i]);
                }
                
                for (int i = 1; i < lLowerSize - 1; i++)
                {
                        result.add(lLower[i]);
                }
                
                return result;
        }
        
        private static boolean rightTurn(GPSLocation a, GPSLocation b, GPSLocation c)
        {
                return (b.longitude - a.longitude)*(c.latitude - a.latitude) - (b.latitude - a.latitude)*(c.longitude - a.longitude) > 0;
        }

        private static class XCompare implements Comparator<GPSLocation>
        {
                @Override
                public int compare(GPSLocation o1, GPSLocation o2) 
                {
                        return (new Double(o1.longitude)).compareTo(new Double(o2.longitude));
                }
        }
}