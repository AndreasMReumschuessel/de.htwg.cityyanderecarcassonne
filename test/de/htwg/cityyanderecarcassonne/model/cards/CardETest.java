package de.htwg.cityyanderecarcassonne.model.cards;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import de.htwg.cityyanderecarcassonne.model.IDManager;

public class CardETest {
	
	private static CardE cardE;

	@BeforeClass
	public static void setUpBeforClass() throws Exception	{
		IDManager.resetIDCount();
		cardE = new CardE();
	}

	@Test
	public void getLeftTopOneTest() {
		assertEquals(10000, cardE.getLeftTopOne().getID());
	}

	@Test
	public void getMiddleTopTest() {
		assertEquals(10000, cardE.getMiddleTop().getID());
	}

	@Test
	public void getRightTopOneTest() {
		assertEquals(10000, cardE.getRightTopOne().getID());
	}

	@Test
	public void getLeftTopTwoTest() {
		assertEquals(30000, cardE.getLeftTopTwo().getID());
	}

	@Test
	public void getRightTopTwoTest() {
		assertEquals(30000, cardE.getRightTopTwo().getID());
	}

	@Test
	public void getLeftCenterTest() {
		assertEquals(30000, cardE.getLeftCenter().getID());
	}

	@Test
	public void getMiddleCenterTest() {
		assertEquals(30000, cardE.getMiddleCenter().getID());
	}

	@Test
	public void getRightCenterTest() {
		assertEquals(30000, cardE.getRightCenter().getID());
	}

	@Test
	public void getLeftBelowTwoTest() {
		assertEquals(30000, cardE.getLeftBelowTwo().getID());
	}

	@Test
	public void getRightBelowTwoTest() {
		assertEquals(30000, cardE.getRightBelowTwo().getID());
	}

	@Test
	public void getLeftBelowOneTest() {
		assertEquals(30000, cardE.getLeftBelowOne().getID());		
	}

	@Test
	public void getMiddleBelowTest() {
		assertEquals(30000, cardE.getMiddleBelow().getID());		
	}

	@Test
	public void getRightBelowOneTest() {
		assertEquals(30000, cardE.getRightBelowOne().getID());		
	}
	
}
