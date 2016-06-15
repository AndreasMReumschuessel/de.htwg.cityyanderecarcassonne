package de.htwg.cityyanderecarcassonne.model.cards;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import de.htwg.cityyanderecarcassonne.model.IDManager;;

public class CardKTest {
	
	private static CardK cardK;

	@BeforeClass
	public static void setUpBeforClass() throws Exception	{
		IDManager.resetIDManager();
		cardK = new CardK();
	}
	
	@Test
	public void getLeftTopOneTest() {
		assertEquals(30000, cardK.getTopLeft().getID());
	}

	@Test
	public void getMiddleTopTest() {
		assertEquals(50000, cardK.getTopMiddle().getID());
	}

	@Test
	public void getRightTopOneTest() {
		assertEquals(30001, cardK.getTopRight().getID());
	}

	@Test
	public void getLeftTopTwoTest() {
		assertEquals(30000, cardK.getLeftTop().getID());
	}

	@Test
	public void getRightTopTwoTest() {
		assertEquals(10000, cardK.getRightTop().getID());
	}

	@Test
	public void getLeftCenterTest() {
		assertEquals(50000, cardK.getLeftMiddle().getID());
	}

	@Test
	public void getMiddleCenterTest() {
		assertEquals(50000, cardK.getCenterMiddle().getID());
	}

	@Test
	public void getRightCenterTest() {
		assertEquals(10000, cardK.getRightMiddle().getID());
	}

	@Test
	public void getLeftBelowTwoTest() {
		assertEquals(30001, cardK.getLeftBelow().getID());
	}

	@Test
	public void getRightBelowTwoTest() {
		assertEquals(10000, cardK.getRightBelow().getID());
	}

	@Test
	public void getLeftBelowOneTest() {
		assertEquals(30001, cardK.getBelowLeft().getID());		
	}

	@Test
	public void getMiddleBelowTest() {
		assertEquals(30001, cardK.getBelowMiddle().getID());		
	}

	@Test
	public void getRightBelowOneTest() {
		assertEquals(30001, cardK.getBelowRight().getID());		
	}
	
}
