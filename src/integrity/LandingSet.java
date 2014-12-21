package integrity;

import java.util.Observable;

import utils.Constantes;
import vo.Door;
import vo.Wheel;


public class LandingSet extends Observable{
	private String systemeName;
	private Door door;
	private Wheel wheel;
	private int id;
	
	public LandingSet(String name, int id){
		this.setSystemeName(name);
		this.setId(id);
		door = new Door();
		wheel = new Wheel();
	}
	
	public void setValueDoor(int newState)
	{
	    // if value has changed notify observers
	      if(this.door.getPositionDoor() != newState) {
	         System.out.println("START PROCESS DOOR # " + this.getSystemeName() + "\n");
	         this.door.setPositionDoor(Constantes.PROCESSING_DOOR);

	         // mark as value changed
	         setChanged();
	         // trigger notification
	         notifyObservers(Constantes.DOOR);
	         
	         try{
	 			Thread.sleep(Constantes.TIME_DOOR_SUCCESS);
	 			this.door.setPositionDoor(newState);
	         }catch(InterruptedException e){
	 			this.door.setPositionDoor(Constantes.ERROR);
	        	System.out.println(Constantes.ERROR);
	 			System.out.println(e.getMessage()); 
	         }
	 		
	         // mark as value changed
	         setChanged();
	         
	         // trigger notification
	         notifyObservers(Constantes.DOOR);
	      }else{
				System.out.println("DON'T START PROCESS DOOR #" + this.getSystemeName()  + ", DOOR HAVE ALREADY THE GOOD STATE\n");
		  }
	}

	public void setValueWheel(int newState)
	{
	    // if value has changed notify observers
		if(this.wheel.getPositionWheel() != newState) {
			System.out.println("START PROCESS WHEEL #" + this.getSystemeName()  + "\n");
			this.wheel.setPositionWheel(Constantes.PROCESSING_WHEEL);

	        // mark as value changed
	        setChanged();
	        // trigger notification
	        notifyObservers(Constantes.WHEEL);
	        
	        try{
	        	 Thread.sleep(Constantes.TIME_WHEEL_SUCCESS);
	        	 this.wheel.setPositionWheel(newState);
	        }catch(InterruptedException e){
	        	 this.wheel.setPositionWheel(Constantes.ERROR);
	        	 System.out.println(Constantes.ERROR);
	        	 System.out.println(e.getMessage()); 
	        }
	        
	        // mark as value changed
	        setChanged();
	         
	        // trigger notification
	        notifyObservers(Constantes.WHEEL);
		}else{
				System.out.println("DON'T START PROCESS WHEEL #" + this.getSystemeName()  + ", WHEEL HAVE ALREADY THE GOOD STATE\n");
	     }
	}
	
	
	public String getStateWheelString(){
		String msg = null;
		int state = Constantes.ERROR;
		
		state = this.wheel.getPositionWheel();
		
		if(state == Constantes.INSIDE_WHEEL){
			msg = " INSIDE WHEEL " + this.getSystemeName()  + "\n";
		}else if(state == Constantes.OUTSIDE_WHEEL){
			msg = " OUTSIDE WHEEL " + this.getSystemeName()  + "\n";
		}else if(state == Constantes.PROCESSING_WHEEL){
			msg = " PROCESSING WHEEL " + this.getSystemeName()  + "\n";
		}else{
			msg = " ERROR WHEEL"  + this.getSystemeName()  + "\n";
		}
		return msg;
	}
	
	public String getStateDoorString() {
		String msg = null;
		
		if(this.door.getPositionDoor() == Constantes.CLOSE_DOOR){
			msg = " CLOSE DOOR "  + this.getSystemeName()  + "\n";
		}else if(this.door.getPositionDoor() == Constantes.OPEN_DOOR){
			msg = " OPEN DOOR "  + this.getSystemeName()  + "\n";
		}else if(this.door.getPositionDoor() == Constantes.PROCESSING_DOOR){
			msg = " PROCESSING DOOR "  + this.getSystemeName()  + "\n";
		}else{
			msg = " ERROR DOOR "  + this.getSystemeName()  + "\n";
		}
		return msg;
	}
	
	// DOOR
	public Door getDoor() {
		return door;
	}

	public void setDoor(Door door) {
		this.door = door;
	}
	
	/*
	 * return value state door
	 * return int
	 */
	public int getStateDoorInt(){
		return this.door.getPositionDoor();
	}

	
	// WHEEL
	public Wheel getWheel() {
		return wheel;
	}

	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}
	
	/*
	 * return value state wheel
	 * return int
	 */
	public int getStateWheelInt(){
		return this.wheel.getPositionWheel();
	}

	// SYTEME
	public String getSystemeName() {
		return systemeName;
	}

	public void setSystemeName(String systemeName) {
		this.systemeName = systemeName;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
}
