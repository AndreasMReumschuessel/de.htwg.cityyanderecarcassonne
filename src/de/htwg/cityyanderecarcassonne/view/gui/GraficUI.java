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
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.Position;
import de.htwg.cityyanderecarcassonne.view.StatusMessage;
import de.htwg.util.observer.Event;
import de.htwg.util.observer.IObserver;

public class GraficUI extends JFrame implements ActionListener, MouseListener, IObserver {

	private static CarcassonneController controller;
	StatusMessage status;
	
	List<Position> redrawCard;
	List<IRegion> redrawRegion;
	
	Map<Position, String> positionStringCardList;
	Map<IRegion, String> regionStringMap;
	
	Map<Position, BufferedImage> cardsOnField;
	
	BigMap<Position, JLabel, BufferedImage> objectList;
	BigMap<JLabel, IRegion, Position> bm;
	
    int spielfeld = 1000;
    int grid;
    int cardSize;
    int meepleSize;
	int k = 0;
	int gridX;
	int gridY;
	int controllerX;
	int controllerY;
	int i = 0;
	
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
    Border redLine;
    
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
    List<JLabel> meepleList;
    
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
    JLabel picLabel;
    JLabel possibilitiesLabel;
    JLabel[][] cardMatrix;
    
	BufferedImage backPicture;
	BufferedImage startPicture;
	BufferedImage targetPicture;
    BufferedImage meeplePicture1;
    BufferedImage meeplePicture2;
    BufferedImage possCardPicture;
    BufferedImage possMeeplePicture;
	
	Icon startImage;
	Icon targetImage;
	Icon backImage;
	Icon leftImage;
	Icon possImage;
    
//===================================================================================================    
    
