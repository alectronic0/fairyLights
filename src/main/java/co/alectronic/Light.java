package co.alectronic;

public class Light {

    private boolean lightState; //State of Light True= ON; False=OFF
    private String colour; //Colour of the Light as A String (Could use Enum instead in the future to define a set number of colours)


    /**
     * Light constructor (Default)
     * Creates a Light Object which is switched off and bulb colour is White.
     */
    public Light() {
        lightState = false;
        this.colour = "white";
    }

    /**
     * Light constructor
     * Creates a Light Object which is switched off and bulb colour is defined by colour param.
     *
     * @param colour Colour of the Bulb.
     */
    public Light(String colour) {
        lightState = false;
        this.colour = colour;
    }

    /**
     * Light constructor
     * Creates a Light Object bulb colour is defined by colour param and the state of bulb is also a param.
     *
     * @param colour Colour of the Bulb.
     * @param state  set the Bulbs state of ON or OFF
     */
    public Light(String colour, boolean state) {
        lightState = state;
        this.colour = colour;
    }


    //Basic GETTERS///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * @return Returns the Colour of the LightBulb.
     */
    public String getColour() {
        return colour;
    }

    /**
     * @param s String that sets the colour of the bulb.
     */
    public void setColour(String s) {
        colour = s.toLowerCase();
    }

    /**
     * @return Returns the Light Bulbs State (True = ON / False = OFF)
     */
    public boolean getLightState() {
        return lightState;
    }

    //Basic Setters///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * @param b Boolean which set bulbs state (True = ON / False = OFF)
     */
    private void setLightState(boolean b) {
        lightState = b;
    }

    /**
     * @return Return the LightBulb Object as A String example. Red ON
     * @see Object
     */
    @Override
    public String toString() {
        return colour + " " + getStrLightState();
    }

    //Advacne Getters///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * @param col String giving the name of colour.
     * @return Returns a Boolean (True = they are the same colour / False = not the same colour)
     */
    public boolean isThisColour(String col) {
        return colour.toLowerCase().equals(col.toLowerCase());
    }

    /**
     * @param li Light Object  to compare the colour of the bulb objects.
     * @return Returns a Boolean (True = they are the same colour / False = not the same colour)
     */
    public boolean isThisColour(Light li) {
        return colour.toLowerCase().equals(li.getColour().toLowerCase());
    }

    /**
     * @return Returns a String with the text version of the boolean being ON or OFF
     */
    public String getStrLightState() {
        return (lightState) ? "On" : "Off";
    }

    //Advance Setters///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Turn OFF the LightBulb
     */
    public void turnOffLight() {
        setLightState(false);
    }

    /**
     *Turn ON the LightBulb
     */
    public void turnOnLight() {
        setLightState(true);
    }

    /**
     * Flick the lightbulb state ON if it OFF or OFF if its ON
     */
    public void switchLight() {
        if (lightState) {
            turnOffLight();
        } else {turnOnLight();}
    }
}
