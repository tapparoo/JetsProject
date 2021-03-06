package com.skilldistillery.jets;

import java.util.ArrayList;
import java.util.Scanner;

public class PilotList {
    private ArrayList<Pilot> pilots = new ArrayList<Pilot>();

    public ArrayList<Pilot> getPilots() {
	return pilots;
    }

    public void add(Pilot p) {
	pilots.add(p);
    }

    public Pilot getRandomPilot() {
	ArrayList<Pilot> available = getAllAvailablePilots();
	if (available.size() <= 0) {
	    System.out.println("Sorry, no pilots currently available");
	    return null;
	}

	return available.get((int) (Math.random() * available.size()));
    }

    public Pilot choosePilot(Scanner sc) {
	ArrayList<Pilot> available = getAllAvailablePilots();
	if (available.size() <= 0) {
	    System.out.println("Sorry, no pilots currently available");
	    return null;
	}

	Pilot p = available.get(0);
	System.out.print("Choose a pilot by selecting its index (0-" + (available.size() - 1) + ")");

	while (true) {
	    for (int i = 0; i < available.size(); i++) {
		p = available.get(i);
		System.out.println("\n\t" + i + ": " + p.getName() + " / Licensed: " + p.isLicensed() + " / Available: "
			+ !p.isWorking());
	    }
	    try {
		p = available.get(Integer.parseInt(sc.next()));
		break;
	    } catch (Exception e) {
		p = getRandomPilot();
		System.out.print("Invalid selection. Choosing pilot at random...." + p.getName() + "!");
		break;
	    }
	}
	return p;
    }

    public ArrayList<Pilot> getAllLicensedPilots() {
	ArrayList<Pilot> licensed = new ArrayList<Pilot>();

	for (Pilot p : pilots) {
	    if (p.isLicensed()) {
		licensed.add(p);
	    }
	}
	return licensed;
    }

    public ArrayList<Pilot> getAllAvailablePilots() {
	ArrayList<Pilot> available = new ArrayList<Pilot>();

	for (Pilot p : pilots) {
	    if (p.isLicensed() && !p.isWorking()) {
		available.add(p);
	    }
	}
	return available;

    }
}
