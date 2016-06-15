package de.htwg.cityyanderecarcassonne.model.cards;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.model.IDManager;

public class CardATest {
	
	private static CardA cardA;

	@BeforeClass
	public static void setUpBeforClass() throws Exception	{
		IDManager.resetIDManager();
		cardA = new CardA();
	}
	
	@Test
	public void getLeftTopOneTest() {
		assertEquals(30000, cardA.getTopLeft().getID());
	}

	@Test
	public void getMiddleTopTest() {
		assertEquals(30000, cardA.getTopMiddle().getID());
	}

	@Test
	public void getRightTopOneTest() {
		assertEquals(30000, cardA.getTopRight().getID());
	}

	@Test
	public void getLeftTopTwoTest() {
		assertEquals(30000, cardA.getLeftTop().getID());
	}

	@Test
	public void getRightTopTwoTest() {
		assertEquals(30000, cardA.getRightTop().getID());
	}

	@Test
	public void getLeftCenterTest() {
		assertEquals(30000, cardA.getLeftMiddle().getID());
	}

	@Test
	public void getMiddleCenterTest() {
		assertEquals(40000, cardA.getCenterMiddle().getID());
	}

	@Test
	public void getRightCenterTest() {
		assertEquals(30000, cardA.getRightMiddle().getID());
	}

	@Test
	public void getLeftBelowTwoTest() {
		assertEquals(30000, cardA.getLeftBelow().getID());
	}

	@Test
	public void getRightBelowTwoTest() {
		assertEquals(30000, cardA.getRightBelow().getID());
	}

	@Test
	public void getLeftBelowOneTest() {
		assertEquals(30000, cardA.getBelowLeft().getID());		
	}

	@Test
	public void getMiddleBelowTest() {
		assertEquals(50000, cardA.getBelowMiddle().getID());		
	}

	@Test
	public void getRightBelowOneTest() {
		assertEquals(30000, cardA.getBelowRight().getID());		
	}
}
