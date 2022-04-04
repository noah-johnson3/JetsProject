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
	
	public AirField() {
		readFile();
	}
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

	public void fly() {

		for (Jet jet : jetList) {
			jet.fly();
		}

	}

	

	public List<Jet> getJetList() {
		return jetList;
	}

	public void setJetList(List<Jet> jets) {
		this.jetList = jets;
	}
}
