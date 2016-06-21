package de.htwg.cityyanderecarcassonne.model.townsquare;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.graph.Graph;

public final class TownsquareCalculus {
	
	private static Graph<IRegion> skynet = TownsquareGraph.getFullGraph();

	private TownsquareCalculus() {
		throw new UnsupportedOperationException();
	}
	
	public static void refreshScore() {
		skynet = TownsquareGraph.getFullGraph();
		
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
				if (!visited.get(w))
					q.add(w);
			}
		}
	}
}
