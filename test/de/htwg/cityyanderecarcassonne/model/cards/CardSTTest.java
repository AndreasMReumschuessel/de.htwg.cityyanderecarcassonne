package de.htwg.cityyanderecarcassonne.model.cards;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import de.htwg.cityyanderecarcassonne.model.IDManager;;

public class CardSTTest {
	
	private static CardST cardST;

	@BeforeClass
	public static void setUpBeforClass() throws Exception	{
		IDManager.resetIDManager();
		cardST = new CardST();
	}

	@Test
	public void getLeftTopOneTest() {
		assertEquals(10000, cardST.getTopLeft().getID());
	}

	@Test
	public void getMiddleTopTest() {
		assertEquals(10000, cardST.getTopMiddle().getID());
	}

	@Test
	public void getRightTopOneTest() {
		assertEquals(10000, cardST.getTopRight().getID());
	}

	@Test
	public void getLeftTopTwoTest() {
		assertEquals(10000, cardST.getLeftTop().getID());
	}

	@Test
	public void getRightTopTwoTest() {
		assertEquals(10000, cardST.getRightTop().getID());
	}

	@Test
	public void getLeftCenterTest() {
		assertEquals(10000, cardST.getLeftMiddle().getID());
	}

	@Test
	public void getMiddleCenterTest() {
		assertEquals(10000, cardST.getCenterMiddle().getID());
	}

	@Test
	public void getRightCenterTest() {
		assertEquals(10000, cardST.getRightMiddle().getID());
	}

	@Test
	public void getLeftBelowTwoTest() {
		assertEquals(10000, cardST.getLeftBelow().getID());
	}

	@Test
	public void getRightBelowTwoTest() {
		assertEquals(10000, cardST.getRightBelow().getID());
	}

	@Test
	public void getLeftBelowOneTest() {
		assertEquals(30000, cardST.getBelowLeft().getID());		
	}

	@Test
	public void getMiddleBelowTest() {
		assertEquals(50000, cardST.getBelowMiddle().getID());		
	}

	@Test
	public void getRightBelowOneTest() {
		assertEquals(30001, cardST.getBelowRight().getID());		
	}
	
}
