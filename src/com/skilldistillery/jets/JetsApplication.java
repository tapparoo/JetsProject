package com.skilldistillery.jets;

import java.util.Scanner;

public class JetsApplication {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	AirField airField = new AirField();
	
	airField.addJet(new CargoPlane("C-17 Globemaster III", 515, 2785, 218_000_000));
	airField.addJet(new CargoPlane("KC-135 Stratotanker", 580, 1500, 39_600_000));
	airField.addJet(new FighterJet("F-15 Eagle", 1650, 1222, 27_900_000));
	airField.addJet(new FighterJet("B-2 Spirit", 630, 6900, 737_000_000));
	airField.addJet(new FighterJet("F-35 Lightning II", 1200, 1200, 107_700_000));
	
    }
    
    private void launch() {
	
    }
    
    private void displayUserMenu() {
	
    }

}
