package sample.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controller.controllers.AddInfoController;
import sample.controller.controllers.MainQuestionController;
import sample.controller.controllers.SceneController;
import sample.controller.controllers.TitleController;
import java.util.logging.Level;
import java.util.logging.Logger;

/* TODO: Split primaryStage and inferenceStage into different classes. */

/**
 * Class which implements the GUI of the program. The GUI is created using
 * FXML files which hold information of each scene.
 * TERMINOLOGY:
 * -Stage: The window of the program (think of a frame).
 * -Scene: The things contained in your window. We move from scene to scene. (think panels).
 * -Parents: http://tutorials.jenkov.com/javafx/overview.html <- These guys explain it really well.
 */
public class View {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private Stage primaryStage;

    private Parent titleScreenParent;
    private Parent additionalInfoParent;
    private Parent mainQuestionParent;

    private Scene titleScene;
    private Scene additionalInfoScene;
    private Scene mainQuestionScene;

    private SceneController sceneController;

    private TitleController titleController;
    private AddInfoController addInfoController;
    private MainQuestionController mainQuestionController;

    public View(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
    }

    /**
     *
     * @param primaryStage: Initial stage of the program. This is created automatically
     *                    by the program when it runs. It is not special in any way from
     *                    a regular stage created by us.
     * @throws Exception: thrown when: location of FXMLLoader is invalid.
     * !This function should be called ONLY when the logical controllers have been
     * initialized. This is done in the controller constructor.
     */
    public void loadFXMLFiles(Stage primaryStage) throws Exception {
        logger.log(Level.INFO, "LOADING FXML FILES ...");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("titlescreen.fxml"));
        loader.setController(titleController);
        titleScreenParent = loader.load();
        titleScene = new Scene(titleScreenParent);

        loader = new FXMLLoader(getClass().getResource("additionalinfo.fxml"));
        loader.setController(addInfoController);
        additionalInfoParent = loader.load();
        additionalInfoScene = new Scene(additionalInfoParent);

        loader = new FXMLLoader(getClass().getResource("mainquestion.fxml"));
        loader.setController(mainQuestionController);
        mainQuestionParent = loader.load();
        mainQuestionScene = new Scene(mainQuestionParent);

        logger.log(Level.INFO, "FXML FILES LOADED ...");

        primaryStage.setTitle("Centrifugal pump diagnosis");

        logger.log(Level.INFO, "SHOWING PRIMARY STAGE ...");
        primaryStage.setScene(titleScene);
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

    public Parent getMainQuestionParent() {
        return mainQuestionParent;
    }

    public Scene getMainQuestionScene() {
        return mainQuestionScene;
    }

    public MainQuestionController getMainQuestionController() {
        return mainQuestionController;
    }

    public void setMainQuestionController(MainQuestionController mainQuestionController) {
        this.mainQuestionController = mainQuestionController;
    }

    public void setSceneController(SceneController sceneController) {
        this.sceneController = sceneController;
    }
}
