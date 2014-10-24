package vo;


public class Wheel{
	private String positionWheel; // OUT=0, IN=1, TRANSIT=2s
	
	public Wheel(){
		this.positionWheel = "0";
	}

	public String getPositionWheel() {
		return positionWheel;
	}

	public void setPositionWheel(String position) {
		this.positionWheel = position;
	}
}
