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
                controller.getCommander().setRpm(textField.getText());
            }
        });
    }

    public Label getWarningLabel() {
        return warningLabel;
    }
}
