package de.htwg.cityyanderecarcassonne.model.cards;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import de.htwg.cityyanderecarcassonne.model.IDManager;;

public class CardUTest {
	
	private static CardU cardU;

	@BeforeClass
	public static void setUpBeforClass() throws Exception	{
		IDManager.resetIDCount();
		cardU = new CardU();
	}
	
	@Test
	public void getLeftTopOneTest() {
		assertEquals(30000, cardU.getTopLeft().getID());
	}

	@Test
	public void getMiddleTopTest() {
		assertEquals(50000, cardU.getTopMiddle().getID());
	}

	@Test
	public void getRightTopOneTest() {
		assertEquals(30001, cardU.getTopRight().getID());
	}

	@Test
	public void getLeftTopTwoTest() {
		assertEquals(30000, cardU.getLeftTop().getID());
	}

	@Test
	public void getRightTopTwoTest() {
		assertEquals(30001, cardU.getRightTop().getID());
	}

	@Test
	public void getLeftCenterTest() {
		assertEquals(30000, cardU.getLeftMiddle().getID());
	}

	@Test
	public void getMiddleCenterTest() {
		assertEquals(50000, cardU.getCenterMiddle().getID());
	}

	@Test
	public void getRightCenterTest() {
		assertEquals(30001, cardU.getRightMiddle().getID());
	}

	@Test
	public void getLeftBelowTwoTest() {
		assertEquals(30000, cardU.getLeftBelow().getID());
	}

	@Test
	public void getRightBelowTwoTest() {
		assertEquals(30001, cardU.getRightBelow().getID());
	}

	@Test
	public void getLeftBelowOneTest() {
		assertEquals(30000, cardU.getBelowLeft().getID());		
	}

	@Test
	public void getMiddleBelowTest() {
		assertEquals(50000, cardU.getBelowMiddle().getID());		
	}

	@Test
	public void getRightBelowOneTest() {
		assertEquals(30001, cardU.getBelowRight().getID());		
	}
	
}
