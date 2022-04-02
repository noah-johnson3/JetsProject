package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet implements CargoCarrier {
	
	public CargoPlane() {
		
	}
	public CargoPlane(String model, double speed, int range, long price) {
		
		this.setModel(model);
		this.setPrice(price);
		this.setRange(range);
		this.setSpeed(speed);
	}
	public void loadCargo() {
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getSpeedInMach() {
		// TODO Auto-generated method stub
		return 0;
	}

}
