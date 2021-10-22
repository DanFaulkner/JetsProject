package com.skilldistillery.jets.entities;

import java.util.Objects;

public class Bomber extends Jets {

	private int payload;
	
	
	public Bomber() {
		super();
	}
	
	public Bomber(int payload) {
		super();
		this.payload = payload;
	}

	public int getPayload() {
		return payload;
	}

	public void setPayload(int payload) {
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
		return "Bomber [payload=" + payload + ", toString()=" + super.toString() + "]";
	}

	@Override
	public double fly(int range, int speed) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getSpeedInMach(int speed) {
		// TODO Auto-generated method stub
		return 0;
	}

}
