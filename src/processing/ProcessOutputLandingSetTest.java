package processing;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.Constantes;
import integrity.LandingSet;

public class ProcessOutputLandingSetTest {

	/*
	 * Check if action return landing set is correctly running 
	 */
	@Test
	public void testRun() {
		LandingSet ls = new LandingSet("TEST 1", 1);
		
		//Set state inside wheel, close door
		ls.setValueDoor(Constantes.CLOSE_DOOR);
		ls.setValueWheel(Constantes.INSIDE_WHEEL);
		
		//Check state inside wheel, close door
		assertEquals(Constantes.CLOSE_DOOR, ls.getStateDoorInt());
		assertEquals(Constantes.INSIDE_WHEEL, ls.getStateWheelInt());

		//Proceess run outside wheel, open door
		ProcessOutputLandingSet p = new ProcessOutputLandingSet(ls);
		p.run();
		
		//Check State outside wheel, open door
		assertEquals(Constantes.OPEN_DOOR, ls.getStateDoorInt());
		assertEquals(Constantes.OUTSIDE_WHEEL, ls.getStateWheelInt());
	}

}
