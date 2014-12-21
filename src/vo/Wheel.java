package vo;

import utils.Constantes;


public class Wheel{
	private int positionWheel; // OUT=0, IN=1, TRANSIT=2s
	
	public Wheel(){
		this.positionWheel = Constantes.OUTSIDE_WHEEL;
	}

	public int getPositionWheel() {
		return positionWheel;
	}

	public void setPositionWheel(int position) {
		this.positionWheel = position;
	}
}
