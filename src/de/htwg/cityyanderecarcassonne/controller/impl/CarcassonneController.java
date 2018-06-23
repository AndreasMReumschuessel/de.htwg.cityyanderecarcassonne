package de.htwg.cityyanderecarcassonne.controller.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import de.htwg.cityyanderecarcassonne.controller.GameStatus;
import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IPlayer;
import de.htwg.cityyanderecarcassonne.model.IPosition;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.IScoreCalculus;
import de.htwg.cityyanderecarcassonne.model.cards.Stock;
import de.htwg.cityyanderecarcassonne.model.impl.Player;
import de.htwg.cityyanderecarcassonne.model.scorecalculus.CalculusFinishGame;
import de.htwg.cityyanderecarcassonne.model.scorecalculus.CalculusRunningGame;
import de.htwg.cityyanderecarcassonne.model.townsquare.Townsquare;
import de.htwg.cityyanderecarcassonne.persistence.IDAO;
import de.htwg.cityyanderecarcassonne.persistence.ISaveGame;
import de.htwg.cityyanderecarcassonne.persistence.hibernate.HibernateDAO;
import de.htwg.cityyanderecarcassonne.persistence.savegame.SaveGame;
import de.htwg.util.observer.Observable;

public class CarcassonneController extends Observable implements ICarcassonneController  {
	
	private GameStatus status = GameStatus.WELCOME;
	private String statusMessage;
	private Stock stock;
	private ICard currentCard;
	private Townsquare townsquare;
	private int sizeX, sizeY;
	private IPlayer currentPlayer;
	
	private Map<IPosition, String> cPossMap;
	private boolean cPossGen;
	
	private Map<IRegion, String> mPossMap;
	private boolean mPossGen;
	
	private Queue<IPlayer> playerQueue;
	private List<IPlayer> playerList;
	
	private IScoreCalculus scoreCalculus;

	private ISaveGame saveGame;
	private IDAO dao;
	
	public CarcassonneController(int sizeX, int sizeY) {
		this.stock = Stock.getInstance();
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		
		this.cPossMap = new HashMap<>();
		this.cPossGen = false;
		
		this.mPossMap = new HashMap<>();
		this.mPossGen = false;
		
		this.playerQueue = new LinkedList<>();
		this.playerList = new LinkedList<>();

		this.dao = new HibernateDAO();
		
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
	
    private void setStatus(GameStatus status) {
        this.status = status;
    }
    
    @Override
    public String getStatusMessage() {
        return statusMessage;
    }
    
    @Override
    public GameStatus getStatus() {
        return status;
    }
	
	private void placeCard(ICard c, IPosition pos) {
		if (townsquare.setCard(c, pos)) {
			this.setStatus(GameStatus.CARD_SET_SUCCESS);
			cPossGen = false;
		} else {
			this.setStatus(GameStatus.CARD_SET_FAIL);
			cPossGen = true;
		}
		statusMessage = c.toString();
	}
	
	@Override 
	public void placeCard(ICard c, String poss) {
		if (cPossGen) {
			Map<String, IPosition> map = new HashMap<>();
			for (IPosition p : cPossMap.keySet())
				map.put(cPossMap.get(p), p);
			
			placeCard(c, map.get(poss));
		}
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

	private void placeMeeple(IPlayer player, IRegion region) {
		if(townsquare.placeMeepleOnRegion(player, region)){
			setStatus(GameStatus.MEEPLE_SET_SUCCESS);
			mPossGen = false;
		} else	{
			setStatus(GameStatus.MEEPLE_SET_FAIL);
			mPossGen = true;
		}
		statusMessage = "Meeple from Player " + currentPlayer;
	}
	
	@Override
	public void placeMeeple(IPlayer player, ICard card, String poss) {
		if (mPossGen) {
			Map<String, IRegion> map = new HashMap<>();
			for (IRegion r : mPossMap.keySet())
				map.put(mPossMap.get(r), r);
			
			placeMeeple(player, map.get(poss));
		}
		notifyObservers();
		finishRound();
	}
	
	@Override
	public void create() {
		this.townsquare = new Townsquare(sizeX, sizeY);
		currentCard = stock.getStartCard();
		townsquare.setCard(currentCard, sizeX / 2, sizeY / 2);
		scoreCalculus = new CalculusRunningGame(townsquare);
		
		status = GameStatus.CREATE;
		statusMessage = "";
		notifyObservers();
	}
	
	@Override
	public void startRound()	{
		nextPlayer();
		
		this.setStatus(GameStatus.ROUND_START);
		statusMessage = "";
		
		currentCard = takeCard();
		if(currentCard == null)	{
			finish();
			return;
		}
		notifyObservers();
	}
	
	@Override
	public void finish() {
		this.setStatus(GameStatus.FINISH);
		statusMessage = "";
		
		scoreCalculus = new CalculusFinishGame(townsquare);
		scoreCalculus.refreshScore();
		notifyObservers();
	}

	@Override
	public void finishRound()	{
		this.setStatus(GameStatus.ROUND_END);
		statusMessage = "";
		
		scoreCalculus.refreshScore();
		notifyObservers();
		startRound();
	}

	@Override
	public void rotateCardLeft() {
		if(status.equals(GameStatus.ROUND_START) || status.equals(GameStatus.CARD_SET_FAIL) || status.equals(GameStatus.CARD_ROTATED)) {
			currentCard.rotateLeft();
			this.setStatus(GameStatus.CARD_ROTATED);
			notifyObservers();
		}	
	}
	
	@Override
	public void rotateCardRight() {
		if(status.equals(GameStatus.ROUND_START) || status.equals(GameStatus.CARD_SET_FAIL) || status.equals(GameStatus.CARD_ROTATED)) {
			currentCard.rotateRight();
			this.setStatus(GameStatus.CARD_ROTATED);
			notifyObservers();
		}
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
	public Map<IPosition, String> getCardPossibilitiesMap(ICard card) {
		 List<IPosition> lpos = townsquare.getPossibilities(card);
		 Map<IPosition, String>  em = new HashMap<>();
		 int ascii = 0;
		 
		 for (IPosition p : lpos) {
			 String input = this.generateLetter(ascii);
			 em.put(p, input);
			 ascii++;
		 }
		 cPossMap = em;
		 cPossGen = true;
		 return em;
	}

	private String generateLetter(int ascii) {
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
		IPlayer player = new Player(name);
		playerQueue.add(player);
		playerList.add(player);
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
	public IPlayer getCurrentPlayer() {
		return currentPlayer;
	}

	@Override
	public List<IPlayer> getPlayers() {
		return playerList;
	}

	@Override
	public void saveSaveGameDB() {
	    if (saveGame == null) {
            saveGame = new SaveGame();
        }

	    saveGame.setPlayerList(playerList);
	    dao.saveGame(saveGame);

        statusMessage = "Saved Game.";
        notifyObservers();
	}

	@Override
	public void loadSaveGameDB(int id) {
		saveGame = dao.loadSaveGame(id);
		playerList = saveGame.getPlayerList();
		playerQueue = new LinkedList<>();
		playerQueue.addAll(playerList);

        statusMessage = "Loaded Game";
        notifyObservers();
	}

	@Override
	public List<ISaveGame> getSaveGameListDB() {
		return null;
	}

	@Override
	public void deleteSaveGameDB(ISaveGame saveGame) {

	}
}
