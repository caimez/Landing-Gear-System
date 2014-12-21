package processing;

import integrity.LandingSet;
import utils.Constantes;

public class ProcessReturnLandingSet implements Runnable{

	private LandingSet land;
	
	public ProcessReturnLandingSet(LandingSet landSet){
		this.land = landSet;
	}
	
	@Override
	public void run() {
		this.land.setValueWheel(Constantes.INSIDE_WHEEL);
		this.land.setValueDoor(Constantes.CLOSE_DOOR);
		System.out.println("---------- END PROCESS RETURN OF THE LANDING SET  : " + this.land.getSystemeName() + " ---------\n");
	}

}
