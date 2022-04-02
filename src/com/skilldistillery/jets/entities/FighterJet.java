package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady {

	

	public FighterJet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		
		this.setModel(model);
		this.setPrice(price);
		this.setRange(range);
		this.setSpeed(speed);
	}

	@Override
	public double getSpeedInMach() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void fly() {
		System.out.println("pewpewpewpewpew");
	}

	@Override
	public void fight() {
		// TODO Auto-generated method stub
		
	}
		
	}


