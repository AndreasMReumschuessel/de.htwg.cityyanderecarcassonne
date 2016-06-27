package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.Border;

import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.util.observer.Event;
import de.htwg.util.observer.IObserver;

public class RightPanel extends JPanel implements ActionListener, IObserver {
	
	private static final long serialVersionUID = 1L;
	private ICarcassonneController controller;
	Queue<Color> meepleColor;
	
	Container contentPane;
	JPanel playerPanel1;
	JPanel playerPanel2;
	JPanel playerPanel3;
    SpringLayout rightPanelLayout;
    Border blackline;

	public RightPanel(ICarcassonneController controller, Container contentPane)	{
		this.controller = controller;
		this.contentPane = contentPane;
		insertColors();
		
		playerPanel1 = new PlayerPanel(this.controller, contentPane, meepleColor.poll());
		playerPanel2 = new PlayerPanel(this.controller, contentPane, meepleColor.poll());
		playerPanel3 = new PlayerPanel(this.controller, contentPane, meepleColor.poll());
		
		rightPanelLayout = new SpringLayout();
		rightPanelLayout.putConstraint(SpringLayout.WEST, playerPanel1, 0, SpringLayout.WEST, contentPane);
		rightPanelLayout.putConstraint(SpringLayout.NORTH, playerPanel1, 500, SpringLayout.NORTH, contentPane);
		
		rightPanelLayout.putConstraint(SpringLayout.WEST, playerPanel2, 0, SpringLayout.WEST, contentPane);
		rightPanelLayout.putConstraint(SpringLayout.NORTH, playerPanel2, 650, SpringLayout.NORTH, contentPane);
		
		rightPanelLayout.putConstraint(SpringLayout.WEST, playerPanel3, 0, SpringLayout.WEST, contentPane);
		rightPanelLayout.putConstraint(SpringLayout.NORTH, playerPanel3, 800, SpringLayout.NORTH, contentPane);
		
		this.setLayout(rightPanelLayout);
		
	    this.add(playerPanel1);
	    this.add(playerPanel2);
	    this.add(playerPanel3);
	    
	    this.setPreferredSize(new Dimension(300,970));
	    this.setBackground(Color.GRAY.darker());
	    this.setVisible(true);
	}
	
	public void insertColors()	{
		 meepleColor = new LinkedList<>();
		 meepleColor.add(Color.BLUE);
		 meepleColor.add(Color.RED);
		 meepleColor.add(Color.GREEN);
		 meepleColor.add(Color.YELLOW);
		 meepleColor.add(Color.BLACK);
	}

	@Override
	public void update(Event e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
