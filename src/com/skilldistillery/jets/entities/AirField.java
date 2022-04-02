package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirField {

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

			System.out.println(jetList.get(index));

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

	public List<Jet> getJetList() {
		return jetList;
	}

	public void setJetList(List<Jet> jets) {
		this.jetList = jets;
	}
}
