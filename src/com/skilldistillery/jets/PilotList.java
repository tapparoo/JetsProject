package com.skilldistillery.jets;

import java.util.ArrayList;

public class PilotList {
    private ArrayList<Pilot> pilots = new ArrayList<Pilot>();

    public ArrayList<Pilot> getPilots() {
	return pilots;
    }
    
    public void add(Pilot p) {
	pilots.add(p);
    }
    public void add(Pilot[] p) {
	for(Pilot pp : p) {
	    pilots.add(pp);
	}
    }
}
