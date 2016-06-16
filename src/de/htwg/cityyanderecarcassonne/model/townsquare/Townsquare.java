package de.htwg.cityyanderecarcassonne.model.townsquare;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.ITownsquare;
import de.htwg.cityyanderecarcassonne.model.Player;
import de.htwg.cityyanderecarcassonne.model.Position;

public class Townsquare implements ITownsquare {
	
	private List<List<ICard>> ts;
	
	private int dimX;
	private int dimY;
	
	public Townsquare(int dimX, int dimY) {
		this.dimX = dimX;
		this.dimY = dimY;
		
		ts = new ArrayList<>();		
		for (int i = 0; i < dimY; i++) {
			ts.add(new ArrayList<>());
			for (int j = 0; j < dimX; j++) {
				ts.get(i).add(null);
			}
		}
	}
	
	@Override
	public ICard getCard(Position p) {
		return getCard(p.getX(), p.getY());
	}
	
	@Override
	public ICard getCard(int x, int y) {
		if (outOfBounds(x, y))
			return null;
		
		return ts.get(y).get(x);
	}
	
	@Override
	public boolean setCard(ICard c, Position p) {
		return setCard(c, p.getX(), p.getY());
	}
	
	@Override
	public boolean setCard(ICard c, int x, int y) {
		if (setPossible(c, x, y)) {
			ts.get(y).set(x, c);
			TownsquareGraph.addCard(c, getCard(x - 1, y), getCard(x, y + 1), getCard(x, y - 1), getCard(x + 1, y));
			return true;
		}
		return false;
	}
	
	@Override
	public List<Position> getPossibilities(ICard c) {
		List<Position> result = new LinkedList<>();
		
		for (int cy = 0; cy < dimY - 1; cy++) {
			for (int cx = 0; cx < dimX - 1; cx++) {
				ICard nL = getCard(cx - 1, cy);
				ICard nB = getCard(cx, cy + 1);
				ICard nT = getCard(cx, cy - 1);
				ICard nR = getCard(cx + 1, cy);
				
				boolean hasNeigbhor = nL != null || nB != null || nT != null || nR != null;
				
				boolean setPossible = setPossible(c, cx, cy) ||
									  setPossible(c.rotateRight(), cx, cy) ||
									  setPossible(c.rotateRight(), cx, cy) ||
									  setPossible(c.rotateRight(), cx, cy);
				
				if (hasNeigbhor && setPossible) {
					Position possibility = new Position(cx, cy);
						
					result.add(possibility);
				}
			}
		}
		return result;
	}
	
	@Override
	public int getDimX() {
		return this.dimX;
	}
	
	@Override
	public int getDimY() {
		return this.dimY;
	}
	
	private boolean outOfBounds(int x, int y) {
		return x < 0 || x > dimX - 1 || y < 0 || y > dimY - 1;
	}
	
	private boolean setPossible(ICard c, int x, int y) {
		if (getCard(x, y) != null || outOfBounds(x, y))
			return false;

		ICard neighborLeft = getCard(x - 1, y);
		ICard neighborBelow = getCard(x, y + 1);
		ICard neighborTop = getCard(x, y - 1);
		ICard neighborRight = getCard(x + 1, y);
		
		boolean nL = neighborLeft == null ||
					 c.getLeftTop().getClass().equals(neighborLeft.getRightTop().getClass()) &&
					 c.getLeftMiddle().getClass().equals(neighborLeft.getRightMiddle().getClass()) &&
					 c.getLeftBelow().getClass().equals(neighborLeft.getRightBelow().getClass());
		
		boolean nB = neighborBelow == null ||
				  	 c.getBelowLeft().getClass().equals(neighborBelow.getTopLeft().getClass()) &&
					 c.getBelowMiddle().getClass().equals(neighborBelow.getTopMiddle().getClass()) &&
					 c.getBelowRight().getClass().equals(neighborBelow.getTopRight().getClass());
		
		boolean nT = neighborTop == null ||
					 c.getTopLeft().getClass().equals(neighborTop.getBelowLeft().getClass()) &&
					 c.getTopMiddle().getClass().equals(neighborTop.getBelowMiddle().getClass()) &&
					 c.getTopRight().getClass().equals(neighborTop.getBelowRight().getClass());
	
		boolean nR = neighborRight == null ||
					 c.getRightTop().getClass().equals(neighborRight.getLeftTop().getClass()) &&
					 c.getRightMiddle().getClass().equals(neighborRight.getLeftMiddle().getClass()) &&
					 c.getRightBelow().getClass().equals(neighborRight.getLeftBelow().getClass());
		
		return nL && nB && nT && nR;
	}
	
	@Override
	public String toString() {
		//TODO
		return "";
	}

	@Override
	public boolean placeMeepleOnRegion(Player player, IRegion region) {
		int rID = region.getID();
		if (!IDManager.isOwned(rID)) {
			region.setPlayer(player);
			IDManager.setPlayer(rID, player);
			return true;
		} 
		return false;
	}
}
