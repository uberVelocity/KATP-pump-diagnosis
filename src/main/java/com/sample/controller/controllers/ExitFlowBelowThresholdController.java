package com.sample.controller.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.sample.controller.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class ExitFlowBelowThresholdController extends SceneController {
	
	
	public ExitFlowBelowThresholdController(Controller controller) {
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
    private Label description;

    @FXML
    private Label state;

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
                controller.getModel().getPump().check("exitFlowBelowThreshold");
                controller.getModel().getPump().setExitFlowBelowThreshold(true);
                controller.getKsession().update(controller.getFactHandle(), controller.getModel().getPump());
                controller.getKsession().fireAllRules();
            }
        });
        noButton.setOnAction(e -> {
            if(noButton.getId().equals("noButton")) {
                controller.getModel().getPump().check("exitFlowBelowThreshold");
                controller.getModel().getPump().setExitFlowBelowThreshold(false);
                controller.getKsession().update(controller.getFactHandle(), controller.getModel().getPump());
                controller.getKsession().fireAllRules();
            }
        });
    }

	
}
