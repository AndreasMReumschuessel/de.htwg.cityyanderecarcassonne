package de.htwg.cityyanderecarcassonne.model;

import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.model.Stock;

public class StockTest {
	private Stock stock;
	
	@Before
	public void setUp() throws Exception {
		stock = new Stock();
	}

	@Test
    public void ImportCardsTest() throws IOException {

	}
		
	@Test
	public void getRandomCardFromStockTest()	{
		stock.getRandomCardFromStock();
	}
	
	@Test
	public void GetRandomInRangeTest()	{
		stock.getRandomInRange(0, stock.getSizeOfStock());
	}
		
	@Test
	public void getSizeOfStockTest()	{
		assertEquals(72,stock.getSizeOfStock());
	}

}