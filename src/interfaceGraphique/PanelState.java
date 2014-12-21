package interfaceGraphique;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelState extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage pict;
	private JLabel jlState;
	private int ls;
	private int component;
	private int idComponent;
	private String path;
	private String panelName;
	
	//CONSTRUCTEUR
	public PanelState(int x, int y, String state, String pathColor, String name){
		super();
		this.pict = null;
		this.path = pathColor;
		this.jlState = new JLabel(state);
		this.ls = x;
		this.component = y;
		this.setPanelName(name);
		this.buildPanel();
	}
	
	// BUILD PANEL
	public JPanel buildPanel(){
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));    // Un BoxLayout sur pane orienté verticalement  
		
		this.add(this.jlState);
		
		try {
			this.pict = ImageIO.read(new File(this.path));
		} catch (IOException e) {
			System.out.println("ERROR PANEL LS" + this.ls + " / " + this.component);
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(this.pict));
		this.add(picLabel);

		return this;
	}
	
	/*
	 * Get id landing set (Pos X)
	 */
	public int getLs(){
		return this.ls;
	}
	
	/*
	 * Get id component (Pos Y)
	 */
	public int getComponent(){
		return this.component;
	}

	/**
	 * @return the idComponent
	 */
	public int getIdComponent() {
		return idComponent;
	}

	/**
	 * @param idComponent the idComponent to set
	 */
	public void setIdComponent(int idComponent) {
		this.idComponent = idComponent;
	}

	/**
	 * @return the panelName
	 */
	public String getPanelName() {
		return panelName;
	}

	/**
	 * @param panelName the panelName to set
	 */
	public void setPanelName(String panelName) {
		this.panelName = panelName;
	}
	
	/**
	 * @return the path
	 */
	public String getPath() {
		return this.path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
}
