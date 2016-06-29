package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;

public class GraphicalUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private Container contentPane;
	private JPanel rightPanel;
	private JPanel gamePanel;
	private SpringLayout mainLayout;
	private JMenuBar menuBar;
	
	public GraphicalUI(ICarcassonneController controller)	{
		contentPane = this.getContentPane();
		
		menuBar = new MenuBar(controller, this);
		rightPanel = new RightPanel(controller, this.contentPane);	
		gamePanel = new GamePanel(controller, this.contentPane);
		
	    mainLayout = new SpringLayout();    
	    mainLayout.putConstraint(SpringLayout.WEST	, rightPanel, 1250, SpringLayout.WEST, contentPane);
	    mainLayout.putConstraint(SpringLayout.NORTH, rightPanel, 30, SpringLayout.NORTH, contentPane); 
	    mainLayout.putConstraint(SpringLayout.WEST	, gamePanel, 5, SpringLayout.WEST, contentPane);
	    mainLayout.putConstraint(SpringLayout.NORTH, gamePanel, 35, SpringLayout.NORTH, contentPane);
	    this.setLayout(mainLayout);
	    
	    contentPane.validate();
	    
		this.add(gamePanel);
	    this.add(rightPanel);
		this.add(menuBar);
	    
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setTitle("Yandere Carcassonne");
		this.setPreferredSize(new Dimension(1510,1050));
	    this.pack();
	    this.setResizable(false);
	    this.setVisible(true);
	}
}
