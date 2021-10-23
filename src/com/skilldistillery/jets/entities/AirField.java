package com.skilldistillery.jets.entities;

import java.util.ArrayList;

public class AirField extends ArrayList{
	
	private ArrayList <Jets> airField = new ArrayList();
	
	
	public void addJet(Jets jet) {
		airField.add(jet);
	}


	@Override
	public String toString() {
		return "AirField [airField=" + airField + "]";
	}



	

	
	
	
	
	
}
