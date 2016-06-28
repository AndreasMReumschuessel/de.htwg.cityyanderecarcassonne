package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.townsquare.Townsquare;

public class TownsquareVisual {

	private Townsquare ts;
	private CardPrinterGUI cardPrinter;
	private Graphics2D g;
	private int dimX;
	private int dimY;
	
	public TownsquareVisual(Townsquare ts) throws IOException {
		cardPrinter.getInstance();
		this.ts = ts;
		this.dimX = ts.getDimX();
		this.dimY = ts.getDimY();
		this.backgroundImageVisual();
	}
	
	private void backgroundImageVisual() throws IOException	{
		BufferedImage image = null;
		
        try {
        	image = ImageIO.read(new File("./data/background.png"));
         } catch (IOException ex) {
              // handle exception...
         }
        
        g = image.createGraphics();
        g.drawImage(image, 1240, 980, null);
	}
	
	public void printNormalTownsquare() {
		
		int xMin = getXMin();
		int xMax = getXMax();
		int yMin = getYMin();
		int yMax = getYMax();
		
		for (int y = yMin; y < yMax + 1; y++) {
			for (int l = 0; l < 7; l++) {
				for (int x = xMin; x < xMax + 1; x++) {
					ICard cx = ts.getCard(x, y);

					performNormalVisual(x, y, cx, g);
					
				}
			}
		}
	}
	
	private void performNormalVisual(int x, int y, ICard cx, Graphics2D g)	{
		BufferedImage image = cardPrinter.printCard(cx);
		g.drawImage(image, x, y, null);
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
	
}
