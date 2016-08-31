package co.alectronic;

public class Light {

    public int id;
    public boolean lightState;
    public String colour;

    public Light(int id, String colour) {
        this.id = id;
        lightState = false;
        this.colour = colour;
    }

    public String getStrLightState() {
        return (lightState) ? "On" : "Off";
    }

    @Override
    public String toString() {
        return "Light " + id + " " + colour + " " + getStrLightState();
    }
}
