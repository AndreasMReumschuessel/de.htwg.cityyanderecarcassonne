package de.htwg.cityyanderecarcassonne.module;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class StockTest {
	
	private String filepath;
	private Stock stock;
	
	@Before
	public void setUp() throws Exception {
		stock = new Stock("/home/henning/workspace/de.htwg.cityyanderecarcassonne/CarcassonneCardStock.txt");
	}

	@Test
    public void testImportCards() throws IOException {
		stock.importCards();
		assertEquals(4, stock.sizeOfStock());
	}

	@Test
	public void testAnalyseCardData()	{
		String line = "street;building;lawn;street;lawn"; 
		stock.analyseCardData(line);
		assertEquals(1,stock.sizeOfStock());
	}
		
	@Test
	public void testGetRandomCardFromStock()	{
		String line = "street;building;lawn;street;lawn"; 
		stock.analyseCardData(line);
		Card card = stock.getRandomCardFromStock();
		assertEquals("street", card.getRegionNorth().getType());
	}
	
	@Test
	public void testGetRandomInRange()	{
		int i = stock.getRandomInRange(0, stock.sizeOfStock());
		assertEquals(i, stock.sizeOfStock());
	}
		
	@Test
	public void testSizeOfStock()	{
		String line = "street;building;lawn;street;lawn"; 
		stock.analyseCardData(line);
		assertEquals(1,stock.sizeOfStock());
	}
	
	@Test
	public void testGetFilePath()	{
		filepath = "test.txt";
		stock.setFilePath("test.txt");
		assertEquals("test.txt", stock.getFilePath());
	}
	
	@Test
	public void testSetFilePath()	{
		filepath = "test.txt";
		stock.setFilePath(filepath);
		assertEquals("test.txt", stock.getFilePath());
	}
}
