package de.htwg.cityyanderecarcassonne.model.cards;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import de.htwg.cityyanderecarcassonne.model.IDManager;;

public class CardXTest {
	
	private static CardX cardX;

	@BeforeClass
	public static void setUpBeforClass() throws Exception	{
		IDManager.resetIDCount();
		cardX = new CardX();
	}
	
	@Test
	public void getLeftTopOneTest() {
		assertEquals(30000, cardX.getLeftTopOne().getID());
	}

	@Test
	public void getMiddleTopTest() {
		assertEquals(50000, cardX.getMiddleTop().getID());
	}

	@Test
	public void getRightTopOneTest() {
		assertEquals(30001, cardX.getRightTopOne().getID());
	}

	@Test
	public void getLeftTopTwoTest() {
		assertEquals(30000, cardX.getLeftTopTwo().getID());
	}

	@Test
	public void getRightTopTwoTest() {
		assertEquals(30001, cardX.getRightTopTwo().getID());
	}

	@Test
	public void getLeftCenterTest() {
		assertEquals(50001, cardX.getLeftCenter().getID());
	}

	@Test
	public void getMiddleCenterTest() {
		assertEquals(20000, cardX.getMiddleCenter().getID());
	}

	@Test
	public void getRightCenterTest() {
		assertEquals(50002, cardX.getRightCenter().getID());
	}

	@Test
	public void getLeftBelowTwoTest() {
		assertEquals(30002, cardX.getLeftBelowTwo().getID());
	}

	@Test
	public void getRightBelowTwoTest() {
		assertEquals(30003, cardX.getRightBelowTwo().getID());
	}

	@Test
	public void getLeftBelowOneTest() {
		assertEquals(30002, cardX.getLeftBelowOne().getID());		
	}

	@Test
	public void getMiddleBelowTest() {
		assertEquals(50003, cardX.getMiddleBelow().getID());		
	}

	@Test
	public void getRightBelowOneTest() {
		assertEquals(30003, cardX.getRightBelowOne().getID());		
	}
	
}
