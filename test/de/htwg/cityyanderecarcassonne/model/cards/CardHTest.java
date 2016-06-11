package de.htwg.cityyanderecarcassonne.model.cards;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import de.htwg.cityyanderecarcassonne.model.IDManager;

public class CardHTest {
	
	private static CardH cardH;

	@BeforeClass
	public static void setUpBeforClass() throws Exception	{
		IDManager.resetIDCount();
		cardH = new CardH();
	}
	
	@Test
	public void setUniqueIDsTest() {
		
	}
	
	@Test
	public void genCardGraphTest()	{
	
	}
	
	@Test
	public void getLeftTopOneTest() {
		assertEquals(30000, cardH.getLeftTopOne().getID());
	}

	@Test
	public void getMiddleTopTest() {
		assertEquals(30000, cardH.getMiddleTop().getID());
	}

	@Test
	public void getRightTopOneTest() {
		assertEquals(30000, cardH.getRightTopOne().getID());
	}

	@Test
	public void getLeftTopTwoTest() {
		assertEquals(10000, cardH.getLeftTopTwo().getID());
	}

	@Test
	public void getRightTopTwoTest() {
		assertEquals(10001, cardH.getRightTopTwo().getID());
	}

	@Test
	public void getLeftCenterTest() {
		assertEquals(10000, cardH.getLeftCenter().getID());
	}

	@Test
	public void getMiddleCenterTest() {
		assertEquals(30000, cardH.getMiddleCenter().getID());
	}

	@Test
	public void getRightCenterTest() {
		assertEquals(10001, cardH.getRightCenter().getID());
	}

	@Test
	public void getLeftBelowTwoTest() {
		assertEquals(10000, cardH.getLeftBelowTwo().getID());
	}

	@Test
	public void getRightBelowTwoTest() {
		assertEquals(10001, cardH.getRightBelowTwo().getID());
	}

	@Test
	public void getLeftBelowOneTest() {
		assertEquals(30000, cardH.getLeftBelowOne().getID());		
	}

	@Test
	public void getMiddleBelowTest() {
		assertEquals(30000, cardH.getMiddleBelow().getID());		
	}

	@Test
	public void getRightBelowOneTest() {
		assertEquals(30000, cardH.getRightBelowOne().getID());		
	}

	@Test
	public void getCardGraphTest()	{
		
	}
	
}
