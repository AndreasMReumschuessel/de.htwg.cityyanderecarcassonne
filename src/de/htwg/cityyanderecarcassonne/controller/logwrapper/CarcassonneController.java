package de.htwg.cityyanderecarcassonne.controller.logwrapper;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.impl.Log4JLogger;

import de.htwg.cityyanderecarcassonne.controller.GameStatus;
import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.Player;
import de.htwg.cityyanderecarcassonne.model.Position;
import de.htwg.cityyanderecarcassonne.model.townsquare.Townsquare;
import de.htwg.util.observer.Observable;

public class CarcassonneController extends Observable implements ICarcassonneController {

	private static final Log4JLogger LOGGER = new Log4JLogger(CarcassonneController.class.getName());
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
	public void placeCard(ICard c, Position pos) {
		pre();
		realController.placeCard(c, pos);
		post();
	}

	@Override
	public void placeCard(ICard c, int x, int y) {
		pre();
		realController.placeCard(c, x, y);
		post();
	}

	@Override
	public List<Position> getPossibilities(ICard card) {
		return realController.getPossibilities(card);
	}

	@Override
	public List<IRegion> getRegionPossibilities(ICard card) {
		return realController.getRegionPossibilities(card);
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
	public String getTownsquareString() {
		return realController.getTownsquareString();
	}

	@Override
	public void placeMeeple(Player player, ICard card, IRegion region) {
		pre();
		realController.placeMeeple(player, card, region);
		post();
	}

	@Override
	public void changePlayer(Player player) {
		pre();
		realController.changePlayer(player);
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
	public void setStatus(GameStatus status) {
		pre();
		realController.setStatus(status);
		post();
	}

	@Override
	public Townsquare getTownsquare() {
		return realController.getTownsquare();
	}

	@Override
	public Map<Position, String> getPossibilitiesMap(ICard card) {
		return realController.getPossibilitiesMap(card);
	}

	@Override
	public String generateLetter(int ascii) {
		return realController.generateLetter(ascii);
	}

}
