package co.alectronic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LightArray {
    private ArrayList<Light> lights;
    private String[] listOfColours;

    //Contrructors
    public LightArray(int l) {
        lights = new ArrayList<Light>();
        listOfColours = new String[]{"Red", "Green", "White"};
        for (int i = 0; i < l; i++) {
            lights.add(new Light(getColour(i)));
        }
    }

    public LightArray(int l, String[] colourList) {
        lights = new ArrayList<Light>();
        listOfColours = colourList;
        for (int i = 0; i < l; i++) {
            lights.add(new Light(getColour(i)));
        }
    }

    //GETTERS
    public String getColour(int i) {
        return listOfColours[i % listOfColours.length];
    }


    public int getLightArraySize() {
        return lights.size();
    }


    public ArrayList<Integer> getColoursPos(String colour) {
        ArrayList<Integer> colourPos = new ArrayList<Integer>();
        //check if colourexitst reduces loop
        if (colourInList(colour)) {
            for (int i = 0; i < lights.size(); i++) {
                Light li = lights.get(i);
                if (li.isThisColour(colour)) {
                    colourPos.add(i);
                }
            }
        }
        return colourPos;
    }

    public boolean colourInList(String colour) {
        for (String col : listOfColours) {
            if (colour.toLowerCase().equals(col.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

//setters

    public void switchColourLight(String colour) {
        for (int i : getColoursPos(colour)) {
            changeLight(i);
        }
    }

    public void changeLight(int pos) {
        if (pos < lights.size()) {
            Light li = lights.get(pos);
            li.switchLight();
            System.out.println((new SimpleDateFormat("HH:mm:ss:SSS").format(new Date())) + " : Light " + (pos + 1) + " " + li.toString());
        }
    }

    public void flickAllTheSwitch() {
        int i = 1;
        for (Light li : lights) {
            changeLight(i);
            i++;
        }
    }

    public void turnOffAllTheLights() {
        for (Light li : lights) {
            li.turnOffLight();
        }
    }

    public void turnOnAllTheLights() {
        for (Light li : lights) {
            li.turnOnLight();
        }
    }


    //[Time in format hh:mm:ss:sss] : Light <number> <colour> <on/off>
    public void listLights() {
        int i = 1;
        for (Light li : lights) {
            System.out.println((new SimpleDateFormat("HH:mm:ss:SSS").format(new Date())) + " : Light " + (i) + " " + li.toString());
            i++;
        }
    }

}
