package com.sample.model.problems;

import com.sample.model.Pump;

public class Recirculation implements Problem{
	private static String description = "This is the description of Internal Recirculation!";
	private static String solution = "This is the solution for Internal Recirculation!";
	
	private static String[] conditions = {"suctionFlowBelowThreshold", "bumpNoises"};
	
	public static boolean fitsModel(Pump pump) {
		return (pump.wasChecked("suctionFlowBelowThreshold") && pump.isSuctionFlowBelowThreshold())
			//&& (pump.wasChecked("noises") && pump.isNoises())
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
