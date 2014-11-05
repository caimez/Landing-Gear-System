package processing;

import integrity.LandingSet;

public class ProcessReturnLandingSet implements Runnable{

	private LandingSet land;
	
	public ProcessReturnLandingSet(LandingSet landSet){
		this.land = landSet;
	}
	
	@Override
	public void run() {
		this.land.setValueWheel("1", 2000);
		this.land.setValueDoor("1", 1000);
		System.out.println("---------- END PROCESS RETURN OF THE LANDING SET  : " + this.land.getSystemeName() + " ---------\n");
	}

}
