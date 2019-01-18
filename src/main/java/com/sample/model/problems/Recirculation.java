package com.sample.model.problems;

import com.sample.model.Pump;

public class Recirculation extends Problem{
	private static String description = "The pump is exhibiting internal recirculation. This will lead to cavitation.";
	private static String solution = "Increase suction flow until it is above minimum flow. When possible, or if the situation persists"
			+ ", turn off the pump"
			+ " and check the condition of seals, propeller and bearings.";
	
	private static String[] conditions = {"suctionFlowBelowThreshold", "bumpNoises"};
	
	public static boolean fitsModel(Pump pump) {
		return (pump.wasChecked("suctionFlowBelowThreshold") && pump.isSuctionFlowBelowThreshold())
			&& (pump.wasChecked("bumpNoises") && pump.isBumpNoises());
	}
	
	
	public static String getDescription() {
		return description;
	}
	
	public static String getSolution() {
		return solution;
	}
	
	public static String[] getConditions() {
		return conditions;
	}
}
