package de.htwg.cityyanderecarcassonne.model.cards;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import de.htwg.cityyanderecarcassonne.model.IDManager;

public class CardJTest {
	
	private static CardJ cardJ;

	@BeforeClass
	public static void setUpBeforClass() throws Exception	{
		IDManager.resetIDCount();
		cardJ = new CardJ();
	}
	
	@Test
	public void getLeftTopOneTest() {
		assertEquals(10000, cardJ.getTopLeft().getID());
	}

	@Test
	public void getMiddleTopTest() {
		assertEquals(10000, cardJ.getTopMiddle().getID());
	}

	@Test
	public void getRightTopOneTest() {
		assertEquals(10000, cardJ.getTopRight().getID());
	}

	@Test
	public void getLeftTopTwoTest() {
		assertEquals(30000, cardJ.getLeftTop().getID());
	}

	@Test
	public void getRightTopTwoTest() {
		assertEquals(30000, cardJ.getRightTop().getID());
	}

	@Test
	public void getLeftCenterTest() {
		assertEquals(30000, cardJ.getLeftMiddle().getID());
	}

	@Test
	public void getMiddleCenterTest() {
		assertEquals(50000, cardJ.getCenterMiddle().getID());
	}

	@Test
	public void getRightCenterTest() {
		assertEquals(50000, cardJ.getRightMiddle().getID());
	}

	@Test
	public void getLeftBelowTwoTest() {
		assertEquals(30000, cardJ.getLeftBelow().getID());
	}

	@Test
	public void getRightBelowTwoTest() {
		assertEquals(30001, cardJ.getRightBelow().getID());
	}

	@Test
	public void getLeftBelowOneTest() {
		assertEquals(30000, cardJ.getBelowLeft().getID());		
	}

	@Test
	public void getMiddleBelowTest() {
		assertEquals(50000, cardJ.getBelowMiddle().getID());		
	}

	@Test
	public void getRightBelowOneTest() {
		assertEquals(30001, cardJ.getBelowRight().getID());		
	}
	
}
