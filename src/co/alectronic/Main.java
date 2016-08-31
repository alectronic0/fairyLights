package co.alectronic;

import java.util.Timer;
import java.util.TimerTask;

public class Main extends TimerTask {

    public static void main(String[] args) {
        // write your code here
        LightArray lightArr = new LightArray(19);

        Timer timer = new Timer();
        timer.schedule(new Main(), 0, 5000);
    }

    public void run() {
        System.out.println("Hello World!");
    }

}

