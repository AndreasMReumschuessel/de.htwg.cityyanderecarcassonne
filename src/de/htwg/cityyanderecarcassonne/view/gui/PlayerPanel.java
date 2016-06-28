package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;

public class PlayerPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private ICarcassonneController controller;
	
	Container contentPane;
	SpringLayout playerLayout;
	JLabel meepleCount;
	JLabel playerName;
	JLabel playerScore;

	public PlayerPanel(ICarcassonneController controller, Container contentPane, Color color, String name)	{
		this.controller = controller;
		this.contentPane = contentPane;
		
	    meepleCount = new JLabel();
	    meepleCount.setText("0");
	    meepleCount.setFont(new Font("Arial", Font.PLAIN, 25));
	    meepleCount.setPreferredSize(new Dimension(40, 40));
	    meepleCount.setBackground(Color.WHITE);
	    meepleCount.setOpaque(true);
	    meepleCount.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    playerName = new JLabel();
	    playerName.setText(name);
	    playerName.setFont(new Font("Arial", Font.PLAIN, 20));
	    playerName.setPreferredSize(new Dimension(130, 40));
	    playerName.setBackground(Color.GRAY.brighter());
	    playerName.setOpaque(true);
	    playerName.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    playerScore = new JLabel();
	    playerScore.setText("0");
	    playerScore.setFont(new Font("Arial", Font.PLAIN, 25));
	    playerScore.setPreferredSize(new Dimension(50, 40));
	    playerScore.setBackground(Color.WHITE);
	    playerScore.setOpaque(true);
	    playerScore.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    playerLayout = new SpringLayout();
	    playerLayout.putConstraint(SpringLayout.WEST, meepleCount, 10, SpringLayout.WEST, contentPane);
	    playerLayout.putConstraint(SpringLayout.NORTH, meepleCount, 10, SpringLayout.NORTH, contentPane);   
	    playerLayout.putConstraint(SpringLayout.WEST, playerName, 50, SpringLayout.WEST, contentPane);
	    playerLayout.putConstraint(SpringLayout.NORTH, playerName, 10, SpringLayout.NORTH, contentPane); 
	    playerLayout.putConstraint(SpringLayout.WEST, playerScore, 180, SpringLayout.WEST, contentPane);
	    playerLayout.putConstraint(SpringLayout.NORTH, playerScore, 10, SpringLayout.NORTH, contentPane);
	    this.setLayout(playerLayout);
		
		this.add(meepleCount);
		this.add(playerName);
		this.add(playerScore);
		
	    this.setPreferredSize(new Dimension(300,60));
	    this.setBackground(color);
	    this.setVisible(true);
	}
}
