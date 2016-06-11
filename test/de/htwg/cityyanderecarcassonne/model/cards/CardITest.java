package de.htwg.cityyanderecarcassonne.model.cards;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import de.htwg.cityyanderecarcassonne.model.IDManager;

public class CardITest {
	
	private static CardI cardI;

	@BeforeClass
	public static void setUpBeforClass() throws Exception	{
		IDManager.resetIDCount();
		cardI = new CardI();
	}
	
	@Test
	public void setUniqueIDsTest() {
		
	}
	
	@Test
	public void genCardGraphTest()	{
	
	}
	
	@Test
	public void getLeftTopOneTest() {
		assertEquals(30000, cardI.getLeftTopOne().getID());
	}

	@Test
	public void getMiddleTopTest() {
		assertEquals(30000, cardI.getMiddleTop().getID());
	}

	@Test
	public void getRightTopOneTest() {
		assertEquals(30000, cardI.getRightTopOne().getID());
	}

	@Test
	public void getLeftTopTwoTest() {
		assertEquals(30000, cardI.getLeftTopTwo().getID());
	}

	@Test
	public void getRightTopTwoTest() {
		assertEquals(10000, cardI.getRightTopTwo().getID());
	}

	@Test
	public void getLeftCenterTest() {
		assertEquals(30000, cardI.getLeftCenter().getID());
	}

	@Test
	public void getMiddleCenterTest() {
		assertEquals(30000, cardI.getMiddleCenter().getID());
	}

	@Test
	public void getRightCenterTest() {
		assertEquals(10000, cardI.getRightCenter().getID());
	}

	@Test
	public void getLeftBelowTwoTest() {
		assertEquals(30000, cardI.getLeftBelowTwo().getID());
	}

	@Test
	public void getRightBelowTwoTest() {
		assertEquals(10000, cardI.getRightBelowTwo().getID());
	}

	@Test
	public void getLeftBelowOneTest() {
		assertEquals(10001, cardI.getLeftBelowOne().getID());		
	}

	@Test
	public void getMiddleBelowTest() {
		assertEquals(10001, cardI.getMiddleBelow().getID());		
	}

	@Test
	public void getRightBelowOneTest() {
		assertEquals(10001, cardI.getRightBelowOne().getID());		
	}

	@Test
	public void getCardGraphTest()	{
		
	}
	
}
