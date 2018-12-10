package com.sample.model.problems;

import java.util.HashMap;

import com.sample.model.Pump;

public interface Problem {
	
	static boolean fitsModel(Pump pump) {
		return true;
	}
	
	static String getDescription() {
		return "Default description";
	}
	
	static String getSolution() {
		return "Default solution";
	}

}
