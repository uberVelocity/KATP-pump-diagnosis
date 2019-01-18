package com.sample.controller;
import javafx.scene.Scene;
import com.sample.controller.controllers.IsVibratingController;
import com.sample.controller.controllers.BumpNoisesController;
import com.sample.controller.controllers.ExitFlowBelowThresholdController;
import com.sample.controller.controllers.ExitParametersCloseTo0Controller;
import com.sample.controller.controllers.ExitPressureBelowThresholdController;
import com.sample.controller.controllers.HighNoisesController;
import com.sample.controller.controllers.IsLeakingController;
import com.sample.controller.controllers.LowNoisesController;
import com.sample.controller.controllers.MainQuestionController;
import com.sample.controller.controllers.NoisesController;
import com.sample.controller.controllers.PowerConsumptionAboveNormalController;
import com.sample.controller.controllers.PropellerSpeedBelowThresholdController;
import com.sample.controller.controllers.SuctionFlowBelowThresholdController;
import com.sample.controller.controllers.SuctionPressureBelowNPSHController;
import com.sample.controller.controllers.TitleController;
import com.sample.controller.controllers.TemperatureController;
import com.sample.model.Model;
import com.sample.model.problems.BearingsDamaged;
import com.sample.model.problems.Cavitation;
import com.sample.model.problems.Debris;
import com.sample.model.problems.Problem;
import com.sample.model.problems.PropellerDamaged;
import com.sample.model.problems.Recirculation;
import com.sample.model.problems.RodDamaged;
import com.sample.model.problems.SealsDamaged;
import com.sample.view.View;
import com.sample.controller.controllers.SolutionController;

