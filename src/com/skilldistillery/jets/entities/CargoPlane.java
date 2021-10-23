package com.skilldistillery.jets.entities;

import java.text.NumberFormat;
import java.util.Objects;
import java.util.Scanner;

public class CargoPlane extends Jets implements CargoCarrier{

	
	private Integer cargoCapacity;
	
	
	
	public CargoPlane() {
		super();
	}

	public CargoPlane(String model, Integer speed, Double range, Long price, Integer cargoCapacity) {
		super(model, speed, range, price);
		this.cargoCapacity = cargoCapacity;
	}

	
	public Integer getCargoCapacity() {
		return cargoCapacity;
	}

	public void setCargoCapacity(Integer cargoCapacity) {
		this.cargoCapacity = cargoCapacity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cargoCapacity);
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
		CargoPlane other = (CargoPlane) obj;
		return cargoCapacity == other.cargoCapacity;
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
	public String toString() {
		String info = super.toString() + "\nThe " + super.getModel() + " has a cargo capacity of " + NumberFormat.getIntegerInstance().format(cargoCapacity) + "lbs.";
		return info;
	}

	@Override
	public void loadCargo(int cargoCapacity, Scanner sc) {
		System.out.print("Please enter the amount in lbs. you would like to load into the " + this.getModel());
		int load = sc.nextInt();
		sc.nextLine();
		System.out.println("Loading cargo...");
		if(load > cargoCapacity) {
			System.out.println("The cargo is too heavy we can only carry " + NumberFormat.getIntegerInstance().format(cargoCapacity) + "lbs.");
		}else {
			System.out.println("Cargo Succesfully loaded weight and balance has been calculated. We're ready for takeoff.");
		}
		
	}


	



}
