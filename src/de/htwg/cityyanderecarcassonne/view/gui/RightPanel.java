package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.Border;

import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;

public class RightPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private ICarcassonneController controller;
	
	Container contentPane;
	JPanel rightPanel;
    SpringLayout rightPanelLayout;
    Border blackline;

	public RightPanel(ICarcassonneController controller, Container contentPane)	{
		this.controller = controller;
		
	    this.setPreferredSize(new Dimension(250,1000));
	    this.setBackground(Color.RED);
	    
	}
}
