package sample.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Commander {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private Controller controller;

    public Commander(Controller controller) {
        this.controller = controller;
    }

    public void setUsername(String username) {
        if (isValidUsername(username)) {
            controller.getModel().getUser().setName(username);
        }
        else {
            logger.log(Level.WARNING, "not a valid username ...");
        }
    }

    private boolean isValidUsername(String username) {
        char[] chars = username.toCharArray();
        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public Controller getController() {
        return controller;
    }
}
