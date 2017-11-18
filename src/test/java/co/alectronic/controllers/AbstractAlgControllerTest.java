package co.alectronic.controllers;

import co.alectronic.LightArray;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

import static co.alectronic.util.Helper.COL_LIST;
import static org.junit.Assert.*;

public class AbstractAlgControllerTest {


//    ALT

    @Test
    public void getTimeALT() throws Exception {
        AbstractAlgController alg = new AlgAltController(new LightArray(0),100);
        assertEquals(100,alg.getTime());
    }

    @Test
    public void setTimeALT() throws Exception {
        AbstractAlgController alg = new AlgAltController(new LightArray(0),100);
        alg.setTime(200);
        assertEquals(200,alg.getTime());
    }

    @Test
    public void getLightArrALT() throws Exception {
        LightArray array = new LightArray(0);
        AbstractAlgController alg = new AlgAltController(array,100);
        assertEquals(array,alg.getLightArr());
        assertNotEquals(new LightArray(0),alg.getLightArr());
    }

    @Test
    public void setLightArrALT() throws Exception {
        LightArray array = new LightArray(0);
        LightArray array2 = new LightArray(1);
        AbstractAlgController alg = new AlgAltController(array,100);
        alg.setLightArr(array2);
        assertNotEquals(array,alg.getLightArr());
        assertEquals(array2,alg.getLightArr());
    }





//COL



    @Test
    public void getTimeCOL() throws Exception {
        AbstractAlgController alg = new AlgColourController(new LightArray(0),100,COL_LIST);
        assertEquals(100,alg.getTime());
    }

    @Test
    public void setTimeCOL() throws Exception {
        AbstractAlgController alg = new AlgColourController(new LightArray(0),100,COL_LIST);
        alg.setTime(200);
        assertEquals(200,alg.getTime());
    }

    @Test
    public void getLightArrCOL() throws Exception {
        LightArray array = new LightArray(0);
        AbstractAlgController alg = new AlgColourController(array,100,COL_LIST);
        assertEquals(array,alg.getLightArr());
        assertNotEquals(new LightArray(0),alg.getLightArr());
    }

    @Test
    public void setLightArrCOL() throws Exception {
        LightArray array = new LightArray(0);
        LightArray array2 = new LightArray(1);
        AbstractAlgController alg = new AlgColourController(array,100,COL_LIST);
        alg.setLightArr(array2);
        assertNotEquals(array,alg.getLightArr());
        assertEquals(array2,alg.getLightArr());
    }








// SEQ

    @Test
    public void getTimeSEQ() throws Exception {
        AbstractAlgController alg = new AlgSeqController(new LightArray(0),100);
        assertEquals(100,alg.getTime());
    }

    @Test
    public void setTimeSEQ() throws Exception {
        AbstractAlgController alg = new AlgSeqController(new LightArray(0),100);
        alg.setTime(200);
        assertEquals(200,alg.getTime());
    }

    @Test
    public void getLightArrSEQ() throws Exception {
        LightArray array = new LightArray(0);
        AbstractAlgController alg = new AlgSeqController(array,100);
        assertEquals(array,alg.getLightArr());
        assertNotEquals(new LightArray(0),alg.getLightArr());
    }

    @Test
    public void setLightArrSEQ() throws Exception {
        LightArray array = new LightArray(0);
        LightArray array2 = new LightArray(1);
        AbstractAlgController alg = new AlgSeqController(array,100);
        alg.setLightArr(array2);
        assertNotEquals(array,alg.getLightArr());
        assertEquals(array2,alg.getLightArr());
    }




















}