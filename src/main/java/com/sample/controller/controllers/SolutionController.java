package com.sample.controller.controllers;

import javax.swing.text.StyledDocument;

import com.sample.controller.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;

public class SolutionController {

	private Controller controller;
	
	@FXML
	private Label description;
	
	@FXML
	private Label solution;
	
	public SolutionController (Controller controller) {
		this.controller = controller;
	}
	
	public void setDescription(String text) {
		description.setText(text);
	}
	
	public void setSolution(String text) {
		solution.setText(text);
	}
	
	public Label getDescription() {
		return description;
	}
	
	public Label getSolution() {
		return solution;
	}
	
}
