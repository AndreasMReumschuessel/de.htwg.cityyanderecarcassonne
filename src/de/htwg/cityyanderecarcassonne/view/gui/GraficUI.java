package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/* 
 * JMenuBar
 * JMenuItem
 * JButton
 * BorderFactory
*/
public class GraficUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//MenuBar
    JMenuBar menuBar;
    
    //JMenu
    JMenu menu;
    
    //JMenuItem
    JMenuItem newGame;
    JMenuItem info;
    JMenuItem close;
    
    //Panel
    JPanel mainPanel;
    JPanel leftPanel;
    
    //Layout
    SpringLayout leftPanelLayout;
    
    //JButton
    JButton finishRound;
    
    //Picture
    BufferedImage cardPicture;
    JLabel picLabel;
    
//===================================================================================================    
    
    public GraficUI()	{
    
    // Menubars
    menuBar = new JMenuBar();
    menuBar.setOpaque(true);
    menuBar.setBackground(Color.GRAY.brighter());
    menuBar.setPreferredSize(new Dimension(1500, 30));
    
    // Menus
    menu = new JMenu("Datei");
    
    // Menuitems
    newGame = new JMenuItem("Create a new game");
    info = new JMenuItem("Information");
    close = new JMenuItem("Quit City Yandere Carcassone");
    newGame.addActionListener(this);
    info.addActionListener(this);
    close.addActionListener(this);
    
//===================================================================================================
    
    mainPanel = new JPanel();
    mainPanel.setBackground(Color.GRAY.darker());
    
    leftPanel = new JPanel();
    leftPanel.setPreferredSize(new Dimension(250,1000));
    leftPanel.setBackground(Color.BLUE.brighter());
    
//===================================================================================================    
    
    
    finishRound = new JButton("Finish round");
    finishRound.setPreferredSize(new Dimension(200, 50));
    

//===================================================================================================    
    
    try {                
    	cardPicture = ImageIO.read(new File("./src/de/htwg/cityyanderecarcassonne/view/gui/card_test.png"));
     } catch (IOException ex) {
          // handle exception...
     }
 
    picLabel = new JLabel(new ImageIcon(cardPicture));
    
//===================================================================================================        
    
    Container contentPane = this.getContentPane();
    leftPanelLayout = new SpringLayout();
    leftPanelLayout.putConstraint(SpringLayout.WEST	, finishRound, 25, SpringLayout.WEST, contentPane);
    leftPanelLayout.putConstraint(SpringLayout.NORTH, finishRound, 25, SpringLayout.NORTH, contentPane);
    
    leftPanelLayout.putConstraint(SpringLayout.WEST	, picLabel, 59, SpringLayout.WEST, contentPane);
    leftPanelLayout.putConstraint(SpringLayout.NORTH, picLabel, 100, SpringLayout.NORTH, contentPane);
    
    leftPanel.setLayout(leftPanelLayout);

//===================================================================================================    
    
    menu.add(newGame);
    menu.add(info);
    menu.add(close);
    menuBar.add(menu);
    
    leftPanel.add(finishRound);
    leftPanel.add(picLabel);
    
    this.setJMenuBar(menuBar);
    this.add(mainPanel, BorderLayout.CENTER);
    this.add(leftPanel, BorderLayout.LINE_END);

//===================================================================================================    
    
    // Eigenschaften
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Yandere Carcassonne");
	this.setPreferredSize(new Dimension(1500,1000));
    this.pack();
    this.setResizable(false);
    this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args)	{
		new GraficUI();
	}

}
