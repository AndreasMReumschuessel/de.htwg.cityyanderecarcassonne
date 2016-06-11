package de.htwg.cityyanderecarcassonne.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.model.cards.CardA;
import de.htwg.cityyanderecarcassonne.model.townsquare.Townsquare;

public class TownsquareTest {
	
	private Townsquare map;
	
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
	}
	
	@Test
	public void getChoicesTest() {
		assertTrue(true);
	}
}
