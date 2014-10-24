package integrity;

import java.util.Observable;

import utils.Constantes;
import vo.Door;
import vo.Wheel;


public class LandingSet extends Observable{
	private String systemeName;
	private Door door;
	private Wheel wheel;
	
	public LandingSet(String id){
		setSystemeName(id);
		door = new Door();
		wheel = new Wheel();
	}
	  
	public void setValueDoor(String newState)
	{
	    // if value has changed notify observers
	      if(!this.door.getPositionDoor().equals(newState)) {
	         System.out.println("      DOOR # " + this.getSystemeName());
	         this.door.setPositionDoor(newState);
	         
	         // mark as value changed
	         setChanged();
	         // trigger notification
	         notifyObservers(this.getStateDoor());
	         
	 		try{
	 			Constantes cst = new Constantes();
	 			Thread.sleep(1000);
	 			newState = cst.closeDoor;
				}catch(InterruptedException e){
				System.out.println(e.getMessage()); 
				}
	 		
	 		
	         this.door.setPositionDoor(newState);
	         
	         // mark as value changed
	         setChanged();
	         // trigger notification
	         notifyObservers(this.getStateDoor());
	      }
	}

	public void setValueWheel(String newState)
	{
	    // if value has changed notify observers
	      if(!this.wheel.getPositionWheel().equals(newState)) {
	         System.out.println("      WHEEL #" + this.getSystemeName());
	         this.wheel.setPositionWheel(newState);
	         
	         // mark as value changed
	         setChanged();
	         // trigger notification
	         notifyObservers(this.getStateWheel());
	         
	 		try{
	 			Constantes cst = new Constantes();
	 			Thread.sleep(1000);
	 			newState = cst.insideWheel;
		         this.wheel.setPositionWheel(newState);

				}catch(InterruptedException e){
					System.out.println(e.getMessage()); 
				}
	         
	         // mark as value changed
	         setChanged();
	         // trigger notification
	         notifyObservers(this.getStateWheel());
	      }
	}
	
	
	public String getStateWheel(){
		String msg = null;
		Constantes cst = new Constantes();
		
		if(this.wheel.getPositionWheel().equals(cst.insideWheel)){
			msg = " INSIDE WHEEL ";
		}else if(this.wheel.getPositionWheel().equals(cst.outsideWheel)){
			msg = " OUTSIDE WHEEL ";
		}else if(this.wheel.getPositionWheel().equals(cst.processingWheel)){
			msg = " PROCESSING WHEEL ";
		}else{
			msg = " ERROR";
		}
		return msg;
	}
	
	public String getStateDoor() {
		String msg = null;
		Constantes cst = new Constantes();
		
		if(this.door.getPositionDoor().equals(cst.closeDoor)){
			msg = " CLOSE DOOR ";
		}else if(this.door.getPositionDoor().equals(cst.openDoor)){
			msg = " OPEN DOOR ";
		}else if(this.door.getPositionDoor().equals(cst.processingDoor)){
			msg = " PROCESSING DOOR ";
		}else{
			msg = " ERROR";
		}
		return msg;
	}
	
	public Door getDoor() {
		return door;
	}

	public void setDoor(Door door) {
		this.door = door;
	}

	public Wheel getWheel() {
		return wheel;
	}

	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}

	public String getSystemeName() {
		return systemeName;
	}

	public void setSystemeName(String systemeName) {
		this.systemeName = systemeName;
	}
}
