package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.cityyanderecarcassonne.controller.impl.CarcassonneController;
import de.htwg.util.observer.Event;
import de.htwg.util.observer.IObserver;

public class GraphicalUI extends JFrame implements ActionListener, IObserver {

	private ICarcassonneController controller;
	private static final long serialVersionUID = 1L;
	
	Container contentPane;
	JPanel rightPanel;
	JScrollPane gamePane;
    SpringLayout mainLayout;
	JMenuBar menuBar;
	
	public GraphicalUI(ICarcassonneController controller)	{
		this.controller = controller;
		contentPane = this.getContentPane();

		menuBar = new MenuBar(this.controller);
		rightPanel = new RightPanel(this.controller, contentPane);
		gamePane = new GamePane(this.controller);
	    
	    mainLayout = new SpringLayout();    
	    mainLayout.putConstraint(SpringLayout.WEST	, rightPanel, 1250, SpringLayout.WEST, contentPane);
	    mainLayout.putConstraint(SpringLayout.NORTH, rightPanel, 0, SpringLayout.NORTH, contentPane); 
	    mainLayout.putConstraint(SpringLayout.WEST	, gamePane, 0, SpringLayout.WEST, contentPane);
	    mainLayout.putConstraint(SpringLayout.NORTH, gamePane, 30, SpringLayout.NORTH, contentPane); 
	    this.setLayout(mainLayout);
	    
		this.add(gamePane);
	    this.add(rightPanel);
		this.add(menuBar);
	    
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setTitle("Yandere Carcassonne");
	    this.setBackground(Color.GREEN);
		this.setPreferredSize(new Dimension(1500,1000));
	    this.pack();
	    this.setResizable(false);
	    this.setVisible(true);
	}

	@Override
	public void update(Event e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args)	{
		CarcassonneController controller = new CarcassonneController(150, 150);
		new GraphicalUI(controller);
	}
	
}









