package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;

public class TeammatesPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private ICarcassonneController controller;
	Queue<Color> meepleColor;
	
	Container contentPane;
	SpringLayout teammatesLayout;
	JPanel playerPanel;
	JButton addPlayer;
	int y = 0;
	int playerCount;

	public TeammatesPanel(ICarcassonneController controller, Container contentPane)	{
		this.controller = controller;
		this.contentPane = contentPane;
		insertColors();
		playerCount = 0;
		
		addPlayer = new JButton("Add Player");
		addPlayer.setSize(150, 50);
		addPlayer.addActionListener(this);
		
		teammatesLayout = new SpringLayout();	
		teammatesLayout.putConstraint(SpringLayout.WEST, addPlayer, 75, SpringLayout.WEST, contentPane);
		teammatesLayout.putConstraint(SpringLayout.NORTH, addPlayer, 300, SpringLayout.NORTH, contentPane);
		
		this.setLayout(teammatesLayout);
		
		this.add(addPlayer);
	    this.setPreferredSize(new Dimension(250,325));
	    this.setBackground(Color.CYAN);
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
	
	public void addPlayer()	{
		if(playerCount < 5)	{
			
			String name = JOptionPane.showInputDialog(this, "What's your name?");
			Color playerColor = new Color(Math.abs(name.hashCode()) % 255, Math.abs(name.hashCode() + 40) % 255, Math.abs(name.hashCode() + 80) % 255);
			playerPanel = new PlayerPanel(this.controller, contentPane, playerColor /*meepleColor.poll()*/, name);
			controller.addPlayer(name);
			
			teammatesLayout.putConstraint(SpringLayout.WEST, playerPanel, 0, SpringLayout.WEST, contentPane);
			teammatesLayout.putConstraint(SpringLayout.NORTH, playerPanel, y, SpringLayout.NORTH, contentPane);
			
			y = y + 60;
			playerCount++;
			
		    this.add(playerPanel);
			this.setLayout(teammatesLayout);
		    contentPane.revalidate();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.addPlayer)	{
			this.addPlayer();
		}
		
	}
}





