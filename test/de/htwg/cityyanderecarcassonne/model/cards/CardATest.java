package de.htwg.cityyanderecarcassonne.model.cards;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import de.htwg.cityyanderecarcassonne.model.IDManager;

public class CardATest {
	
	private static CardA cardA;

	@BeforeClass
	public static void setUpBeforClass() throws Exception	{
		IDManager.resetIDCount();
		cardA = new CardA();
	}
	
	@Test
	public void setUniqueIDsTest() {
		
	}
	
	@Test
	public void genCardGraphTest()	{
	
	}
	
	@Test
	public void getLeftTopOneTest() {
		assertEquals(30000, cardA.getLeftTopOne().getID());
	}

	@Test
	public void getMiddleTopTest() {
		assertEquals(30000, cardA.getMiddleTop().getID());
	}

	@Test
	public void getRightTopOneTest() {
		assertEquals(30000, cardA.getRightTopOne().getID());
	}

	@Test
	public void getLeftTopTwoTest() {
		assertEquals(30000, cardA.getLeftTopTwo().getID());
	}

	@Test
	public void getRightTopTwoTest() {
		assertEquals(30000, cardA.getRightTopTwo().getID());
	}

	@Test
	public void getLeftCenterTest() {
		assertEquals(30000, cardA.getLeftCenter().getID());
	}

	@Test
	public void getMiddleCenterTest() {
		assertEquals(40000, cardA.getMiddleCenter().getID());
	}

	@Test
	public void getRightCenterTest() {
		assertEquals(30000, cardA.getRightCenter().getID());
	}

	@Test
	public void getLeftBelowTwoTest() {
		assertEquals(30000, cardA.getLeftBelowTwo().getID());
	}

	@Test
	public void getRightBelowTwoTest() {
		assertEquals(30000, cardA.getRightBelowTwo().getID());
	}

	@Test
	public void getLeftBelowOneTest() {
		assertEquals(30000, cardA.getLeftBelowOne().getID());		
	}

	@Test
	public void getMiddleBelowTest() {
		assertEquals(50000, cardA.getMiddleBelow().getID());		
	}

	@Test
	public void getRightBelowOneTest() {
		assertEquals(30000, cardA.getRightBelowOne().getID());		
	}

	@Test
	public void getCardGraphTest()	{
		
	}
	
}
