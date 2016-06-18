package de.htwg.cityyanderecarcassonne.model.cards;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.cards.*;

public class Stock {

	List<ICard> cardStock;
	int cardCountA;
	int cardCountB;
	int cardCountC;
	int cardCountD;
	int cardCountE;
	int cardCountFG;
	int cardCountH;
	int cardCountI;
	int cardCountJ;
	int cardCountK;
	int cardCountL;
	int cardCountMN;
	int cardCountOP;
	int cardCountQR;
	int cardCountST;
	int cardCountU;
	int cardCountV;
	int cardCountW;
	int cardCountX;
	
	private static Stock instance = null;
	
	protected Stock()	{
		cardStock = new LinkedList<>();
		cardCountA = 2;
		cardCountB = 4;
		cardCountC = 1;
		cardCountD = 4;
		cardCountE = 5;
		cardCountFG = 3;
		cardCountH = 3;
		
		cardCountI = 2;
		cardCountJ = 3;
		cardCountK = 3;
		cardCountL = 3;
		cardCountMN = 5;
		cardCountOP = 5;
		cardCountQR = 4;
		cardCountST = 3;
		cardCountU = 8;
		cardCountV = 9;
		cardCountW = 4;
		cardCountX = 1;
		this.importCards();
	}
	
	public static Stock getInstance()	{
		if(instance == null)	{
			instance = new Stock();
		}
		return instance;
	}

	/**
	 * Should import number of cards of each card type
	 * 
	 */
	public void importCards()	{
		
		for(int i = 0; i < cardCountA; i++)	{
			cardStock.add(new CardA());
		}
		
		for(int i = 0; i < cardCountB; i++)	{
			cardStock.add(new CardB());
		}
		
		for(int i = 0; i < cardCountC; i++)	{
			cardStock.add(new CardC());
		}
		
		for(int i = 0; i < cardCountD; i++)	{
			cardStock.add(new CardD());
		}
		
		for(int i = 0; i < cardCountE; i++)	{
			cardStock.add(new CardE());
		}
		
		for(int i = 0; i < cardCountFG; i++)	{
			cardStock.add(new CardFG());
		}
		
		for(int i = 0; i < cardCountH; i++)	{
			cardStock.add(new CardH());
		}
		
		for(int i = 0; i < cardCountI; i++)	{
			cardStock.add(new CardI());
		}
		
		for(int i = 0; i < cardCountJ; i++)	{
			cardStock.add(new CardJ());
		}
		
		for(int i = 0; i < cardCountK; i++)	{
			cardStock.add(new CardK());
		}
		
		for(int i = 0; i < cardCountL; i++)	{
			cardStock.add(new CardL());
		}
		
		for(int i = 0; i < cardCountMN; i++)	{
			cardStock.add(new CardMN());
		}
		
		for(int i = 0; i < cardCountOP; i++)	{
			cardStock.add(new CardOP());
		}
		
		for(int i = 0; i < cardCountQR; i++)	{
			cardStock.add(new CardQR());
		}
		
		for(int i = 0; i < cardCountST; i++)	{
			cardStock.add(new CardST());
		}
		
		for(int i = 0; i < cardCountU; i++)	{
			cardStock.add(new CardU());
		}
		
		for(int i = 0; i < cardCountV; i++)	{
			cardStock.add(new CardV());
		}
		
		for(int i = 0; i < cardCountW; i++)	{
			cardStock.add(new CardW());
		}
		
		for(int i = 0; i < cardCountX; i++)	{
			cardStock.add(new CardX());
		}
	}
	
	/**
	 * Get size of stock
	 * @return size of stock
	 */
	public int getSizeOfStock()	{
		return cardStock.size();
	}
	
	/**
	 * Should be the "take a card" move.
	 * @return random card in range of card left from cardStock
	 */
	public ICard getRandomCardFromStock()	{
		if(this.getSizeOfStock() == 0)	{
			return null;
		}
		int i = this.getRandomInRange(0, this.getSizeOfStock()-1);
		ICard x = cardStock.get(i);
		cardStock.remove(x);
		return x;
	}
	
	/**
	 * Help function to manage the changing size of cardStock and random function.
	 * @param start startindex
	 * @param end endindex
	 * @return	index of card
	 */
	public int getRandomInRange(int start, int end)	{
		return ThreadLocalRandom.current().nextInt(start, end + 1);
	}

	public ICard getStartCard() {
		ICard startCard = cardStock.get(8);
		cardStock.remove(8);
		return startCard;
	}
}