package processing;

import integrity.LandingSet;

public class ProcessOutputLandingSet implements Runnable{

	private LandingSet land;
	
	public ProcessOutputLandingSet(LandingSet landSet){
		this.land = landSet;
	}
	
	@Override
	public void run() {
		this.land.setValueDoor("0", 1000);
		this.land.setValueWheel("0", 2000);
		System.out.println("---------- END PROCESS OUTPUT OF THE LANDING SET : " + this.land.getSystemeName() + " ---------\n");
	}

}
