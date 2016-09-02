package co.alectronic;

public class Main {
    public static final String SEQ = "sequence";
    public static final String COL = "colour";
    public static final String ALT = "alternate";

    public static final int NO_LIGHTS = 20;
    public static final String[] COL_LIST = new String[]{"Green", "White"};

    public static final int SEQ_MILLI_TIME = 500;
    public static final int COL_MILLI_TIME = 1000;
    public static final int ALT_MILLI_TIME = 30000;

    /**
     * Main function
     * This runs a demo of the Lights flick on and off in a pretty order.
     * <p>
     * Future implmentation could use mutiple args to define colours, amount of lights and special sequence cases.
     *
     * @param args Current only takes one arg (args[0]) this set the type of sequence. (this is out of Scope)
     */
    public static void main(String[] args) {

        LightArray arrLi = new LightArray(NO_LIGHTS);
        Thread d;

        //check there is at least 1 argument.
        if (args.length > 0) {
            String cmd = args[0].toLowerCase();

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
                //Not one of the right args
                System.out.println("Invalid Argument.");
                System.out.println("Try adding either '" + SEQ + "','" + COL + "','" + ALT + "' as an Argument to this Programme.");
            }

        } else {
            //you have no args
            System.out.println("You are missing and Argument.");
            System.out.println("Try adding either '" + SEQ + "','" + COL + "','" + ALT + "' as an Argument to this Programme.");
        }
    }


    /**
     * abstract controller algorithm Class
     *
     *
     */
    private abstract static class algController implements Runnable {
        private static LightArray lightArr;
        private int time; //time delay used when extended

        /**
         * algController constructor
         * @param li lights Array that will be mainpulated with this programme.
         * @param t time in millisec used to hold the delay of switching light ON or OFF.
         */
        public algController(LightArray li, int t) {
            lightArr = li;
            time = t;
        }

        /**
         *
         */
        public void run() {
        }
    }

    /**
     *
     */
    private static class algSeqController extends algController {
        private int seq = 0;

        /**
         * @param li see algController
         * @param t see algController
         * @see algController
         */
        public algSeqController(LightArray li, int t) {
            super(li, t);
        }

        /**
         *@see algController
         */
        public void run() {
            try {
                while (true) {
                    if (seq > super.lightArr.getLightArraySize()) {
                        seq = 0;
                    }

                    super.lightArr.changeLight(seq);


                    Thread.sleep(super.time);

                    super.lightArr.changeLight(seq);

                    seq++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     */
    private static class algColourController extends algController {
        private String[] listOfColours;

        /**
         * @param li see algController
         * @param t see algController
         * @param colourList set the colour you wish to alternate between with this controller
         * @see algController
         */
        public algColourController(LightArray li, int t, String[] colourList) {
            super(li, t);
            listOfColours = colourList;
        }

        /**
         *@see algController
         */
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
         * @param li see algController
         * @param t see algController
         * @see algController
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
