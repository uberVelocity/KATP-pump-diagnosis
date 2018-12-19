package com.sample;

import javafx.application.Application;
import javafx.stage.Stage;

import com.sample.controller.Controller;
import com.sample.model.Model;
import com.sample.view.View;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
    	try {
            View view = new View(primaryStage);
            Model model = new Model();
            Controller controller = new Controller(model, view);  
            controller.getKsession().insert(model.getPump());
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    /*
    Whenever the main java program starts it calls launch(args) and sets up the program
    as a JavaFX application. The app will call the method start().
     */
    public static void main(String[] args) {
        launch(args);
    }
}