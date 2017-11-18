package co.alectronic;

import co.alectronic.controllers.AlgAltController;
import co.alectronic.controllers.AlgColourController;
import co.alectronic.controllers.AlgSeqController;

import static co.alectronic.util.Helper.*;

public class Main {

    /**
     * Main function
     * This runs a demo of the Lights flick on and off in a pretty order.
     * <p>
     * Future implmentation could use mutiple args to define colours, amount of lights and special sequence cases.
     *
     * @param args Current only takes one arg (args[0]) this set the type of sequence. (this is out of Scope)
     */
    public static void main(String[] args) {

        //check there is at least 1 argument.
        if (args.length > 0) {
            String cmd = args[0].toLowerCase();
            int numberOfLights = (args.length > 1) ?  parseArg(args[1],NO_LIGHTS) : NO_LIGHTS;
            LightArray arrLi = new LightArray(numberOfLights);

            Runnable alg;

            switch (cmd){
                //1.	'sequence' : each light is turned on for 0.5 seconds then off in turn from first to last.
                case SEQ : System.out.println("Starting Default Sequence:"); alg = new AlgSeqController(arrLi, SEQ_MILLI_TIME);break;
                //2.	'colour' :  all of the red lights are turned on for 1 second, then all the green for 1 second then all the white for 1 second.
                case COL: System.out.println("Starting Colour Sequence:");alg = new AlgColourController(arrLi, COL_MILLI_TIME, COL_LIST); break;
                //3.	'alternate' : the 'sequence' algorithm runs for 30 seconds, then the 'colour' algorithm for 30 seconds.
                case ALT : System.out.println("Starting Atl Sequence:"); alg = new AlgAltController(arrLi, ALT_MILLI_TIME); break;
                //Not one of the right args
                default: alg = null;break;
            }


            if(alg != null){
                new Thread(alg).start();
            }else{
                System.out.println("Invalid Argument.");
                System.out.println("Try adding either '" + SEQ + "','" + COL + "','" + ALT + "' as an Argument to this Programme.");
            }
        } else {
            //you have no args
            System.out.println("You are missing and Argument.");
            System.out.println("Try adding either '" + SEQ + "','" + COL + "','" + ALT + "' as an Argument to this Programme.");
        }
    }


}
