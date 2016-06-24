package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.border.Border;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import de.htwg.cityyanderecarcassonne.controller.GameStatus;
import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.cityyanderecarcassonne.controller.impl.CarcassonneController;
import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.Position;
import de.htwg.cityyanderecarcassonne.view.StatusMessage;

public class GraficUI extends JFrame implements ActionListener, MouseListener {

	private static ICarcassonneController inController;
	private ICard currentCard;
	Icon startImage;
	Icon mainImage;
	Icon backImage;
	Icon leftImage;
	Icon possImage;
	StatusMessage status;
	List<Position> redrawCard;
	List<IRegion> redrawRegion;
	Map<Position, String> psCardList;
	Map<IRegion, String> psRegionList;
	Map<Position, Image> cardsOnField;
    
    int spielfeld = 1000;
    int grid;
    int karte;
	int k = 0;
	
	Position topLeft;
	Position topMiddle;
	Position topRight;
	
	Position leftTop;
	Position rightTop;
	
	Position leftMiddle;
	Position centerMiddle;
	Position rightMiddle;
	
	Position leftBelow;
	Position rightBelow;
	
	Position belowLeft;
	Position belowMiddle;
	Position belowRight;
	
	private static final long serialVersionUID = 1L;

	//MenuBar
    JMenuBar menuBar;
    
    //JMenu
    JMenu menu;
    
    //JMenuItem
    JMenuItem newGame;
    JMenuItem info;
    JMenuItem close;
    
    JMenuItem finishRoundItem;
    JMenuItem rotateLeftItem;
    JMenuItem rotateRightItem;
    
    //Panel
    Container contentPane;
    static JPanel mainPanel;
    JPanel gamePanel;
    JPanel leftPanel;
    JPanel player1Panel;
    JPanel player2Panel;
    
    //JTextField
    static JLabel textField;
    
    //Layout
    SpringLayout leftPanelLayout;
    SpringLayout gamePanelLayout;
    GridBagConstraints gpc;
    SpringLayout mainLayout;
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
    JLabel meeple;
    
    JLabel topLeftLabel;
    JLabel topMiddleLabel;
    JLabel topRightLabel;
    
    JLabel leftTopLabel;
    JLabel rightTopLabel;
    
    JLabel leftMiddleLabel;
    JLabel centerMiddleLabel;
    JLabel rightMiddleLabel;
    
    JLabel leftBelowLabel;
    JLabel rightBelowLabel;
    
    JLabel belowLeftLabel;
    JLabel belowMiddleLabel;
    JLabel belowRightLabel;
    
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
    BufferedImage picture;
    BufferedImage meeplePicture;
    BufferedImage possibilitiesPicture;
    JLabel picLabel;
    JLabel possibilitiesLabel;
    
    JLabel[][] cardMatrix;
    
//===================================================================================================    
    
