package vo;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.Constantes;

public class DoorTest extends Door{

	@Test
	public void testGetDoor() {
		Door door = new Door();
		assertEquals(Constantes.OPEN_DOOR, door.getPositionDoor());
	}
	
	@Test
	public void testSetDoor(){
		Door door = new Door();
		door.setPositionDoor(Constantes.PROCESSING_DOOR);
		assertEquals(Constantes.PROCESSING_DOOR, door.getPositionDoor());
	}

}
