package co.alectronic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LightArray {
    ArrayList<Light> lights;

    public LightArray(int l) {
        lights = new ArrayList<Light>();
        for (int i = 0; i < l; i++) {
            lights.add(new Light(i, "Red"));
        }

        for (Light li : lights) {
            System.out.println((new SimpleDateFormat("HH:mm:ss:SSS").format(new Date())) + " " + li.toString());
        }
    }
}
