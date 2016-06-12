package de.htwg.cityyanderecarcassonne.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.model.cards.CardA;
import de.htwg.cityyanderecarcassonne.model.cards.CardB;
import de.htwg.cityyanderecarcassonne.model.cards.CardC;
import de.htwg.cityyanderecarcassonne.model.cards.CardD;
import de.htwg.cityyanderecarcassonne.model.cards.CardE;
import de.htwg.cityyanderecarcassonne.model.cards.CardH;
import de.htwg.cityyanderecarcassonne.model.cards.CardI;
import de.htwg.cityyanderecarcassonne.model.cards.CardL;
import de.htwg.cityyanderecarcassonne.model.cards.CardMN;
import de.htwg.cityyanderecarcassonne.model.cards.CardOP;
import de.htwg.cityyanderecarcassonne.model.cards.CardU;
import de.htwg.cityyanderecarcassonne.model.townsquare.Townsquare;

public class ITownsquareTest {
	
	private ITownsquare map;
	
	@Before
	public void setUp() throws Exception {
		map = new Townsquare(100, 101);
	}
	
	@Test
	public void dimTest() {
		assertEquals(100, map.getDimX());
		assertEquals(101, map.getDimY());
	}
	
	@Test
	public void getCardTest() {
		ICard card = new CardA();
		
		map.setCard(card, 30, 45);
		assertEquals(card, map.getCard(30, 45));
		
		Position pos = new Position(25, 60);
		map.setCard(card, pos);
		
		assertEquals(card, map.getCard(pos));
		
		assertEquals(null, map.getCard(-1, 200));
		assertEquals(null, map.getCard(150, -10));
		assertEquals(null, map.getCard(150, 10));
		assertEquals(null, map.getCard(50, 1000));
	}
	
	@Test
	public void complexTest() {
		assertTrue(map.setCard(new CardD(), 50, 50));
		assertTrue(map.setCard(new CardL(), 50, 51));
		assertTrue(map.setCard(new CardMN(), 51, 51));
		assertTrue(map.setCard(new CardOP(), 49, 51));
		assertTrue(map.setCard(new CardU(), 50, 49));
		assertTrue(map.setCard(new CardI(), 51, 49));
		assertTrue(map.setCard(new CardC(), 51, 50));
		assertTrue(map.setCard(new CardE(), 49, 49));
		assertTrue(map.setCard(new CardB(), 48, 50));
		assertFalse(map.setCard(new CardI(), 49, 50));
		assertFalse(map.setCard(new CardD(), 50, 50));
		
		assertEquals("[(49|48), (51|48), (52|49), (47|50), (52|50), (48|51), (52|51), (51|52)]", map.getPossibilities(new CardH()).toString());
		assertEquals("[(49|48), (51|48), (48|49), (52|49), (47|50), (52|50), (48|51), (52|51), (51|52)]", map.getPossibilities(new CardI()).toString());
	}
}
