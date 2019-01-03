package com.sample.model.problems;

import com.sample.model.Pump;

public class RodDamaged implements Problem{
	private static String description = "This is the description of damaged-rod!";
	private static String solution = "This is the solution for damaged-rod!";
	
	private static String[] conditions = {"exitPressureBelowThreshold", "exitFlowBelowThreshold", "exitParametersCloseTo0"};

	public static boolean fitsModel(Pump pump) {
		return pump.wasChecked("exitPressureBelowThreshold") && pump.isExitPressureBelowThreshold() &&
			   pump.wasChecked("exitFlowBelowThreshold") && pump.isExitFlowBelowThreshold() && 
			   pump.wasChecked("exitParametersCloseTo0") && pump.isExitParametersCloseTo0();
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