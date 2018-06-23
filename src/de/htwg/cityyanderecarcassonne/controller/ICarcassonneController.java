package de.htwg.cityyanderecarcassonne.controller;

import java.util.List;
import java.util.Map;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IPlayer;
import de.htwg.cityyanderecarcassonne.model.IPosition;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.townsquare.Townsquare;
import de.htwg.cityyanderecarcassonne.persistence.ISaveGame;
import de.htwg.util.observer.IObservable;

public interface ICarcassonneController extends IObservable {
	
	int getDimensionX();
	
	int getDimensionY();
	
	ICard cardOnHand();
	
    GameStatus getStatus();
    
    String getStatusMessage();
    
    void placeMeeple(IPlayer player,ICard card, String poss);
    
    void rotateCardLeft();
    
    void rotateCardRight();
    
    Map<IRegion, String>	getRegionPossibilitiesMap(ICard card);

    void create();

    void startRound();

    void finishRound();

    Townsquare getTownsquare();
	
    Map<IPosition, String> getCardPossibilitiesMap(ICard card);
	
	void placeCard(ICard c, String poss);

	void addPlayer(String name);

	void nextPlayer();

	IPlayer getCurrentPlayer();

	List<IPlayer> getPlayers();

	int getRemainingCards();

	void finish();

	void saveSaveGameDB();

	void loadSaveGameDB(int id);

    List<ISaveGame> getSaveGameListDB();

    void deleteSaveGameDB(ISaveGame saveGame);

}
