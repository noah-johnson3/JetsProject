package com.skilldistillery.jets.entities;

public class PassengerJet extends Jet{

	@Override
	public void fly() {
		System.out.println(this.toString() + this.getModel() + " can fly for " + (this.getRange() / this.getSpeed()) + " hours\n");
		
	}

	@Override
	public String toString() {
		return "PassengerJet [ Model = " + getModel() + ", Speed = " + getSpeed() + ", Range = " + getRange()
				+ ", Price = " + getPrice() + "]\n";
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
