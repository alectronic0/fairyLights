package co.alectronic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LightArray {
    ArrayList<Light> lights;

    public LightArray(int l) {
        lights = new ArrayList<Light>();
        for (int i = 0; i < l; i++) {
            lights.add(new Light(i, getColour(i)));
        }
    }


    public String getColour(int i) {
        String tmpString = "";

        switch (i % 3) {
            case 0:
                tmpString = "Red";
                break;
            case 1:
                tmpString = "Green";
                break;
            case 2:
                tmpString = "White";
                break;
        }

        return tmpString;
    }


    public void listLights() {
        for (Light li : lights) {
            System.out.println((new SimpleDateFormat("HH:mm:ss:SSS").format(new Date())) + " " + li.toString());
        }
    }

}
