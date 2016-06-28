package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.Position;
import de.htwg.cityyanderecarcassonne.model.townsquare.Townsquare;

public class TownsquareVisual {

	private Townsquare ts;
	private BufferedImage imageTS;
	private Graphics2D g;
	private int dimX;
	private int dimY;
	
	public TownsquareVisual(Townsquare ts) {
		CardPrinterGUI.getInstance();
		this.ts = ts;
		this.dimX = ts.getDimX();
		this.dimY = ts.getDimY();
	}
	
	public void backgroundImageVisual()	{
		int type = BufferedImage.TYPE_INT_RGB;
		imageTS = new BufferedImage(dimX * 200, dimY * 200, type);
		
		BufferedImage image = null;
		
        try {
        	image = ImageIO.read(new File("./data/background.png"));
         } catch (IOException ex) {
        	 ex.printStackTrace();
         }
        
        g = imageTS.createGraphics();
        g.drawImage(image, 0, 0, null);
	}
	
	public BufferedImage normalTownsquareVisual() {
		backgroundImageVisual();
		
		int xMin = getXMin();
		int xMax = getXMax();
		int yMin = getYMin();
		int yMax = getYMax();
		
		for (int y = yMin; y < yMax + 1; y++) {
			for (int l = 0; l < 7; l++) {
				for (int x = xMin; x < xMax + 1; x++) {
					ICard cx = ts.getCard(x, y);

					performNormalVisual(x, y, cx);
					
				}
			}
		}
		
		return imageTS;
	}
	
	private void performNormalVisual(int x, int y, ICard cx)	{
		if (cx != null) {
			BufferedImage image = CardPrinterGUI.printCard(cx);
			g.drawImage(image, x * image.getWidth(), y * image.getHeight(), null);
		}
	}
	
	public BufferedImage possTownsquareVisual(Map<Position, String> possibilities)	{
		backgroundImageVisual();
	int xMin = getXMin();
	int xMax = getXMax();
	int yMin = getYMin();
	int yMax = getYMax();
	
		for (int y = yMin; y < yMax + 1; y++) {
			for (int l = 0; l < 7; l++) {
				for (int x = xMin; x < xMax + 1; x++) {
					ICard cx = ts.getCard(x, y);
	
					Position tmppos = new Position(x, y);
					performPossVisual(possibilities, tmppos, cx);
					
				}
			}
		}
		return imageTS;
	}
	
	private void performPossVisual(Map<Position, String> possibilities, Position tmppos, ICard cx)	{
		BufferedImage changed = CardPrinterGUI.pseudoCard();
		
		if(possibilities.containsKey(tmppos))	{
			g.drawImage(changed, tmppos.getX() * changed.getWidth(), tmppos.getY() * changed.getHeight(), null);
		} else {
			this.performNormalVisual(tmppos.getX(), tmppos.getY(), cx);
		}
	}
		
	public BufferedImage meepleTownsquareVisual(ICard card, Map<IRegion, String> possList)	{
		backgroundImageVisual();
		int xMin = getXMin();
		int xMax = getXMax();
		int yMin = getYMin();
		int yMax = getYMax();
		
		for (int y = yMin; y < yMax + 1; y++) {
			for (int l = 0; l < 7; l++) {
				for (int x = xMin; x < xMax + 1; x++) {
					ICard cx = ts.getCard(x, y);
					Position pos = new Position(x, y);
					performMeepleVisual(card, cx, pos, possList);
				}
			}
		}
		return imageTS;
	}
	
	private void performMeepleVisual(ICard card, ICard cx, Position pos, Map<IRegion, String> possList)	{
		if (cx != null) {
			BufferedImage changed = CardPrinterGUI.printCardPoss(cx, possList);
		
			if(card.equals(cx))	{
				g.drawImage(changed, pos.getX() * changed.getWidth(), pos.getY() * changed.getHeight(), null);
			} else {
				this.performNormalVisual(pos.getX(), pos.getY(), cx);
			}
		}
	}
	
	private int getXMin() {
		int min = dimX;
		for (int y = 0; y < dimY; y++) {
			for (int x = 0; x < dimX; x++) {
				if (ts.getCard(x, y) != null)
					min = Math.min(min, x);
			}
		}
		if (min - 1 < 0)
			return 0;
		else
			return min - 1;
	}
	
	private int getXMax() {
		int max = 0;
		for (int y = 0; y < dimY; y++) {
			for (int x = 0; x < dimX; x++) {
				if (ts.getCard(x, y) != null)
					max = Math.max(max, x);
			}
		}
		if (max + 1 >= dimX)
			return max;
		return max + 1;
	}
	
	private int getYMin() {
		for (int y = 0; y < dimY; y++) {
			for (int x = 0; x < dimX; x++) {
				if (ts.getCard(x, y) != null && y - 1 >= 0)
					return y - 1;
				else if (ts.getCard(x, y) != null && y - 1 < 0)
					return 0;
			}
		}
		return 0;
	}
	
	private int getYMax() {
		int max = 0;
		for (int y = 0; y < dimY; y++) {
			for (int x = 0; x < dimX; x++) {
				if (ts.getCard(x, y) != null)
					max = Math.max(max, y);
			}
		}
		if (max + 1 >= dimX)
			return max;
		return max + 1;
	}
	
	private BufferedImage graphicsToImage(Graphics2D graphic) {
		return null;
	}
	
}