    public GraficUI(ICarcassonneController controller)	{
    	
    this.inController = controller;
    
    status = new StatusMessage();
    
    redrawCard = new LinkedList<>();
    redrawRegion = new LinkedList<>();
    
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
    
//===================================================================================================
    
    mainPanel = new JPanel(new SpringLayout());
    mainPanel.setBackground(Color.GRAY.darker());
    mainPanel.addMouseListener(this);
    
    grid = 5;
    gamePanel = new JPanel();
    gamePanel.setPreferredSize(new Dimension(spielfeld, spielfeld));
    gamePanel.setBackground(Color.GRAY.brighter());
    
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
    
    textField = new JLabel();
    textField.setPreferredSize(new Dimension(230, 100));
    textField.setBackground(Color.WHITE);
    textField.setHorizontalAlignment(SwingConstants.CENTER);
    textField.setBorder(blackline);
    textField.setOpaque(true);

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
    
    meeple = new JLabel();
    meeple.setVisible(false);
    
    topLeftLabel = new JLabel();
    topMiddleLabel = new JLabel();
    topRightLabel = new JLabel();
    
    leftTopLabel = new JLabel();
    rightTopLabel = new JLabel();
    
    leftMiddleLabel = new JLabel();
    centerMiddleLabel = new JLabel();
    rightMiddleLabel = new JLabel();
    
    leftBelowLabel = new JLabel();
    rightBelowLabel = new JLabel();
    
    belowLeftLabel = new JLabel();
    belowMiddleLabel = new JLabel();
    belowRightLabel = new JLabel();
    
    meepleCount1 = new JLabel();
    meepleCount1.setText(meepleCountText1);
    meepleCount1.setFont(new Font("Arial", Font.PLAIN, 25));
    meepleCount1.setAlignmentX(SwingConstants.CENTER);
    meepleCount1.setAlignmentY(SwingConstants.CENTER);
    meepleCount1.setPreferredSize(new Dimension(50, 50));
    meepleCount1.setBackground(Color.WHITE);
    meepleCount1.setOpaque(true);
    meepleCount1.setHorizontalAlignment(SwingConstants.CENTER);
    
    player1Name = new JLabel();
    player1Name.setText(player1);
    player1Name.setFont(new Font("Arial", Font.PLAIN, 20));
    player1Name.setAlignmentX(SwingConstants.CENTER);
    player1Name.setAlignmentY(SwingConstants.CENTER);
    player1Name.setPreferredSize(new Dimension(130, 50));
    player1Name.setBackground(Color.GRAY.brighter());
    player1Name.setOpaque(true);
    player1Name.setHorizontalAlignment(SwingConstants.CENTER);
    
    player1Score = new JLabel();
    player1Score.setText(scoreCountText1);
    player1Score.setFont(new Font("Arial", Font.PLAIN, 25));
    player1Score.setAlignmentX(SwingConstants.CENTER);
    player1Score.setAlignmentY(SwingConstants.CENTER);
    player1Score.setPreferredSize(new Dimension(50, 50));
    player1Score.setBackground(Color.WHITE);
    player1Score.setOpaque(true);
    player1Score.setHorizontalAlignment(SwingConstants.CENTER);
    
//===================================================================================================      
         
    meepleCount2 = new JLabel();
    meepleCount2.setText(meepleCountText2);
    meepleCount2.setFont(new Font("Arial", Font.PLAIN, 25));
    meepleCount2.setAlignmentX(SwingConstants.CENTER);
    meepleCount2.setAlignmentY(SwingConstants.CENTER);
    meepleCount2.setPreferredSize(new Dimension(50, 50));
    meepleCount2.setBackground(Color.WHITE);
    meepleCount2.setOpaque(true);
    meepleCount2.setHorizontalAlignment(SwingConstants.CENTER);
    
    player2Name = new JLabel();
    player2Name.setText(player2);
    player2Name.setFont(new Font("Arial", Font.PLAIN, 20));
    player2Name.setAlignmentX(SwingConstants.CENTER);
    player2Name.setAlignmentY(SwingConstants.CENTER);
    player2Name.setPreferredSize(new Dimension(130, 50));
    player2Name.setBackground(Color.GRAY.brighter());
    player2Name.setOpaque(true);
    player2Name.setHorizontalAlignment(SwingConstants.CENTER);
    
    player2Score = new JLabel();
    player2Score.setText(scoreCountText2);
    player2Score.setFont(new Font("Arial", Font.PLAIN, 25));
    player2Score.setAlignmentX(SwingConstants.CENTER);
    player2Score.setAlignmentY(SwingConstants.CENTER);
    player2Score.setPreferredSize(new Dimension(50, 50));
    player2Score.setBackground(Color.WHITE);
    player2Score.setOpaque(true);
    player2Score.setHorizontalAlignment(SwingConstants.CENTER);
      
//===================================================================================================       
    
    contentPane = this.getContentPane();
    mainLayout = new SpringLayout();
    mainLayout.putConstraint(SpringLayout.WEST	, gamePanel, 0, SpringLayout.WEST, contentPane);
    mainLayout.putConstraint(SpringLayout.NORTH, gamePanel, 0, SpringLayout.NORTH, contentPane);
    
    mainLayout.putConstraint(SpringLayout.WEST	, leftPanel, 1000, SpringLayout.WEST, contentPane);
    mainLayout.putConstraint(SpringLayout.NORTH, leftPanel, 0, SpringLayout.NORTH, contentPane);
    
    mainPanel.setLayout(mainLayout);
    
//===================================================================================================      
   
	cardMatrix = new JLabel[grid][grid];
    
//===================================================================================================    

    try {
    	picture = ImageIO.read(new File("./src/de/htwg/cityyanderecarcassonne/view/gui/rueckseite_start.png"));
     } catch (IOException ex) {
          // handle exception...
     }
 
    picLabel = new JLabel(new ImageIcon(picture));
    picLabel.setToolTipText("Current card on hand");
    picLabel.setBorder(blackline);
    
    try {
    	possibilitiesPicture = ImageIO.read(new File("./src/de/htwg/cityyanderecarcassonne/view/gui/meeple_possibilities.png"));
     } catch (IOException ex) {
          // handle exception...
     }
    
//===================================================================================================        
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
    
    leftPanelLayout.putConstraint(SpringLayout.WEST	, textField, 10, SpringLayout.WEST, contentPane);
    leftPanelLayout.putConstraint(SpringLayout.NORTH, textField, 830, SpringLayout.NORTH, contentPane);
    
    leftPanel.setLayout(leftPanelLayout);
    
    leftPanel.setBorder(blackline);
    
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
    
    gamePanelLayout = new SpringLayout();
    gamePanel.setLayout(gamePanelLayout);
	
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
    menu.add(finishRoundItem);
    menu.add(rotateLeftItem);
    menu.add(rotateRightItem);
    menu.add(info);
    menu.add(close);
    menuBar.add(menu);
    
    gamePanel.add(meeple);
    
	gamePanel.add(topLeftLabel);
	gamePanel.add(topMiddleLabel);
	gamePanel.add(topRightLabel);
	
	gamePanel.add(leftTopLabel);
	gamePanel.add(rightTopLabel);
	
	gamePanel.add(leftMiddleLabel);
	gamePanel.add(centerMiddleLabel);
	gamePanel.add(rightMiddleLabel);
	
	gamePanel.add(leftBelowLabel);
	gamePanel.add(rightBelowLabel);
	
	gamePanel.add(belowLeftLabel);
	gamePanel.add(belowMiddleLabel);
	gamePanel.add(belowRightLabel);
    
    leftPanel.add(finishRound);
    leftPanel.add(picLabel);
    leftPanel.add(turnLeft);
    leftPanel.add(turnRight);
    leftPanel.add(player1Panel);
    leftPanel.add(player2Panel);
    leftPanel.add(textField);
    player1Panel.add(meepleCount1);
    player1Panel.add(player1Name);
    player1Panel.add(player1Score);
    player2Panel.add(meepleCount2);
    player2Panel.add(player2Name);
    player2Panel.add(player2Score);
    
    mainPanel.add(gamePanel);
    mainPanel.add(leftPanel);
    
    this.setJMenuBar(menuBar);
    this.add(mainPanel, BorderLayout.CENTER);

//===================================================================================================    
    
    // Eigenschaften
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Yandere Carcassonne");
	this.setPreferredSize(new Dimension(1260,1260));
    this.pack();
    this.setResizable(false);
    this.setVisible(true);
	}
    
