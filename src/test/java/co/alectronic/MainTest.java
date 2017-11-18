package co.alectronic;

import co.alectronic.controllers.AbstractAlgController;
import co.alectronic.controllers.AlgAltController;
import co.alectronic.controllers.AlgColourController;
import co.alectronic.controllers.AlgSeqController;
import co.alectronic.util.Helper;
import org.junit.Test;

import java.io.SequenceInputStream;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void main() throws Exception {
        Main main = new Main();
        Helper helper = new Helper();


        Main.main(new String[]{});
        Main.main(new String[]{""});
        Main.main(new String[]{Helper.SEQ});
        Main.main(new String[]{Helper.ALT});
        Main.main(new String[]{Helper.COL});

        Main.main(new String[]{Helper.SEQ,"0"});
        Main.main(new String[]{Helper.ALT,"0"});
        Main.main(new String[]{Helper.COL,"0"});
    }

    @Test
    public void controller(){
        AbstractAlgController abstractAlgController = new AbstractAlgController(new LightArray(0), 0) {};
        AlgColourController algColourController = new AlgColourController(new LightArray(0),0,new String[]{""});
        AlgSeqController algSeqController = new AlgSeqController(new LightArray(0),0);
        AlgAltController algAltController= new AlgAltController(new LightArray(0),0);


        abstractAlgController.run();
//        algColourController.run();
//        algSeqController.run();
//        algAltController.run();

    }

}