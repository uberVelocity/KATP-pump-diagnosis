package sample.controller;

import java.util.logging.Logger;

/**
 * Class which should at some point implement commander pattern,
 * should we need it. (was used in Food Tracking app in order to
 * change username, change weight, calories etc...). We may still
 * need it depending on the number of parameters a centrifugal pump
 * has.
 */
public class Commander {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private Controller controller;

    public Commander(Controller controller) {
        this.controller = controller;
    }

    public Controller getController() {
        return controller;
    }
}
