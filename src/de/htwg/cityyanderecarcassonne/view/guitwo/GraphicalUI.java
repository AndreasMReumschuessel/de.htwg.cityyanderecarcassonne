package de.htwg.cityyanderecarcassonne.view.guitwo;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.cityyanderecarcassonne.controller.impl.CarcassonneController;

public class GraphicalUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public ICarcassonneController controller;

	public GraphicalUI(CarcassonneController controller) {
		this.controller = controller;
		
		this.setTitle("City Yandere Carcassonne");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JPanel pp = new PlayerPanel(controller, "Anmax");
		JPanel pp = new PicturePanel(controller);
		this.add(pp);
		
		this.pack();
		this.setVisible(true);
	}

	/*
	public static void main(String[] args) {
		JFrame gui = new GraphicalUI();
		JPanel pp = new PlayerPanel(gui.controller, "Hans");
		gui.add(pp);
		gui.pack();
	}
	*/

}
