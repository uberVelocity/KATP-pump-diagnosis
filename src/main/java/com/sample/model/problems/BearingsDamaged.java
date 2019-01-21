package com.sample.model.problems;

import com.sample.model.Pump;

public class BearingsDamaged extends Problem {
	private static String description = "The bearings of the pump are damaged.";
	private static String solution = "First stop the pump, then change the bearings of the pump.";
	
	private static String[] conditions = {"isVibrating", "lowNoises"};
	private static boolean[] vals = {true, true};
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
	public static boolean[] getVals() {
		return vals;
	}
}