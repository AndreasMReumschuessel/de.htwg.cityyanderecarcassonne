package de.htwg.cityyanderecarcassonne.controller;

import java.util.List;
import java.util.Map;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IPlayer;
import de.htwg.cityyanderecarcassonne.model.IPosition;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.townsquare.Townsquare;
import de.htwg.util.observer.IObservable;

public interface ICarcassonneController extends IObservable {
	
	public int getDimensionX();
	
	public int getDimensionY();
	
	public ICard cardOnHand();
	
    public GameStatus getStatus();
    
    public String getStatusMessage();
    
    public void placeMeeple(IPlayer player,ICard card, String poss);
    
    public void rotateCardLeft();
    
    public void rotateCardRight();
    
    public Map<IRegion, String>	getRegionPossibilitiesMap(ICard card);

    public void create();

    public void startRound();

    public void finishRound();

    public Townsquare getTownsquare();
	
    public Map<IPosition, String> getCardPossibilitiesMap(ICard card);
	
	void placeCard(ICard c, String poss);

	void addPlayer(String name);

	void nextPlayer();

	IPlayer getCurrentPlayer();

	public List<IPlayer> getPlayers();

	int getRemainingCards();

	void finish();
}
