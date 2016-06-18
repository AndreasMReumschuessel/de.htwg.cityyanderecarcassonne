package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;

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
    static JPanel mainPanel;
    JPanel leftPanel;
    JPanel player1Panel;
    JPanel player2Panel;
    
    //Layout
    SpringLayout leftPanelLayout;
    SpringLayout meepleCount1Layout;
    SpringLayout meepleCount2Layout;
    Border blackline;
    
    //JButton
    JButton finishRound;
    JButton turnLeft;
    JButton turnRight;
    
    //JLabel
    JLabel meepleCount1;
    JLabel player1Name;
    JLabel player1Score;
    JLabel meepleCount2;
    JLabel player2Name;
    JLabel player2Score;
    
    //Meeples
    String meepleCountText1 = "6";
    String meepleCountText2 = "3";
    
    //Score
    String scoreCountText1 = "123";
    String scoreCountText2 = "55";
    
    //Player
    String player1 = "Henning";
    String player2 = "Andreas";
    
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
   
    KeyStroke ctrlC = KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK);
    newGame.setAccelerator(ctrlC);
    
    KeyStroke ctrlI = KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK);
    info.setAccelerator(ctrlI);
    
    KeyStroke ctrlQ = KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK);
    close.setAccelerator(ctrlQ);
    
//===================================================================================================
    
    mainPanel = new JPanel();
    mainPanel.setBackground(Color.GRAY.darker());
    
    leftPanel = new JPanel();
    leftPanel.setPreferredSize(new Dimension(250,1000));
    leftPanel.setBackground(Color.gray);
    
    player1Panel = new JPanel();
    player1Panel.setPreferredSize(new Dimension(240,60));
    player1Panel.setBackground(Color.RED);
    player1Panel.setToolTipText("Player 1 Info");
    
    player2Panel = new JPanel();
    player2Panel.setPreferredSize(new Dimension(240,60));
    player2Panel.setBackground(Color.BLUE);
    player2Panel.setToolTipText("Player 2 Info");
    
    blackline = BorderFactory.createLineBorder(Color.black);
    
//===================================================================================================    
    
    
    finishRound = new JButton("Finish round");
    finishRound.setPreferredSize(new Dimension(200, 50));
    finishRound.setFont(new Font("Arial", Font.PLAIN, 25));
    finishRound.setToolTipText("Finishes round");
    finishRound.setMnemonic(KeyEvent.VK_ENTER);
    finishRound.addKeyListener(new KeyListener());
    finishRound.addActionListener(this);
    
    turnLeft = new JButton();
    turnLeft.setPreferredSize(new Dimension(75, 40));
    turnLeft.setIcon(new ImageIcon("./src/de/htwg/cityyanderecarcassonne/view/gui/turn_left.png"));
    turnLeft.setToolTipText("Turns card to the left");
    turnLeft.setMnemonic(KeyEvent.VK_LEFT);
    turnLeft.addKeyListener(new KeyListener());
    turnLeft.addActionListener(this);
    
    turnRight = new JButton();
    turnRight.setPreferredSize(new Dimension(75, 40));
    turnRight.setIcon(new ImageIcon("./src/de/htwg/cityyanderecarcassonne/view/gui/turn_right.png"));
    turnRight.setToolTipText("Turns card to the right");
    turnRight.setMnemonic(KeyEvent.VK_RIGHT);
    turnRight.addKeyListener(new KeyListener());
    turnRight.addActionListener(this);
    
//===================================================================================================      
    
    meepleCount1 = new JLabel();
    meepleCount1.setText(meepleCountText1);
    meepleCount1.setFont(new Font("Arial", Font.PLAIN, 25));
    meepleCount1.setAlignmentX(SwingConstants.CENTER);
    meepleCount1.setAlignmentY(SwingConstants.CENTER);
    meepleCount1.setPreferredSize(new Dimension(50, 50));
    meepleCount1.setBackground(Color.WHITE);
    meepleCount1.setOpaque(true);
    
    player1Name = new JLabel();
    player1Name.setText(player1);
    player1Name.setFont(new Font("Arial", Font.PLAIN, 20));
    player1Name.setAlignmentX(SwingConstants.CENTER);
    player1Name.setAlignmentY(SwingConstants.CENTER);
    player1Name.setPreferredSize(new Dimension(130, 50));
    player1Name.setBackground(Color.GRAY.brighter());
    player1Name.setOpaque(true);
    
    player1Score = new JLabel();
    player1Score.setText(scoreCountText1);
    player1Score.setFont(new Font("Arial", Font.PLAIN, 25));
    player1Score.setAlignmentX(SwingConstants.CENTER);
    player1Score.setAlignmentY(SwingConstants.CENTER);
    player1Score.setPreferredSize(new Dimension(50, 50));
    player1Score.setBackground(Color.WHITE);
    player1Score.setOpaque(true);
    
