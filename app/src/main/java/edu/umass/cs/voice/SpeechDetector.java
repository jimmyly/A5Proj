package edu.umass.cs.voice;

/**
 * Created by elisandler on 10/28/15.
 */
public class SpeechDetector {

    public static double classify(Object[] i)
            throws Exception {

        double p = Double.NaN;
        p = SpeechDetector.N1e146c70212(i);
        return p;
    }
    static double N1e146c70212(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= 2.009673659476442) {
            p = SpeechDetector.N4edb3c7d213(i);
        } else if (((Double) i[2]).doubleValue() > 2.009673659476442) {
            p = SpeechDetector.N1b3fd199288(i);
        }
        return p;
    }
    static double N4edb3c7d213(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 80.31943552020563) {
            p = SpeechDetector.N1b605afd214(i);
        } else if (((Double) i[0]).doubleValue() > 80.31943552020563) {
            p = SpeechDetector.N31313429270(i);
        }
        return p;
    }
    static double N1b605afd214(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 62.90167422970288) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() > 62.90167422970288) {
            p = SpeechDetector.N52f5a615215(i);
        }
        return p;
    }
    static double N52f5a615215(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() <= 6.05731245109625) {
            p = SpeechDetector.N7d6ad73f216(i);
        } else if (((Double) i[1]).doubleValue() > 6.05731245109625) {
            p = 0;
        }
        return p;
    }
    static double N7d6ad73f216(Object []i) {
        double p = Double.NaN;
        if (i[6] == null) {
            p = 0;
        } else if (((Double) i[6]).doubleValue() <= 2.2956152536623122) {
            p = SpeechDetector.N7159a96c217(i);
        } else if (((Double) i[6]).doubleValue() > 2.2956152536623122) {
            p = 0;
        }
        return p;
    }
    static double N7159a96c217(Object []i) {
        double p = Double.NaN;
        if (i[9] == null) {
            p = 0;
        } else if (((Double) i[9]).doubleValue() <= -0.3684542900750798) {
            p = SpeechDetector.N35822b97218(i);
        } else if (((Double) i[9]).doubleValue() > -0.3684542900750798) {
            p = SpeechDetector.N2d5c74e247(i);
        }
        return p;
    }
    static double N35822b97218(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() <= 2.6594652333311424) {
            p = SpeechDetector.N74fbe1f2219(i);
        } else if (((Double) i[4]).doubleValue() > 2.6594652333311424) {
            p = 0;
        }
        return p;
    }
    static double N74fbe1f2219(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 0;
        } else if (((Double) i[3]).doubleValue() <= 3.265150140619432) {
            p = SpeechDetector.N44af12de220(i);
        } else if (((Double) i[3]).doubleValue() > 3.265150140619432) {
            p = 0;
        }
        return p;
    }
    static double N44af12de220(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 76.77374456157284) {
            p = SpeechDetector.N41ffd00c221(i);
        } else if (((Double) i[0]).doubleValue() > 76.77374456157284) {
            p = SpeechDetector.N6d5eeaef230(i);
        }
        return p;
    }
    static double N41ffd00c221(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 0;
        } else if (((Double) i[5]).doubleValue() <= 1.5223645985644685) {
            p = SpeechDetector.N1b3e5ae222(i);
        } else if (((Double) i[5]).doubleValue() > 1.5223645985644685) {
            p = 0;
        }
        return p;
    }
    static double N1b3e5ae222(Object []i) {
        double p = Double.NaN;
        if (i[7] == null) {
            p = 0;
        } else if (((Double) i[7]).doubleValue() <= 2.220467786004798) {
            p = SpeechDetector.N49ac0361223(i);
        } else if (((Double) i[7]).doubleValue() > 2.220467786004798) {
            p = SpeechDetector.N70950d85228(i);
        }
        return p;
    }
    static double N49ac0361223(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 68.00439656024875) {
            p = SpeechDetector.N3c11fb10224(i);
        } else if (((Double) i[0]).doubleValue() > 68.00439656024875) {
            p = 0;
        }
        return p;
    }
    static double N3c11fb10224(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() <= -0.8280349291692688) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() > -0.8280349291692688) {
            p = SpeechDetector.N4079f63f225(i);
        }
        return p;
    }
    static double N4079f63f225(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() <= 3.552961262438803) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() > 3.552961262438803) {
            p = SpeechDetector.N715c32b226(i);
        }
        return p;
    }
    static double N715c32b226(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= -1.3126589908475397) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() > -1.3126589908475397) {
            p = SpeechDetector.N25c03faf227(i);
        }
        return p;
    }
    static double N25c03faf227(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 65.12473204816158) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() > 65.12473204816158) {
            p = 1;
        }
        return p;
    }
    static double N70950d85228(Object []i) {
        double p = Double.NaN;
        if (i[6] == null) {
            p = 1;
        } else if (((Double) i[6]).doubleValue() <= -3.9894700672450147) {
            p = SpeechDetector.N49aad081229(i);
        } else if (((Double) i[6]).doubleValue() > -3.9894700672450147) {
            p = 0;
        }
        return p;
    }
    static double N49aad081229(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() <= -0.20418342838334777) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() > -0.20418342838334777) {
            p = 0;
        }
        return p;
    }
    static double N6d5eeaef230(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= -0.9280803891161136) {
            p = SpeechDetector.N72922901231(i);
        } else if (((Double) i[2]).doubleValue() > -0.9280803891161136) {
            p = 0;
        }
        return p;
    }
    static double N72922901231(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() <= -5.919990757919461) {
            p = SpeechDetector.N59c23b6a232(i);
        } else if (((Double) i[4]).doubleValue() > -5.919990757919461) {
            p = SpeechDetector.N5ecada2f233(i);
        }
        return p;
    }
    static double N59c23b6a232(Object []i) {
        double p = Double.NaN;
        if (i[7] == null) {
            p = 1;
        } else if (((Double) i[7]).doubleValue() <= 3.2938092250281454) {
            p = 1;
        } else if (((Double) i[7]).doubleValue() > 3.2938092250281454) {
            p = 0;
        }
        return p;
    }
    static double N5ecada2f233(Object []i) {
        double p = Double.NaN;
        if (i[9] == null) {
            p = 0;
        } else if (((Double) i[9]).doubleValue() <= -3.0377790989053426) {
            p = SpeechDetector.N57ba7447234(i);
        } else if (((Double) i[9]).doubleValue() > -3.0377790989053426) {
            p = SpeechDetector.N618ec997240(i);
        }
        return p;
    }
    static double N57ba7447234(Object []i) {
        double p = Double.NaN;
        if (i[6] == null) {
            p = 0;
        } else if (((Double) i[6]).doubleValue() <= -0.6787092291935656) {
            p = SpeechDetector.N12280e50235(i);
        } else if (((Double) i[6]).doubleValue() > -0.6787092291935656) {
            p = 0;
        }
        return p;
    }
    static double N12280e50235(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 0;
        } else if (((Double) i[3]).doubleValue() <= -2.40039074647922) {
            p = SpeechDetector.N3c3af80236(i);
        } else if (((Double) i[3]).doubleValue() > -2.40039074647922) {
            p = 0;
        }
        return p;
    }
    static double N3c3af80236(Object []i) {
        double p = Double.NaN;
        if (i[7] == null) {
            p = 0;
        } else if (((Double) i[7]).doubleValue() <= 4.149137222711869) {
            p = SpeechDetector.N2436fe6e237(i);
        } else if (((Double) i[7]).doubleValue() > 4.149137222711869) {
            p = 0;
        }
        return p;
    }
    static double N2436fe6e237(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 79.5226613710131) {
            p = SpeechDetector.N1679fa55238(i);
        } else if (((Double) i[0]).doubleValue() > 79.5226613710131) {
            p = 1;
        }
        return p;
    }
    static double N1679fa55238(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() <= -1.6989761614102126) {
            p = SpeechDetector.N2221edfa239(i);
        } else if (((Double) i[4]).doubleValue() > -1.6989761614102126) {
            p = 0;
        }
        return p;
    }
    static double N2221edfa239(Object []i) {
        double p = Double.NaN;
        if (i[6] == null) {
            p = 1;
        } else if (((Double) i[6]).doubleValue() <= -1.2904654387042502) {
            p = 1;
        } else if (((Double) i[6]).doubleValue() > -1.2904654387042502) {
            p = 0;
        }
        return p;
    }
    static double N618ec997240(Object []i) {
        double p = Double.NaN;
        if (i[10] == null) {
            p = 0;
        } else if (((Double) i[10]).doubleValue() <= 0.32489663147578346) {
            p = SpeechDetector.N65550a8a241(i);
        } else if (((Double) i[10]).doubleValue() > 0.32489663147578346) {
            p = 0;
        }
        return p;
    }
    static double N65550a8a241(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 1;
        } else if (((Double) i[3]).doubleValue() <= -1.230727098841188) {
            p = SpeechDetector.N32271dff242(i);
        } else if (((Double) i[3]).doubleValue() > -1.230727098841188) {
            p = SpeechDetector.N1d61d74d244(i);
        }
        return p;
    }
    static double N32271dff242(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 79.78081704861361) {
            p = SpeechDetector.N26226a12243(i);
        } else if (((Double) i[0]).doubleValue() > 79.78081704861361) {
            p = 0;
        }
        return p;
    }
    static double N26226a12243(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() <= 1.043690676215951) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() > 1.043690676215951) {
            p = 0;
        }
        return p;
    }
    static double N1d61d74d244(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() <= 1.3414381406906004) {
            p = SpeechDetector.N27e0f4d245(i);
        } else if (((Double) i[4]).doubleValue() > 1.3414381406906004) {
            p = 1;
        }
        return p;
    }
    static double N27e0f4d245(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= -1.3481910088360392) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() > -1.3481910088360392) {
            p = SpeechDetector.N221e8982246(i);
        }
        return p;
    }
    static double N221e8982246(Object []i) {
        double p = Double.NaN;
        if (i[8] == null) {
            p = 0;
        } else if (((Double) i[8]).doubleValue() <= -0.9647815220099067) {
            p = 0;
        } else if (((Double) i[8]).doubleValue() > -0.9647815220099067) {
            p = 1;
        }
        return p;
    }
    static double N2d5c74e247(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 0;
        } else if (((Double) i[3]).doubleValue() <= 1.1936868201734645) {
            p = SpeechDetector.N210fd356248(i);
        } else if (((Double) i[3]).doubleValue() > 1.1936868201734645) {
            p = 0;
        }
        return p;
    }
    static double N210fd356248(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 0;
        } else if (((Double) i[5]).doubleValue() <= 0.42916508623274213) {
            p = SpeechDetector.N15fbc40f249(i);
        } else if (((Double) i[5]).doubleValue() > 0.42916508623274213) {
            p = 0;
        }
        return p;
    }
    static double N15fbc40f249(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 67.05287501347208) {
            p = SpeechDetector.N4404c00f250(i);
        } else if (((Double) i[0]).doubleValue() > 67.05287501347208) {
            p = SpeechDetector.N2d0efcbb258(i);
        }
        return p;
    }
    static double N4404c00f250(Object []i) {
        double p = Double.NaN;
        if (i[8] == null) {
            p = 0;
        } else if (((Double) i[8]).doubleValue() <= -1.4016805569809216) {
            p = 0;
        } else if (((Double) i[8]).doubleValue() > -1.4016805569809216) {
            p = SpeechDetector.N13dd3bac251(i);
        }
        return p;
    }
    static double N13dd3bac251(Object []i) {
        double p = Double.NaN;
        if (i[7] == null) {
            p = 0;
        } else if (((Double) i[7]).doubleValue() <= 2.350566580432833) {
            p = SpeechDetector.N2178a364252(i);
        } else if (((Double) i[7]).doubleValue() > 2.350566580432833) {
            p = 0;
        }
        return p;
    }
    static double N2178a364252(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= 1.7263322939279226) {
            p = SpeechDetector.N772f0b66253(i);
        } else if (((Double) i[2]).doubleValue() > 1.7263322939279226) {
            p = 0;
        }
        return p;
    }
    static double N772f0b66253(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() <= -1.218806928235256) {
            p = SpeechDetector.N319592ab254(i);
        } else if (((Double) i[4]).doubleValue() > -1.218806928235256) {
            p = SpeechDetector.N24088bc0257(i);
        }
        return p;
    }
    static double N319592ab254(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() <= 4.91337758273064) {
            p = SpeechDetector.N52d031fb255(i);
        } else if (((Double) i[1]).doubleValue() > 4.91337758273064) {
            p = 0;
        }
        return p;
    }
    static double N52d031fb255(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() <= -2.131434962235699) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() > -2.131434962235699) {
            p = SpeechDetector.N62818036256(i);
        }
        return p;
    }
    static double N62818036256(Object []i) {
        double p = Double.NaN;
        if (i[6] == null) {
            p = 0;
        } else if (((Double) i[6]).doubleValue() <= -0.4026578197113845) {
            p = 0;
        } else if (((Double) i[6]).doubleValue() > -0.4026578197113845) {
            p = 1;
        }
        return p;
    }
    static double N24088bc0257(Object []i) {
        double p = Double.NaN;
        if (i[9] == null) {
            p = 0;
        } else if (((Double) i[9]).doubleValue() <= 0.5464014422377523) {
            p = 0;
        } else if (((Double) i[9]).doubleValue() > 0.5464014422377523) {
            p = 1;
        }
        return p;
    }
    static double N2d0efcbb258(Object []i) {
        double p = Double.NaN;
        if (i[11] == null) {
            p = 0;
        } else if (((Double) i[11]).doubleValue() <= -2.6228128608289296) {
            p = SpeechDetector.N32f27019259(i);
        } else if (((Double) i[11]).doubleValue() > -2.6228128608289296) {
            p = SpeechDetector.N3b2fc0ac262(i);
        }
        return p;
    }
    static double N32f27019259(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() <= -3.7258741191779094) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() > -3.7258741191779094) {
            p = SpeechDetector.N4a9d9370260(i);
        }
        return p;
    }
    static double N4a9d9370260(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 76.41610762726377) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() > 76.41610762726377) {
            p = SpeechDetector.N2f3ac455261(i);
        }
        return p;
    }
    static double N2f3ac455261(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 0;
        } else if (((Double) i[3]).doubleValue() <= 0.8769643652085979) {
            p = 0;
        } else if (((Double) i[3]).doubleValue() > 0.8769643652085979) {
            p = 1;
        }
        return p;
    }
    static double N3b2fc0ac262(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 75.60937914119705) {
            p = SpeechDetector.N3c127a8f263(i);
        } else if (((Double) i[0]).doubleValue() > 75.60937914119705) {
            p = 0;
        }
        return p;
    }
    static double N3c127a8f263(Object []i) {
        double p = Double.NaN;
        if (i[11] == null) {
            p = 0;
        } else if (((Double) i[11]).doubleValue() <= -0.5957986517749639) {
            p = SpeechDetector.N612c6118264(i);
        } else if (((Double) i[11]).doubleValue() > -0.5957986517749639) {
            p = 1;
        }
        return p;
    }
    static double N612c6118264(Object []i) {
        double p = Double.NaN;
        if (i[10] == null) {
            p = 1;
        } else if (((Double) i[10]).doubleValue() <= -0.06647368212711284) {
            p = 1;
        } else if (((Double) i[10]).doubleValue() > -0.06647368212711284) {
            p = SpeechDetector.N289aa07f265(i);
        }
        return p;
    }
    static double N289aa07f265(Object []i) {
        double p = Double.NaN;
        if (i[7] == null) {
            p = 0;
        } else if (((Double) i[7]).doubleValue() <= 1.4883517442330467) {
            p = SpeechDetector.N3f9f06ac266(i);
        } else if (((Double) i[7]).doubleValue() > 1.4883517442330467) {
            p = 0;
        }
        return p;
    }
    static double N3f9f06ac266(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() <= -4.0789599945662385) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() > -4.0789599945662385) {
            p = SpeechDetector.N616f26d5267(i);
        }
        return p;
    }
    static double N616f26d5267(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() <= 4.117832024467352) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() > 4.117832024467352) {
            p = SpeechDetector.N485e9bec268(i);
        }
        return p;
    }
    static double N485e9bec268(Object []i) {
        double p = Double.NaN;
        if (i[6] == null) {
            p = 0;
        } else if (((Double) i[6]).doubleValue() <= -0.5944857767084919) {
            p = 0;
        } else if (((Double) i[6]).doubleValue() > -0.5944857767084919) {
            p = SpeechDetector.N3b4ec812269(i);
        }
        return p;
    }
    static double N3b4ec812269(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() <= 5.315984726227029) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() > 5.315984726227029) {
            p = 1;
        }
        return p;
    }
    static double N31313429270(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 98.98056527888099) {
            p = SpeechDetector.N155788fa271(i);
        } else if (((Double) i[0]).doubleValue() > 98.98056527888099) {
            p = SpeechDetector.N4cf90b5c282(i);
        }
        return p;
    }
    static double N155788fa271(Object []i) {
        double p = Double.NaN;
        if (i[7] == null) {
            p = 0;
        } else if (((Double) i[7]).doubleValue() <= -3.846573295504783) {
            p = SpeechDetector.N25e1e008272(i);
        } else if (((Double) i[7]).doubleValue() > -3.846573295504783) {
            p = 0;
        }
        return p;
    }
    static double N25e1e008272(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 85.48412738643941) {
            p = SpeechDetector.N103b40a6273(i);
        } else if (((Double) i[0]).doubleValue() > 85.48412738643941) {
            p = 0;
        }
        return p;
    }
    static double N103b40a6273(Object []i) {
        double p = Double.NaN;
        if (i[9] == null) {
            p = 0;
        } else if (((Double) i[9]).doubleValue() <= -1.3958960876539825) {
            p = SpeechDetector.N22115a9d274(i);
        } else if (((Double) i[9]).doubleValue() > -1.3958960876539825) {
            p = SpeechDetector.N21540ae4275(i);
        }
        return p;
    }
    static double N22115a9d274(Object []i) {
        double p = Double.NaN;
        if (i[8] == null) {
            p = 1;
        } else if (((Double) i[8]).doubleValue() <= -9.334441388459208) {
            p = 1;
        } else if (((Double) i[8]).doubleValue() > -9.334441388459208) {
            p = 0;
        }
        return p;
    }
    static double N21540ae4275(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() <= -1.6297066001152365) {
            p = SpeechDetector.N14970fd4276(i);
        } else if (((Double) i[2]).doubleValue() > -1.6297066001152365) {
            p = 0;
        }
        return p;
    }
    static double N14970fd4276(Object []i) {
        double p = Double.NaN;
        if (i[11] == null) {
            p = 0;
        } else if (((Double) i[11]).doubleValue() <= -2.1981809582654) {
            p = SpeechDetector.N499031db277(i);
        } else if (((Double) i[11]).doubleValue() > -2.1981809582654) {
            p = SpeechDetector.N19b94698278(i);
        }
        return p;
    }
    static double N499031db277(Object []i) {
        double p = Double.NaN;
        if (i[10] == null) {
            p = 1;
        } else if (((Double) i[10]).doubleValue() <= -3.6138014725670704) {
            p = 1;
        } else if (((Double) i[10]).doubleValue() > -3.6138014725670704) {
            p = 0;
        }
        return p;
    }
    static double N19b94698278(Object []i) {
        double p = Double.NaN;
        if (i[11] == null) {
            p = 1;
        } else if (((Double) i[11]).doubleValue() <= -1.2298924550652162) {
            p = 1;
        } else if (((Double) i[11]).doubleValue() > -1.2298924550652162) {
            p = SpeechDetector.N52c9b259279(i);
        }
        return p;
    }
    static double N52c9b259279(Object []i) {
        double p = Double.NaN;
        if (i[9] == null) {
            p = 0;
        } else if (((Double) i[9]).doubleValue() <= 0.9336706784965823) {
            p = SpeechDetector.N37dc1b85280(i);
        } else if (((Double) i[9]).doubleValue() > 0.9336706784965823) {
            p = 1;
        }
        return p;
    }
    static double N37dc1b85280(Object []i) {
        double p = Double.NaN;
        if (i[11] == null) {
            p = 0;
        } else if (((Double) i[11]).doubleValue() <= 0.11140508491973188) {
            p = 0;
        } else if (((Double) i[11]).doubleValue() > 0.11140508491973188) {
            p = SpeechDetector.N5392d569281(i);
        }
        return p;
    }
    static double N5392d569281(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() <= 7.279823279551609) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() > 7.279823279551609) {
            p = 1;
        }
        return p;
    }
    static double N4cf90b5c282(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() <= -3.666814003830857) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() > -3.666814003830857) {
            p = SpeechDetector.N7258ec7e283(i);
        }
        return p;
    }
    static double N7258ec7e283(Object []i) {
        double p = Double.NaN;
        if (i[6] == null) {
            p = 0;
        } else if (((Double) i[6]).doubleValue() <= -4.105515758649981) {
            p = 0;
        } else if (((Double) i[6]).doubleValue() > -4.105515758649981) {
            p = SpeechDetector.N2c0e7ed8284(i);
        }
        return p;
    }
    static double N2c0e7ed8284(Object []i) {
        double p = Double.NaN;
        if (i[9] == null) {
            p = 0;
        } else if (((Double) i[9]).doubleValue() <= -3.6969952493493192) {
            p = 0;
        } else if (((Double) i[9]).doubleValue() > -3.6969952493493192) {
            p = SpeechDetector.N6ba9ad80285(i);
        }
        return p;
    }
    static double N6ba9ad80285(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() <= -1.9770570761781803) {
            p = SpeechDetector.N50bde5b8286(i);
        } else if (((Double) i[2]).doubleValue() > -1.9770570761781803) {
            p = 1;
        }
        return p;
    }
    static double N50bde5b8286(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() <= 0.4533988331104579) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() > 0.4533988331104579) {
            p = SpeechDetector.N6334bc71287(i);
        }
        return p;
    }
    static double N6334bc71287(Object []i) {
        double p = Double.NaN;
        if (i[8] == null) {
            p = 1;
        } else if (((Double) i[8]).doubleValue() <= -2.3249658903025185) {
            p = 1;
        } else if (((Double) i[8]).doubleValue() > -2.3249658903025185) {
            p = 0;
        }
        return p;
    }
    static double N1b3fd199288(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() <= -0.564117224655465) {
            p = SpeechDetector.N7ad9a1c8289(i);
        } else if (((Double) i[4]).doubleValue() > -0.564117224655465) {
            p = SpeechDetector.N5df804e8292(i);
        }
        return p;
    }
    static double N7ad9a1c8289(Object []i) {
        double p = Double.NaN;
        if (i[10] == null) {
            p = 0;
        } else if (((Double) i[10]).doubleValue() <= 7.652731138831787) {
            p = 0;
        } else if (((Double) i[10]).doubleValue() > 7.652731138831787) {
            p = SpeechDetector.N660c907a290(i);
        }
        return p;
    }
    static double N660c907a290(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 0;
        } else if (((Double) i[5]).doubleValue() <= 2.5312970116694635) {
            p = 0;
        } else if (((Double) i[5]).doubleValue() > 2.5312970116694635) {
            p = SpeechDetector.N42e16ded291(i);
        }
        return p;
    }
    static double N42e16ded291(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 79.59195748039119) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() > 79.59195748039119) {
            p = 1;
        }
        return p;
    }
    static double N5df804e8292(Object []i) {
        double p = Double.NaN;
        if (i[9] == null) {
            p = 0;
        } else if (((Double) i[9]).doubleValue() <= -0.00946874181099182) {
            p = SpeechDetector.N460a4b8a293(i);
        } else if (((Double) i[9]).doubleValue() > -0.00946874181099182) {
            p = SpeechDetector.N78dd0b8f301(i);
        }
        return p;
    }
    static double N460a4b8a293(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 0;
        } else if (((Double) i[3]).doubleValue() <= 3.4467148146535904) {
            p = 0;
        } else if (((Double) i[3]).doubleValue() > 3.4467148146535904) {
            p = SpeechDetector.N4de574f2294(i);
        }
        return p;
    }
    static double N4de574f2294(Object []i) {
        double p = Double.NaN;
        if (i[9] == null) {
            p = 0;
        } else if (((Double) i[9]).doubleValue() <= -2.117650701847546) {
            p = 0;
        } else if (((Double) i[9]).doubleValue() > -2.117650701847546) {
            p = SpeechDetector.N1360e3d2295(i);
        }
        return p;
    }
    static double N1360e3d2295(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() <= 3.186466743742328) {
            p = SpeechDetector.N3e0cf9ee296(i);
        } else if (((Double) i[4]).doubleValue() > 3.186466743742328) {
            p = SpeechDetector.N68f08888299(i);
        }
        return p;
    }
    static double N3e0cf9ee296(Object []i) {
        double p = Double.NaN;
        if (i[6] == null) {
            p = 0;
        } else if (((Double) i[6]).doubleValue() <= -0.4988859804642584) {
            p = 0;
        } else if (((Double) i[6]).doubleValue() > -0.4988859804642584) {
            p = SpeechDetector.N45ec9815297(i);
        }
        return p;
    }
    static double N45ec9815297(Object []i) {
        double p = Double.NaN;
        if (i[11] == null) {
            p = 0;
        } else if (((Double) i[11]).doubleValue() <= 0.7048436850066803) {
            p = 0;
        } else if (((Double) i[11]).doubleValue() > 0.7048436850066803) {
            p = SpeechDetector.N2ff4ae90298(i);
        }
        return p;
    }
    static double N2ff4ae90298(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 1;
        } else if (((Double) i[5]).doubleValue() <= -0.4565548380933568) {
            p = 1;
        } else if (((Double) i[5]).doubleValue() > -0.4565548380933568) {
            p = 0;
        }
        return p;
    }
    static double N68f08888299(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= 5.772764727849689) {
            p = SpeechDetector.N793ce8b300(i);
        } else if (((Double) i[2]).doubleValue() > 5.772764727849689) {
            p = 1;
        }
        return p;
    }
    static double N793ce8b300(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() <= 6.076241381038109) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() > 6.076241381038109) {
            p = 0;
        }
        return p;
    }
    static double N78dd0b8f301(Object []i) {
        double p = Double.NaN;
        if (i[6] == null) {
            p = 0;
        } else if (((Double) i[6]).doubleValue() <= -0.2138036416767269) {
            p = 0;
        } else if (((Double) i[6]).doubleValue() > -0.2138036416767269) {
            p = SpeechDetector.N78221746302(i);
        }
        return p;
    }
    static double N78221746302(Object []i) {
        double p = Double.NaN;
        if (i[7] == null) {
            p = 0;
        } else if (((Double) i[7]).doubleValue() <= -0.8220498588628873) {
            p = 0;
        } else if (((Double) i[7]).doubleValue() > -0.8220498588628873) {
            p = SpeechDetector.N6263248303(i);
        }
        return p;
    }
    static double N6263248303(Object []i) {
        double p = Double.NaN;
        if (i[11] == null) {
            p = 0;
        } else if (((Double) i[11]).doubleValue() <= 1.5840176527761054) {
            p = SpeechDetector.N35af181f304(i);
        } else if (((Double) i[11]).doubleValue() > 1.5840176527761054) {
            p = SpeechDetector.N6c893bbb315(i);
        }
        return p;
    }
    static double N35af181f304(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() <= 3.2586230006524723) {
            p = SpeechDetector.N7a58b6c1305(i);
        } else if (((Double) i[4]).doubleValue() > 3.2586230006524723) {
            p = SpeechDetector.N2625a38c313(i);
        }
        return p;
    }
    static double N7a58b6c1305(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 0;
        } else if (((Double) i[5]).doubleValue() <= 0.03611237951450026) {
            p = 0;
        } else if (((Double) i[5]).doubleValue() > 0.03611237951450026) {
            p = SpeechDetector.N564677a7306(i);
        }
        return p;
    }
    static double N564677a7306(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 79.93735893618218) {
            p = SpeechDetector.N2c59a131307(i);
        } else if (((Double) i[0]).doubleValue() > 79.93735893618218) {
            p = 0;
        }
        return p;
    }
    static double N2c59a131307(Object []i) {
        double p = Double.NaN;
        if (i[8] == null) {
            p = 0;
        } else if (((Double) i[8]).doubleValue() <= -1.4671740686195214) {
            p = 0;
        } else if (((Double) i[8]).doubleValue() > -1.4671740686195214) {
            p = SpeechDetector.N3065aeb6308(i);
        }
        return p;
    }
    static double N3065aeb6308(Object []i) {
        double p = Double.NaN;
        if (i[11] == null) {
            p = 0;
        } else if (((Double) i[11]).doubleValue() <= -2.0301989534886586) {
            p = 0;
        } else if (((Double) i[11]).doubleValue() > -2.0301989534886586) {
            p = SpeechDetector.N63b1478c309(i);
        }
        return p;
    }
    static double N63b1478c309(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 67.05287501347208) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() > 67.05287501347208) {
            p = SpeechDetector.Nbd06b76310(i);
        }
        return p;
    }
    static double Nbd06b76310(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 1;
        } else if (((Double) i[5]).doubleValue() <= 1.825892673506896) {
            p = 1;
        } else if (((Double) i[5]).doubleValue() > 1.825892673506896) {
            p = SpeechDetector.N203f1609311(i);
        }
        return p;
    }
    static double N203f1609311(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 75.672875955966) {
            p = SpeechDetector.Ndbfb969312(i);
        } else if (((Double) i[0]).doubleValue() > 75.672875955966) {
            p = 1;
        }
        return p;
    }
    static double Ndbfb969312(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 69.08723310099029) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() > 69.08723310099029) {
            p = 0;
        }
        return p;
    }
    static double N2625a38c313(Object []i) {
        double p = Double.NaN;
        if (i[7] == null) {
            p = 0;
        } else if (((Double) i[7]).doubleValue() <= 2.1644000135940398) {
            p = SpeechDetector.N71144fe4314(i);
        } else if (((Double) i[7]).doubleValue() > 2.1644000135940398) {
            p = 1;
        }
        return p;
    }
    static double N71144fe4314(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 66.86138830527399) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() > 66.86138830527399) {
            p = 0;
        }
        return p;
    }
    static double N6c893bbb315(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 0;
        } else if (((Double) i[5]).doubleValue() <= -2.9931663735554896) {
            p = 0;
        } else if (((Double) i[5]).doubleValue() > -2.9931663735554896) {
            p = SpeechDetector.N25b0a9a8316(i);
        }
        return p;
    }
    static double N25b0a9a8316(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() <= 3.9691567181473872) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() > 3.9691567181473872) {
            p = SpeechDetector.N715267ec317(i);
        }
        return p;
    }
    static double N715267ec317(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 74.79684321582047) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() > 74.79684321582047) {
            p = 1;
        }
        return p;
    }
}
