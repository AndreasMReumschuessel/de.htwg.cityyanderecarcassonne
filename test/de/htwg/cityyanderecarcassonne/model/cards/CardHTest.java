package de.htwg.cityyanderecarcassonne.model.cards;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import de.htwg.cityyanderecarcassonne.model.IDManager;

public class CardHTest {
	
	private static CardH cardH;

	@BeforeClass
	public static void setUpBeforClass() throws Exception	{
		IDManager.resetIDManager();
		cardH = new CardH();
	}

	@Test
	public void getLeftTopOneTest() {
		assertEquals(30000, cardH.getTopLeft().getID());
	}

	@Test
	public void getMiddleTopTest() {
		assertEquals(30000, cardH.getTopMiddle().getID());
	}

	@Test
	public void getRightTopOneTest() {
		assertEquals(30000, cardH.getTopRight().getID());
	}

	@Test
	public void getLeftTopTwoTest() {
		assertEquals(10000, cardH.getLeftTop().getID());
	}

	@Test
	public void getRightTopTwoTest() {
		assertEquals(10001, cardH.getRightTop().getID());
	}

	@Test
	public void getLeftCenterTest() {
		assertEquals(10000, cardH.getLeftMiddle().getID());
	}

	@Test
	public void getMiddleCenterTest() {
		assertEquals(30000, cardH.getCenterMiddle().getID());
	}

	@Test
	public void getRightCenterTest() {
		assertEquals(10001, cardH.getRightMiddle().getID());
	}

	@Test
	public void getLeftBelowTwoTest() {
		assertEquals(10000, cardH.getLeftBelow().getID());
	}

	@Test
	public void getRightBelowTwoTest() {
		assertEquals(10001, cardH.getRightBelow().getID());
	}

	@Test
	public void getLeftBelowOneTest() {
		assertEquals(30000, cardH.getBelowLeft().getID());		
	}

	@Test
	public void getMiddleBelowTest() {
		assertEquals(30000, cardH.getBelowMiddle().getID());		
	}

	@Test
	public void getRightBelowOneTest() {
		assertEquals(30000, cardH.getBelowRight().getID());		
	}
	
}