    public BufferedImage getImage(String filename)	{
        try {
        	picture =  ImageIO.read(new File("./src/de/htwg/cityyanderecarcassonne/view/gui/" + filename + ".png"));
         } catch (IOException ex) {
              // handle exception...
         }
		return picture;
    }
    
    public BufferedImage getImage(ICard card)	{
        try {
        	picture = ImageIO.read(new File("./src/de/htwg/cityyanderecarcassonne/view/gui/" + card.getClass().getSimpleName() + ".png"));
         } catch (IOException ex) {
              // handle exception...
         }
		return picture;
    }
    
    public void placeMeeple(Position pos)	{
        try {
        	meeplePicture = ImageIO.read(new File("./src/de/htwg/cityyanderecarcassonne/view/gui/meeple.png"));
         } catch (IOException ex) {
              // handle exception...
         }
        
        meeple.setVisible(true);
        meeple.setIcon(new ImageIcon(meeplePicture));
		gamePanelLayout.putConstraint(SpringLayout.WEST, meeple, pos.getX(), SpringLayout.WEST, contentPane);
		gamePanelLayout.putConstraint(SpringLayout.NORTH, meeple, pos.getY(), SpringLayout.NORTH, contentPane);
    }

    public ImageIcon skale(Image im)	{
    	karte = spielfeld/grid;
		Image tmp = im.getScaledInstance(karte, karte, Image.SCALE_SMOOTH);
		return new ImageIcon(tmp);
    }
    
