package sample.controller.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import sample.controller.Controller;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Logical controller for the additional info scene.
 */
public class AddInfoController extends SceneController {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private Controller controller;

    @FXML
    private Button previousButton;

    @FXML
    private Button nextButton;

    @FXML
    private Button yesButton;

    @FXML
    private Button noButton;

    @FXML
    private Label noLabel;

    @FXML
    private Label yesLabel;

    @FXML
    private TextArea textArea;

    public AddInfoController() {

    }

    public AddInfoController(Controller controller) {
        this.controller = controller;
    }


    @FXML
    public void setButtonActionPrevious() {
        previousButton.setOnAction(e -> {
            if(previousButton.getId().equals("button")) {
                controller.getView().getPrimaryStage().setScene(controller.getView().getTitleScene());
            }
        });
    }

    @FXML
    public void setButtonActionNext() {
        nextButton.setOnAction(e -> {
            if(nextButton.getId().equals("button2")) {
                nextButton.setText("Stop touching me!");
            }
        });
    }

    /**
     * Set all action buttons.
     */
    @FXML
    public void setButtonActions() {
        logger.log(Level.INFO, "SET ACTIONS OF BUTTONS");
        previousButton.setOnAction(e -> {
            if(previousButton.getId().equals("previousButton")) {
                controller.getView().getPrimaryStage().setScene(controller.getView().getTitleScene());
            }
        });
        nextButton.setOnAction(e -> {
            if(nextButton.getId().equals("nextButton")) {
                controller.getView().getPrimaryStage().setScene(controller.getView().getMainQuestionScene());
            }
        });
        yesButton.setOnAction(e -> {
            if(yesButton.getId().equals("yesButton")) {
                fadeTransition(yesLabel, 500);
            }
        });
        noButton.setOnAction(e -> {
            if(noButton.getId().equals("noButton")) {
                fadeTransition(noLabel, 500);
            }
        });
    }


    public Controller getController() {
        return controller;
    }

}
