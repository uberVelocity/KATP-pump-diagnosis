package sample.controller.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.controller.Controller;

import java.util.logging.Logger;

/**
 * Logical controller for the title screen scene.
 */
public class TitleController implements SceneController {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private Controller controller;

    @FXML
    private Button button;

    public TitleController() {

    }

    public TitleController(Controller controller) {
        this.controller = controller;
    }

    public void setButtonActions() {
        button.setOnAction(e -> {
            if(button.getId().equals("button")) {
                controller.getView().getPrimaryStage().setScene(controller.getView().getAdditionalInfoScene());
            }
        });
    }

    public Controller getController() {
        return controller;
    }

    public void requestInsertName() {

    }

}
