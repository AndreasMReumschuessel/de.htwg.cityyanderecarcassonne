package de.htwg.cityyanderecarcassonne.model;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Stock {

	private String filepath = "./CarcassonneCardStock.txt";
	private List<Card> cardStock = new LinkedList<>();
	
	public Stock(String filepath)	{
		this.filepath = filepath;
	}

	public void importCards() throws IOException	{
	    BufferedReader br = new BufferedReader(new FileReader(getFilePath()));
	    String line = br.readLine();
	    
	    while (line != null) {
	    	analyseCardData(line);
	    	line = br.readLine();
	    }
	    br.close();
	}

	public void analyseCardData(String data)	{
		String[] split = data.split(";");
		Region north = new Region(split[0]);
		Region east = new Region(split[1]);
		Region south = new Region(split[2]);
		Region west = new Region(split[3]);
		Region center = new Region(split[4]);
		Card tmpCard = new Card(north, east, south, west, center);
		cardStock.add(tmpCard);
	}
	
	public Card getCardAtStart()	{
		return cardStock.get(0);
	}
	
	public Card getRandomCardFromStock()	{		
		int i = this.getRandomInRange(0, this.sizeOfStock()-1);
		Card x = cardStock.get(i);
		cardStock.remove(x);
		return x;
	}
	
	public int getRandomInRange(int start, int end)	{
		return ThreadLocalRandom.current().nextInt(start, end + 1);
	}
	
	public int sizeOfStock()	{
		return cardStock.size();
	}
	
	public String getFilePath()	{
		return this.filepath;
	}
	
	public void setFilePath(String filepath)	{
		this.filepath = filepath;
	}
}