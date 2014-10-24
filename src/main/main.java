package main;

import java.util.Observable;
import java.util.Observer;

import integrity.LandingSet;

public class main implements Observer {
	   public static void main(String[] args) {
	  
	   // create watched and watcher objects
      LandingSet landingSet1 = new LandingSet("1");
	   // create watched and watcher objects
      LandingSet landingSet2 = new LandingSet("2");
	   // create watched and watcher objects
      LandingSet landingSet3 = new LandingSet("3");
      
	  System.out.println("          /********* Starting System *********/");
	  System.out.println("Etat Door #" + landingSet1.getSystemeName() + " : " + landingSet1.getStateDoor());
	  System.out.println("Etat Door #" + landingSet2.getSystemeName() + " : " + landingSet2.getStateDoor());
	  System.out.println("Etat Door #" + landingSet3.getSystemeName() + " : " + landingSet3.getStateDoor());
	  System.out.println("Etat Wheel #" + landingSet1.getSystemeName() + " : " + landingSet1.getStateWheel());
	  System.out.println("Etat Wheel #" + landingSet2.getSystemeName() + " : " + landingSet2.getStateWheel());
	  System.out.println("Etat Wheel #" + landingSet3.getSystemeName() + " : " + landingSet3.getStateWheel());
	  
      // watcher object listens to object change
      main watcher1 = new main();
      // watcher object listens to object change
      main watcher2 = new main();
      // watcher object listens to object change
      main watcher3 = new main();
      
      // add observer to the watched object
      landingSet1.addObserver(watcher1);
      
      // add observer to the watched object
      landingSet2.addObserver(watcher2);

      // add observer to the watched object
      landingSet3.addObserver(watcher3);
      
      // trigger value change
      landingSet1.setValueWheel("2");
      // trigger value change
      landingSet2.setValueWheel("2");
      // trigger value change
      landingSet3.setValueWheel("2");
      
      // trigger value change
      landingSet1.setValueDoor("2");
      // trigger value change
      landingSet2.setValueDoor("2");
      // trigger value change
      landingSet3.setValueDoor("2");
      
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Mise a jour : => Etat :" + arg);

	}
}
