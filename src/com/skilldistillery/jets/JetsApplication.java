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

	airField.addJet(new CargoPlane("C-17 Globemaster III", 515, 2785, 218_000_000));
	airField.addJet(new CargoPlane("KC-135 Stratotanker", 580, 1500, 39_600_000));
	airField.addJet(new FighterJet("F-15 Eagle", 1650, 1222, 27_900_000));
	airField.addJet(new FighterJet("B-2 Spirit", 630, 6900, 737_000_000));
	airField.addJet(new FighterJet("F-35 Lightning II", 1200, 1200, 107_700_000));

	while (true) {
	    displayUserMenu();
	    try {
		System.out.print(">> ");
		choice = Integer.parseInt(sc.next());
		doMenuChoice(airField, choice, sc);
		System.out.print("\nAny key to continue, or (Q)uit: ");
	    } catch (Exception e) {
		System.out.print("\nInvalid input.  Try again? (y/n) ");
		if (sc.next().equalsIgnoreCase("n")) {
		    break;
		} else {
		    continue;
		}
	    }
	    if (sc.next().equalsIgnoreCase("q")) {
		break;
	    }
	}
	sc.close();
    }

    private void displayUserMenu() {
	System.out.println("\n\t ---------------------------\n\t" + "|1. List fleet              |\n\t"
		+ "|2. Fly all jets            |\n\t" + "|3. View fastest jet        |\n\t"
		+ "|4. View jet w/longest range|\n\t" + "|5. Load all Cargo jets     |\n\t"
		+ "|6. Dogfight!               |\n\t" + "|7. Add a jet to Fleet      |\n\t"
		+ "|8. Quit                    |\n\t" + " ---------------------------");
    }

    private void doMenuChoice(AirField airField, int choice, Scanner sc) {
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
	    case 6:
		ArrayList<Jet> jetsArrList = airField.getJets();
		ArrayList<Jet> combatJets = new ArrayList<Jet>();

		for (Jet jet : jetsArrList) {
		    if (jet instanceof CombatReady) {
			combatJets.add(jet);
		    }
		}

		for (int i = 0; i < combatJets.size(); i++) {
		    // Can't attack itself...
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
	    case 7:
		Jet j;

		while (true) {
		    String model;
		    double speed;
		    int range;
		    long price;
		    int type;

		    try {
			System.out.print("\nAdding new jet to fleet.\n\tModel: ");
			model = sc.next();
			System.out.print("\n\tSpeed: ");
			speed = sc.nextDouble();
			System.out.print("\n\tRange: ");
			range = sc.nextInt();
			System.out.print("\n\tPrice: ");
			price = sc.nextLong();

			System.out.print("Type: (1)Cargo / (2)Fighter)");
			type = sc.nextInt();
			if (type == 1) {
			    j = new CargoPlane(model, speed, range, price);
			}else {
			    j = new FighterJet(model, speed, range, price);
			}
			airField.addJet(j);
		    } catch (Exception e) {
			System.out.print("Invalid entry, try again? (y/n) ");
			if (sc.next().equalsIgnoreCase("n")) {
			    break;
			}
		    }
		    System.out.println("Added new jet");
		    break;
		}
		break;

	}
    }
}