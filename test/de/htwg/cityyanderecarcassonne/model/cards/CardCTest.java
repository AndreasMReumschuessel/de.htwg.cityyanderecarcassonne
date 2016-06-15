package de.htwg.cityyanderecarcassonne.model.cards;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import de.htwg.cityyanderecarcassonne.model.IDManager;

public class CardCTest {
	
	private static CardC cardC;

	@BeforeClass
	public static void setUpBeforClass() throws Exception	{
		IDManager.resetIDManager();
		cardC = new CardC();
	}

	@Test
	public void getLeftTopOneTest() {
		assertEquals(10000, cardC.getTopLeft().getID());
	}

	@Test
	public void getMiddleTopTest() {
		assertEquals(10000, cardC.getTopMiddle().getID());
	}

	@Test
	public void getRightTopOneTest() {
		assertEquals(10000, cardC.getTopRight().getID());
	}

	@Test
	public void getLeftTopTwoTest() {
		assertEquals(10000, cardC.getLeftTop().getID());
	}

	@Test
	public void getRightTopTwoTest() {
		assertEquals(10000, cardC.getRightTop().getID());
	}

	@Test
	public void getLeftCenterTest() {
		assertEquals(10000, cardC.getLeftMiddle().getID());
	}

	@Test
	public void getMiddleCenterTest() {
		assertEquals(10000, cardC.getCenterMiddle().getID());
	}

	@Test
	public void getRightCenterTest() {
		assertEquals(10000, cardC.getRightMiddle().getID());
	}

	@Test
	public void getLeftBelowTwoTest() {
		assertEquals(10000, cardC.getLeftBelow().getID());
	}

	@Test
	public void getRightBelowTwoTest() {
		assertEquals(10000, cardC.getRightBelow().getID());
	}

	@Test
	public void getLeftBelowOneTest() {
		assertEquals(10000, cardC.getBelowLeft().getID());		
	}

	@Test
	public void getMiddleBelowTest() {
		assertEquals(10000, cardC.getBelowMiddle().getID());		
	}

	@Test
	public void getRightBelowOneTest() {
		assertEquals(10000, cardC.getBelowRight().getID());		
	}
	
}
