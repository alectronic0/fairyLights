package co.alectronic;

import java.util.Timer;
import java.util.TimerTask;

public class Main extends TimerTask {

    public static LightArray lightArr;

    public static void main(String[] args) {
        // write your code here
        lightArr = new LightArray(19);

        //check there is a 1st arrValue
        if (args.length == 1) {
            if (args[0].toLowerCase().equals("sequence")) {
                System.out.println("Starting Default Sequence:");
            } else if (args[0].toLowerCase().equals("colour")) {
                System.out.println("Starting Colour Sequence:");
            } else if (args[0].toLowerCase().equals("alternate")) {
                System.out.println("Starting Atl Sequence:");
            } else {
                System.out.println("Incorrect command. Starting Atl Sequence:");
            }

        } else {
            System.out.println("You Don't have the right amount of Args. Starting Atl Sequence:");
        }


        Timer timer = new Timer();
        timer.schedule(new Main(), 0, 5000);
    }

    public void run() {
        lightArr.listLights();
    }

}

