package sample.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controller.controllers.AddInfoController;
import sample.controller.controllers.TitleController;

import java.util.logging.Level;
import java.util.logging.Logger;

public class View {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private Stage primaryStage;

    private Parent titleScreenParent;
    private Parent additionalInfoParent;

    private Scene titleScene;
    private Scene additionalInfoScene;

    private TitleController titleController;
    private AddInfoController addInfoController;

    public View(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
    }

    public void loadFXMLFiles(Stage primaryStage) throws Exception {
        logger.log(Level.INFO, "LOADING FXML FILES ...");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("titlescreen.fxml"));
        loader.setController(titleController);
        titleScreenParent = loader.load();
        titleScene = new Scene(titleScreenParent);
        primaryStage.setScene(titleScene);

        loader = new FXMLLoader(getClass().getResource("additionalinfo.fxml"));
        loader.setController(addInfoController);
        additionalInfoParent = loader.load();
        additionalInfoScene = new Scene(additionalInfoParent);

        logger.log(Level.INFO, "Should show the stage");

        primaryStage.setTitle("Centrifugal pump diagnosis");
        primaryStage.show();
    }

    public TitleController getTitleController() {
        return titleController;
    }

    public AddInfoController getAddInfoController() {
        return addInfoController;
    }

    public void setAddInfoController(AddInfoController addInfoController) {
        this.addInfoController = addInfoController;
    }

    public void setTitleController(TitleController titleController) {
        this.titleController = titleController;
    }

    public Parent getTitleScreenParent() {
        return titleScreenParent;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public Scene getTitleScene() {
        return titleScene;
    }

    public Scene getAdditionalInfoScene() {
        return additionalInfoScene;
    }

    public Parent getAdditionalInfoParent() {
        return additionalInfoParent;
    }
}
