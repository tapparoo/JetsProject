package com.skilldistillery.jets;

import java.util.Scanner;

public class JetsApplication {

    public static void main(String[] args) {
	JetsApplication app = new JetsApplication();
	app.launch();
    }

    private void launch() {
	AirField airField = new AirField();
	Scanner sc = new Scanner(System.in);
	int choice = 0;

	airField.addJet(new CargoPlane("C-17 Globemaster III", 515, 2785, 218_000_000));
	airField.addJet(new CargoPlane("KC-135 Stratotanker", 580, 1500, 39_600_000));
	airField.addJet(new FighterJet("F-15 Eagle", 1650, 1222, 27_900_000));
	airField.addJet(new FighterJet("B-2 Spirit", 630, 6900, 737_000_000));
	airField.addJet(new FighterJet("F-35 Lightning II", 1200, 1200, 107_700_000));

	displayUserMenu();

	try {
	    choice = Integer.parseInt(sc.next());
	} catch (Exception e) {
	    System.out.println("Invalid input.  Try again? (y/n)");
	    if (sc.next().equalsIgnoreCase("n")) {
	    } else {
		displayUserMenu();
	    }
	}
	doMenuChoice(airField, choice);

    }

    private void displayUserMenu() {
	System.out.println("\n\t ---------------------------\n\t" + "|1. List fleet              |\n\t"
		+ "|2. Fly all jets            |\n\t" + "|3. View fastest jet        |\n\t"
		+ "|4. View jet w/longest range|\n\t" + "|5. Load all Cargo jets     |\n\t"
		+ "|6. Dogfight!               |\n\t" + "|7. Add a jet to Fleet      |\n\t"
		+ "|8. Quit                    |\n\t" + " ---------------------------");
    }

    private void doMenuChoice(AirField airField, int choice) {
	switch (choice) {
	    case 1:
		System.out.println(airField.listFleet());
		break;
	    case 2:
		airField.flyAllJets();
		break;
	    case 3:
		Jet fastestJet = airField.getJets().get(0);
		for (Jet jet : airField.getJets()) {
		    if (jet.getSpeed() > fastestJet.getSpeed()) {
			fastestJet = jet;
		    }
		}
		System.out.println("Fastest jet: " + fastestJet.toString());
		break;
	    case 4:
		Jet furthestRangeJet = airField.getJets().get(0);
		for (Jet jet : airField.getJets()) {
		    if (jet.getRange() > furthestRangeJet.getRange()) {
			furthestRangeJet = jet;
		    }
		}
		System.out.println("Jet w/longest range: " + furthestRangeJet.toString());
		break;
	    case 5:
		for (Jet jet : airField.getJets()) {
		    if (jet instanceof CargoCarrier) {
			((CargoCarrier) jet).loadCargo();
		    }
		}
		break;
	}
    }
}