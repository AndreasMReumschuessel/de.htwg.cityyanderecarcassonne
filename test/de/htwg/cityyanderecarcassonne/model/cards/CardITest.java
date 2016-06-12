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
	public void getLeftTopOneTest() {
		assertEquals(30000, cardI.getTopLeft().getID());
	}

	@Test
	public void getMiddleTopTest() {
		assertEquals(30000, cardI.getTopMiddle().getID());
	}

	@Test
	public void getRightTopOneTest() {
		assertEquals(30000, cardI.getTopRight().getID());
	}

	@Test
	public void getLeftTopTwoTest() {
		assertEquals(30000, cardI.getLeftTop().getID());
	}

	@Test
	public void getRightTopTwoTest() {
		assertEquals(10000, cardI.getRightTop().getID());
	}

	@Test
	public void getLeftCenterTest() {
		assertEquals(30000, cardI.getLeftMiddle().getID());
	}

	@Test
	public void getMiddleCenterTest() {
		assertEquals(30000, cardI.getCenterMiddle().getID());
	}

	@Test
	public void getRightCenterTest() {
		assertEquals(10000, cardI.getRightMiddle().getID());
	}

	@Test
	public void getLeftBelowTwoTest() {
		assertEquals(30000, cardI.getLeftBelow().getID());
	}

	@Test
	public void getRightBelowTwoTest() {
		assertEquals(10000, cardI.getRightBelow().getID());
	}

	@Test
	public void getLeftBelowOneTest() {
		assertEquals(10001, cardI.getBelowLeft().getID());		
	}

	@Test
	public void getMiddleBelowTest() {
		assertEquals(10001, cardI.getBelowMiddle().getID());		
	}

	@Test
	public void getRightBelowOneTest() {
		assertEquals(10001, cardI.getBelowRight().getID());		
	}
	
}
