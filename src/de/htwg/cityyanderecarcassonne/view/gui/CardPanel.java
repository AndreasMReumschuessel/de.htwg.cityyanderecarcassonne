package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;

public class CardPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private ICarcassonneController controller;
	
	Container contentPane;
	JLabel card;
	JButton nextRound;
	JButton rotateLeft;
	JButton rotateRight;
	SpringLayout cardLayout;
	
	public CardPanel(ICarcassonneController controller, Container contentPane)	{
		this.controller = controller;
		this.contentPane = contentPane;
		
		card = new JLabel();
		card.setPreferredSize(new Dimension(240, 240));
		card.setBackground(Color.MAGENTA);
		card.setVisible(true);
		card.setOpaque(true);
		
		nextRound = new JButton("Next Round");
		nextRound.setPreferredSize(new Dimension(250, 50));
		nextRound.addActionListener(this);
		
		rotateLeft = new JButton("Rotate Left");
		rotateLeft.setPreferredSize(new Dimension(125, 50));
		rotateLeft.addActionListener(this);
		
		rotateRight = new JButton("Rotate Right");
		rotateRight.setPreferredSize(new Dimension(125, 50));
		rotateRight.addActionListener(this);
		
		cardLayout = new SpringLayout();
		cardLayout.putConstraint(SpringLayout.WEST, card, 5, SpringLayout.WEST, contentPane);
		cardLayout.putConstraint(SpringLayout.NORTH, card, 5, SpringLayout.NORTH, contentPane);
		
		cardLayout.putConstraint(SpringLayout.WEST, nextRound, 0, SpringLayout.WEST, contentPane);
		cardLayout.putConstraint(SpringLayout.NORTH, nextRound, 250, SpringLayout.NORTH, contentPane);
		
		cardLayout.putConstraint(SpringLayout.WEST, rotateLeft, 0, SpringLayout.WEST, contentPane);
		cardLayout.putConstraint(SpringLayout.NORTH, rotateLeft, 300, SpringLayout.NORTH, contentPane);
		
		cardLayout.putConstraint(SpringLayout.WEST, rotateRight, 125, SpringLayout.WEST, contentPane);
		cardLayout.putConstraint(SpringLayout.NORTH, rotateRight, 300, SpringLayout.NORTH, contentPane);
		this.setLayout(cardLayout);
	    contentPane.revalidate();
	    
		this.add(card);
		this.add(nextRound);
		this.add(rotateLeft);
		this.add(rotateRight);
		
	    this.setPreferredSize(new Dimension(250,350));
	    this.setBackground(Color.ORANGE);
	    this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
}
