package de.htwg.cityyanderecarcassonne.model.cards;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import de.htwg.cityyanderecarcassonne.model.IDManager;;

public class CardUTest {
	
	private static CardU cardU;

	@BeforeClass
	public static void setUpBeforClass() throws Exception	{
		IDManager.resetIDCount();
		cardU = new CardU();
	}
	
	@Test
	public void getLeftTopOneTest() {
		assertEquals(30000, cardU.getLeftTopOne().getID());
	}

	@Test
	public void getMiddleTopTest() {
		assertEquals(50000, cardU.getMiddleTop().getID());
	}

	@Test
	public void getRightTopOneTest() {
		assertEquals(30001, cardU.getRightTopOne().getID());
	}

	@Test
	public void getLeftTopTwoTest() {
		assertEquals(30000, cardU.getLeftTopTwo().getID());
	}

	@Test
	public void getRightTopTwoTest() {
		assertEquals(30001, cardU.getRightTopTwo().getID());
	}

	@Test
	public void getLeftCenterTest() {
		assertEquals(30000, cardU.getLeftCenter().getID());
	}

	@Test
	public void getMiddleCenterTest() {
		assertEquals(50000, cardU.getMiddleCenter().getID());
	}

	@Test
	public void getRightCenterTest() {
		assertEquals(30001, cardU.getRightCenter().getID());
	}

	@Test
	public void getLeftBelowTwoTest() {
		assertEquals(30000, cardU.getLeftBelowTwo().getID());
	}

	@Test
	public void getRightBelowTwoTest() {
		assertEquals(30001, cardU.getRightBelowTwo().getID());
	}

	@Test
	public void getLeftBelowOneTest() {
		assertEquals(30000, cardU.getLeftBelowOne().getID());		
	}

	@Test
	public void getMiddleBelowTest() {
		assertEquals(50000, cardU.getMiddleBelow().getID());		
	}

	@Test
	public void getRightBelowOneTest() {
		assertEquals(30001, cardU.getRightBelowOne().getID());		
	}
	
}
