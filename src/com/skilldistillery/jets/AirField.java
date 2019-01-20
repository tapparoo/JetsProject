package com.skilldistillery.jets;

import java.util.ArrayList;

public class AirField {
    private ArrayList<Jet> jets = new ArrayList<Jet>();

    public ArrayList<Jet> getJets() {
	return jets;
    }

    public void addJet(Jet jet) {
	jets.add(jet);
    }

    public void flyAllJets() {
	for (Jet jet : jets) {
	    jet.fly();
	}
    }

    public String listFleet() {
	String out = "";
	for (Jet jet : getJets()) {
	    out += String.format("[%s] - Pilot: %s / Speed: %.1f / Range: %,d miles / Unit Cost: $%,d%n",
		    jet.getModel(), jet.getPilot().getName(), jet.getSpeed(), jet.getRange(), jet.getPrice());
	}
	return out;
    }

}
