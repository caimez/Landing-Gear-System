package integrity;

import integrity.LandingSet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import communication.ComClientSystem;
import processing.ProcessOutputLandingSet;
import processing.ProcessReturnLandingSet;
import utils.Constantes;


public class SystemLandingSet implements Observer, ActionListener{

	private ArrayList<LandingSet> landingSetList;
	private ComClientSystem comClientSystem;

	public SystemLandingSet(ComClientSystem ccs){
		this.landingSetList = new ArrayList<LandingSet>(); 
		this.comClientSystem = ccs;
		
		LandingSet land1 = new LandingSet("Left", 1);
		LandingSet land2 = new LandingSet("Center", 2);
		LandingSet land3 = new LandingSet("Right", 3);
		
		this.landingSetList.add(land1);
		this.landingSetList.add(land2);
		this.landingSetList.add(land3);
	}
	
	public void initSystemLandingSet(){

	    // watcher object listens to object change
		SystemLandingSet watcherLeft = new SystemLandingSet(this.comClientSystem);
		SystemLandingSet watcherCenter = new SystemLandingSet(this.comClientSystem);
		SystemLandingSet watcherRight = new SystemLandingSet(this.comClientSystem);
		
		// add observer to the watched object
		this.landingSetList.get(0).addObserver(watcherLeft);
		this.landingSetList.get(1).addObserver(watcherCenter);
		this.landingSetList.get(2).addObserver(watcherRight);
		
		/*this.comClientSystem.setPanelStateWheel(this.getStateWheelByLandingSet(0), this.getIdStateWheelByLandingSet(0), 1);
		this.comClientSystem.setPanelStateDoor(this.getStateDoorByLandingSet(0), this.getIdStateDoorByLandingSet(0), 1);
		
		this.comClientSystem.setPanelStateWheel(this.getStateWheelByLandingSet(1), this.getIdStateWheelByLandingSet(1), 2);
		this.comClientSystem.setPanelStateDoor(this.getStateDoorByLandingSet(1), this.getIdStateDoorByLandingSet(1), 2);
		
		this.comClientSystem.setPanelStateWheel(this.getStateWheelByLandingSet(1), this.getIdStateWheelByLandingSet(2), 3);
		this.comClientSystem.setPanelStateDoor(this.getStateDoorByLandingSet(2), this.getIdStateDoorByLandingSet(2), 3);*/
		
		//this.comClientSystem.setVisibleMainWindow();
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
		
		if (arg0 instanceof LandingSet) {
			LandingSet ls = (LandingSet) arg0;
			
			//System.out.println("Mise a jour : => Etat DOOR " + ls.getSystemeName() + ": " + ls.getStateDoorString());
			//System.out.println("MAJ Observer : name => "+ ls.getSystemeName() + "  => " + ls.getId());
			 
			//Check wich component is update wheel or door
			if(arg.equals(Constantes.DOOR)){
				
				 //UPDATE PANEL DOOR
				 System.out.println("Mise a jour : => Etat DOOR " + ls.getSystemeName() + ": " + ls.getStateDoorString());
				 //this.comClientSystem.setPanelStateDoor(ls.getStateDoorString(), ls.getStateDoorInt(), ls.getId());
				 
			}else if(arg.equals(Constantes.WHEEL)){
				
				 //UPDATE PANEL WHEEL
				 System.out.println("Mise a jour : => Etat WHEEL " + ls.getSystemeName() + ": " + ls.getStateWheelString());
				 //this.comClientSystem.setPanelStateWheel(ls.getStateWheelString(), ls.getStateWheelInt(), ls.getId());
				 
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public ArrayList<LandingSet> getLandingSetList(){
		return this.landingSetList;
	}
	
	public void setLandingSetLsit(ArrayList<LandingSet> set){
		this.landingSetList = set;
	}
	
	
	/*
	 * GET STATE   BY LANDING SET
	 * return int
	 */
	public int getIdStateDoorByLandingSet(int idLS){
		int sStateDoor = 3;
		
		sStateDoor = this.landingSetList.get(idLS).getStateDoorInt();
		
		return sStateDoor;
	}
	
	/*
	 * GET STATE WHEEL BY LANDING SET 
	 * return int
	 */
	public int getIdStateWheelByLandingSet(int idLS){
		int iStateWheel = 3;
		
		iStateWheel = this.landingSetList.get(idLS).getStateWheelInt();
		
		return iStateWheel;
	}
	
	/*
	 * GET STATE DOOR  BY LANDING SET
	 * return String
	 */
	public String getStateDoorByLandingSet(int idLS){
		String iStateDoor ="";
		
		iStateDoor = this.landingSetList.get(idLS).getStateDoorString();
		
		return iStateDoor;
	}
	
	/*
	 * GET STATE WHEEL BY LANDING SET 
	 * return String
	 */
	public String getStateWheelByLandingSet(int idLS){
		String sStateWheel ="";
		
		sStateWheel = this.landingSetList.get(idLS).getStateWheelString();
		
		return sStateWheel;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
