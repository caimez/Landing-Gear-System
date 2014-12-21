package vo;

import utils.Constantes;


public class Door{
	private int positionDoor; // OUT=0, IN=1, TRANSIT=2

	public Door(){
		this.positionDoor = Constantes.OPEN_DOOR;
	}

	public int getPositionDoor() {
		return positionDoor;
	}

	public void setPositionDoor(int position) {
		this.positionDoor = position;
	}

}
