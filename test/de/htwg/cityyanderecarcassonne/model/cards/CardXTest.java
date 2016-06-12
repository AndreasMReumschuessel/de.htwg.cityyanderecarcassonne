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
		assertEquals(30000, cardX.getTopLeft().getID());
	}

	@Test
	public void getMiddleTopTest() {
		assertEquals(50000, cardX.getTopMiddle().getID());
	}

	@Test
	public void getRightTopOneTest() {
		assertEquals(30001, cardX.getTopRight().getID());
	}

	@Test
	public void getLeftTopTwoTest() {
		assertEquals(30000, cardX.getLeftTop().getID());
	}

	@Test
	public void getRightTopTwoTest() {
		assertEquals(30001, cardX.getRightTop().getID());
	}

	@Test
	public void getLeftCenterTest() {
		assertEquals(50001, cardX.getLeftMiddle().getID());
	}

	@Test
	public void getMiddleCenterTest() {
		assertEquals(20000, cardX.getCenterMiddle().getID());
	}

	@Test
	public void getRightCenterTest() {
		assertEquals(50002, cardX.getRightMiddle().getID());
	}

	@Test
	public void getLeftBelowTwoTest() {
		assertEquals(30002, cardX.getLeftBelow().getID());
	}

	@Test
	public void getRightBelowTwoTest() {
		assertEquals(30003, cardX.getRightBelow().getID());
	}

	@Test
	public void getLeftBelowOneTest() {
		assertEquals(30002, cardX.getBelowLeft().getID());		
	}

	@Test
	public void getMiddleBelowTest() {
		assertEquals(50003, cardX.getBelowMiddle().getID());		
	}

	@Test
	public void getRightBelowOneTest() {
		assertEquals(30003, cardX.getBelowRight().getID());		
	}
	
}
