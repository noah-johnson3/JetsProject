package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.BobaJett;
import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.PassengerJet;

public class JetsApplication {

	AirField field;

	Scanner userInput = new Scanner(System.in);

	List<Jet> jetNames;
	

	public static void main(String[] args) {

		JetsApplication app = new JetsApplication();
		app.launch();
		
	}

	private void launch() {
		
		field = new AirField();
		field.readFile();
		jetNames = field.getJetList();
		displayUserMenu();

	}

	private void displayUserMenu() {

		boolean keepGoing = true;

		while (keepGoing) {
			System.out.println("Hello! Welcome to Jet Simulator please select one of the following options:");
			System.out.println("1. List fleet");
			System.out.println("2. Fly all jets");
			System.out.println("3. View fastest jet");
			System.out.println("4. View jet with longest range");
			System.out.println("5. Load all Cargo Jets");
			System.out.println("6. Dogfight!");
			System.out.println("7. Add a jet to fleet");
			System.out.println("8. Remove a jet from Fleet");
			System.out.println("9. Quit");
//			System.out.println(field.getJetList());
			int numChosen = userInput.nextInt();

			userInput.nextLine();

			switch (numChosen) {
			case 1:
				field.displayList();
				break;
			case 2:
				field.fly();
				break;
			case 3:
				field.fastestJet();
				break;
			case 4:
				field.longestRangeJet();
				break;
			case 5:
				for (Jet jet : jetNames) {
					
					if(jet instanceof CargoPlane) {
						((CargoPlane) jet).loadCargo();
					}
				}
				break;
			case 6:
				for (Jet jet : jetNames) {
					
					if(jet instanceof FighterJet) {
						((FighterJet) jet).fight();
					}
				}
				break;
			case 7:
				field.displayList();
				break;
//			case 8:
//				field.displayList();
//				break;
//			case 9:
//				field.displayList();
//				break;

			default:
				break;
			}
		}

	}

	

}
