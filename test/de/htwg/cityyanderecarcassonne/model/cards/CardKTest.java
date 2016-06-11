package de.htwg.cityyanderecarcassonne.model.cards;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import de.htwg.cityyanderecarcassonne.model.IDManager;;

public class CardKTest {
	
	private static CardK cardK;

	@BeforeClass
	public static void setUpBeforClass() throws Exception	{
		IDManager.resetIDCount();
		cardK = new CardK();
	}
	
	@Test
	public void getLeftTopOneTest() {
		assertEquals(30000, cardK.getLeftTopOne().getID());
	}

	@Test
	public void getMiddleTopTest() {
		assertEquals(50000, cardK.getMiddleTop().getID());
	}

	@Test
	public void getRightTopOneTest() {
		assertEquals(30001, cardK.getRightTopOne().getID());
	}

	@Test
	public void getLeftTopTwoTest() {
		assertEquals(30000, cardK.getLeftTopTwo().getID());
	}

	@Test
	public void getRightTopTwoTest() {
		assertEquals(10000, cardK.getRightTopTwo().getID());
	}

	@Test
	public void getLeftCenterTest() {
		assertEquals(50000, cardK.getLeftCenter().getID());
	}

	@Test
	public void getMiddleCenterTest() {
		assertEquals(50000, cardK.getMiddleCenter().getID());
	}

	@Test
	public void getRightCenterTest() {
		assertEquals(10000, cardK.getRightCenter().getID());
	}

	@Test
	public void getLeftBelowTwoTest() {
		assertEquals(30001, cardK.getLeftBelowTwo().getID());
	}

	@Test
	public void getRightBelowTwoTest() {
		assertEquals(10000, cardK.getRightBelowTwo().getID());
	}

	@Test
	public void getLeftBelowOneTest() {
		assertEquals(30001, cardK.getLeftBelowOne().getID());		
	}

	@Test
	public void getMiddleBelowTest() {
		assertEquals(30001, cardK.getMiddleBelow().getID());		
	}

	@Test
	public void getRightBelowOneTest() {
		assertEquals(30001, cardK.getRightBelowOne().getID());		
	}
	
}
