package de.htwg.cityyanderecarcassonne.model.townsquare;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.graph.AdjacencyListUndirectedGraph;
import de.htwg.cityyanderecarcassonne.model.graph.Edge;
import de.htwg.cityyanderecarcassonne.model.graph.Graph;

public final class TownsquareGraph {
	
	private static Graph<IRegion> skynet = new AdjacencyListUndirectedGraph<>();
	
	private TownsquareGraph() {
		throw new UnsupportedOperationException();
	}
	
	public static Graph<IRegion> getFullGraph() {
		return skynet;
	}
	
	public static boolean addCard(ICard center, ICard left, ICard below, ICard top, ICard right) {
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

	private static void addLeft(ICard center, ICard left) {
		mergeIDs(center.getLeftTop(), left.getRightTop());
		skynet.addEdge(center.getLeftTop(), left.getRightTop());
		center.getLeftTop().setOpenBorder(false);
		left.getRightTop().setOpenBorder(false);
		
		mergeIDs(center.getLeftMiddle(), left.getRightMiddle());
		skynet.addEdge(center.getLeftMiddle(), left.getRightMiddle());
		center.getLeftMiddle().setOpenBorder(false);
		left.getRightMiddle().setOpenBorder(false);
		
		mergeIDs(center.getLeftBelow(), left.getRightBelow());
		skynet.addEdge(center.getLeftBelow(), left.getRightBelow());
		center.getLeftBelow().setOpenBorder(false);
		left.getRightBelow().setOpenBorder(false);
	}

	private static void addBelow(ICard center, ICard below) {
		mergeIDs(center.getBelowLeft(), below.getTopLeft());
		skynet.addEdge(center.getBelowLeft(), below.getTopLeft());
		center.getBelowLeft().setOpenBorder(false);
		below.getTopLeft().setOpenBorder(false);
		
		mergeIDs(center.getBelowMiddle(), below.getTopMiddle());
		skynet.addEdge(center.getBelowMiddle(), below.getTopMiddle());
		center.getBelowMiddle().setOpenBorder(false);
		below.getTopMiddle().setOpenBorder(false);
		
		mergeIDs(center.getBelowRight(), below.getTopRight());
		skynet.addEdge(center.getBelowRight(), below.getTopRight());
		center.getBelowRight().setOpenBorder(false);
		below.getTopRight().setOpenBorder(false);
	}

	private static void addTop(ICard center, ICard top) {
		mergeIDs(center.getTopLeft(), top.getBelowLeft());
		skynet.addEdge(center.getTopLeft(), top.getBelowLeft());
		center.getTopLeft().setOpenBorder(false);
		top.getBelowLeft().setOpenBorder(false);
		
		mergeIDs(center.getTopMiddle(), top.getBelowMiddle());
		skynet.addEdge(center.getTopMiddle(), top.getBelowMiddle());
		center.getTopMiddle().setOpenBorder(false);
		top.getBelowMiddle().setOpenBorder(false);
		
		mergeIDs(center.getTopRight(), top.getBelowRight());
		skynet.addEdge(center.getTopRight(), top.getBelowRight());
		center.getTopRight().setOpenBorder(false);
		top.getBelowRight().setOpenBorder(false);
	}
	
	private static void addRight(ICard center, ICard right) {
		mergeIDs(center.getRightTop(), right.getLeftTop());
		skynet.addEdge(center.getRightTop(), right.getLeftTop());
		center.getRightTop().setOpenBorder(false);
		right.getLeftTop().setOpenBorder(false);
		
		mergeIDs(center.getRightMiddle(), right.getLeftMiddle());
		skynet.addEdge(center.getRightMiddle(), right.getLeftMiddle());
		center.getRightMiddle().setOpenBorder(false);
		right.getLeftMiddle().setOpenBorder(false);
		
		mergeIDs(center.getRightBelow(), right.getLeftBelow());
		skynet.addEdge(center.getRightBelow(), right.getLeftBelow());
		center.getRightBelow().setOpenBorder(false);
		right.getLeftBelow().setOpenBorder(false); //TODO Possible task in mergeIDs?
	}

	private static void mergeIDs(IRegion r1, IRegion r2) {
		if (r1.getID() == r2.getID())
			return;
		
		List<IRegion> tmp = new LinkedList<>();
		int maxID = 0;
		Set<Integer> uniqueIDs = new HashSet<>();
		
		tmp.addAll(breadthFirstSearch(r1));
		for (IRegion r : breadthFirstSearch(r2))
			if (!tmp.contains(r))
				tmp.add(r);
		
		int sum = 0;
		for (IRegion r : tmp) {
			if (uniqueIDs.add(r.getID()))
				sum += IDManager.getSumCards(r.getID());
			
			maxID = Math.max(maxID, r.getID());
		}
		
		for (IRegion r : tmp) {
			r.setID(maxID);
			IDManager.setPlayer(maxID, r.getPlayer());
		}
		
		IDManager.setSumCards(maxID, sum);
	}
	
	private static List<IRegion> breadthFirstSearch(IRegion s) {
		Map<IRegion, Boolean> visited = new HashMap<>();
		List<IRegion> results = new LinkedList<>();
		
		for (IRegion v : skynet.getVertexList())
			visited.put(v, false);
		
		breadthVisit(s, visited, results);
		
		return results;
	}

	private static void breadthVisit(IRegion s, Map<IRegion, Boolean> visited, List<IRegion> results) {
		Queue<IRegion> q = new LinkedList<>();
		Class<?> type = s.getClass();
		int id = s.getID();
		IRegion n = s;
		
		q.add(n);
		
		while (!q.isEmpty()) {
			n = q.remove();
			
			if (visited.get(n))
				continue;
			
			visited.replace(n, true);
			
			results.add(n);
			
			for (IRegion w : skynet.getAdjacentVertexList(n)) {
				if (w.getClass().equals(type) && (w.getID() == id) && !visited.get(w))
					q.add(w);
			}
		}
	}
}
