package com.sample.controller.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import com.sample.controller.Controller;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Logical controller for the title screen scene.
 */
public class TitleController extends SceneController {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private Controller controller;

    @FXML
    private Button nextButton;

    @FXML
    private TextArea textArea;

    public TitleController() {

    }

    public TitleController(Controller controller) {
        this.controller = controller;
    }

    public void displayInterface() {
        fadeTransition(textArea, 700);
        textArea.setVisible(true);
    }

    public void setButtonActions() {
        logger.log(Level.INFO, "SET ACTIONS OF BUTTONS ...");
        nextButton.setOnAction(e -> {
            if(nextButton.getId().equals("nextButton")) {
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