//===================================================================================================      
         
    meepleCount2 = new JLabel();
    meepleCount2.setText(meepleCountText2);
    meepleCount2.setFont(new Font("Arial", Font.PLAIN, 25));
    meepleCount2.setAlignmentX(SwingConstants.CENTER);
    meepleCount2.setAlignmentY(SwingConstants.CENTER);
    meepleCount2.setPreferredSize(new Dimension(50, 50));
    meepleCount2.setBackground(Color.WHITE);
    meepleCount2.setOpaque(true);
    
    player2Name = new JLabel();
    player2Name.setText(player2);
    player2Name.setFont(new Font("Arial", Font.PLAIN, 20));
    player2Name.setAlignmentX(SwingConstants.CENTER);
    player2Name.setAlignmentY(SwingConstants.CENTER);
    player2Name.setPreferredSize(new Dimension(130, 50));
    player2Name.setBackground(Color.GRAY.brighter());
    player2Name.setOpaque(true);
    
    player2Score = new JLabel();
    player2Score.setText(scoreCountText2);
    player2Score.setFont(new Font("Arial", Font.PLAIN, 25));
    player2Score.setAlignmentX(SwingConstants.CENTER);
    player2Score.setAlignmentY(SwingConstants.CENTER);
    player2Score.setPreferredSize(new Dimension(50, 50));
    player2Score.setBackground(Color.WHITE);
    player2Score.setOpaque(true);
    
//===================================================================================================    
    
    try {                
    	cardPicture = ImageIO.read(new File("./src/de/htwg/cityyanderecarcassonne/view/gui/card_test.png"));
     } catch (IOException ex) {
          // handle exception...
     }
 
    picLabel = new JLabel(new ImageIcon(cardPicture));
    picLabel.setToolTipText("Current card on hand");
    picLabel.setBorder(blackline);
    
//===================================================================================================        
    
    Container contentPane = this.getContentPane();
    leftPanelLayout = new SpringLayout();
    leftPanelLayout.putConstraint(SpringLayout.WEST	, finishRound, 25, SpringLayout.WEST, contentPane);
    leftPanelLayout.putConstraint(SpringLayout.NORTH, finishRound, 25, SpringLayout.NORTH, contentPane);
    
    leftPanelLayout.putConstraint(SpringLayout.WEST	, picLabel, 59, SpringLayout.WEST, contentPane);
    leftPanelLayout.putConstraint(SpringLayout.NORTH, picLabel, 100, SpringLayout.NORTH, contentPane);
    
    leftPanelLayout.putConstraint(SpringLayout.WEST	, turnLeft, 40, SpringLayout.WEST, contentPane);
    leftPanelLayout.putConstraint(SpringLayout.NORTH, turnLeft, 260, SpringLayout.NORTH, contentPane);
    
    leftPanelLayout.putConstraint(SpringLayout.WEST	, turnRight, 140, SpringLayout.WEST, contentPane);
    leftPanelLayout.putConstraint(SpringLayout.NORTH, turnRight, 260, SpringLayout.NORTH, contentPane);
    
    leftPanelLayout.putConstraint(SpringLayout.WEST	, player1Panel, 5, SpringLayout.WEST, contentPane);
    leftPanelLayout.putConstraint(SpringLayout.NORTH, player1Panel, 340, SpringLayout.NORTH, contentPane);
    
    leftPanelLayout.putConstraint(SpringLayout.WEST	, player2Panel, 5, SpringLayout.WEST, contentPane);
    leftPanelLayout.putConstraint(SpringLayout.NORTH, player2Panel, 405, SpringLayout.NORTH, contentPane);
    
    leftPanel.setBorder(blackline);
    
    leftPanel.setLayout(leftPanelLayout);
    
