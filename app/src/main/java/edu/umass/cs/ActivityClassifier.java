package edu.umass.cs;


public class ActivityClassifier {

    public static double classify(Object[] i)
            throws Exception {

        double p = Double.NaN;
        p = ActivityClassifier.N6809c8010(i);
        return p;
    }
    static double N6809c8010(Object []i) {
        double p = Double.NaN;
        if (i[34] == null) {
            p = 1;
        } else if (((Double) i[34]).doubleValue() <= 0.5994567988636929) {
            p = 1;
        } else if (((Double) i[34]).doubleValue() > 0.5994567988636929) {
            p = ActivityClassifier.N5a29ef031(i);
        }
        return p;
    }
    static double N5a29ef031(Object []i) {
        double p = Double.NaN;
        if (i[18] == null) {
            p = 2;
        } else if (((Double) i[18]).doubleValue() <= 6.6150278579932325) {
            p = 2;
        } else if (((Double) i[18]).doubleValue() > 6.6150278579932325) {
            p = 0;
        }
        return p;
    }
}
