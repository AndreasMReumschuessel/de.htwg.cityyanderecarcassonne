package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;

public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;
	private ICarcassonneController controller;
	
    JMenu menu;
    JMenuItem newGame;
    JMenuItem info;
    JMenuItem close;
    JMenuItem finishRoundItem;
    JMenuItem rotateLeftItem;
    JMenuItem rotateRightItem;
	
	public MenuBar(ICarcassonneController controller)	{
		this.controller = controller;
		
		this.setOpaque(true);
		this.setBackground(Color.CYAN);
		this.setPreferredSize(new Dimension(1500, 30));
		
	    menu = new JMenu("Datei");
		
	    newGame = new JMenuItem("Create a new game");
	    info = new JMenuItem("Information");
	    close = new JMenuItem("Quit City Yandere Carcassone");
	    
	    finishRoundItem = new JMenuItem("Finish current round");
	    rotateLeftItem = new JMenuItem("Rotate card to the left");
	    rotateRightItem = new JMenuItem("Rotate card to the right");
	    
	    menu.add(newGame);
	    menu.add(info);
	    menu.add(close);
	    menu.add(finishRoundItem);
	    menu.add(rotateLeftItem);
	    menu.add(rotateRightItem);
	    
	    this.add(menu);
		
	}
}
