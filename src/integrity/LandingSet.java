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
	
	public void setValueDoor(String newState, int time)
	{
	    // if value has changed notify observers
	      if(!this.door.getPositionDoor().equals(newState)) {
	         System.out.println("START PROCESS DOOR # " + this.getSystemeName() + "\n");
	         this.door.setPositionDoor(Constantes.processingDoor);
	         
	         // mark as value changed
	         setChanged();
	         // trigger notification
	         notifyObservers(this.getStateDoor());
	        	 			
	 		try{
	 			Thread.sleep(1000);
	 			this.door.setPositionDoor(newState);
			}catch(InterruptedException e){
	 			this.door.setPositionDoor(Constantes.error);
				System.out.println(e.getMessage()); 
			}
	 			
	         // mark as value changed
	         setChanged();
	         
	         // trigger notification
	         notifyObservers(this.getStateDoor());
	      }
	}

	public void setValueWheel(String newState, int time)
	{
	    // if value has changed notify observers
		if(!this.wheel.getPositionWheel().equals(newState)) {
			System.out.println("START PROCESS WHEEL #" + this.getSystemeName()  + "\n");
			this.wheel.setPositionWheel(Constantes.processingWheel);
			 
			// mark as value changed
			setChanged();
			// trigger notification
			notifyObservers(this.getStateWheel());
	         			
	 		try{
	 			Thread.sleep(1000);
		        this.wheel.setPositionWheel(newState);
			}catch(InterruptedException e){
		        this.wheel.setPositionWheel(Constantes.error);
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
		
		if(this.wheel.getPositionWheel().equals(Constantes.insideWheel)){
			msg = " INSIDE WHEEL " + this.getSystemeName()  + "\n";
		}else if(this.wheel.getPositionWheel().equals(Constantes.outsideWheel)){
			msg = " OUTSIDE WHEEL " + this.getSystemeName()  + "\n";
		}else if(this.wheel.getPositionWheel().equals(Constantes.processingWheel)){
			msg = " PROCESSING WHEEL " + this.getSystemeName()  + "\n";
		}else{
			msg = " ERROR WHEEL"  + this.getSystemeName()  + "\n";
		}
		return msg;
	}
	
	public String getStateDoor() {
		String msg = null;
		
		if(this.door.getPositionDoor().equals(Constantes.closeDoor)){
			msg = " CLOSE DOOR "  + this.getSystemeName()  + "\n";
		}else if(this.door.getPositionDoor().equals(Constantes.openDoor)){
			msg = " OPEN DOOR "  + this.getSystemeName()  + "\n";
		}else if(this.door.getPositionDoor().equals(Constantes.processingDoor)){
			msg = " PROCESSING DOOR "  + this.getSystemeName()  + "\n";
		}else{
			msg = " ERROR DOOR "  + this.getSystemeName()  + "\n";
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
