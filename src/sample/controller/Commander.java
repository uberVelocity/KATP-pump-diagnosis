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

    /**
     * Checks whether the RPM is non-negative.
     * @param stringRpm
     * @return
     */
    public boolean isValidRpm(String stringRpm) {
        int rpm = Integer.parseInt(stringRpm);
        if (rpm < 0) {
            return false;
        }
        return true;
    }

    /**
     * Checks whether the RPM is out of normal operational use.
     * @param stringRpm Input rpm from textField.
     * @return Whether RPM is out of normal mode of operation.
     */
    public boolean rpmOutOfBounds(String stringRpm) {
        int rpm = Integer.parseInt(stringRpm);
        if(rpm < 800 || rpm > 1200) {
            return true;
        }
        return false;
    }

    /**
     * Checks whether the text s is an integer.
     * @param s Input string.
     * @param radix Size of radix.
     * @return Whether string is integer.
     */
    public boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }
}
