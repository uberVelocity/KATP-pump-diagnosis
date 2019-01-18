package com.sample.model.problems;

import com.sample.model.Pump;

public class RodDamaged extends Problem{
	private static String description = "The rod of the pump is damaged.";
	private static String solution = "Turn off the pump and check the condition of the rod. Fix or replace if necessary.";
	
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