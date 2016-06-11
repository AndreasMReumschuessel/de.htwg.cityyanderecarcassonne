package de.htwg.cityyanderecarcassonne.model.cards;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import de.htwg.cityyanderecarcassonne.model.IDManager;

public class CardFGTest {
	
	private static CardFG cardFG;

	@BeforeClass
	public static void setUpBeforClass() throws Exception	{
		IDManager.resetIDCount();
		cardFG = new CardFG();
	}

	@Test
	public void getLeftTopOneTest() {
		assertEquals(30000, cardFG.getLeftTopOne().getID());
	}

	@Test
	public void getMiddleTopTest() {
		assertEquals(30000, cardFG.getMiddleTop().getID());
	}

	@Test
	public void getRightTopOneTest() {
		assertEquals(30000, cardFG.getRightTopOne().getID());
	}

	@Test
	public void getLeftTopTwoTest() {
		assertEquals(10000, cardFG.getLeftTopTwo().getID());
	}

	@Test
	public void getRightTopTwoTest() {
		assertEquals(10000, cardFG.getRightTopTwo().getID());
	}

	@Test
	public void getLeftCenterTest() {
		assertEquals(10000, cardFG.getLeftCenter().getID());
	}

	@Test
	public void getMiddleCenterTest() {
		assertEquals(10000, cardFG.getMiddleCenter().getID());
	}

	@Test
	public void getRightCenterTest() {
		assertEquals(10000, cardFG.getRightCenter().getID());
	}

	@Test
	public void getLeftBelowTwoTest() {
		assertEquals(10000, cardFG.getLeftBelowTwo().getID());
	}

	@Test
	public void getRightBelowTwoTest() {
		assertEquals(10000, cardFG.getRightBelowTwo().getID());
	}

	@Test
	public void getLeftBelowOneTest() {
		assertEquals(30001, cardFG.getLeftBelowOne().getID());		
	}

	@Test
	public void getMiddleBelowTest() {
		assertEquals(30001, cardFG.getMiddleBelow().getID());		
	}

	@Test
	public void getRightBelowOneTest() {
		assertEquals(30001, cardFG.getRightBelowOne().getID());		
	}
	
}
