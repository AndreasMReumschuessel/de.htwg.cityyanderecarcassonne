package de.htwg.cityyanderecarcassonne.model.townsquare;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.ITownsquare;
import de.htwg.cityyanderecarcassonne.model.Position;

public class Townsquare implements ITownsquare {
	
	private List<List<ICard>> ts;
	private TownsquareGraph tsg;
	
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
		
		tsg = new TownsquareGraph(); //TODO: Change it to a static class?
	}
	
	public ICard getCard(Position p) {
		return getCard(p.getX(), p.getY());
	}
	
	public ICard getCard(int x, int y) {
		if (x < 0 || x > dimX - 1 || y < 0 || y > dimY - 1)
			return null;
		
		return ts.get(y).get(x);
	}
	
	public boolean setCard(ICard c, Position p) {
		return setCard(c, p.getX(), p.getY());
	}
	
	public boolean setCard(ICard c, int x, int y) {
		if (setPossible(c, x, y)) {
			ts.get(y).set(x, c);
			tsg.addCard(c, getCard(x - 1, y), getCard(x, y + 1), getCard(x, y - 1), getCard(x + 1, y));
			return true;
		}
		return false;
	}
	
	public List<Position> getPossibilities(ICard c) {
		List<Position> result = new LinkedList<>();
		
		for (int cy = 0; cy < dimY - 1; cy++) {
			for (int cx = 0; cx < dimX - 1; cx++) {
				ICard nL = getCard(cx - 1, cy);
				ICard nB = getCard(cx, cy + 1);
				ICard nT = getCard(cx, cy - 1);
				ICard nR = getCard(cx + 1, cy);
				
				if (nL != null || nB != null || nT != null || nR != null) {
					if (setPossible(c, cx, cy)) { //TODO: Check rotated possibilities of c
						Position possibility = new Position(cx, cy);
						
						result.add(possibility);
					}
				}
			}
		}
		return result;
	}
	
	public int getDimX() {
		return this.dimX;
	}
	
	public int getDimY() {
		return this.dimY;
	}
	
	private boolean setPossible(ICard c, int x, int y) {
		if (getCard(x, y) != null)
			return false;

		ICard neighborLeft = getCard(x - 1, y);
		ICard neighborBelow = getCard(x, y + 1);
		ICard neighborTop = getCard(x, y - 1);
		ICard neighborRight = getCard(x + 1, y);
		
		boolean nL = (neighborLeft == null ||
					  c.getLeftTopTwo().getClass().equals(neighborLeft.getRightTopTwo().getClass()) &&
					  c.getLeftCenter().getClass().equals(neighborLeft.getRightCenter().getClass()) &&
					  c.getLeftBelowTwo().getClass().equals(neighborLeft.getRightBelowTwo().getClass()));
		
		boolean nB = (neighborBelow == null ||
				  	  c.getLeftBelowOne().getClass().equals(neighborBelow.getLeftTopOne().getClass()) &&
					  c.getMiddleBelow().getClass().equals(neighborBelow.getMiddleTop().getClass()) &&
					  c.getRightBelowOne().getClass().equals(neighborBelow.getRightTopOne().getClass()));
		
		boolean nT = (neighborTop == null ||
					  c.getLeftTopOne().getClass().equals(neighborTop.getLeftBelowOne().getClass()) &&
					  c.getMiddleTop().getClass().equals(neighborTop.getMiddleBelow().getClass()) &&
					  c.getRightTopOne().getClass().equals(neighborTop.getRightBelowOne().getClass()));
	
		boolean nR = (neighborRight == null ||
					  c.getRightTopTwo().getClass().equals(neighborRight.getLeftTopTwo().getClass()) &&
					  c.getRightCenter().getClass().equals(neighborRight.getLeftCenter().getClass()) &&
					  c.getRightBelowTwo().getClass().equals(neighborRight.getLeftBelowTwo().getClass()));
		
		return (nL && nB && nT && nR);
	}
}
