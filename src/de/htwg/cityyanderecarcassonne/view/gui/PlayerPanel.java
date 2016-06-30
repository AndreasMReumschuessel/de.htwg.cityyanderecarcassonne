package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import de.htwg.cityyanderecarcassonne.controller.GameStatus;
import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.util.observer.Event;
import de.htwg.util.observer.IObserver;

public class PlayerPanel extends JPanel implements IObserver {
	private static final long serialVersionUID = 1L;
	private ICarcassonneController controller;
	
	private SpringLayout playerLayout;
	private JLabel meepleCount;
	private JLabel playerName;
	private JLabel playerScore;
	private Border redline;
	private Border normalline;
	private String name;

	public PlayerPanel(ICarcassonneController controller, Container contentPane, Color color, String name) {
		this.controller = controller;
		controller.addObserver(this);
		this.name = name;
		
		Font font = new Font("Arial", Font.PLAIN, 20);
		
		redline = BorderFactory.createLineBorder(Color.RED, 5);
		normalline = BorderFactory.createLineBorder(color, 5);
		
	    meepleCount = new JLabel();
	    meepleCount.setText(" 8 ");
	    meepleCount.setFont(font);
	    meepleCount.setPreferredSize(new Dimension(40, 40));
	    meepleCount.setBackground(Color.WHITE);
	    meepleCount.setOpaque(true);
	    meepleCount.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    playerName = new JLabel(" - ");
	    playerName.setText(name);
	    playerName.setFont(font);
	    playerName.setPreferredSize(new Dimension(130, 40));
	    playerName.setBackground(Color.GRAY.brighter());
	    playerName.setOpaque(true);
	    playerName.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    playerScore = new JLabel();
	    playerScore.setText(" 0 ");
	    playerScore.setFont(font);
	    playerScore.setPreferredSize(new Dimension(40, 40));
	    playerScore.setBackground(Color.WHITE);
	    playerScore.setOpaque(true);
	    playerScore.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    playerLayout = new SpringLayout();
	    playerLayout.putConstraint(SpringLayout.WEST, meepleCount, 15, SpringLayout.WEST, contentPane);
	    playerLayout.putConstraint(SpringLayout.NORTH, meepleCount, 5, SpringLayout.NORTH, contentPane);   
	    playerLayout.putConstraint(SpringLayout.WEST, playerName, 55, SpringLayout.WEST, contentPane);
	    playerLayout.putConstraint(SpringLayout.NORTH, playerName, 5, SpringLayout.NORTH, contentPane); 
	    playerLayout.putConstraint(SpringLayout.WEST, playerScore, 185, SpringLayout.WEST, contentPane);
	    playerLayout.putConstraint(SpringLayout.NORTH, playerScore, 5, SpringLayout.NORTH, contentPane);
	    this.setLayout(playerLayout);
		
		this.add(meepleCount);
		this.add(playerName);
		this.add(playerScore);
		this.setBorder(normalline);
		
	    this.setPreferredSize(new Dimension(250,60));
	    this.setBackground(color);
	    this.setVisible(true);
	}
	
	@Override
	public void update(Event e) {
		
		GameStatus status = controller.getStatus();
		
		if(status.equals(GameStatus.PLAYER_CHANGED)) {
			if(controller.getCurrentPlayer().toString().equals(name)) {
				this.setBorder(redline);
			} else {
				this.setBorder(normalline);
			}
		}	
		
		if(status.equals(GameStatus.ROUND_END) || status.equals(GameStatus.FINISH)) {
			if(controller.getCurrentPlayer().toString().equals(name)) {
				playerScore.setText(Integer.toString(controller.getCurrentPlayer().getScore()));
				meepleCount.setText(Integer.toString(controller.getCurrentPlayer().getSumMeeples()));
			}
		} else if(status.equals(GameStatus.MEEPLE_SET_SUCCESS) || status.equals(GameStatus.ROUND_END)) {
			if(controller.getCurrentPlayer().toString().equals(name)) {
				meepleCount.setText(Integer.toString(controller.getCurrentPlayer().getSumMeeples()));
			}
		}
	}
}
