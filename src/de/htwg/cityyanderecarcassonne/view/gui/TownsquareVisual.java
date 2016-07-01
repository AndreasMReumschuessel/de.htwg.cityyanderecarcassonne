package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IPosition;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.impl.Position;
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
        	image = ImageIO.read(new File("./data/blueprint.jpg"));
         } catch (IOException ex) {
        	 ex.printStackTrace();
         }
        
        image = CardPrinterGUI.scaleImage(image, dimX * 200);
        
        g = imageTS.createGraphics();
        g.drawImage(image, 0, 0, null);
	}
	
	public BufferedImage normalTownsquareVisual() {
		backgroundImageVisual();
		
		int xMin = ts.getXMin();
		int xMax = ts.getXMax();
		int yMin = ts.getYMin();
		int yMax = ts.getYMax();
		
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
	
	public BufferedImage possTownsquareVisual(Map<IPosition, String> possibilities)	{
		backgroundImageVisual();
	int xMin = ts.getXMin();
	int xMax = ts.getXMax();
	int yMin = ts.getYMin();
	int yMax = ts.getYMax();
	
		for (int y = yMin; y < yMax + 1; y++) {
			for (int l = 0; l < 7; l++) {
				for (int x = xMin; x < xMax + 1; x++) {
					ICard cx = ts.getCard(x, y);
	
					IPosition tmppos = new Position(x, y);
					performPossVisual(possibilities, tmppos, cx);
					
				}
			}
		}
		return imageTS;
	}
	
	private void performPossVisual(Map<IPosition, String> possibilities, IPosition tmppos, ICard cx)	{
		BufferedImage changed = CardPrinterGUI.pseudoCard();
		
		if(possibilities.containsKey(tmppos))	{
			g.drawImage(changed, tmppos.getX() * changed.getWidth(), tmppos.getY() * changed.getHeight(), null);
		} else {
			this.performNormalVisual(tmppos.getX(), tmppos.getY(), cx);
		}
	}
		
	public BufferedImage meepleTownsquareVisual(ICard card, Map<IRegion, String> possList)	{
		backgroundImageVisual();
		int xMin = ts.getXMin();
		int xMax = ts.getXMax();
		int yMin = ts.getYMin();
		int yMax = ts.getYMax();
		
		for (int y = yMin; y < yMax + 1; y++) {
			for (int l = 0; l < 7; l++) {
				for (int x = xMin; x < xMax + 1; x++) {
					ICard cx = ts.getCard(x, y);
					IPosition pos = new Position(x, y);
					performMeepleVisual(card, cx, pos, possList);
				}
			}
		}
		return imageTS;
	}
	
	private void performMeepleVisual(ICard card, ICard cx, IPosition pos, Map<IRegion, String> possList)	{
		if (cx != null) {
			BufferedImage changed = CardPrinterGUI.printCardPoss(cx, possList);
		
			if(card.equals(cx))	{
				g.drawImage(changed, pos.getX() * changed.getWidth(), pos.getY() * changed.getHeight(), null);
			} else {
				this.performNormalVisual(pos.getX(), pos.getY(), cx);
			}
		}
	}
}
