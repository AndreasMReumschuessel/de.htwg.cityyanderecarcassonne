package de.htwg.cityyanderecarcassonne.controller.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.controller.GameStatus;
import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.cards.*;

public class CarcassonneControllerTest {
	
	private CarcassonneController ctrl;

	@Before
	public void setUpBeforeClass() throws Exception {
		ctrl = new CarcassonneController(100, 110);
		//ctrl.create();
	}
	/*
	@Test
	public void testGetTownsquare() {
		ctrl.getTownsquare();
	}

	@Test
	public void testGetDimensionX() {
		assertEquals(100, ctrl.getDimensionX());
	}

	@Test
	public void testGetDimensionY() {
		assertEquals(110, ctrl.getDimensionY());
	}

	@Test
	public void testGetStatusMessage() {
		ctrl.addPlayer("Bob");
		assertEquals("Bob!", ctrl.getStatusMessage());
		
		ctrl.addPlayer("Yandere-chan");
		assertEquals("wait no, I have to kill you! Now!", ctrl.getStatusMessage());
	}

	@Test
	public void testGetStatus() {
		ctrl.setStatus(GameStatus.CREATE);
		assertEquals(GameStatus.CREATE,ctrl.getStatus());
	}

	@Test
	public void testPlaceCard() {
		ICard card = new CardA();
		ctrl.addPlayer("Miku");
		ctrl.startRound();
		ctrl.placeCard(ctrl.cardOnHand(), "B");
		ctrl.getCardPossibilitiesMap(card);
		ctrl.placeCard(ctrl.cardOnHand(), "B");
		ctrl.placeCard(ctrl.cardOnHand(), "A");
	}

	@Test
	public void testCardOnHand() {
		ctrl.cardOnHand();
	}

	@Test
	public void testGetRemainingCards() {
		ctrl.addPlayer("Hatsune");
		ctrl.startRound();
		assertEquals(67, ctrl.getRemainingCards());
	}*/

	@Test
	public void testPlaceMeeple() {
		//fail("Not yet implemented");
	}

	@Test
	public void testCreate() {
		//fail("Not yet implemented");
	}

	@Test
	public void testStartRound() {
		//fail("Not yet implemented");
	}

	@Test
	public void testFinish() {
		//fail("Not yet implemented");
	}

	@Test
	public void testFinishRound() {
		//fail("Not yet implemented");
	}

	@Test
	public void testRotateCardLeft() {
		//fail("Not yet implemented");
	}

	@Test
	public void testRotateCardRight() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetRegionPossibilitiesMap() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetCardPossibilitiesMap() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGenerateLetter() {
		//fail("Not yet implemented");
	}

	@Test
	public void testAddPlayer() {
		//fail("Not yet implemented");
	}

	@Test
	public void testNextPlayer() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetCurrentPlayer() {
		//fail("Not yet implemented");
	}

}
