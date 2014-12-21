package interfaceGraphique;


import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.Constantes;

public class MainWindow extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Nouvelle Instance jpanel
	private JPanel jpane;
	private Hashtable<String, PanelState> panelStateList;
	private GridBagLayout grid;
	//Nouvelle instance GridBagConstraints
    private GridBagConstraints c;
    private ArrayList<String> listNamePanel;
    
	public MainWindow(){
		super();
		this.jpane = new JPanel();
		this.c = new GridBagConstraints();
		this.grid = new GridBagLayout();
		this.panelStateList = new Hashtable<String, PanelState>();
		this.listNamePanel = new ArrayList<String>();
		build();
	}

	public void build(){
		this.setTitle("Landing Gear System"); //On donne un titre à l'application
		this.setSize(600,380); //On donne une taille à notre fenêtre
		this.setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		this.setResizable(true); //On interdit la redimensionnement de la fenêtre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
		this.setContentPane(buildContentPane());
	}
	
	public JPanel buildContentPane(){		
		//Add grid into jpanel
		jpane.setLayout(grid);
		
	    //Propriété comune au éléments de la page
	    this.c.insets = new Insets(5, 15, 10, 15); // top, left, bottom, right

	    //Label titre colonne WHEEL
		JLabel jlWheel = new JLabel("WHEEL");
		this.c.anchor = GridBagConstraints.CENTER;
	    this.c.gridx = 1;
	    this.c.gridy = 0;
	    //Ajout du composant au containers jpanel
		jpane.add(jlWheel, this.c);
	    
		//Label titre colonne DOOR
		JLabel jlDoor = new JLabel("DOOR");
		this.c.gridx = 2;
	    this.c.gridy = 0;
	    //Ajout du composant au containers jpanel
		jpane.add(jlDoor, this.c);

		//Porpriété commune 
	    this.c.gridx = 0;
	    
		//Label titre Ligne landingGear 1
		JLabel jlLandingGear1 = new JLabel("LG 1:");
	    this.c.gridy = 1;
	    //Ajout du composant au containers jpanel
		jpane.add(jlLandingGear1, this.c);
	    
		//Label titre Ligne landingGear 1
		JLabel jlLandingGear2 = new JLabel("LG 2:");
	    this.c.gridy = 2;
	    //Ajout du composant au containers jpanel
		jpane.add(jlLandingGear2, this.c);

		//Label titre Ligne landingGear 3
		JLabel jlLandingGear3 = new JLabel("LG 3:");
	    this.c.gridy = 3;
	    //Ajout du composant au containers jpanel
		jpane.add(jlLandingGear3, this.c);

		//Add buton Action
		JButton button = new JButton("Landing Set Action");
        //button.addActionListener(this);
        
		this.c.gridx = 1;
		this.c.gridy = 4;
		this.c.anchor = GridBagConstraints.BELOW_BASELINE;
		//Add buton dans le jpane
		jpane.add(button, this.c);
		
		return jpane;
	}
	
	//SET PANEL IN MAIN WINDOW
	public void setPanel(PanelState comp){
		//this.removePanel(comp.getLs(), comp.getComponent());
		
		int x = comp.getLs();
		int y = comp.getComponent();

		this.c.fill = GridBagConstraints.CENTER;
		this.c.anchor = GridBagConstraints.CENTER;
		this.c.weightx = 30;
		this.c.weighty = 20;
		this.c.insets = new Insets(30, 55, 30, 55);

		this.c.gridx = x;
		this.c.gridy = y;
		
		if(this.listNamePanel!=null && this.listNamePanel.size()<6){
			this.listNamePanel.add(comp.getPanelName());
			System.out.println("LIST NAME PANEL INIT : " + comp.getPanelName());
			System.out.println("TAILLE LIST : " + this.listNamePanel.size());

			this.panelStateList.put(comp.getPanelName(), comp);
			
			this.jpane.add(this.panelStateList.get(comp.getPanelName()), this.c);
		}else{
			//this.removeAll();
			this.panelStateList.remove(comp.getPanelName());
			this.panelStateList.put(comp.getPanelName(), comp);
			System.out.println("LIST NAME PANEL CURRENT : " + comp.getPanelName());
			
			this.jpane.remove(this.jpane.getComponentAt(x, y));
			//PanelState ps  = (PanelState) this.jpane.getComponentAt(x, y);
			
			//System.out.println(" OBJECT REMOVE : " + ps.getPanelName());
			
			System.out.println(" PATH : " + comp.getPath());
			System.out.println(" X => " + this.c.gridx + "    /    Y => " + this.c.gridy);
			//this.jpane.add(comp, this.c);

			Component toRemove = this.jpane.getComponent(4);
			GridBagLayout layout = (GridBagLayout)getLayout();
			GridBagConstraints gbc = this.grid.getConstraints(toRemove);
			remove(toRemove);
			add(comp, gbc, 4);

			
			/*for(int i=0; i<this.listNamePanel.size(); i++){
				this.buildContentPane();
				System.out.println("/n/n LIST NAME PANEL : " + this.listNamePanel.get(i));

				this.c.gridx = this.panelStateList.get(this.listNamePanel.get(i)).getLs();
				this.c.gridy = this.panelStateList.get(this.listNamePanel.get(i)).getComponent();
				
				System.out.println("/n/n X => " + this.c.gridx + "    /    Y => " + this.c.gridy);

				
				this.jpane.add(this.panelStateList.get(this.listNamePanel.get(i)), this.c);
			}*/
		}
		this.jpane.revalidate();
		this.jpane.repaint();
		this.jpane.setVisible(true);
	}

}
