package com.skilldistillery.jets;

import java.util.ArrayList;

public class AirField {
    ArrayList<Jet> jets = new ArrayList<Jet>();

    public ArrayList<Jet> getJets() {
        return jets;
    }

    public void addJet(Jet jet) {
	jets.add(jet);
    }
    
    
}
