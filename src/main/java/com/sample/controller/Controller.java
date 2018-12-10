package com.sample.controller;

import com.sample.controller.controllers.AddInfoController;
import com.sample.controller.controllers.MainQuestionController;
import com.sample.controller.controllers.TitleController;
import com.sample.model.Model;
import com.sample.view.View;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.drools.KnowledgeBase;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.FactHandle;
import org.drools.KnowledgeBaseFactory;

import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;

import org.drools.io.ResourceFactory;

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

    private KnowledgeBase kbase;
	private StatefulKnowledgeSession ksession;
    private KnowledgeRuntimeLogger knowledgeLogger;
    private FactHandle factHandle;
    private FactHandle factHandle2;
    
    public Controller(Model model, View view) {
        commander = new Commander(this);
        this.model = model;
        this.view = view;
        try {
        	kbase = readKnowledgeBase();
            ksession = kbase.newStatefulKnowledgeSession();
            knowledgeLogger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
            factHandle = ksession.insert(model.getPump());
            ksession.fireAllRules();
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
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

    private static KnowledgeBase readKnowledgeBase() throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("Sample.drl"), ResourceType.DRL);
        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        if (errors.size() > 0) {
            for (KnowledgeBuilderError error: errors) {
                System.err.println(error);
            }
            throw new IllegalArgumentException("Could not parse knowledge.");
        }
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
        return kbase;
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
    public KnowledgeBase getKbase() {
		return kbase;
	}

	public void setKbase(KnowledgeBase kbase) {
		this.kbase = kbase;
	}

	public StatefulKnowledgeSession getKsession() {
		return ksession;
	}

	public void setKsession(StatefulKnowledgeSession ksession) {
		this.ksession = ksession;
	}

	public KnowledgeRuntimeLogger getKnowledgeLogger() {
		return knowledgeLogger;
	}

	public void setKnowledgeLogger(KnowledgeRuntimeLogger knowledgeLogger) {
		this.knowledgeLogger = knowledgeLogger;
	}
	
	public FactHandle getFactHandle() {
		return factHandle;
	}
}
