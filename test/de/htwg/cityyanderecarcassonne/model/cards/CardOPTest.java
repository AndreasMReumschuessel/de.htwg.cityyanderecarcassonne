package de.htwg.cityyanderecarcassonne.model.cards;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import de.htwg.cityyanderecarcassonne.model.IDManager;

public class CardOPTest {
	
	private static CardOP cardOP;

	@BeforeClass
	public static void setUpBeforClass() throws Exception	{
		IDManager.resetIDCount();
		cardOP = new CardOP();
	}
	
	@Test
	public void setUniqueIDsTest() {
		
	}
	
	@Test
	public void genCardGraphTest()	{
	
	}
	
	@Test
	public void getLeftTopOneTest() {
		assertEquals(10000, cardOP.getLeftTopOne().getID());
	}

	@Test
	public void getMiddleTopTest() {
		assertEquals(10000, cardOP.getMiddleTop().getID());
	}

	@Test
	public void getRightTopOneTest() {
		assertEquals(10000, cardOP.getRightTopOne().getID());
	}

	@Test
	public void getLeftTopTwoTest() {
		assertEquals(10000, cardOP.getLeftTopTwo().getID());
	}

	@Test
	public void getRightTopTwoTest() {
		assertEquals(30000, cardOP.getRightTopTwo().getID());
	}

	@Test
	public void getLeftCenterTest() {
		assertEquals(10000, cardOP.getLeftCenter().getID());
	}

	@Test
	public void getMiddleCenterTest() {
		assertEquals(50000, cardOP.getMiddleCenter().getID());
	}

	@Test
	public void getRightCenterTest() {
		assertEquals(50000, cardOP.getRightCenter().getID());
	}

	@Test
	public void getLeftBelowTwoTest() {
		assertEquals(10000, cardOP.getLeftBelowTwo().getID());
	}

	@Test
	public void getRightBelowTwoTest() {
		assertEquals(30000, cardOP.getRightBelowTwo().getID());
	}

	@Test
	public void getLeftBelowOneTest() {
		assertEquals(30000, cardOP.getLeftBelowOne().getID());		
	}

	@Test
	public void getMiddleBelowTest() {
		assertEquals(50000, cardOP.getMiddleBelow().getID());		
	}

	@Test
	public void getRightBelowOneTest() {
		assertEquals(30000, cardOP.getRightBelowOne().getID());		
	}

	@Test
	public void getCardGraphTest()	{
		
	}
	
}