    public void printCardLeftPanel()	{
    	getImage(inController.cardOnHand());
    	picLabel.setIcon(new ImageIcon(getImage(currentCard)));	
    }
    
    public void printCardPossibilities()	{
		psCardList = inController.getCardPossibilitiesMap(inController.cardOnHand());
    	Map<String, Position> spList = flipP(inController.getCardPossibilitiesMap(inController.cardOnHand()));
    	
    	possImage = skale(getImage("possibilities"));
    	
    	for(Map.Entry<String, Position> pos : spList.entrySet())	{
    		
    		int coordX = (pos.getValue().getX() - inController.getDimensionX()/2) + grid/2;
    		int coordY = (pos.getValue().getY() - inController.getDimensionY()/2) + grid/2;
    		
    		redrawCard.add(new Position(coordX, coordY));
    		
    		cardMatrix[coordX][coordY].setIcon(possImage);
    	}
    }
    
    public void printRegions(int x, int y)	{
    	
    	Map<JLabel, Position> regions = new HashMap<>();
    	Map<IRegion, JLabel> visible = new HashMap<>();
    	
    	topLeft = new Position(((1*karte)/4) + x - 12, 0 + y);
    	topMiddle = new Position((2*(karte)/4) + x - 12, 0 + y);
    	topRight = new Position(((3*karte)/4) + x - 12, 0 + y);
    	
    	leftTop = new Position(0 + x, ((1*karte)/4) + y - 12);
    	rightTop = new Position(((4*karte)/4) + x - 25, ((1*karte)/4) + y - 12);
    	
    	leftMiddle = new Position(0 + x, ((2*karte)/4) + y - 12);
    	centerMiddle = new Position(((2*karte)/4) + x - 12, ((2*karte)/4) + y - 12);
    	rightMiddle = new Position(((4*karte)/4) + x - 25, ((2*karte)/4) + y - 12);
    	
    	leftBelow = new Position(0 + x, ((3*karte)/4) + y - 12);
    	rightBelow = new Position(((4*karte)/4) + x - 25, ((3*karte)/4) + y - 12);
    	
    	belowLeft = new Position(((1*karte)/4) + x - 12 , ((4*karte)/4) + y - 25);
    	belowMiddle = new Position(((2*karte)/4) + x - 12, ((4*karte)/4) + y - 25);
    	belowRight = new Position(((3*karte)/4) + x - 12, ((4*karte)/4) + y - 25);
    	
    	regions.put(topLeftLabel, topLeft);
    	regions.put(topMiddleLabel, topMiddle);
    	regions.put(topRightLabel, topRight);
    	
    	regions.put(leftTopLabel, leftTop);
    	regions.put(rightTopLabel, rightTop);
    	
    	regions.put(leftMiddleLabel, leftMiddle);
    	regions.put(centerMiddleLabel, centerMiddle);
    	regions.put(rightMiddleLabel, rightMiddle);
    	
    	regions.put(leftBelowLabel, leftBelow);
    	regions.put(rightBelowLabel, rightBelow);
    	
    	regions.put(belowLeftLabel, belowLeft);
    	regions.put(belowMiddleLabel, belowMiddle);
    	regions.put(belowRightLabel, belowRight);
    	
		psRegionList = inController.getRegionPossibilitiesMap(inController.cardOnHand());
    	
    	inController.placeMeeple(inController.getCurrentPlayer(), currentCard, psRegionList.get(currentCard.getTopLeft()));
    	inController.placeMeeple(inController.getCurrentPlayer(), currentCard, psRegionList.get(currentCard.getTopRight()));
    	inController.placeMeeple(inController.getCurrentPlayer(), currentCard, psRegionList.get(currentCard.getTopMiddle()));
    	
    	visible.put(currentCard.getTopLeft(), topLeftLabel);
    	visible.put(currentCard.getTopMiddle(), topMiddleLabel);
    	visible.put(currentCard.getTopRight(), topRightLabel);
    	
    	for(Map.Entry<IRegion, JLabel> point : visible.entrySet())	{
    		if(IDManager.isOwned(point.getKey().getID()))	{
    			point.getValue().setVisible(false);
    		}
    	}
    	
    	for(Map.Entry<JLabel, Position> point : regions.entrySet())	{
    		if(IDManager.isOwned(currentCard.getBelowLeft().getID()))	{	
    		} 		
    		point.getKey().setIcon(new ImageIcon(possibilitiesPicture));
    		gamePanelLayout.putConstraint(SpringLayout.WEST, point.getKey(), point.getValue().getX(), SpringLayout.WEST, contentPane);
    		gamePanelLayout.putConstraint(SpringLayout.NORTH, point.getKey(), point.getValue().getY(), SpringLayout.NORTH, contentPane);
    	}
    }
    
