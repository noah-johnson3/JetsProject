package com.skilldistillery.jets.entities;

public class BobaJett extends FighterJet{
	
	
	
	@Override
	public double getSpeedInMach() {
		return super.getSpeedInMach();
	}
	@Override
	public void fly() {
		System.out.println(super.toString() + this.getModel() + " can fly for " + (this.getRange() / this.getSpeed()) + " hours\n");
	}
	@Override
	public String toString() {
		return "BobaJett [Model = " + getModel() + ",Speed = " + getSpeed()
				+ ", Range=" + getRange() + ", Price =" + getPrice() + "]\n";
	}
	@Override
	public void fight() {
		System.out.println("pewpewpewpew");
	}
	public BobaJett(){
		
	}
	public BobaJett(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
}
