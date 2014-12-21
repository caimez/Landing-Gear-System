package integrity;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.Constantes;
import communication.ComClientSystem;

public class SystemLandingSetTest {
	private ComClientSystem ccs;

	@Test
	public void testReturnLandingSet() {
		System.out.println("TEST RETURN LANDING SET");

		//Initialisation and declaration object
		this.ccs = new ComClientSystem();
		SystemLandingSet sls = new SystemLandingSet(this.ccs);
		
		//Action return landing set from system control landing set 
		sls.returnLandingSet();
		
		//Waiting time process landing set
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Check state wheel for each landing set
		for(int i = 0; i<sls.getLandingSetList().size(); i++){
			assertEquals(Constantes.INSIDE_WHEEL, sls.getIdStateWheelByLandingSet(i));
		}
		
		//Check state door for each landing set 
		for(int i = 0; i<sls.getLandingSetList().size(); i++){
			System.out.println(" CLOSE DOOR : " + i + " STATE : " + sls.getIdStateDoorByLandingSet(i));
			assertEquals(Constantes.CLOSE_DOOR, sls.getIdStateDoorByLandingSet(i));
		}
	}

	/*	@Test
	public void testGoOutLandingSet() {
		System.out.println("TEST GO OUT LANDING SET");
		//Initialisation and declaration object
		this.ccs = new ComClientSystem();
		SystemLandingSet sls = new SystemLandingSet(this.ccs);
		
		//Action return landing set from system control landing set 
		sls.goOutLandingSet();
		
		//Check state door for each landing set 
		for(int i = 0; i<sls.getLandingSetList().size(); i++){
			assertEquals(Constantes.OPEN_DOOR, sls.getIdStateDoorByLandingSet(i));
		}

		//Check state wheel for each landing set
		for(int i = 0; i<sls.getLandingSetList().size(); i++){
			assertEquals(Constantes.OUTSIDE_WHEEL, sls.getIdStateWheelByLandingSet(i));
		}
	}*/

}