    public void placeStartCard()	{
    	Position pos = new Position(grid/2, grid/2);
    	currentCard = inController.cardOnHand();
		cardMatrix[pos.getX()][pos.getY()].setIcon(skale(getImage(currentCard)));
		cardsOnField.put(pos, picture);
    }
    
    public void redrawCardCard()	{
		for(Position p : redrawCard){
			cardMatrix[p.getX()][p.getY()].setIcon(backImage);
		}
		redrawCard.removeAll(redrawCard);
    }
    
    public void redrawCardRegion()	{
		for(Position p : redrawCard){
			cardMatrix[p.getX()][p.getY()].setIcon(backImage);
		}
		redrawCard.removeAll(redrawCard);
    }
    
    public Map<String, Position> flipP(Map<Position, String> ps)	{
    	Map<String, Position> sp = new HashMap<>();
    	
    	for(Map.Entry<Position, String> test : ps.entrySet())	{
    		sp.put(test.getValue(), test.getKey());
    	}
    	return sp;
    }
    
    public Map<String, IRegion> flipR(Map<IRegion, String> ps)	{
    	Map<String, IRegion> sp = new HashMap<>();
    	
    	for(Map.Entry<IRegion, String> test : ps.entrySet())	{
    		sp.put(test.getValue(), test.getKey());
    	}
    	return sp;
    }
    
    public void rotateCardToLeft()	{
    	picture = rotateImage(picture, -90.0);
    	inController.rotateCardLeft();
    	picLabel.setIcon(new ImageIcon(picture));
    	mainImage = skale(picture);
    }
    
    public void rotateCardToRight()	{
    	picture = rotateImage(picture, 90.0);
    	inController.rotateCardRight(); 
    	leftImage = new ImageIcon(picture);
    	picLabel.setIcon(leftImage);
    	mainImage = skale(picture);
    }
    
