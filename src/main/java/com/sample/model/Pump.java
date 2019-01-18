package com.sample.model;
import java.util.*;

import com.sample.model.problems.BearingsDamaged;
import com.sample.model.problems.Cavitation;
import com.sample.model.problems.Debris;
import com.sample.model.problems.Problem;
import com.sample.model.problems.PropellerDamaged;
import com.sample.model.problems.Recirculation;
import com.sample.model.problems.RodDamaged;
import com.sample.model.problems.SealsDamaged;


/**
 * Class which holds the information of the centrifugal pump.
 */
public class Pump {	
	
	private String problemDescription;
	private String problemSolution;
	
	private HashMap checked;
	
	private boolean isOperating;

	private boolean isLeaking;
    private boolean isVibrating;
    private boolean highFreqVibration;
    private boolean lowFrequencyVibration;
    private boolean noises;
    private boolean bumpNoises;
    private boolean highNoises;
    private boolean lowNoises;
    
    private boolean suctionPressureBelowNPSH;
    private boolean suctionFlowBelowThreshold;
    private boolean exitFlowBelowThreshold;
    private boolean exitPressureBelowThreshold;
	private boolean exitParametersCloseTo0;
    private boolean highTemperature;
    private boolean propellerSpeedBelowThreshold;
    private boolean speedBelowNormal;
	private boolean powerConsumptionAboveNormal;

    public Pump() {
    	checked = new HashMap();
    	problemDescription = null;
    	problemSolution = null;
    }
    
    public void check(String key) {
    	checked.put(key, true);
    }
    
    public boolean wasChecked(String key) {
    	return checked.containsKey(key);
    }
    
	public boolean hasProblem(String problem) {
		switch (problem) {
			case "Cavitation" : 
				return Cavitation.fitsModel(this);
			case "Recirculation" :
				return Recirculation.fitsModel(this);
			case "SealsDamaged" :
				return SealsDamaged.fitsModel(this);
			case "RodDamaged" :
				return RodDamaged.fitsModel(this);
			case "Debris" :
				return Debris.fitsModel(this);
			case "PropellerDamaged" :
				return PropellerDamaged.fitsModel(this);
			case "BearingsDamaged" :
				return BearingsDamaged.fitsModel(this);
		}
		return false;
	}
    
	public HashMap getChecked() {
		return checked;
	}

	public void setChecked(HashMap checked) {
		this.checked = checked;
	}

	public boolean isOperating() {
		return isOperating;
	}

	public void setOperating(boolean isOperating) {
		this.isOperating = isOperating;
	}

	public boolean isLeaking() {
		return isLeaking;
	}

	public void setLeaking(boolean isLeaking) {
		this.isLeaking = isLeaking;
	}

	public String getProblemDescription() {
		return problemDescription;
	}

	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}

	public String getProblemSolution() {
		return problemSolution;
	}

	public void setProblemSolution(String problemSolution) {
		this.problemSolution = problemSolution;
	}

	
	public boolean isVibrating() {
		return isVibrating;
	}

	public void setVibrating(boolean isVibrating) {
		this.isVibrating = isVibrating;
	}

	
	
	public boolean isHighFreqVibration() {
		return highFreqVibration;
	}

	public void setHighFreqVibration(boolean highFreqVibration) {
		this.highFreqVibration = highFreqVibration;
	}

	public boolean isLowFrequencyVibration() {
		return lowFrequencyVibration;
	}

	public void setLowFrequencyVibration(boolean lowFrequencyVibration) {
		this.lowFrequencyVibration = lowFrequencyVibration;
	}

	public boolean isNoises() {
		return noises;
	}

	public void setNoises(boolean noises) {
		this.noises = noises;
	}

	public boolean isBumpNoises() {
		return bumpNoises;
	}

	public void setBumpNoises(boolean bumpNoises) {
		this.bumpNoises = bumpNoises;
	}

	public boolean isHighNoises() {
		return highNoises;
	}

	public void setHighNoises(boolean highNoises) {
		this.highNoises = highNoises;
	}

	public boolean isLowNoises() {
		return lowNoises;
	}

	public void setLowNoises(boolean lowNoises) {
		this.lowNoises = lowNoises;
	}

	public boolean isSuctionPressureBelowNPSH() {
		return suctionPressureBelowNPSH;
	}

	public void setSuctionPressureBelowNPSH(boolean suctionPressureBelowNPSH) {
		this.suctionPressureBelowNPSH = suctionPressureBelowNPSH;
	}

	public boolean isSuctionFlowBelowThreshold() {
		return suctionFlowBelowThreshold;
	}

	public void setSuctionFlowBelowThreshold(boolean suctionFlowBelowThreshold) {
		this.suctionFlowBelowThreshold = suctionFlowBelowThreshold;
	}

	public boolean isExitFlowBelowThreshold() {
		return exitFlowBelowThreshold;
	}

	public void setExitFlowBelowThreshold(boolean exitFlowBelowThreshold) {
		this.exitFlowBelowThreshold = exitFlowBelowThreshold;
	}

	public boolean isExitParametersCloseTo0() {
		return exitParametersCloseTo0;
	}

	public void setExitParametersCloseTo0(boolean exitParametersCloseTo0) {
		this.exitParametersCloseTo0 = exitParametersCloseTo0;
	}

	public boolean isHighTemperature() {
		return highTemperature;
	}

	public void setHighTemperature(boolean highTemperature) {
		this.highTemperature = highTemperature;
	}

	public boolean isPropellerSpeedBelowThreshold() {
		return propellerSpeedBelowThreshold;
	}

	public void setPropellerSpeedBelowThreshold(boolean propellerSpeedBelowThreshold) {
		this.propellerSpeedBelowThreshold = propellerSpeedBelowThreshold;
	}
	
	public boolean isSpeedBelowNormal() {
		return speedBelowNormal;
	}

	public void setSpeedBelowNormal(boolean speedBelowNormal) {
		this.speedBelowNormal = speedBelowNormal;
	}

	public boolean isPowerConsumptionAboveNormal() {
		return powerConsumptionAboveNormal;
	}

	public void setPowerConsumptionAboveNormal(boolean powerConsumptionAboveNormal) {
		this.powerConsumptionAboveNormal = powerConsumptionAboveNormal;
	}
	
	public boolean isExitPressureBelowThreshold() {
		return exitPressureBelowThreshold;
	}

	public void setExitPressureBelowThreshold(boolean exitPressureBelowThreshold) {
		this.exitPressureBelowThreshold = exitPressureBelowThreshold;
	}
}
