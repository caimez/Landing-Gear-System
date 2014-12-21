package communication;


public class ComClientSystem{
	//Declaration 
	//private MainWindow mainWindow;
	
	//CONSTRUCTEUR
	public ComClientSystem(){
		//this.mainWindow = new MainWindow();
		//this.mainWindow.setVisible(true);
	}
	
	//INITIALISATION PANEL DOOR
	/*public void setPanelStateDoor(String state, int idState, int y){
		int x=2;
		
		String name = "DOOR" + y;
		
		PanelState paneStateDoor = new PanelState(x, y, state, this.getPathForDoor(y, idState), name);
				
		//paneStateDoor.revalidate();	
		
		this.mainWindow.setPanel(paneStateDoor);

		//this.mainWindow.getPanelStateList().add(paneStateDoor);


	}
	
	//INITIALISATION PANEL WHEEL
	public void setPanelStateWheel(String state, int idState, int y){
		int x = 1;
		
		String name = "WHEEL" + y;
		PanelState paneStateWheel = new PanelState(x, y, state, this.getPathForWheel(y, idState), name);
	
		paneStateWheel.validate();

		this.mainWindow.setPanel(paneStateWheel);
		//this.mainWindow.add(paneStateWheel);

		//this.mainWindow.getPanelStateList().add(paneStateWheel);

	}

	
	//GET PATH COLOR FOR STATE DOOR
	public String getPathForDoor(int idLS, int idState){
		String path = Constantes.RED_LIGHT;
		
		if(idState == Constantes.CLOSE_DOOR || idState == Constantes.OPEN_DOOR){
			path = Constantes.GREEN_LIGHT;
		}else if(idState == Constantes.PROCESSING_DOOR){
			path = Constantes.ORANGE_LIGHT;
		}else {
			path = Constantes.RED_LIGHT;
		}
		return path;
	}
	
	//GET PATH COLOR FOR STATE WHEEL
	public String getPathForWheel(int idLS, int idState){
		String path = Constantes.RED_LIGHT;
		
		if(idState == Constantes.OUTSIDE_WHEEL || idState == Constantes.INSIDE_WHEEL){
			path = Constantes.GREEN_LIGHT;
		}else if( idState == Constantes.PROCESSING_WHEEL){
			path = Constantes.ORANGE_LIGHT;
		}else{
			path = Constantes.RED_LIGHT;
		}
		return path;
	}
	
	
	//STATE WHEEL
	/*public int checkStateWheel(int comp){
		int action = 3;
		if(sysLandSet.getStateDoorByLandingSet(comp).equals(Constantes.OUTSIDE_WHEEL)){
			return Constantes.SYSTEM_OPEN;
		}
		if(sysLandSet.getStateWheelByLandingSet(comp).equals(Constantes.INSIDE_WHEEL)){
			return Constantes.SYSTEM_CLOSE;
		}
		return action;
	}

	//STATE DOOR
	public int checkStateDoor(int comp){
		int action = 3;
		if(sysLandSet.getStateDoorByLandingSet(comp).equals(Constantes.OPEN_DOOR)){
				return Constantes.SYSTEM_OPEN;
		}
		if(sysLandSet.getStateWheelByLandingSet(comp).equals(Constantes.CLOSE_DOOR)){
				return Constantes.SYSTEM_CLOSE;
		}
		return action;
	}


	public int checkState(){
		int action = 3;
		for(int i=0; i<sysLandSet.getLandingSetList().size(); i++){
			if(sysLandSet.getStateDoorByLandingSet(i).equals(Constantes.OPEN_DOOR)){
				if(sysLandSet.getStateDoorByLandingSet(i).equals(Constantes.OUTSIDE_WHEEL)){
					return Constantes.SYSTEM_OPEN;
				}
			}
			if(sysLandSet.getStateWheelByLandingSet(i).equals(Constantes.CLOSE_DOOR)){
				if(sysLandSet.getStateWheelByLandingSet(i).equals(Constantes.INSIDE_WHEEL)){
					return Constantes.SYSTEM_CLOSE;
				}
			}
		}
		return action;
	}
	

	
	public void ActionChangeState(){
		//TCHEK STATE DOOR AND WHEEL
		int action = checkState();
		
		//FIND ACTION
		if(action == Constantes.SYSTEM_CLOSE){
			//RUN ACTION
			this.sysLandSet.goOutLandingSet();
		}
		if(action == Constantes.SYSTEM_OPEN){
			this.sysLandSet.returnLandingSet();
		}

	}*/
	
}
