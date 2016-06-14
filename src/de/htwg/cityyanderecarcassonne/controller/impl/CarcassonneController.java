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
	private String statusMessage = "";
	private Townsquare townsquare;
	private Stock stock;
	
	public CarcassonneController(int sizeX, int sizeY) {
		setTownsquare(sizeX, sizeY);
		stock = new Stock();
	}
	
	public void setTownsquare(int sizeX, int sizeY) {
		this.townsquare = new Townsquare(sizeX, sizeY);
		status = GameStatus.CREATED;
		statusMessage = "";
		notifyObservers();
	}
	
	public int getDimensionX() {
		return townsquare.getDimX();
	}
	
	public int getDimensionY() {
		return townsquare.getDimY();
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
	
	@Override
	public void placeCard(ICard c, Position pos) {
		if (townsquare.setCard(c, pos)) {
			status = GameStatus.CARD_SET_SUCCESS;
			statusMessage = c.toString();
		} else {
			status = GameStatus.CARD_SET_FAIL;
			statusMessage = c.toString();
		}
		notifyObservers();
	}
	
    public GameStatus getStatus() {
        return status;
    }
    
    public String getStatusMessage() {
        return statusMessage;
    }
    
    public String getTownsquareString() {
    	return townsquare.toString();
    }

	@Override
	public ICard takeCard() {
		return stock.getRandomCardFromStock();
	}

	@Override
	public List<Position> getPossibilities(ICard card) {
		return townsquare.getPossibilities(card);
	}

	@Override
	public void placeMeeple(Player player,ICard card, IRegion region) {
		if(townsquare.placeMeepleOnRegion(player, region)){
			status = GameStatus.MEEPLE_SET_SUCCESS;
			statusMessage = card.toString();
		} else	{
			status = GameStatus.MEEPLE_SET_FAIL;
		}
		notifyObservers();
	}

	@Override
	public void score() {

	}
}
