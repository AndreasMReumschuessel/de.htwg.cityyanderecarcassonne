package de.htwg.cityyanderecarcassonne.controller.impl;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.townsquare.Townsquare;
import de.htwg.cityyanderecarcassonne.controller.GameStatus;
import de.htwg.util.observer.Observable;

public class CarcassonneController extends Observable {
	
	private GameStatus status = GameStatus.WELCOME;
	private String statusMessage = "";
	private Townsquare townsquare;
	
	public CarcassonneController(int sizeX, int sizeY) {
		setTownsquare(sizeX, sizeY);
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
	
	public void setCard(ICard c, int x, int y) {
		if (townsquare.setCard(c, x, y)) {
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
}
