package de.htwg.cityyanderecarcassonne.model.cards;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import de.htwg.cityyanderecarcassonne.model.IDManager;

public class CardCTest {
	
	private static CardC cardC;

	@BeforeClass
	public static void setUpBeforClass() throws Exception	{
		IDManager.resetIDCount();
		cardC = new CardC();
	}
	
	@Test
	public void setUniqueIDsTest() {
		
	}
	
	@Test
	public void genCardGraphTest()	{
	
	}
	
	@Test
	public void getLeftTopOneTest() {
		assertEquals(10000, cardC.getLeftTopOne().getID());
	}

	@Test
	public void getMiddleTopTest() {
		assertEquals(10000, cardC.getMiddleTop().getID());
	}

	@Test
	public void getRightTopOneTest() {
		assertEquals(10000, cardC.getRightTopOne().getID());
	}

	@Test
	public void getLeftTopTwoTest() {
		assertEquals(10000, cardC.getLeftTopTwo().getID());
	}

	@Test
	public void getRightTopTwoTest() {
		assertEquals(10000, cardC.getRightTopTwo().getID());
	}

	@Test
	public void getLeftCenterTest() {
		assertEquals(10000, cardC.getLeftCenter().getID());
	}

	@Test
	public void getMiddleCenterTest() {
		assertEquals(10000, cardC.getMiddleCenter().getID());
	}

	@Test
	public void getRightCenterTest() {
		assertEquals(10000, cardC.getRightCenter().getID());
	}

	@Test
	public void getLeftBelowTwoTest() {
		assertEquals(10000, cardC.getLeftBelowTwo().getID());
	}

	@Test
	public void getRightBelowTwoTest() {
		assertEquals(10000, cardC.getRightBelowTwo().getID());
	}

	@Test
	public void getLeftBelowOneTest() {
		assertEquals(10000, cardC.getLeftBelowOne().getID());		
	}

	@Test
	public void getMiddleBelowTest() {
		assertEquals(10000, cardC.getMiddleBelow().getID());		
	}

	@Test
	public void getRightBelowOneTest() {
		assertEquals(10000, cardC.getRightBelowOne().getID());		
	}

	@Test
	public void getCardGraphTest()	{
		
	}
	
}
