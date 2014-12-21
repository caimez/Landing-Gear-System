package utils;

public final class Constantes {

// PART SYTEM LANDING SET
	
	// DOOR
	public static final String DOOR = "DOOR";
	public static final int OPEN_DOOR = 0; 
	public static final int CLOSE_DOOR = 1; 
	public static final int  PROCESSING_DOOR = 2; 
	
	// WHEEL
	public static final String WHEEL = "WHEEL";
	public static final int OUTSIDE_WHEEL = 0; 
	public static final int INSIDE_WHEEL = 1; 
	public static final int  PROCESSING_WHEEL = 2; 
	
	// ERROR
	public static final int ERROR = 3;
	
	// CONSTANTES TIME PROCESSING
	public static final int TIME_WHEEL_SUCCESS = 2000;
	public static final int TIME_DOOR_SUCCESS = 1000;
	
	public static final int TIME_WHEEL_FAIL = 7000;
	public static final int TIME_DOOR_FAIL = 7000;

	
// CONSTANTES COMCLIENTSYSTEM	
	
	// SYSTEM OPEN
	public static final int SYSTEM_OPEN = 1;
	public static final int SYSTEM_CLOSE = 2;
	
	//NB COMPOSANT
	public static final int NB_COMPOSANT = 2;
	
	// NB LANDING SET
	public static final int NB_LANDING_SET = 3;
	
	//COMPONENT WHEEL
	public static final int COMPONENT_WHEEL = 1;
	
	//COMPONENT DOOR
	public static final int COMPONENT_DOOR = 2;
	
	
	
// INTERFACE GRAPHIQUE
	
	// STATE DOOR 
	public static final String STATE_OPEN_DOOR = "OPEN";
	public static final String STATE_CLOSE_DOOR = "CLOSE";
	public static final String STATE_PROCESSING_OPEN_DOOR = "PROCESSING OPEN DOOR";
	public static final String STATE_PROCESSING_CLOSE_DOOR = "PROCESSING CLOSE DOOR";
	
	// STATE WHEEL
	public static final String STATE_OUTSIDE_WHEEL = "OUTSIDE";
	public static final String STATE_INSIDE_WHEEL = "INSIDE";
	public static final String STATE_PROCESSING_OUTSIDE_WHEEL = "PROCESSING OUTSIDE WHEEL";
	public static final String STATE_PROCESSING_INSIDE_WHEEL = "PROCESSING INSIDE WHEEL";

	// PATH PICTURE GREEN, ORANGE, RED
	public static final String GREEN_LIGHT = "./picture/green.jpg";
	public static final String ORANGE_LIGHT = "./picture/orange.png";
	public static final String RED_LIGHT = "./picture/red.jpg";

}
