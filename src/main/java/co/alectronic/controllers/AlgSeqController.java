package co.alectronic.controllers;


import co.alectronic.LightArray;

/**
 *
 */
public class AlgSeqController extends AbstractAlgController {
    private int seq = 0;

    /**
     * @param li see algController
     * @param t see algController
     * @see AbstractAlgController
     */
    public AlgSeqController(LightArray li, int t) {
        super(li, t);
    }

    /**
     *@see AbstractAlgController
     */
    @Override
    public void run() {
        try {
            while (true) {
                if (seq > super.getLightArr().getLightArraySize()) {
                    seq = 0;
                }

                super.getLightArr().changeLight(seq);


                Thread.sleep(super.getTime());

                super.getLightArr().changeLight(seq);

                seq++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

