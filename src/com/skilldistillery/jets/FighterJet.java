package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady{

    public FighterJet(String model, double speed, int range, long price, Pilot pilot) {
	super(model, speed, range, price, pilot);
    }
    
    public void fight() {
	System.out.println(this.getModel() + " is attacking other jets at random!  ");
    }

}
