package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private ICarcassonneController controller;
	
	JPanel rightPanel;
    JPanel mainPanel;
    SpringLayout mainLayout;
	Container contentPane;
	
	public MainPanel(ICarcassonneController controller, Container contentPane)	{
		this.controller = controller;
		this.contentPane = contentPane;
		
		rightPanel = new RightPanel(this.controller, contentPane);
		
	    this.setBackground(Color.GRAY.darker());
	    
	    mainLayout = new SpringLayout();    
	    mainLayout.putConstraint(SpringLayout.WEST	, rightPanel, 1250, SpringLayout.WEST, contentPane);
	    mainLayout.putConstraint(SpringLayout.NORTH, rightPanel, 0, SpringLayout.NORTH, contentPane); 
	    this.setLayout(mainLayout);
	    
	    this.add(rightPanel);
	}
}
