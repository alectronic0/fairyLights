package co.alectronic;

import java.util.Timer;
import java.util.TimerTask;

public class Main  {
    public static final String SEQ = "sequence";
    public static final String COL = "colour";
    public static final String ALT = "alternate";

    public static final int NO_LIGHTS = 20;
    public static final String[] COL_LIST  = new String[]{"Green", "White"};

    public static final int SEQ_MILLI_TIME = 500;
    public static final int COL_MILLI_TIME = 1000;
    public static final int ALT_MILLI_TIME = 30000;


    public static void main(String[] args) {
        // write your code here
        Timer timer = new Timer();
        //check there is a 1st arrValue
        if (args.length == 1) {
            String cmd = args[0].toLowerCase();
            if (cmd.equals(SEQ)) {
                //1.	'sequence' : each light is turned on for 0.5 seconds then off in turn from first to last.
                System.out.println("Starting Default Sequence:");
                timer.schedule(new algSeqController(NO_LIGHTS, SEQ_MILLI_TIME), 0, SEQ_MILLI_TIME);

            } else if (cmd.equals(COL)) {
                //2.	'colour' :  all of the red lights are turned on for 1 second, then all the green for 1 second then all the white for 1 second.
                System.out.println("Starting Colour Sequence:");
                timer.schedule(new algColourController(NO_LIGHTS,COL_MILLI_TIME,COL_LIST), 0, COL_MILLI_TIME * COL_LIST.length);

            } else if (cmd.equals(ALT)) {
                //3.	'alternate' : the 'sequence' algorithm runs for 30 seconds, then the 'colour' algorithm for 30 seconds.
                System.out.println("Starting Atl Sequence:");
                timer.schedule(new algAltController(NO_LIGHTS,ALT_MILLI_TIME,COL_LIST),0,ALT_MILLI_TIME*2);

            } else {
                System.out.println("Incorrect command. Starting Atl Sequence:");

            }

        } else {
            System.out.println("You Don't have the right amount of Args. Starting Atl Sequence:");
        }
    }





    public abstract static class algController extends TimerTask{
        private static LightArray lightArr;
        private int time;

        public algController(int i, int t){
            super();
            lightArr = new LightArray(i);
            time = t;
        }

        public void run(){}
    }

    public static class algSeqController extends algController {
        private int seq = 0;

        public algSeqController(int i, int t){
            super(i,t);
        }

        public void run() {
            if (seq > super.lightArr.getLightArraySize()) {seq = 0;}

            super.lightArr.changeLight(seq);

            try {Thread.sleep(super.time);}
            catch (Exception e) {e.printStackTrace();}

            super.lightArr.changeLight(seq);

            seq++;
        }
    }




    public static class algColourController extends algController {
        private String[] listOfColours;

        public algColourController(int i, int t,  String[] colourList){
            super(i,t);
            listOfColours = colourList;
        }

        public void run() {
            for(String col : listOfColours){
                super.lightArr.switchColourLight(col);

                try {Thread.sleep(super.time);}
                catch (Exception e) {e.printStackTrace();}

                super.lightArr.switchColourLight(col);
            }
        }
    }

//Still working on
    public static class algAltController extends algController {
        private String[] listOfColours;

        public algAltController(int i, int t,String[] colourList){
            super(i,t);
            listOfColours = colourList;
        }

        public void run() {
            Timer timerx = new Timer();

            timerx.schedule(new algSeqController(NO_LIGHTS, SEQ_MILLI_TIME), 0, SEQ_MILLI_TIME);

            try {Thread.sleep(super.time);}
            catch (Exception e) {e.printStackTrace();}
            timerx.purge();

            timerx.schedule(new algColourController(NO_LIGHTS,COL_MILLI_TIME,COL_LIST), 0, COL_MILLI_TIME * COL_LIST.length);

        }
    }

}

