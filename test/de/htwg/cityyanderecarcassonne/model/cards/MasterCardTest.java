package de.htwg.cityyanderecarcassonne.model.cards;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.model.ICard;

public class MasterCardTest {

	private ICard card;
	
	@Before
	public void setUp() throws Exception {
		card = new CardA();
	}

	@Test
	public void testGetCardGraph() {
		assertEquals(21, card.getCardGraph().getNumberOfEdges());
		
		assertEquals(13, card.getCardGraph().getNumberOfVertexes());
	}

}
