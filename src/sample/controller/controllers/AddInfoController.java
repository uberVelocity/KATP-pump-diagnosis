package sample.controller.controllers;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.util.Duration;
import sample.controller.Controller;

/**
 * Logical controller for the additional info scene.
 */
public class AddInfoController implements SceneController {

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
        previousButton.setOnAction(e -> {
            if(previousButton.getId().equals("previousButton")) {
                controller.getView().getPrimaryStage().setScene(controller.getView().getTitleScene());
            }
        });
        nextButton.setOnAction(e -> {
            if(nextButton.getId().equals("nextButton")) {
                nextButton.setText("Stop touching me!");
            }
        });
        yesButton.setOnAction(e -> {
            if(yesButton.getId().equals("yesButton")) {
                fadeTransition(yesLabel);
            }
        });
        noButton.setOnAction(e -> {
            if(noButton.getId().equals("noButton")) {
                fadeTransition(noLabel);
            }
        });
    }

    private void fadeTransition(Control control) {
        FadeTransition ft = new FadeTransition(Duration.millis(500), control);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        control.setVisible(true);
    }

    public Controller getController() {
        return controller;
    }

}
