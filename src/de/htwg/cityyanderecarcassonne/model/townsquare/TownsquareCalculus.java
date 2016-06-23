package de.htwg.cityyanderecarcassonne.model.townsquare;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.Player;
import de.htwg.cityyanderecarcassonne.model.graph.Graph;
import de.htwg.cityyanderecarcassonne.model.regions.RegionBuilding;
import de.htwg.cityyanderecarcassonne.model.regions.RegionLawn;
import de.htwg.cityyanderecarcassonne.model.regions.RegionStreet;

public final class TownsquareCalculus {
	
	private static Graph<IRegion> skynet = TownsquareGraph.getFullGraph();

	private TownsquareCalculus() {
		throw new UnsupportedOperationException();
	}
	
	public static void refreshScore() {
		skynet = TownsquareGraph.getFullGraph();
		
		Map<Integer, List<IRegion>> areas = breadthFirstSearch(skynet.getVertex(0));
		
		calcScoreClosedAreas(areas);
	}
	
	private static void calcScoreClosedAreas(Map<Integer, List<IRegion>> areas) {
		Map<Integer, List<IRegion>> result = new HashMap<>();
		result.putAll(areas);
		
		for (Map.Entry<Integer, List<IRegion>> entry : areas.entrySet()) {
			for (IRegion r : entry.getValue()) {
				if (r.getOpenBorder()) {
					result.remove(entry.getKey());
					break;
				}
			}
		}
		
		for (Map.Entry<Integer, List<IRegion>> entry : result.entrySet()) {
			int type = Character.getNumericValue(entry.getKey().toString().charAt(0));
			switch (type) {
			case 5:
				calculateStreetpoints(entry.getKey(), entry.getValue());
				break;
			case 1:
				calculateBuildingpoints(entry.getKey(), entry.getValue());
			}
			/*
			for (IRegion r : entry.getValue()) {
				Player player = r.getPlayer();
				if (player != null) {
					r.setPlayer(null);
					player.addMeeple();
					
					int oldScore = player.getScore();
					int points = IDManager.getSumCards(entry.getKey()) / IDManager.getPlayerList(entry.getKey()).size();
					player.setScore(oldScore + points);
					System.out.println("LIST FOR ID " + entry.getKey() + ": " + IDManager.getPlayerList(entry.getKey()));
				}
			}*/
		}
		
		System.out.println(result);
		
		int i = 0;
		
	}

	private static void calculateStreetpoints(int id, List<IRegion> rList) {
		
		List<Player> relevantPlayers = getRelevantPlayers(id);
		
		for (Player p : relevantPlayers) {
			int oldScore = p.getScore();
			int points = IDManager.getSumCards(id);
			p.setScore(oldScore + points);
			System.out.println("Player: " + p + ", Score: " + p.getScore());
		}
		
		freeMeeple(rList);
	}
	
	private static void calculateBuildingpoints(Integer key, List<IRegion> value) {
		// TODO Auto-generated method stub
		
	}
	
	private static List<Player> getRelevantPlayers(int id) {
		List<Player> player = IDManager.getPlayerList(id);
		Map<Player, Integer> winnerPlayer = new HashMap<>();
		List<Player> result = new LinkedList<>();
		
		Map<Player, Integer> pSum = new HashMap<>();
		for (Player p : player)
			if (pSum.get(p) != null)
				pSum.put(p, pSum.get(p) + 1);
			else
				pSum.put(p, 1);
		
		winnerPlayer.putAll(pSum);
		
		int lastSum = 0;
		Player lastPlayer = null;
		
		for (int i = 0; i < 2; i++) {
			for (Map.Entry<Player, Integer> entry : pSum.entrySet()) {
				int sum = entry.getValue();
				Player currentPlayer = entry.getKey();
				if (sum < lastSum)
					winnerPlayer.remove(currentPlayer);
				
				if (sum > lastSum) {
					lastSum = sum;
					lastPlayer = currentPlayer;
				} else if (sum == lastSum) {
					lastPlayer = null;
				}
			}
			
			if (player != null)
				break;
		}
		
		System.out.println("LIST FOR ID " + id + ": " + player);
		System.out.println("Player: " + lastPlayer);
		System.out.println("Equal Full Points: " + winnerPlayer.keySet());
		
		if (lastPlayer != null)
			result.add(lastPlayer);
		else
			result.addAll(winnerPlayer.keySet());
		
		return result;
	}
	
	private static void freeMeeple(List<IRegion> area) {
		for (IRegion r : area) {
			Player player = r.getPlayer();
			if (player != null) {
				r.setPlayer(null);
				player.addMeeple();
			}
		}
	}

	private int genPoints(int id, IRegion r) {
		int points = 0;
		int multiplier = 1;
		
		if (r.getClass().equals(RegionStreet.class)) {
			multiplier = 1;
		} else if (r.getClass().equals(RegionBuilding.class)) {
			multiplier = 2;
			// Gleichstand, beide volle Punkte
			// Derjenige mit den meisten Rittern drauf, bekommt die meisten Punkte
		} else if (r.getClass().equals(RegionLawn.class)) {
			multiplier = 3; // quatsch
		}
		return 0;
	}

	private static Map<Integer, List<IRegion>> breadthFirstSearch(IRegion s) {
		Map<IRegion, Boolean> visited = new HashMap<>();
		Map<Integer, List<IRegion>> results = new HashMap<>();
		
		for (IRegion v : skynet.getVertexList())
			visited.put(v, false);
		
		breadthVisit(s, visited, results);
		
		return results;
	}

	private static void breadthVisit(IRegion s, Map<IRegion, Boolean> visited, Map<Integer, List<IRegion>> results) {
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
			
			if (results.get(n.getID()) == null)
				results.put(n.getID(), new LinkedList<>());
			results.get(n.getID()).add(n);
			
			for (IRegion w : skynet.getAdjacentVertexList(n)) {
				if (!visited.get(w))
					q.add(w);
			}
		}
	}
}
