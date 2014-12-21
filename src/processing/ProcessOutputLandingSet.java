package processing;

import integrity.LandingSet;
import utils.Constantes;

public class ProcessOutputLandingSet implements Runnable{

	private LandingSet land;
	
	public ProcessOutputLandingSet(LandingSet landSet){
		this.land = landSet;
	}
	
	@Override
	public void run() {
		this.land.setValueDoor(Constantes.OUTSIDE_WHEEL);
		this.land.setValueWheel(Constantes.OPEN_DOOR);
		System.out.println("---------- END PROCESS OUTPUT OF THE LANDING SET : " + this.land.getSystemeName() + " ---------\n");
	}

}
