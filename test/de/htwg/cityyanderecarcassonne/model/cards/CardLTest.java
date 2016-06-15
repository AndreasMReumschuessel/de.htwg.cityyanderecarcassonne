package de.htwg.cityyanderecarcassonne.model.cards;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.model.IDManager;

public class CardLTest {
	
	private static CardL cardL;

	@BeforeClass
	public static void setUpBeforClass() throws Exception	{
		IDManager.resetIDManager();
		cardL = new CardL();
	}
	
	@Test
	public void getLeftTopOneTest() {
		assertEquals(30000, cardL.getTopLeft().getID());
	}

	@Test
	public void getMiddleTopTest() {
		assertEquals(50000, cardL.getTopMiddle().getID());
	}

	@Test
	public void getRightTopOneTest() {
		assertEquals(30001, cardL.getTopRight().getID());
	}

	@Test
	public void getLeftTopTwoTest() {
		assertEquals(30000, cardL.getLeftTop().getID());
	}

	@Test
	public void getRightTopTwoTest() {
		assertEquals(10000, cardL.getRightTop().getID());
	}

	@Test
	public void getLeftCenterTest() {
		assertEquals(50001, cardL.getLeftMiddle().getID());
	}

	@Test
	public void getMiddleCenterTest() {
		assertEquals(20000, cardL.getCenterMiddle().getID());
	}

	@Test
	public void getRightCenterTest() {
		assertEquals(10000, cardL.getRightMiddle().getID());
	}

	@Test
	public void getLeftBelowTwoTest() {
		assertEquals(30002, cardL.getLeftBelow().getID());
	}

	@Test
	public void getRightBelowTwoTest() {
		assertEquals(10000, cardL.getRightBelow().getID());
	}

	@Test
	public void getLeftBelowOneTest() {
		assertEquals(30002, cardL.getBelowLeft().getID());		
	}

	@Test
	public void getMiddleBelowTest() {
		assertEquals(50002, cardL.getBelowMiddle().getID());		
	}

	@Test
	public void getRightBelowOneTest() {
		assertEquals(30001, cardL.getBelowRight().getID());		
	}
	
}
