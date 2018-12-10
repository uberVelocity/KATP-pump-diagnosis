package com.sample.controller.controllers;

import javafx.animation.FadeTransition;
import javafx.scene.control.Control;
import javafx.util.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * !TODO: Decide based on the inference made by the system which scene to be set.
 */

public class SceneController {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public void setButtonActions() {
        logger.log(Level.WARNING, "SET BUTTON ACTIONS NOT IMPLEMENTED IN CALLED CONTROLLER");
    }
    
    protected void fadeTransition(Control control, int fadeDuration) {
        FadeTransition ft = new FadeTransition(Duration.millis(fadeDuration), control);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        control.setVisible(true);
    }
}
