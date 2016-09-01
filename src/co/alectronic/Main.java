package co.alectronic;

import java.util.Timer;
import java.util.TimerTask;

import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.runnable;

public class Main {
    public static final String SEQ = "sequence";
    public static final String COL = "colour";
    public static final String ALT = "alternate";

    public static final int NO_LIGHTS = 20;
    public static final String[] COL_LIST = new String[]{"Green", "White"};

    public static final int SEQ_MILLI_TIME = 500;
    public static final int COL_MILLI_TIME = 1000;
    public static final int ALT_MILLI_TIME = 30000;


    public static void main(String[] args) {
        // write your code here
        Timer timer = new Timer();
        //check there is a 1st arrValue
        if (args.length == 1) {
            String cmd = args[0].toLowerCase();
            LightArray arrLi = new LightArray(NO_LIGHTS);
            Thread d;
            if (cmd.equals(SEQ)) {
                //1.	'sequence' : each light is turned on for 0.5 seconds then off in turn from first to last.
                System.out.println("Starting Default Sequence:");
                d = new Thread(new algSeqController(arrLi, SEQ_MILLI_TIME));
                d.start();

            } else if (cmd.equals(COL)) {
                //2.	'colour' :  all of the red lights are turned on for 1 second, then all the green for 1 second then all the white for 1 second.
                System.out.println("Starting Colour Sequence:");
                d = new Thread(new algColourController(arrLi, COL_MILLI_TIME, COL_LIST));
                d.start();

            } else if (cmd.equals(ALT)) {
                //3.	'alternate' : the 'sequence' algorithm runs for 30 seconds, then the 'colour' algorithm for 30 seconds.
                System.out.println("Starting Atl Sequence:");
                d = new Thread(new algAltController(arrLi, ALT_MILLI_TIME));
                d.start();

            } else {
                System.out.println("Incorrect command. Starting Atl Sequence:");

            }

        } else {
            System.out.println("You Don't have the right amount of Args. Starting Atl Sequence:");
        }
    }


    private abstract static class algController implements Runnable {
        private static LightArray lightArr;
        private int time;

        public algController(LightArray li, int t) {
            lightArr = li;
            time = t;
        }

        public void run() {
        }
    }

    private static class algSeqController extends algController {
        private int seq = 0;

        public algSeqController(LightArray li, int t) {
            super(li, t);
        }

        public void run() {
            while (true) {
                if (seq > super.lightArr.getLightArraySize()) {
                    seq = 0;
                }

                super.lightArr.changeLight(seq);

                try {
                    Thread.sleep(super.time);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                super.lightArr.changeLight(seq);

                seq++;
            }
        }
    }


    private static class algColourController extends algController {
        private String[] listOfColours;

        public algColourController(LightArray li, int t, String[] colourList) {
            super(li, t);
            listOfColours = colourList;
        }

        public void run() {
            try {
                while (true) {
                    for (String col : listOfColours) {
                        super.lightArr.switchColourLight(col);

                        Thread.sleep(super.time);

                        super.lightArr.switchColourLight(col);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     */
    private static class algAltController extends algController {

        /**
         * @param li
         * @param t
         */
        public algAltController(LightArray li, int t) {
            super(li, t);
            try {
                Thread d;
                while (true) {
                    d = new Thread(new algSeqController(super.lightArr, SEQ_MILLI_TIME));
                    d.start();
                    Thread.sleep(super.time);
                    d.stop();
                    super.lightArr.turnOffAllTheLights();
                    d = new Thread(new algColourController(super.lightArr, COL_MILLI_TIME, COL_LIST));
                    d.start();
                    Thread.sleep(super.time);
                    d.stop();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
