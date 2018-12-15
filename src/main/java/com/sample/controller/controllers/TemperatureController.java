package com.sample.controller.controllers;

import com.sample.controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TemperatureController extends SceneController {

	private Controller controller;
	
	@FXML
	private Button nextButton;
	
	@FXML
	private Button previousButton;
	
	@FXML
	private Button noButton;
	
	@FXML
	private Button yesButton;
	
	public TemperatureController() {}
	
	public TemperatureController(Controller controller) {
		this.controller = controller;
	}
	
	public void setButtonActions() {
		noButton.setOnAction(e -> {
			if(noButton.getId().equals("noButton")) {
				controller.getModel().getPump().setHighTemperature(false);
                controller.getModel().getPump().check("highTemperature");
				controller.getKsession().update(controller.getFactHandle(), controller.getModel().getPump());
				controller.getKsession().fireAllRules();
			}
		});
		
		yesButton.setOnAction(e -> {
			if(yesButton.getId().equals("yesButton")) {
				controller.getModel().getPump().setHighTemperature(true);
                controller.getModel().getPump().check("highTemperature");
				controller.getKsession().update(controller.getFactHandle(), controller.getModel().getPump());
				controller.getKsession().fireAllRules();
			}
		});
		
		nextButton.setOnAction(e -> {
			if(nextButton.getId().equals("nextButton")) {
				controller.getView().getPrimaryStage().setScene(controller.getTheRightScene());
			}
		});
		
		previousButton.setOnAction(e -> {
			if(previousButton.getId().equals("previousButton")) {
				controller.getView().getPrimaryStage().setScene(controller.getView().getAdditionalInfoScene());
			}
		});
		
	}
	
}
