package com.skilldistillery.jets;

public abstract class Jet {
    private String model;
    private double speed;
    private int range;
    private long price;
    private Pilot pilot;

    public Jet(String model, double speed, int range, long price, Pilot pilot) {
	this.model = model;
	this.speed = speed;
	this.range = range;
	this.price = price;
	this.pilot = pilot;
	pilot.setWorking(true);
	pilot.setAssignedTo(this);
    }

    public void fly() {
	String out = "\n***FLYING***\n    [" + model + "]";
	out += String.format("%n           Unit Price: $%,d", price);
	out += String.format("%n                Speed: %1$.1f mph / Mach %2$.4f", speed, getSpeedInMach());
	out += String.format("%n                Range: %,d miles", range);
	out += String.format("%n      Max Flight Time: %.2f hours", getMaxFlightTime());
	out += String.format("%n                Pilot: %2$s", getMaxFlightTime(), pilot.getName());

	System.out.println(out);
    }

    public double getSpeedInMach() {
	return (double) Math.round((speed / 767.269) * 10000) / 10000;
    }

    public String getModel() {
	return model;
    }

    public void setModel(String model) {
	this.model = model;
    }

    public double getSpeed() {
	return speed;
    }

    public void setSpeed(double speed) {
	this.speed = speed;
    }

    public int getRange() {
	return range;
    }

    public void setRange(int range) {
	this.range = range;
    }

    public long getPrice() {
	return price;
    }

    public void setPrice(long price) {
	this.price = price;
    }

    public double getMaxFlightTime() {
	return (double) Math.round((range / speed) * 100) / 100;
    }

    public Pilot getPilot() {
	return pilot;
    }

    public void setPilot(Pilot pilot) {
	this.pilot = pilot;
    }

    @Override
    public String toString() {
	return this.getClass().getSimpleName() + " [model=" + model + ", speed=" + speed + ", range=" + range
		+ ", price=" + price + ", pilot=" + pilot.getName() + "]";
    }
}
