package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.Border;

import de.htwg.cityyanderecarcassonne.controller.GameStatus;
import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.util.observer.Event;
import de.htwg.util.observer.IObserver;

public class TeammatesPanel extends JPanel implements ActionListener, IObserver {
	private static final long serialVersionUID = 1L;
	private ICarcassonneController controller;
	private Queue<Color> meepleColor;
	
	private Container contentPane;
	private SpringLayout teammatesLayout;
	private JPanel playerPanel;
	private JButton addPlayer;
	private int y = 0;
	private int playerCount;
	private Border blackline;

	public TeammatesPanel(ICarcassonneController controller, Container contentPane)	{
		this.controller = controller;
		this.contentPane = contentPane;
		controller.addObserver(this);
		
		insertColors();
		playerCount = 0;
		blackline = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		addPlayer = new JButton("Add Player");
		addPlayer.setSize(150, 50);
		addPlayer.addActionListener(this);
		
		teammatesLayout = new SpringLayout();	
		teammatesLayout.putConstraint(SpringLayout.WEST, addPlayer, 75, SpringLayout.WEST, contentPane);
		teammatesLayout.putConstraint(SpringLayout.NORTH, addPlayer, 300, SpringLayout.NORTH, contentPane);
		
		this.setLayout(teammatesLayout);
		
		this.setBorder(blackline);
		this.add(addPlayer);
	    this.setPreferredSize(new Dimension(250,325));
	    this.setBackground(Color.GRAY);
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
		
		String name = JOptionPane.showInputDialog(this, "What's your name?");
		
		if(playerCount >= 4) {
			addPlayer.setEnabled(false);
		}
		
		if(playerCount < 5 && name != null && !name.isEmpty())	{
			
			Color playerColor = new Color(Math.abs(name.hashCode()) % 255, Math.abs(name.hashCode() + 40) % 255, Math.abs(name.hashCode() + 80) % 255);
			playerPanel = new PlayerPanel(controller, contentPane, playerColor /*meepleColor.poll()*/, name);
			controller.addPlayer(name);
			
			teammatesLayout.putConstraint(SpringLayout.WEST, playerPanel, 0, SpringLayout.WEST, contentPane);
			teammatesLayout.putConstraint(SpringLayout.NORTH, playerPanel, y, SpringLayout.NORTH, contentPane);
			
			y = y + 60;
			playerCount++;
			
		    add(playerPanel);
			setLayout(teammatesLayout);
		    contentPane.revalidate();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addPlayer)	{
			addPlayer();
		}
		
	}

	@Override
	public void update(Event e) {
		
		GameStatus status = controller.getStatus();
		
		if(status.equals(GameStatus.WELCOME) || status.equals(GameStatus.PLAYER_ADDED)) {
			addPlayer.setEnabled(true);
		} else {
			addPlayer.setEnabled(false);
		}
	}
}





