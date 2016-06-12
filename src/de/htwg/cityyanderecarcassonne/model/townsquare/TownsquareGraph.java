package de.htwg.cityyanderecarcassonne.model.townsquare;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import java.util.Map;
import java.util.Queue;

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
		
		if (left != null)
			addLeft(center, left);
		
		if (below != null)
			addBelow(center, below);
		
		if (top != null)
			addTop(center, top);
		
		if (right != null)
			addRight(center, right);
		
		return false;
	}

	private void addLeft(ICard center, ICard left) {
		mergeIDs(center.getLeftTopTwo(), left.getRightTopTwo());
		skynet.addEdge(center.getLeftTopTwo(), left.getRightTopTwo());
		
		mergeIDs(center.getLeftCenter(), left.getRightCenter());
		skynet.addEdge(center.getLeftCenter(), left.getRightCenter());
		
		mergeIDs(center.getLeftBelowTwo(), left.getRightBelowTwo());
		skynet.addEdge(center.getLeftBelowTwo(), left.getRightBelowTwo());
	}

	private void addBelow(ICard center, ICard below) {
		mergeIDs(center.getLeftBelowOne(), below.getLeftTopOne());
		skynet.addEdge(center.getLeftBelowOne(), below.getLeftTopOne());
		
		mergeIDs(center.getMiddleBelow(), below.getMiddleTop());
		skynet.addEdge(center.getMiddleBelow(), below.getMiddleTop());
		
		mergeIDs(center.getRightBelowOne(), below.getRightTopOne());
		skynet.addEdge(center.getRightBelowOne(), below.getRightTopOne());
	}

	private void addTop(ICard center, ICard top) {
		mergeIDs(center.getLeftTopOne(), top.getLeftBelowOne());
		skynet.addEdge(center.getLeftTopOne(), top.getLeftBelowOne());
		
		mergeIDs(center.getMiddleTop(), top.getMiddleBelow());
		skynet.addEdge(center.getMiddleTop(), top.getMiddleBelow());
		
		mergeIDs(center.getRightTopOne(), top.getRightBelowOne());
		skynet.addEdge(center.getRightTopOne(), top.getRightBelowOne());
	}
	
	private void addRight(ICard center, ICard right) {
		mergeIDs(center.getRightTopTwo(), right.getLeftTopTwo());
		skynet.addEdge(center.getRightTopTwo(), right.getLeftTopTwo());
		
		mergeIDs(center.getRightCenter(), right.getLeftCenter());
		skynet.addEdge(center.getRightCenter(), right.getLeftCenter());
		
		mergeIDs(center.getRightBelowTwo(), right.getLeftBelowTwo());
		skynet.addEdge(center.getRightBelowTwo(), right.getLeftBelowTwo());
	}

	private void mergeIDs(IRegion r1, IRegion r2) {
		if (r1.getID() == r2.getID())
			return;
		
		List<IRegion> tmp = new LinkedList<>();
		int maxID = 0;
		
		tmp.addAll(breadthFirstSearch(r1));
		for (IRegion r : breadthFirstSearch(r2))
			if (!tmp.contains(r))
				tmp.add(r);
		
		for (IRegion r : tmp) {
			maxID = Math.max(maxID, r.getID());
		}
		
		for (IRegion r : tmp) {
			r.setID(maxID);
		}
		
		System.out.println("Size: " + tmp.size() + " Content: " + tmp);
	}
	
	private List<IRegion> breadthFirstSearch(IRegion s) {
		Map<IRegion, Boolean> visited = new HashMap<>();
		List<IRegion> results = new LinkedList<>();
		
		for (IRegion v : skynet.getVertexList())
			visited.put(v, false);
		
		breadthVisit(s, visited, results);
		
		return results;
	}

	private void breadthVisit(IRegion s, Map<IRegion, Boolean> visited, List<IRegion> results) {
		Queue<IRegion> q = new LinkedList<>();
		Class<?> type = s.getClass();
		int id = s.getID();
		
		q.add(s);
		
		while (!q.isEmpty()) {
			s = q.remove();
			
			if (visited.get(s))
				continue;
			
			visited.replace(s, true);
			
			results.add(s);
			
			for (IRegion w : skynet.getAdjacentVertexList(s)) {
				if (w.getClass().equals(type) && (w.getID() == id) && !visited.get(w))
					q.add(w);
			}
		}
	}
}