import java.util.HashMap;
import java.util.Map.Entry;
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
    
    private HashMap<String, Scene> qMap = new HashMap<String, Scene>();

    private View view;
    private Model model;
    private Commander commander;

    /* Controller classes that handle logic of FXML files. */
    private IsVibratingController isVibratingController;
    private TitleController titleController;
    private MainQuestionController mainQuestionController;
    private TemperatureController temperatureController;
    private IsLeakingController isLeakingController;
    private NoisesController noisesController;
    private LowNoisesController lowNoisesController;
    private HighNoisesController highNoisesController;
    private BumpNoisesController bumpNoisesController;
    private SuctionPressureBelowNPSHController suctionPressureBelowNPSHController;
    private SuctionFlowBelowThresholdController suctionFlowBelowThresholdController;
    private ExitFlowBelowThresholdController exitFlowBelowThresholdController;
    private ExitPressureBelowThresholdController exitPressureBelowThresholdController;
    private ExitParametersCloseTo0Controller exitParametersCloseTo0Controller; 
    private PropellerSpeedBelowThresholdController propellerSpeedBelowThresholdController;
    private PowerConsumptionAboveNormalController powerConsumptionAboveNormalController;
    private SolutionController solutionController;
    
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
        initializeHashmap();
    }

    public void initializeHashmap() {
    	qMap.put("highTemperature", getView().getTemperatureScene());
    	qMap.put("isVibrating", getView().getAdditionalInfoScene());
    	qMap.put("noises", getView().getNoisesScene());
    	qMap.put("lowNoises", getView().getLowNoisesScene());
    	qMap.put("highNoises", getView().getHighNoisesScene());
    	qMap.put("bumpNoises", getView().getBumpNoisesScene());
    	qMap.put("suctionPressureBelowNPSH", getView().getSuctionPressureBelowNPSHScene());
    	qMap.put("speedBelowNormal", getView().getPropellerSpeedBelowThresholdScene());
    	qMap.put("powerConsumptionAboveNormal", getView().getPowerConsumptionAboveNormalScene());
    	qMap.put("exitFlowBelowThreshold", getView().getExitFlowBelowThresholdScene());
    	qMap.put("exitPressureBelowThreshold", getView().getExitPressureBelowThresholdScene());
    	qMap.put("exitParametersCloseTo0", getView().getExitParametersCloseTo0Scene());
    	qMap.put("suctionFlowBelowThreshold", getView().getSuctionFlowBelowThresholdScene());
    	qMap.put("isLeaking", getView().getIsLeakingScene());
    }
    
    public Scene getSolutionScene(String problemDescription, String problemSolution) {
    	solutionController.setDescription(problemDescription);
    	solutionController.setSolution(problemSolution);
    	return view.getSolutionScene();
    }
    //TODO 
    public Scene getTheRightScene() {
    	if(model.getPump().getProblemDescription() != null) {
    		return getSolutionScene(model.getPump().getProblemDescription(), model.getPump().getProblemSolution());
    	}
    	Scene bestScene;
    	int factsNeeded = 999;
    	HashMap<String, Integer> decisionMap = new HashMap<String, Integer>();
    	
    	decisionMap.put("highTemperature", 0);
    	decisionMap.put("isVibrating", 0);
    	decisionMap.put("noises", 0);
    	decisionMap.put("lowNoises", 0);
    	decisionMap.put("highNoises", 0);
    	decisionMap.put("bumpNoises", 0);
    	decisionMap.put("suctionPressureBelowNPSH", 0);
    	decisionMap.put("speedBelowNormal", 0);
    	decisionMap.put("powerConsumptionAboveNormal", 0);
    	decisionMap.put("exitFlowBelowThreshold", 0);
    	decisionMap.put("exitPressureBelowThreshold", 0);
    	decisionMap.put("exitParametersCloseTo0", 0);
    	decisionMap.put("suctionFlowBelowThreshold", 0);
    	decisionMap.put("isLeaking", 0);
    	
    	dealWithProblems(decisionMap, BearingsDamaged.getConditions());
    	dealWithProblems(decisionMap, Cavitation.getConditions());
    	dealWithProblems(decisionMap, Debris.getConditions());
    	dealWithProblems(decisionMap, PropellerDamaged.getConditions());
    	dealWithProblems(decisionMap, Recirculation.getConditions());
    	dealWithProblems(decisionMap, RodDamaged.getConditions());
    	dealWithProblems(decisionMap, SealsDamaged.getConditions());

    	String maxCondition = "";
    	int max = -1;
    	for(Entry<String, Integer> entry : decisionMap.entrySet()) {
    		if(max<entry.getValue()) {
    			max= entry.getValue();
    			maxCondition = entry.getKey();
    		}
    	}
    	return qMap.get(maxCondition);
    	
    }
    
    public void dealWithProblems(HashMap<String, Integer> decisionMap, String[] conditions) {
    	
    	int k=0;
    	for(String condition : conditions) {
    		if(!getModel().getPump().wasChecked(condition)) k++;
    	}
    	
    	for(String condition : conditions) {
    		if(!getModel().getPump().wasChecked(condition)) 
    			decisionMap.replace(condition, decisionMap.get(condition)+(100/k));
    		
    	}
    }
    
    
    /**
     * Creates instances of controllers that handle logic of FXML files
     * and binds the controllers to the FXLM files. It is important that
     * this is done before the FXML files are loaded into the program.
     */
    private void initializeFXMLControllers() {
		isVibratingController = new IsVibratingController(this);
		titleController = new TitleController(this);
		mainQuestionController = new MainQuestionController(this);
		temperatureController = new TemperatureController(this);
		isLeakingController = new IsLeakingController(this);
		noisesController = new NoisesController(this);
		suctionPressureBelowNPSHController = new SuctionPressureBelowNPSHController(this);
		suctionFlowBelowThresholdController = new SuctionFlowBelowThresholdController(this);
		exitFlowBelowThresholdController = new ExitFlowBelowThresholdController(this);
		exitPressureBelowThresholdController = new ExitPressureBelowThresholdController(this);
		exitParametersCloseTo0Controller = new ExitParametersCloseTo0Controller(this); 
		propellerSpeedBelowThresholdController = new PropellerSpeedBelowThresholdController(this);
		powerConsumptionAboveNormalController = new PowerConsumptionAboveNormalController(this);
		highNoisesController = new HighNoisesController(this);
		lowNoisesController = new LowNoisesController(this);
		bumpNoisesController = new BumpNoisesController(this);
		solutionController = new SolutionController(this);
		
        view.setTitleController(titleController);
        view.setAddInfoController(isVibratingController);
        view.setMainQuestionController(mainQuestionController);
        view.setTemperatureController(temperatureController);
        view.setExitFlowBelowThresholdController(exitFlowBelowThresholdController);
        view.setExitParametersCloseTo0Controller(exitParametersCloseTo0Controller);
        view.setExitPressureBelowThresholdController(exitPressureBelowThresholdController);
        view.setPowerConsumptionAboveNormalController(powerConsumptionAboveNormalController);
        view.setNoisesController(noisesController);
        view.setPropellerSpeedBelowThresholdController(propellerSpeedBelowThresholdController);
        view.setHighNoisesController(highNoisesController);
        view.setLowNoisesController(lowNoisesController);
        view.setBumpNoisesController(bumpNoisesController);
        view.setIsLeakingController(isLeakingController);
        view.setSuctionPressureBelowNPSHController(suctionPressureBelowNPSHController);
        view.setSuctionFlowBelowThresholdController(suctionFlowBelowThresholdController);
        view.setSolutionController(solutionController);
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
     * Initializes the actions for each button in the program.
     * This should be called after the FXML files have been loaded
     * so that there are references to the button id's.
     */
    private void setButtonActions() {
        titleController.setButtonActions();
        isVibratingController.setButtonActions();
        mainQuestionController.setButtonActions();
        temperatureController.setButtonActions();
        powerConsumptionAboveNormalController.setButtonActions();
        isLeakingController.setButtonActions();
		noisesController.setButtonActions();
		suctionPressureBelowNPSHController.setButtonActions();
		suctionFlowBelowThresholdController.setButtonActions();
		exitFlowBelowThresholdController.setButtonActions();
		exitPressureBelowThresholdController.setButtonActions();
		exitParametersCloseTo0Controller.setButtonActions();
		propellerSpeedBelowThresholdController.setButtonActions();
		highNoisesController.setButtonActions();
		lowNoisesController.setButtonActions();
		bumpNoisesController.setButtonActions();

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

    
    public IsVibratingController getAddInfoController() {
        return isVibratingController;
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
