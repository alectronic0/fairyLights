package co.alectronic;

public class Light {

    private boolean lightState;
    private String colour;

    public Light(String colour) {
        lightState = false;
        this.colour = colour;
    }


    //Basic GETTERS
    public boolean getLightState() {
        return lightState;
    }

    //Basic Setters
    private void setLightState(boolean b) {
        lightState = b;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String s) {
        colour = s.toLowerCase();
    }

    @Override
    public String toString() {
        return colour + " " + getStrLightState();
    }

    //Advacne Getters

    /**
     * @param col ss
     * @return ss
     */
    public boolean isThisColour(String col) {
        return colour.toLowerCase().equals(col.toLowerCase());
    }

    private String getStrLightState() {
        return (lightState) ? "On" : "Off";
    }

    //Advace Setter
    public void turnOffLight() {
        setLightState(false);
    }

    public void turnOnLight() {
        setLightState(true);
    }

    public void switchLight() {
        if (lightState) {
            turnOffLight();
        } else {
            turnOnLight();
        }
    }


}
