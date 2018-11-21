package sample.controller;

import sample.controller.controllers.AddInfoController;
import sample.controller.controllers.TitleController;
import sample.model.Model;
import sample.view.View;

import java.util.logging.Logger;

public class Controller {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private View view;
    private Model model;
    private Commander commander;

    private AddInfoController addInfoController;
    private TitleController titleController;

    public Controller(Model model, View view) {
        commander = new Commander(this);
        this.model = model;
        this.view = view;
        initializeFXMLControllers();
        initializeView();
        setButtonActions();
    }

    private void initializeFXMLControllers() {
        addInfoController = new AddInfoController(this);
        titleController = new TitleController(this);

        view.setTitleController(titleController);
        view.setAddInfoController(addInfoController);
    }

    private void initializeView() {
        try {
            view.initializeView(view.getPrimaryStage());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setButtonActions() {
        titleController.setButtonAction();
        addInfoController.setButtonAction();
        addInfoController.setButtonAction2();
    }

    public AddInfoController getAddInfoController() {
        return addInfoController;
    }

    public TitleController getTitleController() {
        return titleController;
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
