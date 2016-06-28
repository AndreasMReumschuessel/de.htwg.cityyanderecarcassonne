package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;

public class MenuBar extends JMenuBar implements ActionListener {
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
		this.setBackground(Color.GRAY);
		this.setPreferredSize(new Dimension(1500, 30));
		
	    menu = new JMenu("Datei");
		
	    newGame = new JMenuItem("Create a new game");
	    info = new JMenuItem("Information");
	    close = new JMenuItem("Quit City Yandere Carcassone");
	    
	    finishRoundItem = new JMenuItem("Finish current round");
	    rotateLeftItem = new JMenuItem("Rotate card to the left");
	    rotateRightItem = new JMenuItem("Rotate card to the right");
	    
	    KeyStroke finish = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
	    finishRoundItem.setAccelerator(finish);
	    
	    KeyStroke left = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0);
	    rotateLeftItem.setAccelerator(left);
	    
	    KeyStroke right = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0);
	    rotateRightItem.setAccelerator(right);
	   
	    KeyStroke ctrlC = KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK);
	    newGame.setAccelerator(ctrlC);
	    
	    KeyStroke ctrlI = KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK);
	    info.setAccelerator(ctrlI);
	    
	    KeyStroke ctrlQ = KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK);
	    close.setAccelerator(ctrlQ);
	    
	    newGame.addActionListener(this);
	    info.addActionListener(this);
	    close.addActionListener(this);
	    
	    finishRoundItem.addActionListener(this);
	    rotateLeftItem.addActionListener(this);
	    rotateRightItem.addActionListener(this);
	    
	    menu.add(newGame);
	    menu.add(info);
	    menu.add(close);
	    menu.add(finishRoundItem);
	    menu.add(rotateLeftItem);
	    menu.add(rotateRightItem);
	    
	    this.add(menu);
		
	}

    public String infoPrint()	{
    	StringBuilder sb = new StringBuilder();
    	
    	sb.append("Yandere City Carcassonne!\n")
    	.append("Info...\n")
       	.append("Info...\n")
    	.append("Info...\n\n")
    	.append("Developer\n ")
    	.append("Andreas M. Reumschüssel\n")
    	.append("Henning Krause");
    	
    	return sb.toString();
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		if(source == this.close){
			System.exit(0);
		} else if(source == this.info)	{
			UIManager.put("OptionPane.minimumSize",new Dimension(500,250)); 
			JOptionPane.showMessageDialog(this,this.infoPrint());
		}
	}
}
