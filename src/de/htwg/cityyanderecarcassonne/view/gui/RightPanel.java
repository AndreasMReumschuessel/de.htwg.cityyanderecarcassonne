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
	JPanel playerPanel;
    SpringLayout rightPanelLayout;
    Border blackline;

	public RightPanel(ICarcassonneController controller, Container contentPane)	{
		this.controller = controller;
		this.contentPane = contentPane;
		
		playerPanel = new PlayerPanel(this.controller, contentPane);
		playerPanel.revalidate();
		
		rightPanelLayout = new SpringLayout();
		rightPanelLayout.putConstraint(SpringLayout.WEST, playerPanel, 35, SpringLayout.WEST, contentPane);
		rightPanelLayout.putConstraint(SpringLayout.NORTH, playerPanel, 65, SpringLayout.NORTH, contentPane);
	    this.revalidate();
		this.setLayout(rightPanelLayout);
		
	    this.add(playerPanel);
	    
	    this.setPreferredSize(new Dimension(300,970));
	    this.setBackground(Color.GRAY.darker());
	    this.setVisible(true);
	    revalidate();
	}
}
