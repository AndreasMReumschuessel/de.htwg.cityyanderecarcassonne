package de.htwg.cityyanderecarcassonne.controller.logger;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.htwg.cityyanderecarcassonne.controller.GameStatus;
import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.Player;
import de.htwg.cityyanderecarcassonne.model.Position;
import de.htwg.cityyanderecarcassonne.model.townsquare.Townsquare;
import de.htwg.util.observer.Observable;

public class CarcassonneController extends Observable implements ICarcassonneController {

	private static final Logger LOGGER = LogManager.getLogger(CarcassonneController.class.getName());
	private ICarcassonneController realController;
	private long startTime;
	
	public CarcassonneController(int sizeX, int sizeY)	{
		realController = new de.htwg.cityyanderecarcassonne.controller.impl.CarcassonneController(sizeX, sizeY);
	}
	
	private void pre() {
		LOGGER.debug("Controller method " + getMethodName(1) + " was called.");
		startTime = System.nanoTime();
	}

	private void post() {
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		LOGGER.debug("Controller method " + getMethodName(1) + " was finished in " + duration + " nanoSeconds.");
	}

	private static String getMethodName(final int depth) {
		final StackTraceElement[] stack = Thread.currentThread().getStackTrace();
		return stack[2 + depth].getMethodName();
	}
	
	@Override
	public int getDimensionX() {
		return realController.getDimensionX();
	}

	@Override
	public int getDimensionY() {
		return realController.getDimensionY();
	}

	@Override
	public ICard cardOnHand() {
		return realController.cardOnHand();
	}

	@Override
	public GameStatus getStatus() {
		return realController.getStatus();
	}

	@Override
	public String getStatusMessage() {
		return realController.getStatusMessage();
	}

	@Override
	public void placeMeeple(Player player, ICard card, String poss) {
		pre();
		realController.placeMeeple(player, card, poss);
		post();
	}

	@Override
	public void rotateCardLeft() {
		pre();
		realController.rotateCardLeft();
		post();
	}

	@Override
	public void rotateCardRight() {
		pre();
		realController.rotateCardRight();
		post();
	}

	@Override
	public Map<IRegion, String> getRegionPossibilitiesMap(ICard card) {
		return realController.getRegionPossibilitiesMap(card);
	}

	@Override
	public void create() {
		pre();
		realController.create();
		post();
	}

	@Override
	public void startRound() {
		pre();
		realController.startRound();
		post();
	}

	@Override
	public void finishRound() {
		pre();
		realController.finishRound();
		post();
	}

	@Override
	public Townsquare getTownsquare() {
		return realController.getTownsquare();
	}

	@Override
	public Map<Position, String> getCardPossibilitiesMap(ICard card) {
		return realController.getCardPossibilitiesMap(card);
	}

	@Override
	public void placeCard(ICard c, String poss) {
		realController.placeCard(c, poss);
	}

	@Override
	public void addPlayer(String name) {
		pre();
		realController.addPlayer(name);
		post();
	}

	@Override
	public void nextPlayer() {
		pre();
		realController.nextPlayer();
		post();
	}

	@Override
	public Player getCurrentPlayer() {
		return realController.getCurrentPlayer();
	}

	@Override
	public int getRemainingCards() {
		return realController.getRemainingCards();
	}

	@Override
	public void finish() {
		pre();
		realController.finish();
		post();
	}

}
