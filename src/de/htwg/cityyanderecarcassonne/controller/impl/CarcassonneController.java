package de.htwg.cityyanderecarcassonne.controller.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.Player;
import de.htwg.cityyanderecarcassonne.model.Position;
import de.htwg.cityyanderecarcassonne.model.cards.Stock;
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
	
	private Map<Position, String> cPossMap;
	private boolean cPossGen;
	
	private Map<IRegion, String> mPossMap;
	private boolean mPossGen;
	
	private Queue<Player> playerQueue;
	
	public CarcassonneController(int sizeX, int sizeY) {
		this.stock = Stock.getInstance();
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		
		this.cPossMap = new HashMap<>();
		this.cPossGen = false;
		
		this.mPossMap = new HashMap<>();
		this.mPossGen = false;
		
		this.playerQueue = new LinkedList<>();
		
		status = GameStatus.WELCOME;
		statusMessage = "";
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
	
	private void placeCard(ICard c, Position pos) {
		if (townsquare.setCard(c, pos)) {
			this.setStatus(GameStatus.CARD_SET_SUCCESS);
		} else {
			this.setStatus(GameStatus.CARD_SET_FAIL);
		}
		statusMessage = c.toString();
	}
	
	@Override 
	public void placeCard(ICard c, String poss) {
		if (cPossGen) {
			Map<String, Position> map = new HashMap<>();
			for (Position p : cPossMap.keySet())
				map.put(cPossMap.get(p), p);
			
			placeCard(c, map.get(poss));
		}
		cPossGen = false;
		notifyObservers();
	}
	
	@Override
	public ICard cardOnHand() {
		return currentCard;
	}
	
	@Override
	public int getRemainingCards() {
		return stock.getSizeOfStock();
	}

	private void placeMeeple(Player player, ICard card, IRegion region) {
		if(townsquare.placeMeepleOnRegion(player, region)){
			setStatus(GameStatus.MEEPLE_SET_SUCCESS);
		} else	{
			setStatus(GameStatus.MEEPLE_SET_FAIL);
		}
		statusMessage = "Meeple from Player " + currentPlayer;
	}
	
	@Override
	public void placeMeeple(Player player, ICard card, String poss) {
		if (mPossGen) {
			Map<String, IRegion> map = new HashMap<>();
			for (IRegion r : mPossMap.keySet())
				map.put(mPossMap.get(r), r);
			
			placeMeeple(player, card, map.get(poss));
		}
		mPossGen = false;
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
	public void startRound()	{
		this.setStatus(GameStatus.ROUND_START);
		statusMessage = "";
		currentCard = takeCard();
		if(currentCard == null)	{
			finish();
			return;
			// Finish Game : Check points
		}
		notifyObservers();
	}
	
	@Override
	public void finish() {
		this.setStatus(GameStatus.FINISH);
		statusMessage = "";
		
		notifyObservers();
	}

	@Override
	public void finishRound()	{
		this.setStatus(GameStatus.ROUND_END);
		statusMessage = "";
		// this.getScore();
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
	public Map<IRegion, String>	getRegionPossibilitiesMap(ICard card)	{
		 List<IRegion> lR = card.getRegionPossibilities();
		 Map<IRegion, String>  em = new HashMap<>();
		 int ascii = 0;
		 
		 for (IRegion p : lR) {
			 String input = this.generateLetter(ascii);
			 em.put(p, input);
			 ascii++;
		 }
		 mPossMap = em;
		 mPossGen = true;
		 return em;
	}

	@Override
	public Map<Position, String> getCardPossibilitiesMap(ICard card) {
		 List<Position> lpos = townsquare.getPossibilities(card);
		 Map<Position, String>  em = new HashMap<>();
		 int ascii = 0;
		 
		 for (Position p : lpos) {
			 String input = this.generateLetter(ascii);
			 em.put(p, input);
			 ascii++;
		 }
		 cPossMap = em;
		 cPossGen = true;
		 return em;
	}

	@Override
	public String generateLetter(int ascii) {
		StringBuilder sb = new StringBuilder();
		int input = ascii + 65;
		
		if(input >= 65 && input <= 90){
			sb.append((char) input);
		} else if(input > 90){
			sb.append((char) 65);
			sb.append((char) (((input - 65)%26) + 65));
		}		
		return sb.toString();
	}
	
	@Override
	public void addPlayer(String name) {
		Player player = new Player(name);
		playerQueue.add(player);
		setStatus(GameStatus.PLAYER_ADDED);
		
		if ("Yandere-chan".equals(name))
			statusMessage = "wait no, I have to kill you! Now!";
		else
			statusMessage = name + "!";
		
		notifyObservers();
	}
	
	@Override
	public void nextPlayer() {
		currentPlayer = playerQueue.poll();
		playerQueue.add(currentPlayer);
		
		setStatus(GameStatus.PLAYER_CHANGED);
		statusMessage = currentPlayer.toString() + " <3";
		
		notifyObservers();
	}
	
	@Override
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
}
