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
		System.out.println(this.toString() + this.getModel() + " can fly for " + (this.getRange() / this.getSpeed()) + " hours\n");
	}

	@Override
	public String toString() {
		return "FighterJet [ Model = " + getModel() + ", Speed = " + getSpeed() + ", Range = " + getRange()
				+ ",  Price = " + getPrice() + "]\n";
	}

	@Override
	public void fight() {
		System.out.println("Fighter Jet prepare for attack!");
		System.out.println("*loads missles*");
		System.out.println("*locking on to target*");
		System.out.println("*pew pew pew pew pew pew pew*");
		
	}
		
	}


