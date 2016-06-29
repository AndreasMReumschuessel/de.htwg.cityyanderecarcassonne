package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import de.htwg.cityyanderecarcassonne.controller.GameStatus;
import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.util.observer.Event;
import de.htwg.util.observer.IObserver;

public class CardPanel extends JPanel implements ActionListener, IObserver {
	private static final long serialVersionUID = 1L;
	private ICarcassonneController controller;
	
	Container contentPane;
	JLabel card;
	JButton finishRound;
	JButton rotateLeft;
	JButton rotateRight;
	SpringLayout cardLayout;
	
	public CardPanel(ICarcassonneController controller, Container contentPane)	{
		this.controller = controller;
		this.contentPane = contentPane;
		controller.addObserver(this);

		card = new JLabel();
		card.setPreferredSize(new Dimension(200, 200));
		card.setBackground(Color.MAGENTA);
		card.setVisible(true);
		card.setOpaque(true);
		
		finishRound = new JButton("Next Round");
		finishRound.setPreferredSize(new Dimension(250, 50));
		finishRound.addActionListener(this);
		
		rotateLeft = new JButton("Rotate Left");
		rotateLeft.setPreferredSize(new Dimension(125, 50));
		rotateLeft.addActionListener(this);
		
		rotateRight = new JButton("Rotate Right");
		rotateRight.setPreferredSize(new Dimension(125, 50));
		rotateRight.addActionListener(this);
		
		cardLayout = new SpringLayout();
		cardLayout.putConstraint(SpringLayout.WEST, card, 25, SpringLayout.WEST, contentPane);
		cardLayout.putConstraint(SpringLayout.NORTH, card, 25, SpringLayout.NORTH, contentPane);
		
		cardLayout.putConstraint(SpringLayout.WEST, finishRound, 0, SpringLayout.WEST, contentPane);
		cardLayout.putConstraint(SpringLayout.NORTH, finishRound, 250, SpringLayout.NORTH, contentPane);
		
		cardLayout.putConstraint(SpringLayout.WEST, rotateLeft, 0, SpringLayout.WEST, contentPane);
		cardLayout.putConstraint(SpringLayout.NORTH, rotateLeft, 300, SpringLayout.NORTH, contentPane);
		
		cardLayout.putConstraint(SpringLayout.WEST, rotateRight, 125, SpringLayout.WEST, contentPane);
		cardLayout.putConstraint(SpringLayout.NORTH, rotateRight, 300, SpringLayout.NORTH, contentPane);
		this.setLayout(cardLayout);
	    contentPane.revalidate();
	    
		this.add(card);
		this.add(finishRound);
		this.add(rotateLeft);
		this.add(rotateRight);
		
	    this.setPreferredSize(new Dimension(250,350));
	    this.setBackground(Color.ORANGE);
	    this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		GameStatus status = controller.getStatus();
		
		if(e.getSource() == this.finishRound)	{
			if(status.equals(GameStatus.CREATE)) {
				controller.startRound();
			} else  {
				controller.finishRound();
			}
		} else if(e.getSource() == this.rotateRight){
			controller.rotateCardRight();
		} else if(e.getSource() == this.rotateLeft){
			controller.rotateCardLeft();
		}
	}

	@Override
	public void update(Event e) {
		ICard currentCard = controller.cardOnHand();
		if(currentCard != null)	{
			card.setIcon(new ImageIcon(CardPrinterGUI.printCard(currentCard)));
		}
	}	
}
