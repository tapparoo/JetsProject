package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady{

    public FighterJet(String m, double s, int r, long price, Pilot p) {
	super(m, s, r, price, p);
    }
    
    public void fight() {
	System.out.println(this.getModel() + " is attacking other jets at random!  ");
    }

}
