package integrity;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import processing.ProcessOutputLandingSet;
import processing.ProcessReturnLandingSet;
import integrity.LandingSet;


public class SystemLandingSet implements Observer{

	private ArrayList<LandingSet> landingSetList;
	private LandingSet land1;
	private LandingSet land2;
	private LandingSet land3;

	public SystemLandingSet(){
		this.landingSetList = new ArrayList<LandingSet>(); 
		
		this.land1 = new LandingSet("Left");
		this.land2 = new LandingSet("Center");
		this.land3 = new LandingSet("Right");
		
		this.landingSetList.add(this.land1);
		this.landingSetList.add(this.land2);
		this.landingSetList.add(this.land3);
	}
	
	public void initSystemLandingSet(){

	    // watcher object listens to object change
		SystemLandingSet watcherLeft = new SystemLandingSet();
		SystemLandingSet watcherCenter = new SystemLandingSet();
		SystemLandingSet watcherRight = new SystemLandingSet();
		
		// add observer to the watched object
		this.landingSetList.get(0).addObserver(watcherLeft);
		this.landingSetList.get(1).addObserver(watcherCenter);
		this.landingSetList.get(2).addObserver(watcherRight);	
	}
	
	public void returnLandingSet(){
		Thread t1 = new Thread(new ProcessReturnLandingSet(this.landingSetList.get(0)));
		Thread t2 = new Thread(new ProcessReturnLandingSet(this.landingSetList.get(1)));
		Thread t3 = new Thread(new ProcessReturnLandingSet(this.landingSetList.get(2)));
		t1.start();
		t2.start();
		t3.start();
	}
	
	public void goOutLandingSet(){
		Thread t1 = new Thread(new ProcessOutputLandingSet(this.landingSetList.get(0)));
		Thread t2 = new Thread(new ProcessOutputLandingSet(this.landingSetList.get(1)));
		Thread t3 = new Thread(new ProcessOutputLandingSet(this.landingSetList.get(2)));
		t1.start();
		t2.start();
		t3.start();
	}
	
	
	public void update(Observable arg0, Object arg) {
		System.out.println("Mise a jour : => Etat :" + arg);		
	}

	public ArrayList<LandingSet> getLandingSetList(){
		return this.landingSetList;
	}
	
	public void setLandingSetLsit(ArrayList<LandingSet> set){
		this.landingSetList = set;
	}
}
