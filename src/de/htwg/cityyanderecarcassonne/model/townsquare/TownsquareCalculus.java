package de.htwg.cityyanderecarcassonne.model.townsquare;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.ITownsquare;
import de.htwg.cityyanderecarcassonne.model.Player;
import de.htwg.cityyanderecarcassonne.model.Position;
import de.htwg.cityyanderecarcassonne.model.graph.Graph;
import de.htwg.cityyanderecarcassonne.model.regions.RegionCrossing;
import de.htwg.cityyanderecarcassonne.model.regions.RegionLawn;
import de.htwg.cityyanderecarcassonne.model.regions.RegionSchool;

public final class TownsquareCalculus {
	
	private static Graph<IRegion> skynet = TownsquareGraph.getFullGraph();

	private TownsquareCalculus() {
		throw new UnsupportedOperationException();
	}
	
	public static void refreshScore(ITownsquare townsquare) {
		skynet = TownsquareGraph.getFullGraph();
		
		Map<Integer, List<IRegion>> areas = breadthFirstSearch(skynet.getVertex(0));
		
		calcScoreClosedAreas(areas);
		calculateSchoolpoints(townsquare);
	}
	
	private static void calcScoreClosedAreas(Map<Integer, List<IRegion>> areas) {
		Map<Integer, List<IRegion>> result = new HashMap<>();
		result.putAll(areas);
		
		for (Map.Entry<Integer, List<IRegion>> entry : areas.entrySet()) {
			for (IRegion r : entry.getValue()) {				
				if (r.getOpenBorder() || deniedRegions(r.getClass())) {
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
				break;
			default:
				break;
			}
		}
	}

	private static boolean deniedRegions(Class<? extends IRegion> r) {
		return r.equals(RegionLawn.class) || r.equals(RegionCrossing.class);
	}

	private static void calculateStreetpoints(int id, List<IRegion> rList) {
		
		List<Player> settledPlayers = getSettledPlayers(rList);
		List<Player> relevantPlayers = getRelevantPlayers(settledPlayers);
		
		int points = IDManager.getSumCards(id);
		assignPoints(relevantPlayers, points);
		
		freeMeeple(rList);
	}
	
	private static void calculateBuildingpoints(int id, List<IRegion> rList) {

		List<Player> settledPlayers = getSettledPlayers(rList);
		List<Player> relevantPlayers = getRelevantPlayers(settledPlayers);
		
		int points = IDManager.getSumCards(id)  * 2;
		assignPoints(relevantPlayers, points);
		
		freeMeeple(rList);
	}
	
	private static void calculateSchoolpoints(ITownsquare townsquare) {
		Map<ICard, Position> schools = getSchools(townsquare);
		for (ICard card : schools.keySet()) {
			int points = sumSchoolArea(townsquare, schools.get(card).getX(), schools.get(card).getY());
			assignSchoolPoints(card, points);
		}
		
	}
	
	private static Map<ICard, Position> getSchools(ITownsquare townsquare) {
		Map<ICard, Position> result = new HashMap<>();
		for (int y = 0; y < townsquare.getDimY(); y++) {
			for (int x = 0; x < townsquare.getDimY(); x++) {
				ICard card = townsquare.getCard(x, y);
				if (card != null && card.getCenterMiddle().getClass().equals(RegionSchool.class)) {
					result.put(card, new Position(x, y));
				}
			}
		}
		return result;
	}
	
	private static int sumSchoolArea(ITownsquare townsquare, int x, int y) {
		int sum = 0;
		for (int i = y - 1; i <= y + 1; i++) {
			for (int j = x - 1; j <= x + 1; j++) {
				if (townsquare.getCard(j, i) != null) {
					sum++;
				}
			}
		}
		return sum;
	}
	
	private static void assignSchoolPoints(ICard card, int points) {
		if (points == 9) {
			IRegion region = card.getCenterMiddle();
			Player player = region.getPlayer();
			
			int oldScore = player.getScore();
			player.setScore(oldScore + points);
			region.setPlayer(null);
			player.addMeeple();
		}
	}

	private static List<Player> getRelevantPlayers(List<Player> player) {
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
			
			if (lastPlayer != null)
				break;
		}
		
		if (lastPlayer != null)
			result.add(lastPlayer);
		else
			result.addAll(winnerPlayer.keySet());
		
		return result;
	}
	
	private static List<Player> getSettledPlayers(List<IRegion> rList) {
		List<Player> result = new LinkedList<>();
		for (IRegion r : rList) {
			Player player = r.getPlayer();
			if (player != null) {
				result.add(player);
			}
		}
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
	
	private static void assignPoints(List<Player> players, int points) {
		for (Player p : players) {
			int oldScore = p.getScore();
			p.setScore(oldScore + points);
		}
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
