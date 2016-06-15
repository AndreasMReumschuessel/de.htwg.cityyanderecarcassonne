package de.htwg.cityyanderecarcassonne.model.cards;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import de.htwg.cityyanderecarcassonne.model.IDManager;;

public class CardMNTest {
	
	private static CardMN cardMN;

	@BeforeClass
	public static void setUpBeforClass() throws Exception	{
		IDManager.resetIDManager();
		cardMN = new CardMN();
	}
	
	@Test
	public void getLeftTopOneTest() {
		assertEquals(10000, cardMN.getTopLeft().getID());
	}

	@Test
	public void getMiddleTopTest() {
		assertEquals(10000, cardMN.getTopMiddle().getID());
	}

	@Test
	public void getRightTopOneTest() {
		assertEquals(10000, cardMN.getTopRight().getID());
	}

	@Test
	public void getLeftTopTwoTest() {
		assertEquals(10000, cardMN.getLeftTop().getID());
	}

	@Test
	public void getRightTopTwoTest() {
		assertEquals(30000, cardMN.getRightTop().getID());
	}

	@Test
	public void getLeftCenterTest() {
		assertEquals(10000, cardMN.getLeftMiddle().getID());
	}

	@Test
	public void getMiddleCenterTest() {
		assertEquals(30000, cardMN.getCenterMiddle().getID());
	}

	@Test
	public void getRightCenterTest() {
		assertEquals(30000, cardMN.getRightMiddle().getID());
	}

	@Test
	public void getLeftBelowTwoTest() {
		assertEquals(10000, cardMN.getLeftBelow().getID());
	}

	@Test
	public void getRightBelowTwoTest() {
		assertEquals(30000, cardMN.getRightBelow().getID());
	}

	@Test
	public void getLeftBelowOneTest() {
		assertEquals(30000, cardMN.getBelowLeft().getID());		
	}

	@Test
	public void getMiddleBelowTest() {
		assertEquals(30000, cardMN.getBelowMiddle().getID());		
	}

	@Test
	public void getRightBelowOneTest() {
		assertEquals(30000, cardMN.getBelowRight().getID());		
	}
	
}
