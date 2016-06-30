package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.Border;

import de.htwg.cityyanderecarcassonne.controller.GameStatus;
import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.util.observer.Event;
import de.htwg.util.observer.IObserver;

public class CardPanel extends JPanel implements ActionListener, IObserver {
	private static final long serialVersionUID = 1L;
	private ICarcassonneController controller;
	
	private JLabel card;
	private JLabel cardsRemaining;
	private JButton finishRound;
	private JButton rotateLeft;
	private JButton rotateRight;
	private SpringLayout cardLayout;
	private Border blackline;
	
	public CardPanel(ICarcassonneController controller, Container contentPane)	{
		this.controller = controller;
		controller.addObserver(this);
		blackline = BorderFactory.createLineBorder(Color.BLACK, 1);

		card = new JLabel();
		card.setPreferredSize(new Dimension(200, 200));
		card.setBackground(Color.GRAY.brighter());
		card.setVisible(true);
		card.setOpaque(true);
		card.setBorder(blackline);
		
		cardsRemaining = new JLabel("Cards remaining: - ", JLabel.CENTER);
		cardsRemaining.setPreferredSize(new Dimension(250, 50));
		cardsRemaining.setBackground(Color.GRAY.brighter());
		cardsRemaining.setVisible(true);
		cardsRemaining.setOpaque(true);
		cardsRemaining.setBorder(blackline);
		
		finishRound = new JButton("Start game");
		finishRound.setPreferredSize(new Dimension(250, 50));
		finishRound.addActionListener(this);
		finishRound.setEnabled(false);
		
		rotateLeft = new JButton("Rotate left");
		rotateLeft.setPreferredSize(new Dimension(125, 50));
		rotateLeft.addActionListener(this);
		rotateLeft.setEnabled(false);
		
		rotateRight = new JButton("Rotate right");
		rotateRight.setPreferredSize(new Dimension(125, 50));
		rotateRight.addActionListener(this);
		rotateRight.setEnabled(false);
		
		cardLayout = new SpringLayout();
		cardLayout.putConstraint(SpringLayout.WEST, card, 25, SpringLayout.WEST, contentPane);
		cardLayout.putConstraint(SpringLayout.NORTH, card, 25, SpringLayout.NORTH, contentPane);
		
		cardLayout.putConstraint(SpringLayout.WEST, cardsRemaining, 0, SpringLayout.WEST, contentPane);
		cardLayout.putConstraint(SpringLayout.NORTH, cardsRemaining, 250, SpringLayout.NORTH, contentPane);
		
		cardLayout.putConstraint(SpringLayout.WEST, finishRound, 0, SpringLayout.WEST, contentPane);
		cardLayout.putConstraint(SpringLayout.NORTH, finishRound, 300, SpringLayout.NORTH, contentPane);
		
		cardLayout.putConstraint(SpringLayout.WEST, rotateLeft, 0, SpringLayout.WEST, contentPane);
		cardLayout.putConstraint(SpringLayout.NORTH, rotateLeft, 350, SpringLayout.NORTH, contentPane);
		
		cardLayout.putConstraint(SpringLayout.WEST, rotateRight, 125, SpringLayout.WEST, contentPane);
		cardLayout.putConstraint(SpringLayout.NORTH, rotateRight, 350, SpringLayout.NORTH, contentPane);
		this.setLayout(cardLayout);
	    validate();
	    
		this.add(card);
		this.add(cardsRemaining);
		this.add(finishRound);
		this.add(rotateLeft);
		this.add(rotateRight);
		
	    this.setPreferredSize(new Dimension(250,400));
	    this.setBackground(Color.GRAY);
	    this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		GameStatus status = controller.getStatus();
		
		if(e.getSource() == this.finishRound) {
			if(status.equals(GameStatus.CREATE)) {
				controller.startRound();
			} else {
				controller.finishRound();
			}
		} else if(e.getSource() == this.rotateRight) {
			controller.rotateCardRight();
		} else if(e.getSource() == this.rotateLeft) {
			controller.rotateCardLeft();
		}
	}

	@Override
	public void update(Event e) {
		ICard currentCard = controller.cardOnHand();
		GameStatus status = controller.getStatus();
		
		if(currentCard != null) {
			card.setIcon(new ImageIcon(CardPrinterGUI.printCard(currentCard)));
		}
		
		if(status.equals(GameStatus.CREATE)) {
			finishRound.setText("Start game");
			finishRound.setEnabled(true);
			rotateLeft.setEnabled(true);
			rotateRight.setEnabled(true);
		} else if(status.equals(GameStatus.ROUND_START)) {
			finishRound.setText("Finish round");
			cardsRemaining.setText("Cards remaining: " + controller.getRemainingCards());
			finishRound.setEnabled(true);
			rotateLeft.setEnabled(true);
			rotateRight.setEnabled(true);
		} else if(status.equals(GameStatus.CARD_SET_SUCCESS)) {
			finishRound.setText("Finish round");
			rotateLeft.setEnabled(false);
			rotateRight.setEnabled(false);
			finishRound.setEnabled(true);
		} else if(status.equals(GameStatus.FINISH)) {
			finishRound.setText("Game finished!");
			finishRound.setEnabled(false);
		}
		validate();
	}
}
