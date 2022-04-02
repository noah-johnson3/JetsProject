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

	AirField field = new AirField();

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		JetsApplication app = new JetsApplication();
		List<Jet> jetNames = new ArrayList<>();
		
		app.readFile("jets.txt", jetNames);
		app.launch(userInput);
	}

	public void readFile(String fn, List<Jet> jetNames) {

		BufferedReader bufIn = null;
		try {
			bufIn = new BufferedReader(new FileReader("input.txt"));
			String line;
			while ((line = bufIn.readLine()) != null) {

				String[] splitFile = line.split(",");

				String model = splitFile[1];
				double speed = Double.parseDouble(splitFile[2]);
				int range = Integer.parseInt(splitFile[3]);
				long price = Long.parseLong(splitFile[4]);

				if (splitFile[0].equals("PassengerJet")) {

					Jet jet = new PassengerJet(model, speed, range, price);
					jetNames.add(jet);
				} else if (splitFile[0].equals("FighterJet")) {
					Jet jet = new FighterJet(model, speed, range, price);
					jetNames.add(jet);
				} else if (splitFile[0].equals("BobaJett")) {
					Jet jet = new BobaJett(model, speed, range, price);
					jetNames.add(jet);
				} else if (splitFile[0].equals("CargoPlane")) {
					Jet jet = new CargoPlane(model, speed, range, price);
					jetNames.add(jet);
				}
				
			}
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

	public void populateList(List<Jet> names, List<HashSet<String>> jetList) {

		for (HashSet<String> hashSet : jetList) {

		}
	}

	private void launch(Scanner userInput) {

		displayUserMenu(userInput);

	}

	private void displayUserMenu(Scanner userInput) {

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

	}

}
