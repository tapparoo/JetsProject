package com.skilldistillery.jets;

public class CargoPlane extends Jet implements CargoCarrier{

    public CargoPlane(String m, double s, int r, long price, Pilot p) {
	super(m, s, r, price, p);
    }
    
    public void loadCargo() {
	System.out.println(this.getModel() + " is loading cargo...");
    }

}
