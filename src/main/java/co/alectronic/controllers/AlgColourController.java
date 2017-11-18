package co.alectronic.controllers;

import co.alectronic.LightArray;

/**
 *
 */
public class AlgColourController extends AbstractAlgController {
    private String[] listOfColours;

    /**
     * @param li see algController
     * @param t see algController
     * @param colourList set the colour you wish to alternate between with this controller
     * @see AbstractAlgController
     */
    public AlgColourController(LightArray li, int t, String[] colourList) {
        super(li, t);
        listOfColours = colourList;
    }

    /**
     *@see AbstractAlgController
     */
    public void run() {
        try {
            while (true) {
                for (String col : listOfColours) {
                    super.getLightArr().switchColourLight(col);

                    Thread.sleep(super.getTime());

                    super.getLightArr().switchColourLight(col);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

