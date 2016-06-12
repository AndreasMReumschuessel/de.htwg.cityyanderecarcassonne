package de.htwg.cityyanderecarcassonne.model;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import de.htwg.cityyanderecarcassonne.model.cards.*;

public class Stock {

	private List<ICard> cardStock;
	
	private Stock()	{
		cardStock = new LinkedList<>();
		this.importCards();
	}

	/**
	 * Should import number of cards of each card type
	 * 
	 */
	public void importCards()	{
		
		cardStock.add(new CardA());
		cardStock.add(new CardA());
		
		cardStock.add(new CardB());
		cardStock.add(new CardB());
		cardStock.add(new CardB());
		cardStock.add(new CardB());
		
		//...
	}
	
	/**
	 * Should be the "take a card" move.
	 * @return random card in range of card left from cardStock
	 */
	public ICard getRandomCardFromStock()	{		
		int i = this.getRandomInRange(0, cardStock.size()-1);
		ICard x = cardStock.get(i);
		cardStock.remove(x);
		return x;
	}
	
	/**
	 * Help funktion to manag the changing size of cardStock and random funktion.
	 * @param start startindex
	 * @param end endindex
	 * @return	index of card
	 */
	public int getRandomInRange(int start, int end)	{
		return ThreadLocalRandom.current().nextInt(start, end + 1);
	}
}