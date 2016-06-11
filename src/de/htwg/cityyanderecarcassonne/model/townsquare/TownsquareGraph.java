package de.htwg.cityyanderecarcassonne.model.townsquare;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.graph.AdjacencyListUndirectedGraph;
import de.htwg.cityyanderecarcassonne.model.graph.Edge;
import de.htwg.cityyanderecarcassonne.model.graph.Graph;

public class TownsquareGraph {
	
	private Graph<IRegion> skynet;
	
	public TownsquareGraph() {
		this.skynet = new AdjacencyListUndirectedGraph<>();
		//TODO: Change it to a static class?
	}
	
	public Graph<IRegion> getFullGraph() {
		return this.skynet;
	}
	
	public boolean addCard(ICard center, ICard left, ICard below, ICard top, ICard right) {
		Graph<IRegion> cardGraph = center.getCardGraph();
		
		for (IRegion v : cardGraph.getVertexList())
			skynet.addVertex(v);
		
		for (Edge<IRegion> e : cardGraph.getEdgeList())
			skynet.addEdge(e.getSource(), e.getTarget());
		
		//TODO: Merge IDs
		
		if (left != null) {
			skynet.addEdge(center.getLeftTopTwo(), left.getRightTopTwo());
			skynet.addEdge(center.getLeftCenter(), left.getRightCenter());
			skynet.addEdge(center.getLeftBelowTwo(), left.getRightBelowTwo());
		}
		
		if (below != null) {
			skynet.addEdge(center.getLeftBelowOne(), below.getLeftTopOne());
			skynet.addEdge(center.getMiddleBelow(), below.getMiddleTop());
			skynet.addEdge(center.getRightBelowOne(), below.getRightTopOne());
		}
		
		if (top != null) {
			skynet.addEdge(center.getLeftTopOne(), top.getLeftBelowOne());
			skynet.addEdge(center.getMiddleTop(), top.getMiddleBelow());
			skynet.addEdge(center.getRightTopOne(), top.getRightBelowOne());
		}
		
		if (right != null) {
			skynet.addEdge(center.getRightTopTwo(), right.getLeftTopTwo());
			skynet.addEdge(center.getRightCenter(), right.getLeftCenter());
			skynet.addEdge(center.getRightBelowTwo(), right.getLeftBelowTwo());
		}
		
		return false;
	}
}
