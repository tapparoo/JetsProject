package com.skilldistillery.jets;

public class CargoPlane extends Jet implements CargoCarrier{

    public CargoPlane(String model, double speed, int range, long price, Pilot pilot) {
	super(model, speed, range, price, pilot);
    }
    
    public void loadCargo() {
	System.out.println(this.getModel() + " is loading cargo...");
    }

}
