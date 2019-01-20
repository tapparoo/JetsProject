package com.skilldistillery.jets;

import java.util.ArrayList;
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

	PilotList pilots = new PilotList();
	Pilot[] ps = {
		new Pilot("John"),
		new Pilot("Adam"),
		new Pilot("Todd"),
		new Pilot("Anna"),
		new Pilot("Ebru"),
		new Pilot("Jesse"),
		new Pilot("Steve"),
		new Pilot("Young"),
		new Pilot("Denise"),
		new Pilot("Bruce") };

	for (Pilot p : ps) {
	    pilots.add(p);
	}

	airField.addJet(new CargoPlane("C-17 Globemaster III", 515, 2785, 218_000_000, pilots.getRandomPilot()));
	airField.addJet(new CargoPlane("KC-135 Stratotanker", 580, 1500, 39_600_000, pilots.getRandomPilot()));
	airField.addJet(new FighterJet("F-15 Eagle", 1650, 1222, 27_900_000, pilots.getRandomPilot()));
	airField.addJet(new FighterJet("B-2 Spirit", 630, 6900, 737_000_000, pilots.getRandomPilot()));
	airField.addJet(new FighterJet("F-35 Lightning II", 1200, 1200, 107_700_000, pilots.getRandomPilot()));

	while (true) {
	    displayUserMenu();
	    try {
		choice = Integer.parseInt(sc.nextLine());
		if (choice == 9) {
		    break;
		}
		doMenuChoice(airField, choice, sc, pilots);
		System.out.print("\nAny key to continue, or (Q)uit: ");
		String temp = sc.nextLine();
		if (temp.equalsIgnoreCase("q")) {
		    break;
		}
	    } catch (Exception e) {
		System.out.print("\nInvalid input.  Try again? (y/n) ");
		if (sc.nextLine().equalsIgnoreCase("n")) {
		    break;
		} else {
		    continue;
		}
	    }

	}
	sc.close();
    }

    private void displayUserMenu() {
	System.out.println("\n\t ---------------------------\n\t" + "|1. List fleet              |\n\t"
		+ "|2. Fly individual jet      |\n\t" + "|3. Fly all jets            |\n\t"
		+ "|4. View fastest jet        |\n\t" + "|5. View jet w/longest range|\n\t"
		+ "|6. Load all Cargo jets     |\n\t" + "|7. Dogfight!               |\n\t"
		+ "|8. Add a jet to Fleet      |\n\t" + "|9. Quit                    |\n\t"
		+ " ---------------------------\n");
	System.out.print(">> ");
    }

    private void doMenuChoice(AirField airField, int choice, Scanner sc, PilotList pilots) {
	switch (choice) {
	    case 1:
		System.out.println(airField.listFleet());
		break;
	    case 2:
		System.out.println("Select a jet to fly: ");
		int counter = 0;
		for (Jet j : airField.getJets()) {
		    System.out.println("\t" + ++counter + ": " + j.getModel());
		}
		airField.getJets().get(sc.nextInt() - 1).fly();
		break;
	    case 3:
		airField.flyAllJets();
		break;
	    case 4:
		Jet fastestJet = airField.getJets().get(0);
		for (Jet jet : airField.getJets()) {
		    if (jet.getSpeed() > fastestJet.getSpeed()) {
			fastestJet = jet;
		    }
		}
		System.out.println("Fastest jet: " + fastestJet.toString());
		break;
	    case 5:
		Jet furthestRangeJet = airField.getJets().get(0);
		for (Jet jet : airField.getJets()) {
		    if (jet.getRange() > furthestRangeJet.getRange()) {
			furthestRangeJet = jet;
		    }
		}
		System.out.println("Jet w/longest range: " + furthestRangeJet.toString());
		break;
	    case 6:
		for (Jet jet : airField.getJets()) {
		    if (jet instanceof CargoCarrier) {
			((CargoCarrier) jet).loadCargo();
		    }
		}
		break;
	    case 7:
		ArrayList<Jet> jetsArrList = airField.getJets();
		ArrayList<Jet> combatJets = new ArrayList<Jet>();

		for (Jet jet : jetsArrList) {
		    if (jet instanceof CombatReady) {
			combatJets.add(jet);
		    }
		}

		// Choose random target that isn't itself...
		for (int i = 0; i < combatJets.size(); i++) {
		    while (true) {
			int target = (int) (Math.random() * jetsArrList.size());
			if (combatJets.get(i).getModel() == jetsArrList.get(target).getModel()) {
			    continue;
			} else {
			    System.out.println(combatJets.get(i).getModel() + " is attacking "
				    + jetsArrList.get(target).getModel() + "!!!");
			    break;
			}
		    }
		}
		break;
	    case 8:
		Jet j;

		while (true) {
		    String model;
		    double speed;
		    int range;
		    long price;
		    int type;
		    Pilot pilot;

		    try {
			System.out.print("\nAdding new jet to fleet.\n\tModel: ");
			model = sc.next();
			System.out.print("\n\tSpeed: ");
			speed = sc.nextDouble();
			System.out.print("\n\tRange: ");
			range = sc.nextInt();
			System.out.print("\n\tPrice: ");
			price = sc.nextLong();
			System.out.print("\n\t(R)andom pilot or user (C)hoice? ");
			String temp = sc.next();
			if (temp.equalsIgnoreCase("r")) {
			    pilot = pilots.getRandomPilot();
			} else {
			    pilot = pilots.choosePilot(sc);
			}

			System.out.print("\n\tType: (1)Cargo / (2)Fighter)");
			type = sc.nextInt();
			if (type == 1) {
			    j = new CargoPlane(model, speed, range, price, pilot);
			} else {
			    j = new FighterJet(model, speed, range, price, pilot);
			}
			airField.addJet(j);
			System.out.println("Added new jet: " + j.toString());
		    } catch (Exception e) {
			System.out.print("Invalid entry, try again? (y/n) ");
			if (sc.nextLine().equalsIgnoreCase("n")) {
			    break;
			}
		    }
		    break;
		}
		break;
	    default:
		System.out.println("Invalid selection.  Try again!");
		break;
	}
    }
}