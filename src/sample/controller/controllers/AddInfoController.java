package sample.controller.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.controller.Controller;

public class AddInfoController {

    private Controller controller;

    @FXML
    public Button button;

    @FXML
    public Button button2;

    public AddInfoController() {

    }

    public AddInfoController(Controller controller) {
        this.controller = controller;
    }

    public void setButtonAction() {
        button.setOnAction(e -> {
            if(button.getId().equals("button")) {
                controller.getView().getPrimaryStage().setScene(controller.getView().getTitleScene());
            }
        });
    }

    public void setButtonAction2() {
        button2.setOnAction(e -> {
            System.out.println("Hey, I;m a button");
            button2.setText("Stop touching me!");
        });
    }

    public Controller getController() {
        return controller;
    }

}
