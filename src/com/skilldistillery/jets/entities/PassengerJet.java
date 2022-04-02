package com.skilldistillery.jets.entities;

public class PassengerJet extends Jet{

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getSpeedInMach() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public PassengerJet() {
		
	}
	public PassengerJet(String model, double speed, int range, long price) {
		this.setModel(model);
		this.setPrice(price);
		this.setRange(range);
		this.setSpeed(speed);
		
	}

}
