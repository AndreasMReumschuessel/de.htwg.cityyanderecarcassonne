package de.htwg.cityyanderecarcassonne.model.cards;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import de.htwg.cityyanderecarcassonne.model.IDManager;

public class CardBTest {
	
	private static CardB cardB;

	@BeforeClass
	public static void setUpBeforClass() throws Exception	{
		IDManager.resetIDCount();
		cardB = new CardB();
	}
	
	@Test
	public void setUniqueIDsTest() {
		
	}
	
	@Test
	public void genCardGraphTest()	{
	
	}
	
	@Test
	public void getLeftTopOneTest() {
		assertEquals(30000, cardB.getLeftTopOne().getID());
	}

	@Test
	public void getMiddleTopTest() {
		assertEquals(30000, cardB.getMiddleTop().getID());
	}

	@Test
	public void getRightTopOneTest() {
		assertEquals(30000, cardB.getRightTopOne().getID());
	}

	@Test
	public void getLeftTopTwoTest() {
		assertEquals(30000, cardB.getLeftTopTwo().getID());
	}

	@Test
	public void getRightTopTwoTest() {
		assertEquals(30000, cardB.getRightTopTwo().getID());
	}

	@Test
	public void getLeftCenterTest() {
		assertEquals(30000, cardB.getLeftCenter().getID());
	}

	@Test
	public void getMiddleCenterTest() {
		assertEquals(40000, cardB.getMiddleCenter().getID());
	}

	@Test
	public void getRightCenterTest() {
		assertEquals(30000, cardB.getRightCenter().getID());
	}

	@Test
	public void getLeftBelowTwoTest() {
		assertEquals(30000, cardB.getLeftBelowTwo().getID());
	}

	@Test
	public void getRightBelowTwoTest() {
		assertEquals(30000, cardB.getRightBelowTwo().getID());
	}

	@Test
	public void getLeftBelowOneTest() {
		assertEquals(30000, cardB.getLeftBelowOne().getID());		
	}

	@Test
	public void getMiddleBelowTest() {
		assertEquals(30000, cardB.getMiddleBelow().getID());		
	}

	@Test
	public void getRightBelowOneTest() {
		assertEquals(30000, cardB.getRightBelowOne().getID());		
	}

	@Test
	public void getCardGraphTest()	{
		
	}
	
}
