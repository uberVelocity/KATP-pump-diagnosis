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
     * Verifies if the input of the text field is a valid value for the RPM of the
     * pump and, if it is, assigns the rpm of the pump the value of @rpm.
     * @param rpm
     */
    public void setRpm(String rpm) {
        if(isInteger(rpm, 10) && isValidRpm(rpm)) {
            if (!rpmOutOfBounds(rpm)) {
                controller.getView().getMainQuestionController().getWarningLabel().setVisible(false);
                controller.getModel().getPump().setRpm(Integer.parseInt(rpm));
                System.out.println(controller.getModel().getPump().getRpm());
            }
            else {
                controller.getView().getMainQuestionController().getWarningLabel().setText("RPM out of bounds");
                controller.getModel().getPump().setRpm(Integer.parseInt(rpm));
                controller.getView().getMainQuestionController().getWarningLabel().setVisible(true);
                System.out.println(controller.getModel().getPump().getRpm());
            }
        }
        else {
            controller.getView().getMainQuestionController().getWarningLabel().setText("RPM should be a non-zero positive integer");
            controller.getView().getMainQuestionController().getWarningLabel().setVisible(true);
        }
    }

    private static boolean isValidRpm(String stringRpm) {
        int rpm = Integer.parseInt(stringRpm);
        if(rpm < 0) {
            return false;
        }
        return true;
    }

    private static boolean rpmOutOfBounds(String stringRpm) {
        int rpm = Integer.parseInt(stringRpm);
        if(rpm < 800 || rpm > 1200) {
            return true;
        }
        return false;
    }

    private static boolean isInteger(String s, int radix) {
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
