package de.htwg.cityyanderecarcassonne.controller;

import java.util.List;
import java.util.Map;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.Player;
import de.htwg.cityyanderecarcassonne.model.Position;
import de.htwg.cityyanderecarcassonne.model.townsquare.Townsquare;

public interface ICarcassonneController {
	
	public int getDimensionX();
	
	public int getDimensionY();
	
	public ICard cardOnHand();
	
    public GameStatus getStatus();
    
    public String getStatusMessage();
    
    public String getTownsquareString();
    
    public void placeMeeple(Player player,ICard card, IRegion region);
     
    public void changePlayer(Player player);
    
    public void rotateCardLeft();
    
    public void rotateCardRight();
    
    public Map<IRegion, String>	getRegionPossibilitiesMap(ICard card);

    public void create();

    public void startRound();

    public void finishRound();

    public void setStatus(GameStatus status);

    public Townsquare getTownsquare();
	
    public Map<Position, String> getPossibilitiesMap(ICard card);
	
    public String generateLetter(int ascii);

	void placeCard(ICard c, String poss);
}
