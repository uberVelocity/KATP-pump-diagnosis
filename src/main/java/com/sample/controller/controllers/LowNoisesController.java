package com.sample.controller.controllers;

import java.util.logging.Level;

import com.sample.controller.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class LowNoisesController {



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


    public LowNoisesController(Controller controller) {
    	this.controller = controller;
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
                controller.getView().getPrimaryStage().setScene(controller.getTheRightScene());
            }
        });
        yesButton.setOnAction(e -> {
            if(yesButton.getId().equals("yesButton")) {
                controller.getModel().getPump().check("lowNoises");
                controller.getModel().getPump().setLowNoises(true);
                controller.getKsession().update(controller.getFactHandle(), controller.getModel().getPump());
                controller.getKsession().fireAllRules();
            }
        });
        noButton.setOnAction(e -> {
            if(noButton.getId().equals("noButton")) {
                controller.getModel().getPump().check("lowNoises");
                controller.getModel().getPump().setLowNoises(false);
                controller.getKsession().update(controller.getFactHandle(), controller.getModel().getPump());
                controller.getKsession().fireAllRules();
            }
        });
    }
	
}
