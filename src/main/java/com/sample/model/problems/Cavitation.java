package com.sample.model.problems;

import java.util.HashMap;

import com.sample.model.Pump;

public class Cavitation extends Problem {
	
	private static String description = "The pump is exhibiting cavitation.";
	private static String solution = "Increase suction pressure of the pump. As soon as possible, turn off the pump and"
			+ " check the condition of the propeller and other components of the pump.";
	
	private static String[] conditions = {"suctionPressureBelowNPSH"};
	
	public static boolean fitsModel(Pump pump) {
		return (pump.wasChecked("suctionPressureBelowNPSH") && pump.isSuctionPressureBelowNPSH());
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
