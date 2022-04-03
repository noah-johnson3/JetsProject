package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.app.JetsApplication;


public class AirField {
	
	JetsApplication jets = new JetsApplication();
	
	Scanner userInput = new Scanner(System.in); 
	private List<Jet> jetList = new ArrayList<>();
	

	public void readFile() {

		BufferedReader bufIn = null;
		try {
			bufIn = new BufferedReader(new FileReader("jets.txt"));
			String line;
			while ((line = bufIn.readLine()) != null) {

				String[] splitFile = line.split(",");
				String model = splitFile[1];
				double speed = Double.parseDouble(splitFile[2]);
				int range = Integer.parseInt(splitFile[3]);
				long price = Long.parseLong(splitFile[4]);
				if (splitFile[0].equals("PassengerJet")) {

					Jet jet1 = new PassengerJet(splitFile[1], Double.parseDouble(splitFile[2]),
							Integer.parseInt(splitFile[3]), Long.parseLong(splitFile[4]));
					jetList.add(jet1);

				} else if (splitFile[0].equals("FighterJet")) {

					Jet jet2 = new FighterJet(splitFile[1], Double.parseDouble(splitFile[2]),
							Integer.parseInt(splitFile[3]), Long.parseLong(splitFile[4]));
					jetList.add(jet2);

				} else if (splitFile[0].equals("BobaJett")) {

					Jet jet3 = new BobaJett(splitFile[1], Double.parseDouble(splitFile[2]),
							Integer.parseInt(splitFile[3]), Long.parseLong(splitFile[4]));
					jetList.add(jet3);

				} else if (splitFile[0].equals("CargoPlane")) {

					Jet jet4 = new CargoPlane(splitFile[1], Double.parseDouble(splitFile[2]),
							Integer.parseInt(splitFile[3]), Long.parseLong(splitFile[4]));
					jetList.add(jet4);
				}
				System.out.println();

			}
			bufIn.close();
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			if (bufIn != null) {
				try {
					bufIn.close();
				} catch (IOException e) {
					System.err.println(e);
				}
			}
		}

	}

	public void displayList() {

		for (int index = 0; index < jetList.size(); index++) {

			System.out.println(index + " " + jetList.get(index));

		}

	}

	public void fly() {

		for (Jet jet : jetList) {
			System.out.println(jet + " can fly for " + (jet.getRange() / jet.getSpeed()) + " hours\n");
		}

	}

	public Jet fastestJet() {
		
		Jet fastestJet = jetList.get(0);
		
		for (Jet jet : jetList) {
			
			if(		jet.getSpeed() > fastestJet.getSpeed()	) {
				fastestJet = jet;
			}
		}
		System.out.println(fastestJet);
		return fastestJet;
	}

	public Jet longestRangeJet() {
		Jet longestRangeJet = jetList.get(0);
		
				for (Jet jet : jetList) {
					
					if(jet.getRange() > longestRangeJet.getRange() ) {
						longestRangeJet = jet;
					}
				}
		System.out.println(longestRangeJet);
		return longestRangeJet;
	}
	
	public void Airfield() {
		readFile();
		System.out.println(jetList);
	}
	public void customJet() {
		
		boolean keepGoing = true;
		while(keepGoing) {
			
		System.out.println("Welcome to the Custom Jet Menu!");
		System.out.println("Please select 1 or 2 ");
		System.out.println("1. To Create a Jet");
		System.out.println("2. Quit");
		
		Jet customJet = null;
		String model = "";
		String name = "";
		double speed = 0.0;
		int range = 0;
		long price = 0;
		
		int numChosen = userInput.nextInt();
		userInput.nextLine();
		switch (numChosen) {
		case 1: 
			System.out.println("Please enter what kind of Jet this is: ");
			name = userInput.nextLine();
			
		
			System.out.println("Please enter the Jet Model: ");
			model = userInput.nextLine();
		
			System.out.println("Please enter the Jet Speed: ");
			speed = userInput.nextDouble();
			userInput.nextLine();
		
			System.out.println("Please enter the Jet Range: ");
			range = userInput.nextInt();
			userInput.nextLine();
		
			System.out.println("Please enter the Jet Price: ");
			price = userInput.nextLong();
			userInput.nextLine();
			break;
		case 2:
			System.out.println("Goodbye!");
			keepGoing = false;
			jets.displayUserMenu();
			break;
		default:
			System.out.println("Invalid entry, please choose again");
			break;
		}
		if(name.equals("CargoPlane")) {
			customJet = new CargoPlane(model, speed,range,price);
			
		} else if(name.equalsIgnoreCase("FighterJet")) {
			customJet = new FighterJet(model,speed,range,price);
			
		} else if (name.equalsIgnoreCase("PassengerJet")) {
			customJet = new PassengerJet(model,speed,range,price);
		}
		
		jetList.add(customJet);
		System.out.println("This is the jet you added: " + customJet.toString());
		}
	}

	public List<Jet> getJetList() {
		return jetList;
	}
	public void removeJet(Scanner userInput) {
		
		System.out.println("Which jet would you like to remove? Please choose a number: ");
		displayList();
		int userChoice = userInput.nextInt();
		jetList.remove(userChoice);
		displayList();
	}
	public void setJetList(List<Jet> jets) {
		this.jetList = jets;
	}
}
