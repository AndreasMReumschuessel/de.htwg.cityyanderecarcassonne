package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PlayerPanel {
	
    JPanel playerPanel;

	public PlayerPanel(String s)	{
		
	    playerPanel = new JPanel();
	    playerPanel.setPreferredSize(new Dimension(240,60));
	    playerPanel.setBackground(Color.BLUE);
	    playerPanel.setToolTipText("Player" +  s + "Info");
		
	}
}
