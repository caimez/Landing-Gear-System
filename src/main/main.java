package main;

import communication.ComClientSystem;
import integrity.SystemLandingSet;
import interfaceGraphique.MainWindow;



public class main {

	
	public static void main(String args[]) {
			
		ComClientSystem comClientSystem = new ComClientSystem();
		
		//Initialisation du systeme
		SystemLandingSet sysLandSet = new SystemLandingSet(comClientSystem);
		
		//Etat du systeme
		initSystem(sysLandSet);
		
		//Mise en place des observer du systeme
		sysLandSet.initSystemLandingSet();

		//Sortie landing set
		sysLandSet.returnLandingSet();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Sortie landing sets
		//sysLandSet.goOutLandingSet();
		
	}
	
	public static void initSystem(SystemLandingSet sysLandSet){
		System.out.println("          ********* Starting System *********");
		System.out.println("Etat Door #" + sysLandSet.getLandingSetList().get(0).getSystemeName() + " : " + sysLandSet.getStateDoorByLandingSet(0));
		System.out.println("Etat Door #" + sysLandSet.getLandingSetList().get(1).getSystemeName() + " : " + sysLandSet.getStateDoorByLandingSet(1));
		System.out.println("Etat Door #" + sysLandSet.getLandingSetList().get(2).getSystemeName() + " : " + sysLandSet.getStateDoorByLandingSet(2));
		System.out.println("Etat Wheel #" + sysLandSet.getLandingSetList().get(0).getSystemeName() + " : " + sysLandSet.getStateWheelByLandingSet(0));
		System.out.println("Etat Wheel #" + sysLandSet.getLandingSetList().get(1).getSystemeName() + " : " + sysLandSet.getStateWheelByLandingSet(1));
		System.out.println("Etat Wheel #" + sysLandSet.getLandingSetList().get(2).getSystemeName() + " : " + sysLandSet.getStateWheelByLandingSet(2));
		System.out.println("------------------------------------------------------\n");
	}
}
