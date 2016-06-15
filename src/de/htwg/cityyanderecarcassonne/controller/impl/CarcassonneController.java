package de.htwg.cityyanderecarcassonne.controller.impl;

import java.util.List;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.Player;
import de.htwg.cityyanderecarcassonne.model.Position;
import de.htwg.cityyanderecarcassonne.model.Stock;
import de.htwg.cityyanderecarcassonne.model.townsquare.Townsquare;
import de.htwg.cityyanderecarcassonne.controller.GameStatus;
import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.util.observer.Observable;

public class CarcassonneController extends Observable implements ICarcassonneController  {
	
	private GameStatus status = GameStatus.WELCOME;
	private String statusMessage;
	private Townsquare townsquare;
	private Stock stock;
	public ICard currentCard;
	public Player currentPlayer;
	
	public CarcassonneController(int sizeX, int sizeY) {
		setTownsquare(sizeX, sizeY);
		stock = Stock.getInstance();
	}
	
	public void setTownsquare(int sizeX, int sizeY) {
		this.townsquare = new Townsquare(sizeX, sizeY);
		status = GameStatus.CREATE;
		statusMessage = "";
		notifyObservers();
	}
	
	public int getDimensionX() {
		return townsquare.getDimX();
	}
	
	public int getDimensionY() {
		return townsquare.getDimY();
	}
	
    public void setStatus(GameStatus status) {
        this.status = status;
    }
    
    public String getStatusMessage() {
        return statusMessage;
    }
    
    public String getTownsquareString() {
    	return townsquare.toString();
    }
    
    public GameStatus getStatus() {
        return status;
    }
	
	public void placeCard(ICard c, int x, int y) {
		if (townsquare.setCard(c, x, y)) {
			status = GameStatus.CARD_SET_SUCCESS;
			statusMessage = c.toString();
		} else {
			status = GameStatus.CARD_SET_FAIL;
			statusMessage = c.toString();
		}
		notifyObservers();
	}
	
	public void placeCard(ICard c, Position pos) {
		if (townsquare.setCard(c, pos)) {
			this.setStatus(GameStatus.CARD_SET_SUCCESS);
			statusMessage = c.toString();
		} else {
			this.setStatus(GameStatus.CARD_SET_FAIL);
			statusMessage = c.toString();
		}
		notifyObservers();
	}

	public ICard takeCard() {
		this.setStatus(GameStatus.TAKE_CARD);
		notifyObservers();
		currentCard = stock.getRandomCardFromStock();
		return currentCard;
	}

	public List<Position> getPossibilities(ICard card) {
		notifyObservers();
		return townsquare.getPossibilities(card);
	}
	
	public List<IRegion> getRegionPossibilities(ICard card) {
		//return townsquare.getRegionPossibilities(card);
		notifyObservers();
		return null;
	}

	public void placeMeeple(Player player,ICard card, IRegion region) {
		if(townsquare.placeMeepleOnRegion(player, region)){
			this.setStatus(GameStatus.MEEPLE_SET_SUCCESS);
			statusMessage = card.toString();
		} else	{
			this.setStatus(GameStatus.MEEPLE_SET_FAIL);
		}
		notifyObservers();
	}

	public void changePlayer(Player player) {
		currentPlayer = player;
		notifyObservers();
	}
	
	public void finishRound()	{
		this.setStatus(GameStatus.ROUND_END);
		notifyObservers();
	}

	public void rotateCard(String direction) {
		if(direction == "links")	{
			currentCard.rotateLeft();
		} else	{
			currentCard.rotateRight();
		}
		notifyObservers();
	}
	
}
