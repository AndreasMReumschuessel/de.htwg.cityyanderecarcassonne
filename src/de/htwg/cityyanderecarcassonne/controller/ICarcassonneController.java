package de.htwg.cityyanderecarcassonne.controller;

import java.util.List;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.Position;

public interface ICarcassonneController {

	public void setTownsquare(int sizeX, int sizeY);
	
	public int getDimensionX();
	
	public int getDimensionY();
	
	public void takeCard();
	
	public void placeCard(ICard c, Position pos);
	
	public void placeCard(ICard c, int x, int y);
	
	public List<Position> getPossibilities();
	
    public GameStatus getStatus();
    
    public String getStatusMessage();
    
    public String getTownsquareString();
    
    public boolean placeMeeple();
    
    public boolean score();
	
}
