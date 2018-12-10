package com.sample.model;
import java.util.*;


/**
 * Class which holds the information of the centrifugal pump.
 */
public class Pump {	
	
	private HashMap checked;
	
	private boolean isOperating;
    
	private boolean isLeaking;
    private boolean isVibrating;
    private boolean isClogged;
    private boolean hasDebris;
    
    private boolean suctionPressureAboveNPSH;
    private boolean exitFlowBelowThreshold;
    private boolean highTemperature;
    private boolean propellerSpeedBelowThreshold;
    
    private Component propeller;
    private Component seal;
    private Component bearings;
    private Component rod;

    public Pump() {
    	checked = new HashMap();
    }
    
    public void check(String key) {
    	checked.put(key, true);
    }
    
    public boolean wasChecked(String key) {
    	return checked.containsKey(key);
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

	public boolean isVibrating() {
		return isVibrating;
	}

	public void setVibrating(boolean isVibrating) {
		this.isVibrating = isVibrating;
	}

	public boolean isClogged() {
		return isClogged;
	}

	public void setClogged(boolean isClogged) {
		this.isClogged = isClogged;
	}

	public boolean isHasDebris() {
		return hasDebris;
	}

	public void setHasDebris(boolean hasDebris) {
		this.hasDebris = hasDebris;
	}

	public boolean isSuctionPressureAboveNPSH() {
		return suctionPressureAboveNPSH;
	}

	public void setSuctionPressureAboveNPSH(boolean suctionPressureAboveNPSH) {
		this.suctionPressureAboveNPSH = suctionPressureAboveNPSH;
	}

	public boolean isExitFlowBelowThreshold() {
		return exitFlowBelowThreshold;
	}

	public void setExitFlowBelowThreshold(boolean exitFlowBelowThreshold) {
		this.exitFlowBelowThreshold = exitFlowBelowThreshold;
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

	public void setPropellerSpeed(boolean propellerSpeedBelowThreshold) {
		this.propellerSpeedBelowThreshold = propellerSpeedBelowThreshold;
	}

	public Component getPropeller() {
		return propeller;
	}

	public void setPropeller(Component propeller) {
		this.propeller = propeller;
	}

	public Component getSeal() {
		return seal;
	}

	public void setSeal(Component seal) {
		this.seal = seal;
	}

	public Component getBearings() {
		return bearings;
	}

	public void setBearings(Component bearings) {
		this.bearings = bearings;
	}

	public Component getRod() {
		return rod;
	}

	public void setRod(Component rod) {
		this.rod = rod;
	}
    
    
}
