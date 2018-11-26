package sample.controller;

import javafx.animation.FadeTransition;
import javafx.scene.control.Control;
import javafx.util.Duration;
import sample.controller.controllers.AddInfoController;
import sample.controller.controllers.MainQuestionController;
import sample.controller.controllers.SceneController;
import sample.controller.controllers.TitleController;

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
                fadeTransition(controller.getView().getMainQuestionController().getWarningLabel(), 700);
                controller.getModel().getPump().setRpm(Integer.parseInt(rpm));
                controller.getView().getMainQuestionController().getWarningLabel().setVisible(true);
                System.out.println(controller.getModel().getPump().getRpm());
            }
        }
        else {
            controller.getView().getMainQuestionController().getWarningLabel().setText("RPM should be a non-zero positive integer");
            fadeTransition(controller.getView().getMainQuestionController().getWarningLabel(), 700);
            controller.getView().getMainQuestionController().getWarningLabel().setVisible(true);
        }
    }

    /**
     * Checks whether the RPM is non-negative.
     * @param stringRpm
     * @return
     */
    private static boolean isValidRpm(String stringRpm) {
        int rpm = Integer.parseInt(stringRpm);
        if(rpm < 0) {
            return false;
        }
        return true;
    }

    /**
     * Checks whether the RPM is out of normal operational use.
     * @param stringRpm Input rpm from textField.
     * @return Whether RPM is out of normal mode of operation.
     */
    private static boolean rpmOutOfBounds(String stringRpm) {
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

    /**
     * Should only be in SceneController, rethink commander class.
     * @param control
     * @param fadeDuration
     */
    public void fadeTransition(Control control, int fadeDuration) {
        FadeTransition ft = new FadeTransition(Duration.millis(fadeDuration), control);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        control.setVisible(true);
    }
}
