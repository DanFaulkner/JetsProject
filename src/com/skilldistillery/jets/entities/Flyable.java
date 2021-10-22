package com.skilldistillery.jets.entities;

public interface Flyable {
	double fly(int range, int speed);
	double getSpeedInMach(int speed);
}
