package com.sample.controller.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import com.sample.controller.Controller;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Logical controller for the additional info scene.
 */
public class IsVibratingController extends SceneController {

    public IsVibratingController() {

    }

    public IsVibratingController(Controller controller) {
        this.controller = controller;
    }
    
	
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
    private TextArea textArea;


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
                controller.getView().getPrimaryStage().setScene(controller.getTheRightScene());
            }
        });
        yesButton.setOnAction(e -> {
            if(yesButton.getId().equals("yesButton")) {
                controller.getModel().getPump().check("isVibrating");
                controller.getModel().getPump().setVibrating(true);
                controller.getKsession().update(controller.getFactHandle(), controller.getModel().getPump());
                controller.getKsession().fireAllRules();
            }
        });
        noButton.setOnAction(e -> {
            if(noButton.getId().equals("noButton")) {
                controller.getModel().getPump().check("isVibrating");
                controller.getModel().getPump().setVibrating(false);
                controller.getKsession().update(controller.getFactHandle(), controller.getModel().getPump());
                controller.getKsession().fireAllRules();
            }
        });
    }
    
    public Controller getController() {
        return controller;
    }

}
