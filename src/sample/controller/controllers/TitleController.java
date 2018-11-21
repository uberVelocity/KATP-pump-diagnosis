package sample.controller.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.controller.Controller;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TitleController {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private Controller controller;

    @FXML
    public Button button;

    public TitleController() {

    }

    public TitleController(Controller controller) {
        this.controller = controller;
    }

    public void setButtonAction() {
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
