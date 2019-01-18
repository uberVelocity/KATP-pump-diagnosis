package com.sample.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
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
import com.sample.controller.controllers.SolutionController;
import com.sample.controller.controllers.SuctionFlowBelowThresholdController;
import com.sample.controller.controllers.SuctionPressureBelowNPSHController;
import com.sample.controller.controllers.TitleController;
import com.sample.controller.controllers.TemperatureController;
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

    private Parent solutionParent;
    private Parent titleScreenParent;
    private Parent additionalInfoParent;
    private Parent mainQuestionParent;
    private Parent temperatureParent;
    private Parent highFrequencyVibrationParent;
    private Parent lowFrequencyVibrationParent;
    private Parent noisesParent;
    private Parent suctionPressureBelowNPSHParent;
    private Parent suctionFlowBelowThresholdParent;
    private Parent exitPressureBelowThresholdParent;
    private Parent exitParametersCloseTo0Parent;
    private Parent propellerSpeedBelowThresholdParent;
    private Parent speedBelowNormalParent;
    private Parent powerConsumptionAboveNormalParent;
    private Parent exitFlowBelowThresholdParent;
    private Parent isLeakingParent;
    private Parent highNoisesParent;
    private Parent lowNoisesParent;
    private Parent bumpNoisesParent;

    private Scene solutionScene;
	private Scene titleScene;
    private Scene additionalInfoScene;
    private Scene mainQuestionScene;
    private Scene temperatureScene;
    private Scene highFrequencyVibrationScene;
    private Scene lowFrequencyVibrationScene;
    private Scene noisesScene;
    private Scene suctionPressureBelowNPSHScene;
    private Scene suctionFlowBelowThresholdScene;
    private Scene exitPressureBelowThresholdScene;
    private Scene exitParametersCloseTo0Scene;
    private Scene propellerSpeedBelowThresholdScene;
    private Scene speedBelowNormalScene;
    private Scene powerConsumptionAboveNormalScene;
    private Scene exitFlowBelowThresholdScene;
    private Scene isLeakingScene;
	private Scene highNoisesScene;
    private Scene lowNoisesScene;
    private Scene bumpNoisesScene;
    
    private SolutionController solutionController;
    private TitleController titleController;
    private IsVibratingController isVibratingController;
    private MainQuestionController mainQuestionController;
    private TemperatureController temperatureController;
    private IsLeakingController isLeakingController;
    private NoisesController noisesController;
    private SuctionPressureBelowNPSHController suctionPressureBelowNPSHController;
    private SuctionFlowBelowThresholdController suctionFlowBelowThresholdController;
    private ExitFlowBelowThresholdController exitFlowBelowThresholdController;
    private ExitPressureBelowThresholdController exitPressureBelowThresholdController;
    private ExitParametersCloseTo0Controller exitParametersCloseTo0Controller; 
    private PropellerSpeedBelowThresholdController propellerSpeedBelowThresholdController;
    private PowerConsumptionAboveNormalController powerConsumptionAboveNormalController;
    private LowNoisesController lowNoisesController;
    private HighNoisesController highNoisesController;
    private BumpNoisesController bumpNoisesController;

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

        loader = new FXMLLoader(getClass().getResource("isvibrating.fxml"));
        loader.setController(isVibratingController);
        additionalInfoParent = loader.load();
        additionalInfoScene = new Scene(additionalInfoParent);

        loader = new FXMLLoader(getClass().getResource("mainquestion.fxml"));
        loader.setController(mainQuestionController);
        mainQuestionParent = loader.load();
        mainQuestionScene = new Scene(mainQuestionParent);
        
        loader = new FXMLLoader(getClass().getResource("temperature.fxml"));
        loader.setController(temperatureController);
        temperatureParent = loader.load();
        temperatureScene = new Scene(temperatureParent);

        loader = new FXMLLoader(getClass().getResource("exitflowbelowthreshold.fxml"));
        loader.setController(exitFlowBelowThresholdController);
        exitFlowBelowThresholdParent = loader.load();
        exitFlowBelowThresholdScene = new Scene(exitFlowBelowThresholdParent);
        
        loader = new FXMLLoader(getClass().getResource("exitparameterscloseto0.fxml"));
        loader.setController(exitParametersCloseTo0Controller);
        exitParametersCloseTo0Parent = loader.load();
        exitParametersCloseTo0Scene = new Scene(exitParametersCloseTo0Parent);
        
        loader = new FXMLLoader(getClass().getResource("exitpressurebelowthreshold.fxml"));
        loader.setController(exitPressureBelowThresholdController);
        exitPressureBelowThresholdParent = loader.load();
        exitPressureBelowThresholdScene = new Scene(exitPressureBelowThresholdParent);
        
        loader = new FXMLLoader(getClass().getResource("isleaking.fxml"));
        loader.setController(isLeakingController);
        isLeakingParent = loader.load();
        isLeakingScene = new Scene(isLeakingParent);
        
        loader = new FXMLLoader(getClass().getResource("noises.fxml"));
        loader.setController(noisesController);
        noisesParent = loader.load();
        noisesScene = new Scene(noisesParent);
        
        loader = new FXMLLoader(getClass().getResource("powerconsumptionabovenormal.fxml"));
        loader.setController(powerConsumptionAboveNormalController);
        powerConsumptionAboveNormalParent = loader.load();
        powerConsumptionAboveNormalScene = new Scene(powerConsumptionAboveNormalParent);
        
        loader = new FXMLLoader(getClass().getResource("propellerspeedbelowthreshold.fxml"));
        loader.setController(propellerSpeedBelowThresholdController);
        propellerSpeedBelowThresholdParent = loader.load();
        propellerSpeedBelowThresholdScene = new Scene(propellerSpeedBelowThresholdParent);
        
        loader = new FXMLLoader(getClass().getResource("suctionflowbelowthreshold.fxml"));
        loader.setController(suctionFlowBelowThresholdController);
        suctionFlowBelowThresholdParent = loader.load();
        suctionFlowBelowThresholdScene = new Scene(suctionFlowBelowThresholdParent);
        
        loader = new FXMLLoader(getClass().getResource("suctionpressurebelownpsh.fxml"));
        loader.setController(suctionPressureBelowNPSHController);
        suctionPressureBelowNPSHParent = loader.load();
        suctionPressureBelowNPSHScene = new Scene(suctionPressureBelowNPSHParent);
        
        loader = new FXMLLoader(getClass().getResource("highnoises.fxml"));
        loader.setController(highNoisesController);
        highNoisesParent = loader.load();
        highNoisesScene = new Scene(highNoisesParent);
        
        loader = new FXMLLoader(getClass().getResource("lownoises.fxml"));
        loader.setController(lowNoisesController);
        lowNoisesParent = loader.load();
        lowNoisesScene = new Scene(lowNoisesParent);
        
        loader = new FXMLLoader(getClass().getResource("bumpnoises.fxml"));
        loader.setController(bumpNoisesController);
        bumpNoisesParent = loader.load();
        bumpNoisesScene = new Scene(bumpNoisesParent);
        
        loader = new FXMLLoader(getClass().getResource("solution.fxml"));
        loader.setController(solutionController);
        solutionParent = loader.load();
        solutionScene = new Scene(solutionParent);
        
        logger.log(Level.INFO, "FXML FILES LOADED ...");

        primaryStage.setTitle("Centrifugal pump diagnosis");

        logger.log(Level.INFO, "SHOWING PRIMARY STAGE ...");
        
        primaryStage.setScene(titleScene);
        primaryStage.show();
    }
    
    public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public Parent getTemperatureParent() {
		return temperatureParent;
	}

	public void setTemperatureParent(Parent temperatureParent) {
		this.temperatureParent = temperatureParent;
	}

	public IsLeakingController getIsLeakingController() {
		return isLeakingController;
	}

	public void setIsLeakingController(IsLeakingController isLeakingController) {
		this.isLeakingController = isLeakingController;
	}

	public NoisesController getNoisesController() {
		return noisesController;
	}

	public void setNoisesController(NoisesController noisesController) {
		this.noisesController = noisesController;
	}

	public SuctionPressureBelowNPSHController getSuctionPressureBelowNPSHController() {
		return suctionPressureBelowNPSHController;
	}

	public void setSuctionPressureBelowNPSHController(
			SuctionPressureBelowNPSHController suctionPressureBelowNPSHController) {
		this.suctionPressureBelowNPSHController = suctionPressureBelowNPSHController;
	}

	public SuctionFlowBelowThresholdController getSuctionFlowBelowThresholdController() {
		return suctionFlowBelowThresholdController;
	}

	public void setSuctionFlowBelowThresholdController(
			SuctionFlowBelowThresholdController suctionFlowBelowThresholdController) {
		this.suctionFlowBelowThresholdController = suctionFlowBelowThresholdController;
	}

	public ExitFlowBelowThresholdController getExitFlowBelowThresholdController() {
		return exitFlowBelowThresholdController;
	}

	public void setExitFlowBelowThresholdController(ExitFlowBelowThresholdController exitFlowBelowThresholdController) {
		this.exitFlowBelowThresholdController = exitFlowBelowThresholdController;
	}

	public ExitPressureBelowThresholdController getExitPressureBelowThresholdController() {
		return exitPressureBelowThresholdController;
	}

	public void setExitPressureBelowThresholdController(
			ExitPressureBelowThresholdController exitPressureBelowThresholdController) {
		this.exitPressureBelowThresholdController = exitPressureBelowThresholdController;
	}

    
    public Scene getHighNoisesScene() {
		return highNoisesScene;
	}

	public void setHighNoisesScene(Scene highNoisesScene) {
		this.highNoisesScene = highNoisesScene;
	}

	public Scene getLowNoisesScene() {
		return lowNoisesScene;
	}

	public void setLowNoisesScene(Scene lowNoisesScene) {
		this.lowNoisesScene = lowNoisesScene;
	}

	public Scene getBumpNoisesScene() {
		return bumpNoisesScene;
	}

	public void setBumpNoisesScene(Scene bumpNoisesScene) {
		this.bumpNoisesScene = bumpNoisesScene;
	}

	
	public ExitParametersCloseTo0Controller getExitParametersCloseTo0Controller() {
		return exitParametersCloseTo0Controller;
	}

	public void setExitParametersCloseTo0Controller(ExitParametersCloseTo0Controller exitParametersCloseTo0Controller) {
		this.exitParametersCloseTo0Controller = exitParametersCloseTo0Controller;
	}

	public PropellerSpeedBelowThresholdController getPropellerSpeedBelowThresholdController() {
		return propellerSpeedBelowThresholdController;
	}

	public void setPropellerSpeedBelowThresholdController(
			PropellerSpeedBelowThresholdController propellerSpeedBelowThresholdController) {
		this.propellerSpeedBelowThresholdController = propellerSpeedBelowThresholdController;
	}
	
	public PowerConsumptionAboveNormalController getPowerConsumptionAboveNormalController() {
		return powerConsumptionAboveNormalController;
	}

	public void setPowerConsumptionAboveNormalController(
			PowerConsumptionAboveNormalController powerConsumptionAboveNormalController) {
		this.powerConsumptionAboveNormalController = powerConsumptionAboveNormalController;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public void setTitleScreenParent(Parent titleScreenParent) {
		this.titleScreenParent = titleScreenParent;
	}

	public void setAdditionalInfoParent(Parent additionalInfoParent) {
		this.additionalInfoParent = additionalInfoParent;
	}

	public void setMainQuestionParent(Parent mainQuestionParent) {
		this.mainQuestionParent = mainQuestionParent;
	}

	public void setTitleScene(Scene titleScene) {
		this.titleScene = titleScene;
	}

	public void setSolutionController(SolutionController solutionController) {
		this.solutionController = solutionController;
	}
	
	public void setAdditionalInfoScene(Scene additionalInfoScene) {
		this.additionalInfoScene = additionalInfoScene;
	}

	public void setMainQuestionScene(Scene mainQuestionScene) {
		this.mainQuestionScene = mainQuestionScene;
	}

	public void setTemperatureScene(Scene temperatureScene) {
		this.temperatureScene = temperatureScene;
	}


    public TitleController getTitleController() {
        return titleController;
    }

    public IsVibratingController getAddInfoController() {
        return isVibratingController;
    }

    public void setAddInfoController(IsVibratingController isVibratingController) {
        this.isVibratingController = isVibratingController;
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
    
    public TemperatureController getTemperatureController() {
    	return temperatureController;
    }

    public void setTemperatureController(TemperatureController temperatureController) {
    	this.temperatureController = temperatureController;
    }
    
    public Scene getTemperatureScene() {
    	return temperatureScene;
    }
    

    public Parent getHighFrequencyVibrationParent() {
		return highFrequencyVibrationParent;
	}

	public Parent getLowFrequencyVibrationParent() {
		return lowFrequencyVibrationParent;
	}

	public Parent getNoisesParent() {
		return noisesParent;
	}

	public Parent getSuctionPressureBelowNPSHParent() {
		return suctionPressureBelowNPSHParent;
	}

	public Parent getSuctionFlowBelowThresholdParent() {
		return suctionFlowBelowThresholdParent;
	}

	public Parent getExitPressureBelowThresholdParent() {
		return exitPressureBelowThresholdParent;
	}

	public Parent getExitParametersCloseTo0Parent() {
		return exitParametersCloseTo0Parent;
	}

	public Parent getPropellerSpeedBelowThresholdParent() {
		return propellerSpeedBelowThresholdParent;
	}

	public Parent getSpeedBelowNormalParent() {
		return speedBelowNormalParent;
	}

	public Parent getPowerConsumptionAboveNormalParent() {
		return powerConsumptionAboveNormalParent;
	}

	public Parent getExitFlowBelowThresholdParent() {
		return exitFlowBelowThresholdParent;
	}

	public Parent getIsLeakingParent() {
		return isLeakingParent;
	}

	public Scene getHighFrequencyVibrationScene() {
		return highFrequencyVibrationScene;
	}

	public Scene getLowFrequencyVibrationScene() {
		return lowFrequencyVibrationScene;
	}

	public Scene getNoisesScene() {
		return noisesScene;
	}

	public Scene getSuctionPressureBelowNPSHScene() {
		return suctionPressureBelowNPSHScene;
	}

	public Scene getSuctionFlowBelowThresholdScene() {
		return suctionFlowBelowThresholdScene;
	}

	public Scene getExitPressureBelowThresholdScene() {
		return exitPressureBelowThresholdScene;
	}

	public Scene getExitParametersCloseTo0Scene() {
		return exitParametersCloseTo0Scene;
	}

	public Scene getPropellerSpeedBelowThresholdScene() {
		return propellerSpeedBelowThresholdScene;
	}

	public Scene getSpeedBelowNormalScene() {
		return speedBelowNormalScene;
	}

	public Scene getPowerConsumptionAboveNormalScene() {
		return powerConsumptionAboveNormalScene;
	}

	public Scene getExitFlowBelowThresholdScene() {
		return exitFlowBelowThresholdScene;
	}

	public Scene getIsLeakingScene() {
		return isLeakingScene;
	}
	
    public void setHighNoisesController(HighNoisesController highNoisesController) {
    	this.highNoisesController = highNoisesController;
    }
    
    public void setLowNoisesController(LowNoisesController lowNoisesController) {
    	this.lowNoisesController = lowNoisesController;
    }
    
    public void setBumpNoisesController(BumpNoisesController bumpNoisesController) {
    	this.bumpNoisesController = bumpNoisesController;
    }
    
    public View(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
    }
    
    public Scene getSolutionScene() {
    	return solutionScene;
    }
}
