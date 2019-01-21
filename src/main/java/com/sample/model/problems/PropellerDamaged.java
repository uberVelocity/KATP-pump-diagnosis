package com.sample.model.problems;

import com.sample.model.Pump;

public class PropellerDamaged extends Problem{
	private static String description = "The pump's propeller is damaged.";
	private static String solution = "Turn off the pump and check the condition of the propeller. Fix or replace if necessary.";
	
	private static String[] conditions = {"exitFlowBelowThreshold", "exitPressureBelowThreshold", "exitParametersCloseTo0"};
	private static boolean[] vals = {true, true, false};

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
	public static boolean[] getVals() {
		return vals;
	}
}
