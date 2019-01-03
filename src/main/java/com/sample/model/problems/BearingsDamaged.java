package com.sample.model.problems;

import com.sample.model.Pump;

public class BearingsDamaged implements Problem{
	private static String description = "This is the description of damaged-bearings!";
	private static String solution = "This is the solution for damaged-bearings!";
	
	private static String[] conditions = {"isVibrating", "lowNoises"};
	
	public static boolean fitsModel(Pump pump) {
		return(pump.wasChecked("isVibrating") && pump.isVibrating())
			&&(pump.wasChecked("lowNoises") && pump.isLowNoises());
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