package de.htwg.cityyanderecarcassonne.model;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import de.htwg.cityyanderecarcassonne.model.graph.*;

public class Townsquare {

	private UndirectedGraph<Space> spaceGraph;
	private UndirectedGraph<Region> regionGraph;
	private Map<Region, Integer> freeRegionMap;
	private Stock stock;
	private Card cardOnHand;
	
	public Townsquare()	{
		spaceGraph = new AdjacencyListUndirectedGraph<>();
		regionGraph = new AdjacencyListUndirectedGraph<>();
		freeRegionMap = new TreeMap<>();
	}
	
	public void initTownsquare() throws IOException	{
		stock.importCards();
	}
	
	public void placeStartCard()	{
		cardOnHand = stock.getCardAtStart();
		addEdgesOfCardToRegionGraph(regionGraph,cardOnHand);
		spaceGraph.addVertex(cardOnHand);
		addChoicesOfCard(cardOnHand);
	}
	
	public void placeCardFromStock(Choice choice)	{
		cardOnHand = stock.getRandomCardFromStock();
		addEdgesOfCardToRegionGraph(regionGraph,cardOnHand);
		spaceGraph.addVertex(cardOnHand);
		spaceGraph.addEdge(cardOnHand, placeCard(choice));
		addChoicesOfCard(cardOnHand);
	}
	
	public Card getCardFromStock()	{
		cardOnHand = stock.getRandomCardFromStock();
		return cardOnHand;
	}
	
	public void addEdgesOfCardToRegionGraph(Graph<Region> region, Card card)	{
		
		region.addVertex(card.getRegionNorth());
		region.addVertex(card.getRegionEast());
		region.addVertex(card.getRegionSouth());
		region.addVertex(card.getRegionWest());
		region.addVertex(card.getRegionCenter());
		
		region.addEdge(card.getRegionNorth(), card.getRegionEast(), defineEdgeType(card.getRegionNorth(), card.getRegionEast(), card.getRegionCenter()));

	}
	
	public String defineEdgeType(Region a, Region b, Region c)	{
		
		if(a.getType() == (b.getType()) && c.getType() != "crossing")	{
			return a.getType();
		} else if("lawn" == a.getType() || "lawn" == b.getType()){
			return "lawn";
		}
		
		return "leer";
	}
	
	public void addChoicesOfCard(Card card)	{
		
		Choice choiceNorth = new Choice(null, null, card.getRegionNorth(), null, null);
		spaceGraph.addVertex(choiceNorth);
		spaceGraph.addEdge(cardOnHand, choiceNorth);
		
		Choice choiceEast = new Choice(null, null, null, card.getRegionWest(), null);
		spaceGraph.addVertex(choiceEast);
		spaceGraph.addEdge(cardOnHand, choiceEast);
		
		Choice choiceSouth = new Choice(card.getRegionSouth(), null, null, null, null);
		spaceGraph.addVertex(choiceSouth);
		spaceGraph.addEdge(cardOnHand, choiceSouth);
		
		Choice choiceWest = new Choice(null, card.getRegionEast(), null, null, null);
		spaceGraph.addVertex(choiceWest);
		spaceGraph.addEdge(cardOnHand, choiceWest);
		
	}
	
	public Choice placeCard(Choice choice)	{
	
		return null;
	}	
}
