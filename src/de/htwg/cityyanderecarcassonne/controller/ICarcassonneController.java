package de.htwg.cityyanderecarcassonne.controller;

import java.util.List;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.Player;
import de.htwg.cityyanderecarcassonne.model.Position;

public interface ICarcassonneController {
	
	public int getDimensionX();
	
	public int getDimensionY();
	
	//public ICard takeCard();
	
	public ICard cardOnHand();
	
	public void placeCard(ICard c, Position pos);
	
	public void placeCard(ICard c, int x, int y);
	
	public List<Position> getPossibilities(ICard card);
	
	List<IRegion> getRegionPossibilities(ICard card);
	
    public GameStatus getStatus();
    
    public String getStatusMessage();
    
    public String getTownsquareString();
    
    public void placeMeeple(Player player,ICard card, IRegion region);
     
    public void changePlayer(Player player);
    
    public void rotateCardLeft();
    
    public void rotateCardRight();

	void create();

	void startRound();

	void finishRound();

	void setStatus(GameStatus status);
	
}
