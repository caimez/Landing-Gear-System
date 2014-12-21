package vo;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.Constantes;

public class WheelTest {

	@Test
	public void testGetPositionWheel() {
		Wheel wheel = new Wheel();
		assertEquals(Constantes.OPEN_DOOR, wheel.getPositionWheel());
	}


	@Test
	public void testSetPositionWheel() {
		Wheel wheel = new Wheel();
		wheel.setPositionWheel(Constantes.PROCESSING_WHEEL);
		assertEquals(Constantes.PROCESSING_WHEEL, wheel.getPositionWheel());
	}

}
