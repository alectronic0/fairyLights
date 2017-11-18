package co.alectronic;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

public class LightArrayTest {
    @Test
    public void getColour() throws Exception {
        LightArray lightArray = new LightArray(4);
    }

    @Test
    public void getLightArraySize() throws Exception {
        LightArray lightArray1 = new LightArray(0);
        Assert.assertEquals(0,lightArray1.getLightArraySize());

        LightArray lightArray2 = new LightArray(2);
        Assert.assertEquals(2,lightArray2.getLightArraySize());

    }




    @Test
    public void turnlightOnandOff(){

        int size = 3;
        LightArray lightArray = new LightArray(size);

        lightArray.getLights().forEach(l -> {
            assertEquals(false,l.getLightState());
        });

        lightArray.turnOnAllTheLights();
        lightArray.getLights().forEach(l -> {
            assertEquals(true,l.getLightState());
        });

        lightArray.turnOffAllTheLights();
        lightArray.getLights().forEach(l -> {
            assertEquals(false,l.getLightState());
        });


        lightArray.flickAllTheSwitch();
        lightArray.getLights().forEach(l -> {
            assertEquals(true,l.getLightState());
        });
    }

    @Test
    public void printResult()throws Exception {
        LightArray lightArray = new LightArray(0);
        lightArray.listLights();
        LightArray lightArray1 = new LightArray(1);
        lightArray1.listLights();
    }



    @Test
    public void colourInList(){
        LightArray lightArray = new LightArray(3,new String[]{"red","blue","green"});

        assertFalse(lightArray.colourInList("purple"));
        assertTrue(lightArray.colourInList("blue"));
        assertTrue(lightArray.colourInList("red"));
        assertTrue(lightArray.colourInList("green"));

        LightArray lightArray2 = new LightArray(3);

        assertFalse(lightArray2.colourInList("purple"));
        assertFalse(lightArray2.colourInList("blue"));
        assertTrue(lightArray2.colourInList("RED"));
        assertTrue(lightArray2.colourInList("ReD"));
        assertTrue(lightArray2.colourInList("Red"));
        assertTrue(lightArray2.colourInList("red"));
        assertTrue(lightArray2.colourInList("GREEN"));
        assertTrue(lightArray2.colourInList("WHITE"));


        assertEquals(Collections.EMPTY_LIST,lightArray.getColoursPos("purple"));
    }


    @Test
    public void changeLight(){
        LightArray lightArray = new LightArray(2);

        assertFalse(lightArray.getLights().get(1).getLightState());
        lightArray.changeLight(1);
        assertTrue(lightArray.getLights().get(1).getLightState());

        lightArray.changeLight(99);
    }




    @Test
    public void switchColour(){
        LightArray lightArray = new LightArray(4);
        assertEquals("red Off",lightArray.getLights().get(0).toString());
        assertEquals("green Off",lightArray.getLights().get(1).toString());
        assertEquals("white Off",lightArray.getLights().get(2).toString());
        assertEquals("red Off",lightArray.getLights().get(3).toString());

        lightArray.switchColourLight("red");
        assertEquals("red On",lightArray.getLights().get(0).toString());
        assertEquals("green Off",lightArray.getLights().get(1).toString());
        assertEquals("white Off",lightArray.getLights().get(2).toString());
        assertEquals("red On",lightArray.getLights().get(3).toString());
    }

}