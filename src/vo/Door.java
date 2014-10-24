package vo;


public class Door{
	private String positionDoor; // OUT=0, IN=1, TRANSIT=2

	public Door(){
		this.positionDoor = "0";
	}

	public String getPositionDoor() {
		return positionDoor;
	}

	public void setPositionDoor(String position) {
		this.positionDoor = position;
	}

}
