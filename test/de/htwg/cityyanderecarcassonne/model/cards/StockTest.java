package de.htwg.cityyanderecarcassonne.model.cards;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.model.cards.CardD;

public class StockTest {
	private Stock cardStock;
	private Stock singletonStock = null;
	
	
	@Before
	public void setUp() throws Exception {
		cardStock = Stock.getInstance();
		singletonStock = Stock.getInstance();
	}
	
	@Test
	public void testUnique()	{
		assertTrue(cardStock == singletonStock);
	}

	@Test
    public void ImportCardsTest() throws IOException {

	}
		
	@Test
	public void getRandomCardFromStockTest()	{
		assertNotNull(cardStock.getRandomCardFromStock());
		
		for(int i = 0; i < 72; i++){
			cardStock.getRandomCardFromStock();
		}
		
		assertNull(cardStock.getRandomCardFromStock());
		
	}
	
	@Test
	public void GetRandomInRangeTest()	{
		cardStock.getRandomInRange(0, cardStock.getSizeOfStock());
	}
		
	@Test
	public void getSizeOfStockTest()	{
		assertEquals(72,cardStock.getSizeOfStock());
	}
	
	@Test
	public void getStartCardTest() {
		assertEquals(CardD.class, cardStock.getStartCard().getClass());
	}

}