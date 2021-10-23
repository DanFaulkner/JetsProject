package com.skilldistillery.jets.entities;

public class JetImpl extends Jets{

	
	
	
	
	
	public JetImpl() {
		super();
	}

	public JetImpl(String model, Integer speed, Double range, Long price) {
		super(model, speed, range, price);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public Double fly(Double range, Integer speed) {
		double flightTimeHrs = range / speed;
		return flightTimeHrs;
		
	}

	@Override
	public Double getSpeedInMach(Integer speed) {
		double speedInMach = speed * 0.001303;
		return speedInMach;
	}

}
