package co.alectronic.controllers;

import co.alectronic.LightArray;

/**
 * abstract controller algorithm Class
 *
 *
 */
public abstract class AbstractAlgController implements Runnable{

    private LightArray lightArr;
    private int time; //time delay used when extended

    /**
     * algController constructor
     * @param li lights Array that will be mainpulated with this programme.
     * @param t time in millisec used to hold the delay of switching light ON or OFF.
     */
    public AbstractAlgController(LightArray li, int t) {
        lightArr = li;
        time = t;
    }


    /**
     *
     */
    public void run() {
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public LightArray getLightArr() {
        return lightArr;
    }

    public void setLightArr(LightArray lightArr) {
        this.lightArr = lightArr;
    }
}