//===================================================================================================  
    
    meepleCount1Layout = new SpringLayout();
    
    meepleCount1Layout.putConstraint(SpringLayout.WEST, meepleCount1, 5, SpringLayout.WEST, contentPane);
    meepleCount1Layout.putConstraint(SpringLayout.NORTH, meepleCount1, 5, SpringLayout.NORTH, contentPane);
    
    meepleCount1Layout.putConstraint(SpringLayout.WEST, player1Name, 55, SpringLayout.WEST, contentPane);
    meepleCount1Layout.putConstraint(SpringLayout.NORTH, player1Name, 5, SpringLayout.NORTH, contentPane);    
    
    meepleCount1Layout.putConstraint(SpringLayout.WEST, player1Score, 185, SpringLayout.WEST, contentPane);
    meepleCount1Layout.putConstraint(SpringLayout.NORTH, player1Score, 5, SpringLayout.NORTH, contentPane);
    
    player1Panel.setBorder(blackline);
    
    player1Panel.setLayout(meepleCount1Layout);

//=================================================================================================== 
    
    meepleCount2Layout = new SpringLayout();

    meepleCount2Layout.putConstraint(SpringLayout.WEST, meepleCount2, 5, SpringLayout.WEST, contentPane);
    meepleCount2Layout.putConstraint(SpringLayout.NORTH, meepleCount2, 5, SpringLayout.NORTH, contentPane);
    
    meepleCount2Layout.putConstraint(SpringLayout.WEST, player2Name, 55, SpringLayout.WEST, contentPane);
    meepleCount2Layout.putConstraint(SpringLayout.NORTH, player2Name, 5, SpringLayout.NORTH, contentPane);    
    
    meepleCount2Layout.putConstraint(SpringLayout.WEST, player2Score, 185, SpringLayout.WEST, contentPane);
    meepleCount2Layout.putConstraint(SpringLayout.NORTH, player2Score, 5, SpringLayout.NORTH, contentPane);
    
    player2Panel.setBorder(blackline);
    
    player2Panel.setLayout(meepleCount2Layout);
    
//===================================================================================================    
    
    menu.add(newGame);
    menu.add(info);
    menu.add(close);
    menuBar.add(menu);
    
    leftPanel.add(finishRound);
    leftPanel.add(picLabel);
    leftPanel.add(turnLeft);
    leftPanel.add(turnRight);
    leftPanel.add(player1Panel);
    leftPanel.add(player2Panel);
    player1Panel.add(meepleCount1);
    player1Panel.add(player1Name);
    player1Panel.add(player1Score);
    player2Panel.add(meepleCount2);
    player2Panel.add(player2Name);
    player2Panel.add(player2Score);
    
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
    
    static class KeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
    			UIManager.put("OptionPane.minimumSize",new Dimension(500,250)); 
    			JOptionPane.showMessageDialog(mainPanel, "Round finished!");
            } else if(e.getKeyCode() == KeyEvent.VK_LEFT)	{
    			UIManager.put("OptionPane.minimumSize",new Dimension(500,250)); 
    			JOptionPane.showMessageDialog(mainPanel, "Card turned to left!");
            } else if(e.getKeyCode() == KeyEvent.VK_RIGHT)	{
    			UIManager.put("OptionPane.minimumSize",new Dimension(500,250)); 
    			JOptionPane.showMessageDialog(mainPanel, "Card turned to right!");
            }
        }
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		if(source == this.close){
			System.exit(0);
		} else if(source == this.info)	{
			UIManager.put("OptionPane.minimumSize",new Dimension(500,250)); 
			JOptionPane.showMessageDialog(this,this.infoPrint());
		} else if(source == this.finishRound){
			UIManager.put("OptionPane.minimumSize",new Dimension(500,250)); 
			JOptionPane.showMessageDialog(this, "Round finished!");
		} else if(source == this.turnLeft){
			UIManager.put("OptionPane.minimumSize",new Dimension(500,250)); 
			JOptionPane.showMessageDialog(this, "Card turned to left!");
		} else if(source == this.turnRight){
			UIManager.put("OptionPane.minimumSize",new Dimension(500,250)); 
			JOptionPane.showMessageDialog(this, "Card turned to right!");
		} else if(source == this.newGame){
			UIManager.put("OptionPane.minimumSize",new Dimension(500,250)); 
			JOptionPane.showMessageDialog(this, "New game created!");
		}
	}
	
	public static void main(String[] args)	{
		new GraficUI();
	}

}
