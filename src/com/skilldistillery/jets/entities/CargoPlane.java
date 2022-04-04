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
		System.out.println("Cargo loaded! Prepare for take off!");
	}

	@Override
	public void fly() {
		System.out.println( this.toString() + this.getModel() + " can fly for " + (this.getRange() / this.getSpeed()) + " hours\n");		
	}

	@Override
	public String toString() {
		return "CargoPlane [ Model = " + getModel() + ", Speed = " + getSpeed() + ", Range = " + getRange()
				+ ", Price = " + getPrice() + "]\n";
	}
	@Override
	public double getSpeedInMach() {
		// TODO Auto-generated method stub
		return 0;
	}

}
