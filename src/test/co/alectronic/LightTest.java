package co.alectronic;

import org.junit.Assert;
import org.junit.Test;


public class LightTest {

    final static String DEFAULT_COLOUR = "white";

    @Test
    public void getColour() throws Exception {
        String colour = "red";

        Light l = new Light();
        Light l1 = new Light("red");
        Light l2 = new Light("red",true);

        Assert.assertEquals(DEFAULT_COLOUR ,l.getColour());
        Assert.assertEquals(colour,l1.getColour());
        Assert.assertEquals(colour,l2.getColour());
    }

    @Test
    public void setColour() throws Exception {
    }

    @Test
    public void getLightState() throws Exception {
    }

    @Test
    public void toStringTest() throws Exception {
    }

    @Test
    public void isThisColour() throws Exception {
    }

    @Test
    public void isThisColour1() throws Exception {
    }

    @Test
    public void getStrLightState() throws Exception {
    }

    @Test
    public void turnOffLight() throws Exception {
    }

    @Test
    public void turnOnLight() throws Exception {
    }

    @Test
    public void switchLight() throws Exception {
    }

}