package de.htwg.cityyanderecarcassonne.controller.impl;

import java.util.List;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.Position;
import de.htwg.cityyanderecarcassonne.model.townsquare.Townsquare;
import de.htwg.cityyanderecarcassonne.controller.GameStatus;
import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.util.observer.Observable;

public class CarcassonneController extends Observable implements ICarcassonneController  {
	
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

	@Override
	public void takeCard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void placeCard(ICard c, Position pos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void placeCard(ICard c, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Position> getPossibilities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean placeMeeple() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean score() {
		// TODO Auto-generated method stub
		return false;
	}
}
