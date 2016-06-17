package de.htwg.cityyanderecarcassonne.controller.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private Stock stock;
	private ICard currentCard;
	private Townsquare townsquare;
	private int sizeX, sizeY;
	private Player currentPlayer;
	
	public CarcassonneController(int sizeX, int sizeY) {
		this.stock = Stock.getInstance();
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		status = GameStatus.WELCOME;
		create();
	}
	
	@Override
	public Townsquare getTownsquare() {
		return this.townsquare;
	}
	
	@Override
	public int getDimensionX() {
		return townsquare.getDimX();
	}
	
	@Override
	public int getDimensionY() {
		return townsquare.getDimY();
	}
	
	@Override
    public void setStatus(GameStatus status) {
    	// No need for it.
        this.status = status;
    }
    
    @Override
    public String getStatusMessage() {
        return statusMessage;
    }
    
    @Override
    public String getTownsquareString() {
    	return townsquare.toString();
    }
    
    @Override
    public GameStatus getStatus() {
        return status;
    }
	
    @Override
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
			this.setStatus(GameStatus.CARD_SET_SUCCESS);
			statusMessage = c.toString();
		} else {
			this.setStatus(GameStatus.CARD_SET_FAIL);
			statusMessage = c.toString();
		}
		notifyObservers();
	}
	
	@Override
	public ICard cardOnHand() {
		return currentCard;
	}

	@Override
	public List<Position> getPossibilities(ICard card) {
		notifyObservers();
		return townsquare.getPossibilities(card);
	}	
	
	@Override
	public List<IRegion> getRegionPossibilities(ICard card) {
		// TODO: As descibed in Backlog Item #1489
		return null;
	}

	@Override
	public void placeMeeple(Player player,ICard card, IRegion region) {
		if(townsquare.placeMeepleOnRegion(player, region)){
			setStatus(GameStatus.MEEPLE_SET_SUCCESS);
			statusMessage = card.toString();
		} else	{
			setStatus(GameStatus.MEEPLE_SET_FAIL);
		}
		notifyObservers();
	}
	
	@Override
	public void create() {
		this.townsquare = new Townsquare(sizeX, sizeY);
		currentCard = stock.getStartCard();
		townsquare.setCard(currentCard, sizeX / 2, sizeY / 2);
		status = GameStatus.CREATE;
		statusMessage = "";
		notifyObservers();
	}

	@Override
	public void changePlayer(Player player) {
		currentPlayer = player;
		notifyObservers();
	}
	
	@Override
	public void startRound()	{
		this.setStatus(GameStatus.ROUND_START);
		currentCard = takeCard();
		if(currentCard == null)	{
			// Finish Game : Check points
		}
		notifyObservers();
	}
	
	@Override
	public void finishRound()	{
		this.setStatus(GameStatus.ROUND_END);
		notifyObservers();
	}

	@Override
	public void rotateCardLeft() {
		currentCard.rotateLeft();
		notifyObservers();
	}
	
	@Override
	public void rotateCardRight() {
		currentCard.rotateRight();
		notifyObservers();
	}
	
	private ICard takeCard() {
		return stock.getRandomCardFromStock();
	}

	@Override
	public Map<Position, String> getPossibilitiesMap(ICard card) {
		 List<Position> lpos = townsquare.getPossibilities(card);
		 Map<Position, String>  em = new HashMap<>();
		 int ascii = 65;
		 
		 for (Position p : lpos) {
			 String input = this.generateLetter(ascii);
			 em.put(p, input);
			 ascii++;
		 }
		 return em;
	}

	@Override
	public String generateLetter(int ascii) {
		
		char input = 65;
		
		if(ascii <= 90 && ascii >= 65){
			input = (char) ascii;
		} else if(ascii > 90)	{
			// StringBuilder für AZ etc.?!
		}
		
		return Character.toString(input);
	}
	
}
