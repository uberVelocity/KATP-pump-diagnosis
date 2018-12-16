package com.sample.model.problems;

import com.sample.model.Pump;

public class Debris implements Problem{
	private static String description = "This is the description of Debris!!";
	private static String solution = "This is the solution for Debris!!";
	
	private static String[] conditions = {"speedBelowNormal", "powerConsumptionAboveNormal"};
	
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
}
