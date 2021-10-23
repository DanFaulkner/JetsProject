package com.skilldistillery.jets.entities;

public interface Flyable {
	Double fly(Double range, Integer speed);
	Double getSpeedInMach(Integer speed);
}
