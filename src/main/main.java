package main;

import integrity.SystemLandingSet;

public class main {
	
	//private static SystemLandingSet sysLandSet;
	
	public static void main(String args[]) {
		//Initialisation du systeme
		SystemLandingSet sysLandSet = new SystemLandingSet();
		
		//Etat du systeme
		initSystem(sysLandSet);
		
		//Mise en place des observer du systeme
		sysLandSet.initSystemLandingSet();
		
		//Rentrer landing sets
		sysLandSet.returnLandingSet();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//Sortie landing set
		sysLandSet.goOutLandingSet();
	}
	
	public static void initSystem(SystemLandingSet sysLandSet){
		System.out.println("          /********* Starting System *********/");
		System.out.println("Etat Door #" + sysLandSet.getLandingSetList().get(0).getSystemeName() + " : " + sysLandSet.getLandingSetList().get(0).getStateDoor());
		System.out.println("Etat Door #" + sysLandSet.getLandingSetList().get(1).getSystemeName() + " : " + sysLandSet.getLandingSetList().get(1).getStateDoor());
		System.out.println("Etat Door #" + sysLandSet.getLandingSetList().get(2).getSystemeName() + " : " + sysLandSet.getLandingSetList().get(2).getStateDoor());
		System.out.println("Etat Wheel #" + sysLandSet.getLandingSetList().get(0).getSystemeName() + " : " + sysLandSet.getLandingSetList().get(0).getStateWheel());
		System.out.println("Etat Wheel #" + sysLandSet.getLandingSetList().get(1).getSystemeName() + " : " + sysLandSet.getLandingSetList().get(1).getStateWheel());
		System.out.println("Etat Wheel #" + sysLandSet.getLandingSetList().get(2).getSystemeName() + " : " + sysLandSet.getLandingSetList().get(2).getStateWheel());
		System.out.println("------------------------------------------------------\n");
	}
}
