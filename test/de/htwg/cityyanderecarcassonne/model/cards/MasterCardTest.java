package de.htwg.cityyanderecarcassonne.model.cards;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IRegion;

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
	
	@Test
	public void rotateLeft() {
		IRegion lT = card.getLeftTop();
		IRegion lM = card.getLeftMiddle();
		IRegion lB = card.getLeftBelow();
		
		IRegion bL = card.getBelowLeft();
		IRegion bM = card.getBelowMiddle();
		IRegion bR = card.getBelowRight();
		
		IRegion cM = card.getCenterMiddle();
		
		IRegion tL = card.getTopLeft();
		IRegion tM = card.getTopMiddle();
		IRegion tR = card.getTopRight();
		
		IRegion rT = card.getRightTop();
		IRegion rM = card.getRightMiddle();
		IRegion rB = card.getRightBelow();
		
		card.rotateLeft();
		
		assertEquals(lT, card.getBelowLeft());
		assertEquals(lM, card.getBelowMiddle());
		assertEquals(lB, card.getBelowRight());
		
		assertEquals(bL, card.getRightBelow());
		assertEquals(bM, card.getRightMiddle());
		assertEquals(bR, card.getRightTop());
		
		assertEquals(cM, card.getCenterMiddle());
		
		assertEquals(tL, card.getLeftBelow());
		assertEquals(tM, card.getLeftMiddle());
		assertEquals(tR, card.getLeftTop());
		
		assertEquals(rT, card.getTopLeft());
		assertEquals(rM, card.getTopMiddle());
		assertEquals(rB, card.getTopRight());
	}
	
	@Test
	public void rotateRight() {
		IRegion lT = card.getLeftTop();
		IRegion lM = card.getLeftMiddle();
		IRegion lB = card.getLeftBelow();
		
		IRegion bL = card.getBelowLeft();
		IRegion bM = card.getBelowMiddle();
		IRegion bR = card.getBelowRight();
		
		IRegion cM = card.getCenterMiddle();
		
		IRegion tL = card.getTopLeft();
		IRegion tM = card.getTopMiddle();
		IRegion tR = card.getTopRight();
		
		IRegion rT = card.getRightTop();
		IRegion rM = card.getRightMiddle();
		IRegion rB = card.getRightBelow();
		
		card.rotateRight();
		
		assertEquals(lT, card.getTopRight());
		assertEquals(lM, card.getTopMiddle());
		assertEquals(lB, card.getTopLeft());
		
		assertEquals(bL, card.getLeftTop());
		assertEquals(bM, card.getLeftMiddle());
		assertEquals(bR, card.getLeftBelow());
		
		assertEquals(cM, card.getCenterMiddle());
		
		assertEquals(tL, card.getRightTop());
		assertEquals(tM, card.getRightMiddle());
		assertEquals(tR, card.getRightBelow());
		
		assertEquals(rT, card.getBelowRight());
		assertEquals(rM, card.getBelowMiddle());
		assertEquals(rB, card.getBelowLeft());
	}

}
