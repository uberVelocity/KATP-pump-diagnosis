package com.sample.model.problems;

import java.util.HashMap;

import com.sample.model.Pump;

public class Cavitation implements Problem {
	
	private static String description = "This is the description of cavitation!";
	private static String solution = "This is the solution for cavitation!";
	
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
