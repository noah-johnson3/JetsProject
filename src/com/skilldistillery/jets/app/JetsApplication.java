package com.skilldistillery.jets.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
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
		jetNames = field.getJetList();
		displayUserMenu();

	}

	public void displayUserMenu() {

		boolean keepGoing = true;

		while (keepGoing) {
			System.out.println("Hello! Welcome to Jet Simulator please select one of the following options:");
			System.out.println("*	1. List fleet");
			System.out.println("*	2. Fly all jets");
			System.out.println("*	3. View fastest jet");
			System.out.println("*	4. View jet with longest range");
			System.out.println("*	5. Load all Cargo Jets");
			System.out.println("*	6. Dogfight!");
			System.out.println("*	7. Add a jet to fleet");
			System.out.println("*	8. Remove a jet from Fleet");
			System.out.println("*	9. Quit");
			int numChosen = userInput.nextInt();

			userInput.nextLine();

			switch (numChosen) {
			case 1:
				displayList();
				break;
			case 2:
				field.fly();
				break;
			case 3:
				fastestJet();
				break;
			case 4:
				longestRangeJet();
				break;
			case 5:

				for (Jet jet : jetNames) {

					if (jet instanceof CargoPlane) {
						((CargoPlane) jet).loadCargo();
					}
				}

				break;

			case 6:

				for (Jet jet : jetNames) {

					if (jet instanceof FighterJet) {
						((FighterJet) jet).fight();
					}
				}

				break;

			case 7:
				customJet();
				break;
			case 8:
				removeJet(userInput);
				break;
			case 9:
				System.out.println("Goodbye! Thank you for checking my Project, stay tuned for future Projects!");
				System.exit(0);
				break;

			default:
				break;
			}
		}

	}

	public void displayList() {

		for (int index = 0; index < jetNames.size(); index++) {

			System.out.println(index + " " + jetNames.get(index));

		}

	}

	

	public Jet fastestJet() {

		Jet fastestJet = jetNames.get(0);

		for (Jet jet : jetNames) {

			if (jet.getSpeed() > fastestJet.getSpeed()) {
				fastestJet = jet;
			}
		}
		System.out.println(fastestJet);
		return fastestJet;
	}

	public Jet longestRangeJet() {

		Jet longestRangeJet = jetNames.get(0);

		for (Jet jet : jetNames) {

			if (jet.getRange() > longestRangeJet.getRange()) {
				longestRangeJet = jet;
			}
		}
		System.out.println(longestRangeJet);
		return longestRangeJet;
	}

	public void customJet() {

		boolean keepGoing = true;
		while (keepGoing) {

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
				displayUserMenu();
				break;
			default:
				System.out.println("Invalid entry, please choose again");
				break;
			}
			if (name.equals("CargoPlane")) {
				customJet = new CargoPlane(model, speed, range, price);

			} else if (name.equalsIgnoreCase("FighterJet")) {
				customJet = new FighterJet(model, speed, range, price);

			} else if (name.equalsIgnoreCase("PassengerJet")) {
				customJet = new PassengerJet(model, speed, range, price);
			}

			jetNames.add(customJet);
			System.out.println("This is the jet you added: " + customJet.toString());
		}
	}

	public void removeJet(Scanner userInput) {

		System.out.println("Which jet would you like to remove? Please choose a number: ");
		displayList();
		int userChoice = userInput.nextInt();
		jetNames.remove(userChoice);
		displayList();
	}
}
