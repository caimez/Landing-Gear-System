package integrity;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.Constantes;

public class LandingSetTest {

	/*
	 * Test close door success of one landing set
	 * Door change position
	 */
	@Test
	public void testSetValueDoorTrue() {
		LandingSet landingSet = new LandingSet("TEST SET STATE VALUE DOOR SUCCESS", 1);
		landingSet.setValueDoor(Constantes.CLOSE_DOOR);
		assertEquals(Constantes.CLOSE_DOOR, landingSet.getStateDoorInt());
	}
	
	/*
	 * Test close door of one landing set
	 * Door has already the good position
	 */
	@Test
	public void testSetValueDoorFalse() {
		LandingSet landingSet = new LandingSet("TEST SET SAME STATE VALUE DOOR", 1);
		assertEquals(Constantes.OPEN_DOOR, landingSet.getStateDoorInt());
		landingSet.setValueDoor(Constantes.OPEN_DOOR);
		assertEquals(Constantes.OPEN_DOOR, landingSet.getStateDoorInt());
	}

	/*
	 * Test wheel door success of one landing set
	 * Wheel change position
	 */
	@Test
	public void testSetValueWheelTrue(){
		LandingSet landingSet = new LandingSet("TEST SET STATE VALUE WHEEL SUCCESS", 1);
		landingSet.setValueWheel(Constantes.CLOSE_DOOR);
		assertEquals(Constantes.CLOSE_DOOR, landingSet.getStateWheelInt());
	}
	
	/*
	 * Test wheel door of one landing set
	 * Wheel has already the good position
	 */
	@Test
	public void testSetValueWheelFalse() {
		LandingSet landingSet = new LandingSet("TEST SET SAME STATE VALUE WHEEL", 1);
		assertEquals(Constantes.OPEN_DOOR, landingSet.getStateWheelInt());
		landingSet.setValueWheel(Constantes.OPEN_DOOR);
		assertEquals(Constantes.OPEN_DOOR, landingSet.getStateWheelInt());
	}
	
}
