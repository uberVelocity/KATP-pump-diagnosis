package com.sample.model.problems;

import com.sample.model.Pump;

public class SealsDamaged implements Problem{
	private static String description = "This is the description of YOUR CEILS ARE DAMAGED M8!!";
	private static String solution = "This is the solution for YOUR CEILS ARE DAMAGED M8!!";
	
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
