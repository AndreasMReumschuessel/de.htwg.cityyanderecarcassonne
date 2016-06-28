package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.Player;

public class CardPrinterGUI {
	private static CardPrinterGUI instance = null;
	
	private CardPrinterGUI() {
		
	}
	
	public static CardPrinterGUI getInstance() {
		if(instance == null) {
			instance = new CardPrinterGUI();
		}
		return instance;
	}
	
	public static BufferedImage printCard(ICard card) {
		BufferedImage cardImg = null;
		//Color playerColor = new Color(Math.abs(name.hashCode()) % 255, Math.abs(name.hashCode() + 40) % 255, Math.abs(name.hashCode() + 80) % 255);
		try {
			cardImg = ImageIO.read(new File("./data/" + card.getClass().getSimpleName() + ".png"));
			cardImg = rotateImage(cardImg, card.getOrientation());
			cardImg = scaleImage(cardImg, 200);
			
			int w = 200;
	        int h = 200;
	        int pSize = 20;
	        int type = BufferedImage.TYPE_INT_RGB;
	        BufferedImage tmpImg = new BufferedImage(w, h, type);
	        Graphics2D g2 = tmpImg.createGraphics();
	        g2.drawImage(cardImg, 0, 0, null);
	        g2.setPaint(Color.YELLOW);
	        
	        checkLeft(card, g2, pSize);
	        checkBelow(card, g2, pSize);
	        checkCenter(card, g2, pSize);
	        checkTop(card, g2, pSize);
	        checkRight(card, g2, pSize);
	        
	        cardImg = tmpImg;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cardImg;
	}

	private static void checkLeft(ICard card, Graphics2D g2, int pSize) {
		if (card.getLeftTop().getPlayer() != null) {
    		g2.setPaint(calcColor(card.getLeftTop().getPlayer()));
			g2.fillOval(5, 30, pSize, pSize);
		}
    
	    if (card.getLeftMiddle().getPlayer() != null) {
	    	g2.setPaint(calcColor(card.getLeftMiddle().getPlayer()));
	    	g2.fillOval(5, 90, pSize, pSize);
	    }
	    
	    if (card.getLeftBelow().getPlayer() != null) {
	    	g2.setPaint(calcColor(card.getLeftBelow().getPlayer()));
	    	g2.fillOval(5, 150, pSize, pSize);
	    }
	}

	private static void checkBelow(ICard card, Graphics2D g2, int pSize) {
		if (card.getBelowLeft().getPlayer() != null) {
			g2.setPaint(calcColor(card.getBelowLeft().getPlayer()));
			g2.fillOval(30, 175, pSize, pSize);
		}
		
		if (card.getBelowMiddle().getPlayer() != null) {
			g2.setPaint(calcColor(card.getBelowMiddle().getPlayer()));
			g2.fillOval(90, 175, pSize, pSize);
		}
		
		if (card.getBelowRight().getPlayer() != null) {
			g2.setPaint(calcColor(card.getBelowRight().getPlayer()));
			g2.fillOval(150, 175, pSize, pSize);
		}
		
	}

	private static void checkCenter(ICard card, Graphics2D g2, int pSize) {
		if (card.getCenterMiddle().getPlayer() != null) {
			g2.setPaint(calcColor(card.getCenterMiddle().getPlayer()));
			g2.fillOval(90, 90, pSize, pSize);
		}
		
	}

	private static void checkTop(ICard card, Graphics2D g2, int pSize) {
		// TODO Auto-generated method stub
		
	}

	private static void checkRight(ICard card, Graphics2D g2, int pSize) {
		// TODO Auto-generated method stub
		
	}
	
	private static Paint calcColor(Player player) {
		String name = player.getName();
		return new Color(Math.abs(name.hashCode()) % 255, Math.abs(name.hashCode() + 40) % 255, Math.abs(name.hashCode() + 80) % 255);
	}

	public static BufferedImage printCardPoss(ICard card, Map<IRegion, String> possList) {
		BufferedImage cardImg = null;
		try {
			cardImg = ImageIO.read(new File("./data/" + card.getClass().getSimpleName() + ".png"));
			cardImg = rotateImage(cardImg, card.getOrientation());
			cardImg = scaleImage(cardImg, 200);
			
			int w = 200;
	        int h = 200;
	        int pSize = 20;
	        int type = BufferedImage.TYPE_INT_RGB;
	        BufferedImage tmpImg = new BufferedImage(w, h, type);
	        Graphics2D g2 = tmpImg.createGraphics();
	        g2.drawImage(cardImg, 0, 0, null);
	        g2.setPaint(Color.YELLOW);
	        
	        markLeft(card, possList, g2, pSize);
	        markBelow(card, possList, g2, pSize);
	        markCenter(card, possList, g2, pSize);
	        markTop(card, possList, g2, pSize);
	        markRight(card, possList, g2, pSize);
	        
	        cardImg = tmpImg;
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cardImg;
	}

	private static void markLeft(ICard card, Map<IRegion, String> possList, Graphics2D g2, int pSize) {
		if (possList.containsKey(card.getLeftTop()))
    		g2.fillOval(5, 30, pSize, pSize);
    
	    if (possList.containsKey(card.getLeftMiddle()))
	    	g2.fillOval(5, 90, pSize, pSize);
	    
	    if (possList.containsKey(card.getLeftBelow()))
	    	g2.fillOval(5, 150, pSize, pSize);
	}
	
	private static void markBelow(ICard card, Map<IRegion, String> possList, Graphics2D g2, int pSize) {
		if (possList.containsKey(card.getBelowLeft()))
			g2.fillOval(30, 175, pSize, pSize);
		
		if (possList.containsKey(card.getBelowMiddle()))
			g2.fillOval(90, 175, pSize, pSize);
		
		if (possList.containsKey(card.getBelowRight()))
			g2.fillOval(150, 175, pSize, pSize);
	}

	private static void markCenter(ICard card, Map<IRegion, String> possList, Graphics2D g2, int pSize) {
		if (possList.containsKey(card.getCenterMiddle()))
			g2.fillOval(90, 90, pSize, pSize);
	}

	private static void markTop(ICard card, Map<IRegion, String> possList, Graphics2D g2, int pSize) {
		if (possList.containsKey(card.getTopLeft()))
			g2.fillOval(30, 5, pSize, pSize);
		
		if (possList.containsKey(card.getTopMiddle()))
			g2.fillOval(90, 5, pSize, pSize);
		
		if (possList.containsKey(card.getTopRight()))
			g2.fillOval(150, 5, pSize, pSize);
	}

	private static void markRight(ICard card, Map<IRegion, String> possList, Graphics2D g2, int pSize) {
		if (possList.containsKey(card.getRightTop()))
			g2.fillOval(175, 30, pSize, pSize);
		
		if (possList.containsKey(card.getRightMiddle()))
			g2.fillOval(175, 90, pSize, pSize);
		
		if (possList.containsKey(card.getRightBelow()))
			g2.fillOval(175, 150, pSize, pSize);
	}
	
	public static BufferedImage pseudoCard() {
		BufferedImage cardImg = null;
		try {
			cardImg = ImageIO.read(new File("./data/possibilities.png"));
			cardImg = scaleImage(cardImg, 200);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cardImg;
	}

	private static BufferedImage rotateImage(BufferedImage img, int degree) {
		double radiant = degree * Math.PI / 180;
		AffineTransform at = new AffineTransform();
		
		at.rotate(radiant, img.getWidth() / 2, img.getHeight() / 2);
		
		AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
	    img = op.filter(img, null);
		return img;
	}
	
	private static BufferedImage scaleImage(BufferedImage img, int targetSize) {
		double scaleFactor = (double) targetSize / img.getHeight();
		
		AffineTransform at = new AffineTransform();
		
		at.scale(scaleFactor, scaleFactor);
		
		AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
	    img = op.filter(img, null);
		return img;
	}

}
