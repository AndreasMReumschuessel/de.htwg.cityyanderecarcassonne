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
		mergeIDs(center.getLeftTop(), left.getRightTop());
		skynet.addEdge(center.getLeftTop(), left.getRightTop());
		
		mergeIDs(center.getLeftMiddle(), left.getRightMiddle());
		skynet.addEdge(center.getLeftMiddle(), left.getRightMiddle());
		
		mergeIDs(center.getLeftBelow(), left.getRightBelow());
		skynet.addEdge(center.getLeftBelow(), left.getRightBelow());
	}

	private void addBelow(ICard center, ICard below) {
		mergeIDs(center.getBelowLeft(), below.getTopLeft());
		skynet.addEdge(center.getBelowLeft(), below.getTopLeft());
		
		mergeIDs(center.getBelowMiddle(), below.getTopMiddle());
		skynet.addEdge(center.getBelowMiddle(), below.getTopMiddle());
		
		mergeIDs(center.getBelowRight(), below.getTopRight());
		skynet.addEdge(center.getBelowRight(), below.getTopRight());
	}

	private void addTop(ICard center, ICard top) {
		mergeIDs(center.getTopLeft(), top.getBelowLeft());
		skynet.addEdge(center.getTopLeft(), top.getBelowLeft());
		
		mergeIDs(center.getTopMiddle(), top.getBelowMiddle());
		skynet.addEdge(center.getTopMiddle(), top.getBelowMiddle());
		
		mergeIDs(center.getTopRight(), top.getBelowRight());
		skynet.addEdge(center.getTopRight(), top.getBelowRight());
	}
	
	private void addRight(ICard center, ICard right) {
		mergeIDs(center.getRightTop(), right.getLeftTop());
		skynet.addEdge(center.getRightTop(), right.getLeftTop());
		
		mergeIDs(center.getRightMiddle(), right.getLeftMiddle());
		skynet.addEdge(center.getRightMiddle(), right.getLeftMiddle());
		
		mergeIDs(center.getRightBelow(), right.getLeftBelow());
		skynet.addEdge(center.getRightBelow(), right.getLeftBelow());
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
		
		/* System.out.println("Size: " + tmp.size() + " Content: " + tmp); */
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
