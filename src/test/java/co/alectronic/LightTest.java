package co.alectronic;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class LightTest {

    final static String DEFAULT_COLOUR = "white";

    @Test
    public void getColour() throws Exception {
        String colour = "red";

        Light l = new Light();
        Light l1 = new Light("red");
        Light l2 = new Light("red",true);

        assertEquals(DEFAULT_COLOUR ,l.getColour());
        assertEquals(colour,l1.getColour());
        assertEquals(colour,l2.getColour());
    }

    @Test
    public void colour() throws Exception {
        Light l = new Light();
        assertEquals("white",l.getColour());

        l.setColour("red");
        assertEquals("red",l.getColour());

        l.setColour("blue");
        assertEquals("blue",l.getColour());

        l.setColour(null);
        assertEquals("white",l.getColour());
    }

    @Test
    public void lightState() throws Exception {
        Light l = new Light();
        assertFalse(l.getLightState());

        l.switchLight();
        assertTrue(l.getLightState());
        l.switchLight();
        assertFalse(l.getLightState());

        l.turnOnLight();
        assertTrue(l.getLightState());
        l.turnOffLight();
        assertFalse(l.getLightState());


        Light l2 = new Light("white",true);
        assertTrue(l2.getLightState());

    }


    @Test
    public void whatColour(){
        Light l = new Light();
        Light l2 = new Light();
        Light l3 = new Light("red");

        assertTrue(l.isThisColour(l2));
        assertTrue(l.isThisColour(l2.getColour()));

        assertFalse(l.isThisColour(l3));
        assertFalse(l.isThisColour(l3.getColour()));

    }

    @Test
    public void toStringTest(){
        Light l = new Light();

        String s = "white Off";
        assertEquals(s,l.toString());

        s = "white On";
        l.turnOnLight();
        assertEquals(s,l.toString());

        s = "red On";
        l.setColour("RED");
        assertEquals(s,l.toString());

        s = "red Off";
        l.turnOffLight();
        assertEquals(s,l.toString());

    }


}