    public GraficUI(CarcassonneController controller, int grid)	{
    	
    this.grid = grid;	
    this.controller = controller;
    controller.addObserver(this);
    
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
    redLine = BorderFactory.createLineBorder(Color.RED, 5);
    
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
    
    picLabel = new JLabel();
    
    meepleList = new LinkedList<>();
    
    for(int i = 0; i < 8; i++ )	{
    	meepleList.add(new JLabel());
    }
    
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
    
//===================================================================================================    
 
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
    
    for(JLabel l : meepleList){
    	gamePanel.add(l);
    }
    
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
    
    public void importPictures()	{
    	
        try {
        	startPicture = ImageIO.read(new File("./src/de/htwg/cityyanderecarcassonne/view/gui/rueckseite_start.png"));
         } catch (IOException ex) {
              // handle exception...
         }
    	
        try {
        	backPicture = ImageIO.read(new File("./src/de/htwg/cityyanderecarcassonne/view/gui/rueckseite.png"));
         } catch (IOException ex) {
              // handle exception...
         }
        
        try {
        	possCardPicture = ImageIO.read(new File("./src/de/htwg/cityyanderecarcassonne/view/gui/possibilities.png"));
         } catch (IOException ex) {
              // handle exception...
         }
        
        try {
        	possMeeplePicture = ImageIO.read(new File("./src/de/htwg/cityyanderecarcassonne/view/gui/meeple_possibilities.png"));
         } catch (IOException ex) {
              // handle exception...
         }
        
        try {
        	meeplePicture1 = ImageIO.read(new File("./src/de/htwg/cityyanderecarcassonne/view/gui/meeple_rot.png"));
         } catch (IOException ex) {
              // handle exception...
         }
        
        try {
        	meeplePicture2 = ImageIO.read(new File("./src/de/htwg/cityyanderecarcassonne/view/gui/meeple_blau.png"));
         } catch (IOException ex) {
              // handle exception...
         }
        
        picLabel.setIcon(new ImageIcon(startPicture));
        picLabel.setBorder(blackline);
        
    }
    
    public BufferedImage getImage(ICard card)	{
        try {
        	targetPicture = ImageIO.read(new File("./src/de/htwg/cityyanderecarcassonne/view/gui/" + card.getClass().getSimpleName() + ".png"));
         } catch (IOException ex) {
              // handle exception...
         }
		return targetPicture;
    }

    public void placeMeeple(IRegion r, BufferedImage meeplePicture)	{
    	
    	JLabel meeple = meepleList.get(i++);
    	
        meeple.setIcon(skaleMeeple(meeplePicture,  2));
        gamePanelLayout.putConstraint(SpringLayout.WEST, meeple, bm.getV(r).getX() - (meepleSize/4), SpringLayout.WEST, contentPane);
		gamePanelLayout.putConstraint(SpringLayout.NORTH, meeple, bm.getV(r).getY() - (meepleSize/4), SpringLayout.NORTH, contentPane);
		
		controller.placeMeeple(controller.getCurrentPlayer(), controller.cardOnHand(), regionStringMap.get(r));
		
		objectList.add(new Position(bm.getV(r).getX(), bm.getV(r).getY()), meeple, meeplePicture);
		redrawRegion.add(r);

    }
    
    public ImageIcon skaleCard(Image im)	{
    	cardSize = spielfeld/grid;
		Image tmp = im.getScaledInstance(cardSize, cardSize, Image.SCALE_SMOOTH);
		return new ImageIcon(tmp);
    }
    
    public ImageIcon skaleMeeple(Image im, int s)	{
    	meepleSize = (cardSize*s)/7;
		Image tmp = im.getScaledInstance(meepleSize, meepleSize, Image.SCALE_SMOOTH);
		return new ImageIcon(tmp);
    }
    
    public void printCardLeftPanel()	{
    	picLabel.setIcon(targetImage);	
    }
    
    public void printCardPossibilities()	{
		positionStringCardList = controller.getCardPossibilitiesMap(controller.cardOnHand());
    	Map<String, Position> spList = flipP(controller.getCardPossibilitiesMap(controller.cardOnHand()));
    	
    	possImage = skaleCard(possCardPicture);
    	
    	for(Map.Entry<String, Position> pos : spList.entrySet())	{
    		
    		int coordX = (pos.getValue().getX() - controller.getDimensionX()/2) + grid/2;
    		int coordY = (pos.getValue().getY() - controller.getDimensionY()/2) + grid/2;
    		
    		redrawCard.add(new Position(coordX, coordY));
    		
    		cardMatrix[coordX][coordY].setIcon(possImage);
    	}
    }
    
    public void printRegionPossibilities(int x, int y)	{
    	bm = new BigMap<>();
    	
    	meepleSize = cardSize/7;
    	
    	topLeft = new Position(((1*cardSize)/4) + x - (meepleSize/2), 0 + y);
    	topMiddle = new Position((2*(cardSize)/4) + x - (meepleSize/2), 0 + y);
    	topRight = new Position(((3*cardSize)/4) + x - (meepleSize/2), 0 + y);
    	
    	leftTop = new Position(0 + x, ((1*cardSize)/4) + y - (meepleSize/2));
    	rightTop = new Position(((4*cardSize)/4) + x - meepleSize, ((1*cardSize)/4) + y - (meepleSize/2));
    	
    	leftMiddle = new Position(0 + x, ((2*cardSize)/4) + y - (meepleSize/2));
    	centerMiddle = new Position(((2*cardSize)/4) + x - (meepleSize/2), ((2*cardSize)/4) + y - (meepleSize/2));
    	rightMiddle = new Position(((4*cardSize)/4) + x - meepleSize, ((2*cardSize)/4) + y - (meepleSize/2));
    	
    	leftBelow = new Position(0 + x, ((3*cardSize)/4) + y - (meepleSize/2));
    	rightBelow = new Position(((4*cardSize)/4) + x - meepleSize, ((3*cardSize)/4) + y - (meepleSize/2));
    	
    	belowLeft = new Position(((1*cardSize)/4) + x - (meepleSize/2) , ((4*cardSize)/4) + y - meepleSize);
    	belowMiddle = new Position(((2*cardSize)/4) + x - (meepleSize/2), ((4*cardSize)/4) + y - meepleSize);
    	belowRight = new Position(((3*cardSize)/4) + x - (meepleSize/2), ((4*cardSize)/4) + y - meepleSize);
    	
    	bm.add(topLeftLabel, controller.cardOnHand().getTopLeft(), topLeft);
    	bm.add(topMiddleLabel, controller.cardOnHand().getTopMiddle(), topMiddle);
    	bm.add(topRightLabel, controller.cardOnHand().getTopRight(), topRight);
    	
    	bm.add(leftTopLabel, controller.cardOnHand().getLeftTop(), leftTop);
    	bm.add(rightTopLabel, controller.cardOnHand().getRightTop(), rightTop);
    	
    	bm.add(leftMiddleLabel, controller.cardOnHand().getLeftMiddle(), leftMiddle);
    	bm.add(centerMiddleLabel, controller.cardOnHand().getCenterMiddle(), centerMiddle);
    	bm.add(rightMiddleLabel, controller.cardOnHand().getRightMiddle(), rightMiddle);
    	
    	bm.add(leftBelowLabel, controller.cardOnHand().getLeftBelow(), leftBelow);
    	bm.add(rightBelowLabel, controller.cardOnHand().getRightBelow(), rightBelow);
    	
    	bm.add(belowLeftLabel, controller.cardOnHand().getBelowLeft(), belowLeft);
    	bm.add(belowMiddleLabel, controller.cardOnHand().getBelowMiddle(), belowMiddle);
    	bm.add(belowRightLabel, controller.cardOnHand().getBelowRight(), belowRight);
    	
    	regionStringMap = controller.getRegionPossibilitiesMap(controller.cardOnHand());
    	
    	for(Map.Entry<IRegion, JLabel> point : bm.getKtoT().entrySet())	{
    		if(!regionStringMap.containsKey(point.getKey()))	{			
    			bm.getTtoV().remove(point.getValue());
    		}
    	}
    	
    	for(Map.Entry<JLabel, Position> point : bm.getTtoV().entrySet())	{
    		point.getKey().setIcon(skaleMeeple(possMeeplePicture, 1));
    		point.getKey().setVisible(true);
    		gamePanelLayout.putConstraint(SpringLayout.WEST, point.getKey(), point.getValue().getX(), SpringLayout.WEST, contentPane);
    		gamePanelLayout.putConstraint(SpringLayout.NORTH, point.getKey(), point.getValue().getY(), SpringLayout.NORTH, contentPane);
    		
    		redrawRegion.add(bm.getVtoK().get(point.getValue()));
    	}
    }
    
    public IRegion getRegionPosition(MouseEvent arg0)	{		
    	int controllerX = (int) arg0.getX() % cardSize;
    	int controllerY = (int) arg0.getY() % cardSize;
    	
		double max = Double.POSITIVE_INFINITY;
    
    	IRegion minRegion = null;
    	
    	for(Map.Entry<IRegion, Position> tmp : bm.getKtoV().entrySet())	{ 
      		double abstand = Math.abs(Math.sqrt(Math.abs((tmp.getValue().getX()%cardSize) - controllerX) + Math.abs((tmp.getValue().getY()%cardSize) - controllerY)));
    		
    		if(abstand < max){
    			max = abstand;
    			minRegion = tmp.getKey();
    		}
    	}
    	return minRegion;
    }
    
    public void placeStartCard()	{
    	Position pos = new Position(grid/2, grid/2);
		cardMatrix[pos.getX()][pos.getY()].setIcon(skaleCard(getImage(controller.cardOnHand())));		
		cardsOnField.put(pos, targetPicture);
    }
    
    public void redrawCard()	{
		for(Position p : redrawCard){
			cardMatrix[p.getX()][p.getY()].setIcon(backImage);
		}
		redrawCard.removeAll(redrawCard);
    }
    
    public void redrawRegion()	{
		for(IRegion r : redrawRegion){
			bm.getKtoT().get(r).setVisible(false);
		}
		redrawRegion.removeAll(redrawRegion);
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
    	targetPicture = rotateImage(targetPicture, -90.0);
    	
    	targetImage = new ImageIcon(targetPicture);
    	picLabel.setIcon(new ImageIcon(targetPicture));
    	leftImage = skaleCard(targetPicture);
    	
    	controller.rotateCardLeft();
    }
    
    public void rotateCardToRight()	{
    	targetPicture = rotateImage(targetPicture, 90.0); 
    	
    	targetImage = new ImageIcon(targetPicture);
    	picLabel.setIcon(new ImageIcon(targetPicture));
    	leftImage = skaleCard(targetPicture);
    	
    	controller.rotateCardRight();
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
    	backImage = skaleCard(backPicture);
    	for(int i = 0; i  < cardMatrix.length; i++)	{
    		for(int j = 0; j < cardMatrix[i].length;j++){
    			cardMatrix[i][j] = new JLabel();
    			cardMatrix[i][j].setIcon(backImage);
    			cardMatrix[i][j].setVisible(true);
    			gamePanel.add(cardMatrix[i][j]);
    			gamePanelLayout.putConstraint(SpringLayout.WEST, cardMatrix[i][j], i * cardSize, SpringLayout.WEST, contentPane);
    			gamePanelLayout.putConstraint(SpringLayout.NORTH, cardMatrix[i][j], j * cardSize, SpringLayout.NORTH, contentPane);
    		}
    	}
    }
    
    public void newView()	{
    	importPictures();
    	
		objectList = new BigMap<>();
		cardsOnField = new HashMap<>();
		regionStringMap = new HashMap<>();
		positionStringCardList = new HashMap<>();
		
		controller.addPlayer(player1);
		controller.addPlayer(player2);	
		
		controllerX = controller.getDimensionX()/2;
		controllerY = controller.getDimensionY()/2;
		
    	removeAllJLabel(cardMatrix);
    	cardMatrix = new JLabel[grid][grid];
    	newField();
    	placeStartCard();
    }
    
    public void resizeView()	{
    	JLabel[][] oldMatrix = cardMatrix; 
    	
    	removeAllJLabel(oldMatrix);

    	grid = grid + 2;
    	cardSize = spielfeld/grid;
    	meepleSize = cardSize/7;
        
    	cardMatrix = new JLabel[grid][grid];
    	
    	newField();
    	
    	Map<Position, BufferedImage> cardsOnFieldTmp = new HashMap<>();
    	//BigMap<Position, JLabel, BufferedImage> cardsOnField = new BigMap<>();
    	
    	for(Map.Entry<Position, BufferedImage> object : cardsOnField.entrySet())	{		
    		int newX = object.getKey().getX() + 1;
    		int newY = object.getKey().getY() + 1;
    		
    		System.out.println(newX);
    		System.out.println(newY);
    		
    		cardMatrix[newX][newY].setIcon(skaleCard(object.getValue()));
    		cardsOnField.remove(object);
    		cardsOnFieldTmp.put(new Position(newX,  newY), object.getValue());
    	}
    	
    	cardsOnField = cardsOnFieldTmp;
    	
//    	for(Map.Entry<Position, JLabel> object : objectList.getTtoK().entrySet())	{
//    		int newX = object.getKey().getX() + cardSize;
//    		int newY = object.getKey().getY() + cardSize;
//    
//    		object.getValue().setIcon(skaleMeeple(objectList.getKtoV().get(object.getValue()), 1));
//
//			gamePanelLayout.putConstraint(SpringLayout.WEST, object.getValue(), newX, SpringLayout.WEST, contentPane);
//			gamePanelLayout.putConstraint(SpringLayout.NORTH, object.getValue(), newY, SpringLayout.NORTH, contentPane);
//
//    		objectList.removeTandK(object);
//    		objectsOnField.add(new Position(newX, newY), object.getValue(), meeplePicture1);
//    	}
    }
    
    public void removeAllJLabel(JLabel[][] labelMatrix)	{    	
    	if(labelMatrix != null)	{
	    	for(int i = 0; i  < labelMatrix.length; i++)	{
	    		for(int j = 0; j < labelMatrix[i].length;j++){
	    			gamePanel.remove(labelMatrix[i][j]);
	    		}
	    	}
	    	
	    	
	    	
    	}
    	gamePanel.updateUI();
    }
    
    static class KeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
    		    textField.setText(controller.getStatusMessage());
            } else if(e.getKeyCode() == KeyEvent.VK_LEFT)	{
    			textField.setText(controller.getStatusMessage());
            } else if(e.getKeyCode() == KeyEvent.VK_RIGHT)	{
    			textField.setText(controller.getStatusMessage());
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
			controller.finishRound();
		} else if(source == this.turnLeft || source == this.rotateLeftItem){	
			this.rotateCardToLeft();
		} else if(source == this.turnRight || source == this.rotateRightItem){
			this.rotateCardToRight();			
		} else if(source == this.newGame)	{
			controller.create();
		}
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {	
		gridX = (int) (arg0.getPoint().getX()/cardSize);
		gridY = (int) (arg0.getPoint().getY()/cardSize);
		
		if(controller.getStatus() == GameStatus.ROUND_START)	{
			controllerX = ((gridX-(grid/2))) + 75;
			controllerY = ((gridY-(grid/2))) + 75;
			
			controller.placeCard(controller.cardOnHand(), positionStringCardList.get(new Position(controllerX, controllerY)));
			
		} else if(controller.getStatus() == GameStatus.CARD_SET_SUCCESS)	{
			if(controller.getCurrentPlayer().toString().equals(player1))	{
				placeMeeple(getRegionPosition(arg0), meeplePicture1);
			} else	{
				placeMeeple(getRegionPosition(arg0),meeplePicture2);
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
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
	
	@Override
	public void update(Event e) {
		if(controller.getStatus() == GameStatus.CREATE)	{
			System.out.println("CREATE");
			
			newView();
		    textField.setText(status.getStatusMessage(controller.getStatus()));
		    
		} else if(controller.getStatus() == GameStatus.ROUND_END)	{
			System.out.println("ROUND_END");
			
			redrawRegion();
			redrawCard();
			
		    textField.setText(status.getStatusMessage(controller.getStatus()));
		    
		} else if(controller.getStatus() == GameStatus.ROUND_START)	{
			System.out.println("ROUND_START");
			
			if((Math.abs(controllerX - controller.getDimensionX()/2) >= (grid/2) - 1) || (Math.abs(controllerY - controller.getDimensionY()/2) >= (grid/2) - 1))	{
				resizeView();
			}
			
			targetPicture = getImage(controller.cardOnHand());
	    	targetImage = new ImageIcon(targetPicture);
	    	
	    	printCardLeftPanel();
			printCardPossibilities();
			cardMatrix[gridX][gridY].setBorder(null);
		    textField.setText(status.getStatusMessage(controller.getStatus()));
		    
		} else if(controller.getStatus() == GameStatus.CARD_TURNED_RIGHT)	{
			System.out.println("CARD_TURNED_RIGHT");
			
	    	printCardLeftPanel();
	    	controller.setStatus(GameStatus.ROUND_START);
			textField.setText("Card turned to the right!");
			
		} else if(controller.getStatus() == GameStatus.CARD_TURNED_LEFT)	{
			System.out.println("CARD_TURNED_LEFT");
			
	    	printCardLeftPanel();
	    	controller.setStatus(GameStatus.ROUND_START);
			textField.setText("Card turned to the left!");
			
		} else if(controller.getStatus() == GameStatus.PLAYER_ADDED)	{
			System.out.println("PLAYER_ADDED");
			
		} else if(controller.getStatus() == GameStatus.PLAYER_CHANGED)	{
			System.out.println("PLAYER_CHANGED");
			
		} else if(controller.getStatus() == GameStatus.CARD_SET_SUCCESS)	{
			System.out.println("CARD_SET_SUCCESS");
			
			cardsOnField.put(new Position(gridX, gridY), targetPicture);
			cardMatrix[gridX][gridY].setIcon(skaleCard(targetPicture));
			cardMatrix[gridX][gridY].setBorder(redLine);
			printRegionPossibilities(cardSize*gridX, cardSize*gridY);
			redrawCard.remove(new Position(gridX,gridY));
			
		} else if(controller.getStatus() == GameStatus.CARD_SET_FAIL)	{
			System.out.println("CARD_SET_FAIL");
			
			controller.setStatus(GameStatus.ROUND_START);
			
		} else if(controller.getStatus() == GameStatus.MEEPLE_SET_SUCCESS)	{
			System.out.println("MEEPLE_SET_SUCCESS");
			
			
		} else if(controller.getStatus() == GameStatus.MEEPLE_SET_FAIL)	{
			System.out.println("MEEPLE_SET_FAIL");
			
		}
	}
	
	public static void main(String[] args)	{
		CarcassonneController controller = new CarcassonneController(150, 150);
		new GraficUI(controller, 5);
	}

}
