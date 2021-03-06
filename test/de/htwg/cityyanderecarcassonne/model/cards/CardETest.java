package de.htwg.cityyanderecarcassonne.model.cards;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import de.htwg.cityyanderecarcassonne.model.IDManager;

public class CardETest {
	
	private static CardE cardE;

	@BeforeClass
	public static void setUpBeforClass() throws Exception	{
		IDManager.resetIDManager();
		cardE = new CardE();
	}

	@Test
	public void getLeftTopOneTest() {
		assertEquals(10000, cardE.getTopLeft().getID());
	}

	@Test
	public void getMiddleTopTest() {
		assertEquals(10000, cardE.getTopMiddle().getID());
	}

	@Test
	public void getRightTopOneTest() {
		assertEquals(10000, cardE.getTopRight().getID());
	}

	@Test
	public void getLeftTopTwoTest() {
		assertEquals(30000, cardE.getLeftTop().getID());
	}

	@Test
	public void getRightTopTwoTest() {
		assertEquals(30000, cardE.getRightTop().getID());
	}

	@Test
	public void getLeftCenterTest() {
		assertEquals(30000, cardE.getLeftMiddle().getID());
	}

	@Test
	public void getMiddleCenterTest() {
		assertEquals(30000, cardE.getCenterMiddle().getID());
	}

	@Test
	public void getRightCenterTest() {
		assertEquals(30000, cardE.getRightMiddle().getID());
	}

	@Test
	public void getLeftBelowTwoTest() {
		assertEquals(30000, cardE.getLeftBelow().getID());
	}

	@Test
	public void getRightBelowTwoTest() {
		assertEquals(30000, cardE.getRightBelow().getID());
	}

	@Test
	public void getLeftBelowOneTest() {
		assertEquals(30000, cardE.getBelowLeft().getID());		
	}

	@Test
	public void getMiddleBelowTest() {
		assertEquals(30000, cardE.getBelowMiddle().getID());		
	}

	@Test
	public void getRightBelowOneTest() {
		assertEquals(30000, cardE.getBelowRight().getID());		
	}
	
}
