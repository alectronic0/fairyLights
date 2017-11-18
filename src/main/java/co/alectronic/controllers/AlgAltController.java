package co.alectronic.controllers;

import co.alectronic.LightArray;

import static co.alectronic.until.Helper.COL_LIST;
import static co.alectronic.until.Helper.COL_MILLI_TIME;
import static co.alectronic.until.Helper.SEQ_MILLI_TIME;

/**
 *
 */
public class AlgAltController extends AbstractAlgController {

    /**
     * @param li see algController
     * @param t see algController
     * @see AbstractAlgController
     */
    public AlgAltController(LightArray li, int t) {
        super(li, t);
        try {
            Thread d;
            while (true) {
                d = new Thread(new AlgSeqController(super.getLightArr(), SEQ_MILLI_TIME));
                d.start();
                Thread.sleep(super.getTime());
                d.stop();
                super.getLightArr().turnOffAllTheLights();
                d = new Thread(new AlgColourController(super.getLightArr(), COL_MILLI_TIME, COL_LIST));
                d.start();
                Thread.sleep(super.getTime());
                d.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}