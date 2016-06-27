package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;

public class PlayerPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private ICarcassonneController controller;
	
	Container contentPane;
	SpringLayout playerLayout;
	JLabel meepleCount;
	JLabel playerName;
	JLabel playerScore;

	public PlayerPanel(ICarcassonneController controller, Container contentPane)	{
		this.controller = controller;
		this.contentPane = contentPane;
		
	    meepleCount = new JLabel();
	    meepleCount.setText("6");
	    meepleCount.setFont(new Font("Arial", Font.PLAIN, 25));
	    meepleCount.setPreferredSize(new Dimension(50, 50));
	    meepleCount.setBackground(Color.WHITE);
	    meepleCount.setOpaque(true);
	    
	    playerName = new JLabel();
	    playerName.setText("Henning");
	    playerName.setFont(new Font("Arial", Font.PLAIN, 20));
	    playerName.setPreferredSize(new Dimension(130, 50));
	    playerName.setBackground(Color.GRAY.brighter());
	    playerName.setOpaque(true);
	    
	    playerScore = new JLabel();
	    playerScore.setText("123");
	    playerScore.setFont(new Font("Arial", Font.PLAIN, 25));
	    playerScore.setPreferredSize(new Dimension(50, 50));
	    playerScore.setBackground(Color.WHITE);
	    playerScore.setOpaque(true);
	    
	    playerLayout = new SpringLayout();
	    playerLayout.putConstraint(SpringLayout.WEST, meepleCount, 35, SpringLayout.WEST, contentPane);
	    playerLayout.putConstraint(SpringLayout.NORTH, meepleCount, 100, SpringLayout.NORTH, contentPane);   
	    playerLayout.putConstraint(SpringLayout.WEST, playerName, 85, SpringLayout.WEST, contentPane);
	    playerLayout.putConstraint(SpringLayout.NORTH, playerName, 100, SpringLayout.NORTH, contentPane); 
	    playerLayout.putConstraint(SpringLayout.WEST, playerScore, 215, SpringLayout.WEST, contentPane);
	    playerLayout.putConstraint(SpringLayout.NORTH, playerScore, 100, SpringLayout.NORTH, contentPane);
	    this.revalidate();
	    this.setLayout(playerLayout);
		
		this.add(meepleCount);
		this.add(playerName);
		this.add(playerScore);
		
	    this.setPreferredSize(new Dimension(300,100));
	    this.setBackground(Color.GRAY.darker());
	    this.setVisible(true);
	    revalidate();
	}
}