    private static BufferedImage rotateImage(BufferedImage src, double degrees) {
        AffineTransform affineTransform = AffineTransform.getRotateInstance(
                Math.toRadians(degrees),
                src.getWidth() / 2,
                src.getHeight() / 2);
        BufferedImage rotatedImage = new BufferedImage(src.getWidth(), src
                .getHeight(), src.getType());
        Graphics2D g = (Graphics2D) rotatedImage.getGraphics();
        g.setTransform(affineTransform);
        g.drawImage(src, 0, 0, null);
        return rotatedImage;
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
    
    public void newField()	{
    	backImage = skale(getImage("rueckseite"));
    	for(int i = 0; i  < cardMatrix.length; i++)	{
    		for(int j = 0; j < cardMatrix[i].length;j++){
    			cardMatrix[i][j] = new JLabel();
    			cardMatrix[i][j].setIcon(backImage);
    			cardMatrix[i][j].setVisible(true);
    			gamePanel.add(cardMatrix[i][j]);
    			gamePanelLayout.putConstraint(SpringLayout.WEST, cardMatrix[i][j], i * karte, SpringLayout.WEST, contentPane);
    			gamePanelLayout.putConstraint(SpringLayout.NORTH, cardMatrix[i][j], j * karte, SpringLayout.NORTH, contentPane);
    		}
    	}
    }
    
    public void resizeView()	{
    	JLabel[][] oldMatrix = cardMatrix; 
    	
    	for(int i = 0; i  < oldMatrix.length; i++)	{
    		for(int j = 0; j < oldMatrix[i].length;j++){
    			gamePanel.remove(oldMatrix[i][j]);
    		}
    	}
    	
    	gamePanel.updateUI();

    	grid = grid + 2;
    	karte = spielfeld/grid;
        
    	cardMatrix = new JLabel[grid][grid];
    	
    	newField();
    	
    	Map<Position, Image> cardsOnFieldTmp = new HashMap<>();
    	
    	for(Map.Entry<Position, Image> card : cardsOnField.entrySet())	{		
    		int newX = card.getKey().getX() + 1;
    		int newY = card.getKey().getY() + 1;
    		Image tmpImage = card.getValue();
    		
    		cardMatrix[newX][newY].setIcon(skale(card.getValue()));
    		cardsOnField.remove(card);
    		cardsOnFieldTmp.put(new Position(newX, newY), tmpImage);
    	}
    	cardsOnField = cardsOnFieldTmp;
    }
    
    static class KeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
    		    textField.setText(inController.getStatusMessage());
            } else if(e.getKeyCode() == KeyEvent.VK_LEFT)	{
    			textField.setText(inController.getStatusMessage());
            } else if(e.getKeyCode() == KeyEvent.VK_RIGHT)	{
    			textField.setText(inController.getStatusMessage());
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
		} else if(source == this.finishRound || source == this.finishRoundItem)	{
			inController.finishRound();
			currentCard = inController.cardOnHand();
			
	    	printCardLeftPanel();
			printCardPossibilities();
			
	    	mainImage = skale(getImage(currentCard));
			
		    textField.setText(status.getStatusMessage(inController.getStatus()));
		    
		} else if(source == this.turnLeft || source == this.rotateLeftItem){	
			this.rotateCardToLeft();
			textField.setText("Card turned to the left!");
			
		} else if(source == this.turnRight || source == this.rotateRightItem){
			this.rotateCardToRight();		
			textField.setText("Card turned to the right!");
			
		} else if(source == this.newGame)	{
			inController.create();
			cardsOnField = new HashMap<>();
			
			inController.addPlayer(player1);
			inController.addPlayer(player2);	
	
			newField();
			placeStartCard();
		    textField.setText(status.getStatusMessage(inController.getStatus()));
		}
	}
	
	public static void main(String[] args)	{
		ICarcassonneController controller = new CarcassonneController(150, 150);
		new GraficUI(controller);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {	
		int x = (int) (arg0.getPoint().getX()/karte);
		int y = (int) (arg0.getPoint().getY()/karte);
		int realX = 0;
		int realY = 0;
		
		if(inController.getStatus() == GameStatus.ROUND_START)	{
			
			realX = ((x-(grid/2))) + 75;
			realY = ((y-(grid/2))) + 75;
			
			Position p = new Position(realX, realY);
			
			inController.placeCard(currentCard, psCardList.get(p));
			
			if(inController.getStatus() == GameStatus.CARD_SET_SUCCESS)	{
				
				cardsOnField.put(new Position(x, y), picture);
				
				cardMatrix[x][y].setIcon(mainImage);
				
				printRegions(karte*x, karte*y);
				
				redrawCard.remove(new Position(x,y));
				//redrawRegion.remove();
				redrawCardCard();
				
				
				
				if((Math.abs(realX - inController.getDimensionX()/2) >= grid/2) || (Math.abs(realY - inController.getDimensionY()/2) >= grid/2))	{
					resizeView();
				}
				
			} else if(inController.getStatus() == GameStatus.CARD_SET_FAIL)	{
				inController.setStatus(GameStatus.ROUND_START);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
