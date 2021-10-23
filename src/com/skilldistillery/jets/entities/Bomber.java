package com.skilldistillery.jets.entities;

import java.text.NumberFormat;
import java.util.Objects;

public class Bomber extends Jets implements CanBomb {

	private Integer payload;
	
	
	public Bomber() {
		super();
	}
	
	public Bomber(String model, Integer speed, Double range, Long price, Integer payload) {
		super(model, speed, range, price);
		this.payload = payload;
	}

	
	public Integer getPayload() {
		return payload;
	}

	public void setPayload(Integer payload) {
		this.payload = payload;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(payload);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bomber other = (Bomber) obj;
		return payload == other.payload;
	}

	@Override
	public String toString() {
		return super.toString() + "\nThe " + super.getModel() + " can hold up to " + NumberFormat.getIntegerInstance().format(payload) + "lbs. in munitions.";
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


	@Override
	public void dropBombs() {
		System.out.println("The " + this.getModel() + " drops " + payload + "lbs. of munitions.");
		
	}

}
