package com.skilldistillery.jets.entities;

import java.text.NumberFormat;
import java.util.Objects;

public abstract class Jets implements Flyable{
	
	private String model;
	private double speed;
	private int range;
	private long price;
	
	public Jets() {
		
	}
	
	public Jets(String model, double speed, int range, long price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}
		
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "This plane is a "+ model + " it can fly at " + speed + "MPH and its flight range is " + NumberFormat.getIntegerInstance().format(range) + " miles you can buy one for $" + NumberFormat.getIntegerInstance().format(price) + ".";
	}

	@Override
	public int hashCode() {
		return Objects.hash(model, price, range, speed);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jets other = (Jets) obj;
		return Objects.equals(model, other.model)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Double.doubleToLongBits(range) == Double.doubleToLongBits(other.range) && speed == other.speed;
	}

	
	
	
}
