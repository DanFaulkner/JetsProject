package com.skilldistillery.jets.entities;

import java.text.NumberFormat;
import java.util.Objects;

public abstract class Jets implements Flyable{
	
	private String model;
	private Integer speed;
	private Double range;
	private Long price;
	
	public Jets() {
		
	}
	
	public Jets(String model, Integer speed, Double range, Long price) {
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

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public Double getRange() {
		return range;
	}

	public void setRange(Double range) {
		this.range = range;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return model + " it can fly at " + speed + "MPH and its flight range is " + NumberFormat.getIntegerInstance().format(range) + " miles you can buy one for $" + NumberFormat.getIntegerInstance().format(price) + ".";
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
