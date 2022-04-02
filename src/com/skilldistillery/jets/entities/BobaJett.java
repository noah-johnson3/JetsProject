package com.skilldistillery.jets.entities;

public class BobaJett extends FighterJet{
	
	
	
	@Override
	public double getSpeedInMach() {
		return super.getSpeedInMach();
	}
	@Override
	public void fly() {
		System.out.println("vroom vroom vroom glah glah glah vroom!!!");
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
