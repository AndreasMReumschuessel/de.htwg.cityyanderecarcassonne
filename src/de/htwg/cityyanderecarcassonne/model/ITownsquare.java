package de.htwg.cityyanderecarcassonne.model;

import java.util.List;


public interface ITownsquare {
	
	public ICard getCard(IPosition p);
	
	public ICard getCard(int x, int y);
	
	public boolean setCard(ICard c, IPosition p);
	
	public boolean setCard(ICard c, int x, int y);
	
	public List<IPosition> getPossibilities(ICard c);
	
	public int getDimX();
	
	public int getDimY();
	
	int getXMin();

	int getXMax();

	int getYMin();

	int getYMax();
	
	public boolean placeMeepleOnRegion(IPlayer player, IRegion region);
}
