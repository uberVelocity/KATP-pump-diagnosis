package com.sample.model.problems;

import com.sample.model.Pump;

public class Debris extends Problem{
	private static String description = "The pump has debris clogged within it.";
	private static String solution = "Turn off the pump and clean the debris.";
	
	private static String[] conditions = {"speedBelowNormal", "powerConsumptionAboveNormal"};
	private static boolean[] vals = {true, true};

	public static boolean fitsModel(Pump pump) {
		return (pump.wasChecked("speedBelowNormal") && pump.isSpeedBelowNormal())
			&& (pump.wasChecked("powerConsumptionAboveNormal") && pump.isPowerConsumptionAboveNormal());
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
