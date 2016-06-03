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
		Card tmpCard = new Card();
		
		tmpCard.setLeftTopOne(split[0]);	
		tmpCard.setMiddleTop(split[1]);
		tmpCard.setRightTopOne(split[2]);
		
		tmpCard.setLeftTopTwo(split[3]);
		tmpCard.setRightTopTwo(split[4]);
		
		tmpCard.setLeftCenter(split[5]);
		tmpCard.setMiddleCenter(split[6]);
		tmpCard.setRightCenter(split[7]);
		
		tmpCard.setLeftBelowTwo(split[8]);
		tmpCard.setRightBelowTwo(split[9]);
		
		tmpCard.setLeftBelowOne(split[10]);
		tmpCard.setMiddleBelow(split[11]);
		tmpCard.setRightBelowOne(split[12]);
		
		cardStock.add(tmpCard);
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