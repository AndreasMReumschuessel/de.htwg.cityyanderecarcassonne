package de.htwg.cityyanderecarcassonne.model.cards;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class CardLTest {
	
	private static CardL cardL;

	@BeforeClass
	public static void setUpBeforClass() throws Exception	{
		cardL = new CardL();
		System.out.println();
	}
	
	@Test
	public void setUniqueIDsTest() {
		
	}
	
	@Test
	public void genCardGraphTest()	{
	}
	
	@Test
	public void getLeftTopOneTest() {
		assertEquals(30000, cardL.getLeftTopOne().getID());
	}

	@Test
	public void getMiddleTopTest() {
		assertEquals(50000, cardL.getMiddleTop().getID());
	}

	@Test
	public void getRightTopOneTest() {
		assertEquals(30001, cardL.getRightTopOne().getID());
	}

	@Test
	public void getLeftTopTwoTest() {
		assertEquals(30000, cardL.getLeftTopTwo().getID());
	}

	@Test
	public void getRightTopTwoTest() {
		assertEquals(10000, cardL.getRightTopTwo().getID());
	}

	@Test
	public void getLeftCenterTest() {
		assertEquals(50001, cardL.getLeftCenter().getID());
	}

	@Test
	public void getMiddleCenterTest() {
		assertEquals(20000, cardL.getMiddleCenter().getID());
	}

	@Test
	public void getRightCenterTest() {
		assertEquals(10000, cardL.getRightCenter().getID());
	}

	@Test
	public void getLeftBelowTwoTest() {
		assertEquals(30002, cardL.getLeftBelowTwo().getID());
	}

	@Test
	public void getRightBelowTwoTest() {
		assertEquals(10000, cardL.getRightBelowTwo().getID());
	}

	@Test
	public void getLeftBelowOneTest() {
		assertEquals(30002, cardL.getLeftBelowOne().getID());		
	}

	@Test
	public void getMiddleBelowTest() {
		assertEquals(50002, cardL.getMiddleBelow().getID());		
	}

	@Test
	public void getRightBelowOneTest() {
		assertEquals(30001, cardL.getRightBelowOne().getID());		
	}

	@Test
	public void getCardGraphTest()	{
		
	}
	
}
