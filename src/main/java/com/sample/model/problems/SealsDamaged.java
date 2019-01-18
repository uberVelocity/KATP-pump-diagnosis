package com.sample.model.problems;

import com.sample.model.Pump;

public class SealsDamaged extends Problem{
	private static String description = "The seals of the pump are damaged.";
	private static String solution = "Turn off pump and replace any broken seals.";
	
	private static String[] conditions = {"isLeaking"};

	public static boolean fitsModel(Pump pump) {
		return pump.wasChecked("isLeaking") && pump.isLeaking();
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
