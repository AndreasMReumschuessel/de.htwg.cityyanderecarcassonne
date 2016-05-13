package de.htwg.cityyanderecarcassonne.model;

import java.io.IOException;
import de.htwg.cityyanderecarcassonne.model.graph.*;

public class Townsquare {

	private Graph<Card> cardGraph;
	private Stock stock;
	private Card cardOnHand;
	
	public Townsquare()	{
		cardGraph = new AdjacencyListUndirectedGraph<>();
	}
	
	public void initTownsquare() throws IOException	{
		stock.importCards();
	}
	
	public void placeStartCard()	{
		cardGraph.addVertex(stock.getCardAtStart());
	}
	
	public Card getCardFromStock()	{
		cardOnHand = stock.getRandomCardFromStock();
		return cardOnHand;
	}
	
	public void placeCard(Region setRegion)	{
		if(setRegion != null)	{
			//cardOnHand.setRegion(setRegion);
		}
		
		cardGraph.addVertex(cardOnHand);
	}
	
	public Card getCard()	{
		return cardOnHand;
	}
	
}
