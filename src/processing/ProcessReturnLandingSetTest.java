package processing;

import static org.junit.Assert.*;
import integrity.LandingSet;

import org.junit.Test;

import utils.Constantes;

public class ProcessReturnLandingSetTest {

	/*
	 * Check if action return landing set is correctly running 
	 */
	@Test
	public void testRun() {
		
		//By default landing set is outside
		LandingSet ls = new LandingSet("TEST 1", 1);
		
		//Proceess run inside wheel, close door
		ProcessReturnLandingSet p = new ProcessReturnLandingSet(ls);
		p.run();
		
		//Check State inside wheel, close door
		assertEquals(Constantes.CLOSE_DOOR, ls.getStateDoorInt());
		assertEquals(Constantes.INSIDE_WHEEL, ls.getStateWheelInt());
	}

}
