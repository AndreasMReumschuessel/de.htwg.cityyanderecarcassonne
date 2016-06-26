package de.htwg.cityyanderecarcassonne.view.guitwo;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import de.htwg.cityyanderecarcassonne.controller.impl.CarcassonneController;
import de.htwg.cityyanderecarcassonne.model.Player;
import de.htwg.util.observer.Event;
import de.htwg.util.observer.IObserver;

public class PlayerPanel extends JPanel implements IObserver {
	
	private CarcassonneController controller;
	private String name;
	private JLabel sumMeeple, nameLabel, scoreLabel;
	
	public PlayerPanel(CarcassonneController controller, String name) {
		this.name = name;
		this.controller = controller;
		controller.addObserver(this);
		
		this.setPreferredSize(new Dimension(220,60));
		
		sumMeeple = new JLabel("3");
		sumMeeple.setAlignmentX(SwingConstants.CENTER);
		sumMeeple.setAlignmentY(SwingConstants.CENTER);
		sumMeeple.setPreferredSize(new Dimension(50, 50));
		this.add(sumMeeple);
		
		nameLabel = new JLabel(name);
		nameLabel.setAlignmentX(SwingConstants.CENTER);
		nameLabel.setAlignmentY(SwingConstants.CENTER);
		nameLabel.setPreferredSize(new Dimension(100, 50));
		this.add(nameLabel);
		
		scoreLabel = new JLabel("600");
		scoreLabel.setAlignmentX(SwingConstants.CENTER);
		scoreLabel.setAlignmentY(SwingConstants.CENTER);
		scoreLabel.setPreferredSize(new Dimension(50, 50));
		this.add(scoreLabel);
		
	}
	
	public void setActiveStatus(boolean active) {
		if (active)
			this.setBackground(Color.RED);
		else
			this.setBackground(Color.black);
	}

	@Override
	public void update(Event e) {
		Player player = controller.getCurrentPlayer();
		if (player != null && player.getName().equals(name)) {
			this.sumMeeple.setText(Integer.toString(player.getSumMeeples()));
			this.nameLabel.setText(player.toString());
			this.scoreLabel.setText(Integer.toString(player.getScore()));
		}
	}

}
