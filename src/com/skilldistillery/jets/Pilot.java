package com.skilldistillery.jets;

public class Pilot extends Person {
    private boolean licensed, working;
    private Jet assignedTo;

    public Pilot(String name) {
	this(name, true);
    }
    
    public Pilot(String name, boolean licensed) {
	this(name, licensed, false);
    }

    public Pilot(String name, boolean licensed, boolean working) {
	super(name);
	this.licensed = licensed;
	this.working = working;
    }

    public boolean isLicensed() {
        return licensed;
    }

    public void setLicensed(boolean licensed) {
        this.licensed = licensed;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }
    
    public Jet getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Jet assignedTo) {
        this.assignedTo = assignedTo;
    }
    
}