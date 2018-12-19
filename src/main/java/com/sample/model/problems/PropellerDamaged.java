package com.sample.model.problems;

import com.sample.model.Pump;

public class PropellerDamaged implements Problem{
	private static String description = "This is the description of damaged-propeller!";
	private static String solution = "This is the solution for damaged-propeller!";
	
	private static String[] conditions = {"exitFlowBelowThreshold", "exitPressureBelowThreshold", "exitParametersCloseTo0"};
	
	public static boolean fitsModel(Pump pump) {
		return (pump.wasChecked("exitFlowBelowThreshold") && pump.isExitFlowBelowThreshold())
			&& (pump.wasChecked("exitPressureBelowThreshold") && pump.isExitPressureBelowThreshold())
			&& (pump.wasChecked("exitParametersCloseTo0") && !pump.isExitParametersCloseTo0());
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
