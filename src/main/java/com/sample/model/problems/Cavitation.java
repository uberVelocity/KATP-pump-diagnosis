package com.sample.model.problems;

import java.util.HashMap;

import com.sample.model.Pump;

public class Cavitation implements Problem {
	
	private static String description = "This is the description of cavitation!!";
	private static String solution = "This is the solution for cavitation!!";
	
	public static boolean fitsModel(Pump pump) {
		return (pump.wasChecked("isVibrating") && pump.isVibrating())
			&& (pump.wasChecked("highTemperature") && pump.isHighTemperature())
			&& (pump.wasChecked("suctionAboveNPSH") && pump.isSuctionPressureAboveNPSH());
	}
	
	public static String getDescription() {
		return description;
	}
	
	public static String getSolution() {
		return solution;
	}
	
}
