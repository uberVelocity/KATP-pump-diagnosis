package sample.controller;

import sample.controller.controllers.AddInfoController;
import sample.controller.controllers.MainQuestionController;
import sample.controller.controllers.TitleController;
import sample.model.Model;
import sample.view.View;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller class that handles interaction between the interface and the model.
 */
public class Controller {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private View view;
    private Model model;
    private Commander commander;

    /* Controller classes that handle logic of FXML files. */
    private AddInfoController addInfoController;
    private TitleController titleController;
    private MainQuestionController mainQuestionController;

    public Controller(Model model, View view) {
        commander = new Commander(this);
        this.model = model;
        this.view = view;
        initializeFXMLControllers();
        callFXMLLoaders();
        setButtonActions();
        displayTitleInterface();
    }

    /**
     * Creates instances of controllers that handle logic of FXML files
     * and binds the controllers to the FXLM files. It is important that
     * this is done before the FXML files are loaded into the program.
     */
    private void initializeFXMLControllers() {
        addInfoController = new AddInfoController(this);
        titleController = new TitleController(this);
        mainQuestionController = new MainQuestionController(this);

        view.setTitleController(titleController);
        view.setAddInfoController(addInfoController);
        view.setMainQuestionController(mainQuestionController);
    }

    /**
     * Calls the function which loads FXML files in the program.
     * Should be called after logical controllers have been created
     * but before any referenced field from the GUI is needed.
     */
    private void callFXMLLoaders() {
        try {
            view.loadFXMLFiles(view.getPrimaryStage());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Makes visible the elements of title scene.
     */
    private void displayTitleInterface() {
        titleController.displayInterface();
    }

    /**
     * Initializes the actions for each button in the program.
     * This should be called after the FXML files have been loaded
     * so that there are references to the button id's.
     */
    private void setButtonActions() {
        titleController.setButtonActions();
        addInfoController.setButtonActions();
        mainQuestionController.setButtonActions();

        logger.log(Level.INFO, "BUTTON ACTIONS INITIALIZED ...");
    }

    public AddInfoController getAddInfoController() {
        return addInfoController;
    }

    public TitleController getTitleController() {
        return titleController;
    }

    public MainQuestionController getMainQuestionController() {
        return mainQuestionController;
    }

    public Commander getCommander() {
        return commander;
    }

    public Model getModel() {
        return model;
    }

    public View getView() {
        return view;
    }
}
