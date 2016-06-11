package de.htwg.cityyanderecarcassonne.model.cards;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import de.htwg.cityyanderecarcassonne.model.IDManager;;

public class CardQRTest {
	
	private static CardQR cardQR;

	@BeforeClass
	public static void setUpBeforClass() throws Exception	{
		IDManager.resetIDCount();
		cardQR = new CardQR();
	}
	
	@Test
	public void setUniqueIDsTest() {
		
	}
	
	@Test
	public void genCardGraphTest()	{
	
	}
	
	@Test
	public void getLeftTopOneTest() {
		assertEquals(10000, cardQR.getLeftTopOne().getID());
	}

	@Test
	public void getMiddleTopTest() {
		assertEquals(10000, cardQR.getMiddleTop().getID());
	}

	@Test
	public void getRightTopOneTest() {
		assertEquals(10000, cardQR.getRightTopOne().getID());
	}

	@Test
	public void getLeftTopTwoTest() {
		assertEquals(10000, cardQR.getLeftTopTwo().getID());
	}

	@Test
	public void getRightTopTwoTest() {
		assertEquals(10000, cardQR.getRightTopTwo().getID());
	}

	@Test
	public void getLeftCenterTest() {
		assertEquals(10000, cardQR.getLeftCenter().getID());
	}

	@Test
	public void getMiddleCenterTest() {
		assertEquals(10000, cardQR.getMiddleCenter().getID());
	}

	@Test
	public void getRightCenterTest() {
		assertEquals(10000, cardQR.getRightCenter().getID());
	}

	@Test
	public void getLeftBelowTwoTest() {
		assertEquals(10000, cardQR.getLeftBelowTwo().getID());
	}

	@Test
	public void getRightBelowTwoTest() {
		assertEquals(30000, cardQR.getRightBelowTwo().getID());
	}

	@Test
	public void getLeftBelowOneTest() {
		assertEquals(30000, cardQR.getLeftBelowOne().getID());		
	}

	@Test
	public void getMiddleBelowTest() {
		assertEquals(30000, cardQR.getMiddleBelow().getID());		
	}

	@Test
	public void getRightBelowOneTest() {
		assertEquals(30000, cardQR.getRightBelowOne().getID());		
	}

	@Test
	public void getCardGraphTest()	{
		
	}
	
}
