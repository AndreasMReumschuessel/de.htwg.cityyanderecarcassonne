package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;

public class RightPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private SpringLayout rightPanelLayout;
	private JPanel teammatesPanel;
	private JPanel cardPanel;
	private JPanel yanderePanel;

	public RightPanel(ICarcassonneController controller, Container contentPane)	{
		
		teammatesPanel = new TeammatesPanel(controller, contentPane);
		cardPanel = new CardPanel(controller, contentPane);
		yanderePanel = new YanderePanel(controller, contentPane);

		rightPanelLayout = new SpringLayout();
		rightPanelLayout.putConstraint(SpringLayout.WEST, cardPanel, 0, SpringLayout.WEST, contentPane);
		rightPanelLayout.putConstraint(SpringLayout.NORTH, cardPanel, 0, SpringLayout.NORTH, contentPane);
		rightPanelLayout.putConstraint(SpringLayout.WEST, teammatesPanel, 0, SpringLayout.WEST, contentPane);
		rightPanelLayout.putConstraint(SpringLayout.NORTH, teammatesPanel, 400, SpringLayout.NORTH, contentPane);
		rightPanelLayout.putConstraint(SpringLayout.WEST, yanderePanel, 0, SpringLayout.WEST, contentPane);
		rightPanelLayout.putConstraint(SpringLayout.NORTH, yanderePanel, 725, SpringLayout.NORTH, contentPane);
		this.setLayout(rightPanelLayout);

		this.add(cardPanel);
		this.add(teammatesPanel);
		this.add(yanderePanel);
	    
	    this.setPreferredSize(new Dimension(250,1000));
	    this.setBackground(Color.GRAY.darker());
	    this.setVisible(true);
	}	
}
