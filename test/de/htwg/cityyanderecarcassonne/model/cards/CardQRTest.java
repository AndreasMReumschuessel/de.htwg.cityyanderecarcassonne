package de.htwg.cityyanderecarcassonne.model.cards;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import de.htwg.cityyanderecarcassonne.model.IDManager;;

public class CardQRTest {
	
	private static AbstractCardCQRST cardQR;

	@BeforeClass
	public static void setUpBeforClass() throws Exception	{
		IDManager.resetIDManager();
		cardQR = new CardQR();
	}

	@Test
	public void getLeftTopOneTest() {
		assertEquals(10000, cardQR.getTopLeft().getID());
	}

	@Test
	public void getMiddleTopTest() {
		assertEquals(10000, cardQR.getTopMiddle().getID());
	}

	@Test
	public void getRightTopOneTest() {
		assertEquals(10000, cardQR.getTopRight().getID());
	}

	@Test
	public void getLeftTopTwoTest() {
		assertEquals(10000, cardQR.getLeftTop().getID());
	}

	@Test
	public void getRightTopTwoTest() {
		assertEquals(10000, cardQR.getRightTop().getID());
	}

	@Test
	public void getLeftCenterTest() {
		assertEquals(10000, cardQR.getLeftMiddle().getID());
	}

	@Test
	public void getMiddleCenterTest() {
		assertEquals(10000, cardQR.getCenterMiddle().getID());
	}

	@Test
	public void getRightCenterTest() {
		assertEquals(10000, cardQR.getRightMiddle().getID());
	}

	@Test
	public void getLeftBelowTwoTest() {
		assertEquals(10000, cardQR.getLeftBelow().getID());
	}

	@Test
	public void getRightBelowTwoTest() {
		assertEquals(10000, cardQR.getRightBelow().getID());
	}

	@Test
	public void getLeftBelowOneTest() {
		assertEquals(30000, cardQR.getBelowLeft().getID());		
	}

	@Test
	public void getMiddleBelowTest() {
		assertEquals(30000, cardQR.getBelowMiddle().getID());		
	}

	@Test
	public void getRightBelowOneTest() {
		assertEquals(30000, cardQR.getBelowRight().getID());		
	}
	
}
