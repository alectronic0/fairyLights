package co.alectronic;

public class Light {

    private boolean lightState;
    private String colour;

    public Light(String colour) {
        lightState = false;
        this.colour = colour;
    }


//Basic GETTERS
    public boolean getLightState(){return lightState;}
    public String getColour(){return colour;}

    @Override
    public String toString() {return colour + " " + getStrLightState();}

//Advacne Getters
    public boolean isThisColour(String col){return colour.toLowerCase().equals(col.toLowerCase());}

    private String getStrLightState() {
        return (lightState) ? "On" : "Off";
    }

//Basic Setters
    public void setLightState(boolean b){lightState = b;}
    public void setColour(String s){colour = s.toLowerCase();}


//Advace Setter
    public void turnOffLight(){setLightState(false);}
    public void turnOnLight(){setLightState(true);}

    public void switchLight(){if(lightState){turnOffLight();}else{turnOnLight();}}



}
