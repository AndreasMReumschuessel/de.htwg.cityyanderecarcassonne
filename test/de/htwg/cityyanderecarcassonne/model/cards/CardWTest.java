package de.htwg.cityyanderecarcassonne.model.cards;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import de.htwg.cityyanderecarcassonne.model.IDManager;;

public class CardWTest {
	
	private static CardW cardW;

	@BeforeClass
	public static void setUpBeforClass() throws Exception	{
		IDManager.resetIDManager();
		cardW = new CardW();
	}

	@Test
	public void getLeftTopOneTest() {
		assertEquals(30000, cardW.getTopLeft().getID());
	}

	@Test
	public void getMiddleTopTest() {
		assertEquals(30000, cardW.getTopMiddle().getID());
	}

	@Test
	public void getRightTopOneTest() {
		assertEquals(30000, cardW.getTopRight().getID());
	}

	@Test
	public void getLeftTopTwoTest() {
		assertEquals(30000, cardW.getLeftTop().getID());
	}

	@Test
	public void getRightTopTwoTest() {
		assertEquals(30000, cardW.getRightTop().getID());
	}

	@Test
	public void getLeftCenterTest() {
		assertEquals(50000, cardW.getLeftMiddle().getID());
	}

	@Test
	public void getMiddleCenterTest() {
		assertEquals(20000, cardW.getCenterMiddle().getID());
	}

	@Test
	public void getRightCenterTest() {
		assertEquals(50001, cardW.getRightMiddle().getID());
	}

	@Test
	public void getLeftBelowTwoTest() {
		assertEquals(30001, cardW.getLeftBelow().getID());
	}

	@Test
	public void getRightBelowTwoTest() {
		assertEquals(30002, cardW.getRightBelow().getID());
	}

	@Test
	public void getLeftBelowOneTest() {
		assertEquals(30001, cardW.getBelowLeft().getID());		
	}

	@Test
	public void getMiddleBelowTest() {
		assertEquals(50002, cardW.getBelowMiddle().getID());		
	}

	@Test
	public void getRightBelowOneTest() {
		assertEquals(30002, cardW.getBelowRight().getID());		
	}
	
}
