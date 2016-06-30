package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.BasicStroke;
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
    		drawMeeple(g2, 5, 30, pSize, (Color) calcColor(card.getLeftTop().getPlayer()));
		}
    
	    if (card.getLeftMiddle().getPlayer() != null) {
	    	drawMeeple(g2, 5, 90, pSize, (Color) calcColor(card.getLeftMiddle().getPlayer()));
	    }
	    
	    if (card.getLeftBelow().getPlayer() != null) {
	    	drawMeeple(g2, 5, 150, pSize, (Color) calcColor(card.getLeftBelow().getPlayer()));
	    }
	}

	private static void checkBelow(ICard card, Graphics2D g2, int pSize) {
		if (card.getBelowLeft().getPlayer() != null) {
			drawMeeple(g2, 30, 175, pSize, (Color) calcColor(card.getBelowLeft().getPlayer()));
		}
		
		if (card.getBelowMiddle().getPlayer() != null) {
			drawMeeple(g2, 90, 175, pSize, (Color) calcColor(card.getBelowMiddle().getPlayer()));
		}
		
		if (card.getBelowRight().getPlayer() != null) {
			drawMeeple(g2, 150, 175, pSize, (Color) calcColor(card.getBelowRight().getPlayer()));
		}
		
	}

	private static void checkCenter(ICard card, Graphics2D g2, int pSize) {
		if (card.getCenterMiddle().getPlayer() != null) {
			drawMeeple(g2, 90, 90, pSize, (Color) calcColor(card.getCenterMiddle().getPlayer()));
		}
		
	}

	private static void checkTop(ICard card, Graphics2D g2, int pSize) {
		if (card.getTopLeft().getPlayer() != null) {
			drawMeeple(g2, 30, 5, pSize, (Color) calcColor(card.getTopLeft().getPlayer()));
		}
		
		if (card.getTopMiddle().getPlayer() != null) {
			drawMeeple(g2, 90, 5, pSize, (Color) calcColor(card.getTopMiddle().getPlayer()));
		}
		
		if (card.getTopRight().getPlayer() != null) {
			drawMeeple(g2, 150, 5, pSize, (Color) calcColor(card.getTopRight().getPlayer()));
		}
	}

	private static void checkRight(ICard card, Graphics2D g2, int pSize) {
		if (card.getRightTop().getPlayer() != null) {
			drawMeeple(g2, 175, 30, pSize, (Color) calcColor(card.getRightTop().getPlayer()));
		}
		
		if (card.getRightMiddle().getPlayer() != null) {
			drawMeeple(g2, 175, 90, pSize, (Color) calcColor(card.getRightMiddle().getPlayer()));
		}
		
		if (card.getRightBelow().getPlayer() != null) {
			drawMeeple(g2, 175, 150, pSize, (Color) calcColor(card.getRightBelow().getPlayer()));
		}
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
	        Color color = Color.YELLOW;
	        g2.setStroke(new BasicStroke(1));
	        
	        markLeft(card, possList, g2, pSize, color);
	        markBelow(card, possList, g2, pSize, color);
	        markCenter(card, possList, g2, pSize, color);
	        markTop(card, possList, g2, pSize, color);
	        markRight(card, possList, g2, pSize, color);
	        
	        cardImg = tmpImg;
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cardImg;
	}

	private static void markLeft(ICard card, Map<IRegion, String> possList, Graphics2D g2, int pSize, Color color) {
		if (possList.containsKey(card.getLeftTop()))
			drawMeeple(g2, 5, 30, pSize, color);
    
	    if (possList.containsKey(card.getLeftMiddle()))
	    	drawMeeple(g2, 5, 90, pSize, color);
	    
	    if (possList.containsKey(card.getLeftBelow()))
	    	drawMeeple(g2, 5, 150, pSize, color);
	}

	private static void markBelow(ICard card, Map<IRegion, String> possList, Graphics2D g2, int pSize, Color color) {
		if (possList.containsKey(card.getBelowLeft()))
			drawMeeple(g2, 30, 175, pSize, color);
		
		if (possList.containsKey(card.getBelowMiddle()))
			drawMeeple(g2, 90, 175, pSize, color);
		
		if (possList.containsKey(card.getBelowRight()))
			drawMeeple(g2, 150, 175, pSize, color);
	}

	private static void markCenter(ICard card, Map<IRegion, String> possList, Graphics2D g2, int pSize, Color color) {
		if (possList.containsKey(card.getCenterMiddle()))
			drawMeeple(g2, 90, 90, pSize, color);
	}

	private static void markTop(ICard card, Map<IRegion, String> possList, Graphics2D g2, int pSize, Color color) {
		if (possList.containsKey(card.getTopLeft()))
			drawMeeple(g2, 30, 5, pSize, color);
		
		if (possList.containsKey(card.getTopMiddle()))
			drawMeeple(g2, 90, 5, pSize, color);
		
		if (possList.containsKey(card.getTopRight()))
			drawMeeple(g2, 150, 5, pSize, color);
	}

	private static void markRight(ICard card, Map<IRegion, String> possList, Graphics2D g2, int pSize, Color color) {
		if (possList.containsKey(card.getRightTop()))
			drawMeeple(g2, 175, 30, pSize, color);
		
		if (possList.containsKey(card.getRightMiddle()))
			drawMeeple(g2, 175, 90, pSize, color);
		
		if (possList.containsKey(card.getRightBelow()))
			drawMeeple(g2, 175, 150, pSize, color);
	}
	
	private static void drawMeeple(Graphics2D g2, int x, int y, int pSize, Color color) {
		g2.setPaint(color);
		g2.fillOval(x, y, pSize, pSize);
		g2.setPaint(Color.BLACK);
		g2.drawOval(x, y, pSize, pSize);
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
		BufferedImage resultImg = null;
		double radiant = degree * Math.PI / 180;
		AffineTransform at = new AffineTransform();
		
		at.rotate(radiant, (double) img.getWidth() / 2, (double) img.getHeight() / 2);
		
		AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		resultImg = op.filter(img, null);
		return resultImg;
	}
	
	public static BufferedImage scaleImage(BufferedImage img, int targetSize) {
		BufferedImage resultImg = null;
		double scaleFactor = (double) targetSize / img.getHeight();
		
		AffineTransform at = new AffineTransform();
		
		at.scale(scaleFactor, scaleFactor);
		
		AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		resultImg = op.filter(img, null);
		return resultImg;
	}

}
