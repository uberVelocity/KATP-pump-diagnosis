package sample.controller.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.controller.Controller;

public class MainQuestionController extends SceneController{

    private Controller controller;

    @FXML
    private Button previousButton;

    @FXML
    private Button nextButton;

    @FXML
    private TextField textField;

    @FXML
    private Label warningLabel;

    public MainQuestionController() {}

    public MainQuestionController(Controller controller) {
        this.controller = controller;
    }

    public void setButtonActions() {
        previousButton.setOnAction(e -> {
            if(previousButton.getId().equals("previousButton")) {
                controller.getView().getPrimaryStage().setScene(controller.getView().getAdditionalInfoScene());
            }
        });
        nextButton.setOnAction(e -> {
            if(nextButton.getId().equals("nextButton")) {
                setRpm(textField.getText());
            }
        });
    }

    /**
     * Verifies if the input of the text field is a valid value for the RPM of the
     * pump and, if it is, assigns the rpm of the pump the value of @rpm.
     * @param rpm
     */
    private void setRpm(String rpm) {
        if(controller.getCommander().isInteger(rpm, 10) && controller.getCommander().isValidRpm(rpm)) {
            if (!controller.getCommander().rpmOutOfBounds(rpm)) {
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

    public Label getWarningLabel() {
        return warningLabel;
    }
}
