package sample.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

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
