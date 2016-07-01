package de.htwg.cityyanderecarcassonne.model.scorecalculus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.IPlayer;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.ITownsquare;
import de.htwg.cityyanderecarcassonne.model.regions.RegionBuilding;
import de.htwg.cityyanderecarcassonne.model.regions.RegionLawn;

public class CalculusFinishGame extends ScoreCalculus {

	public CalculusFinishGame(ITownsquare townsquare) {
		super(townsquare);
	}

	@Override
	public void refreshScore() {
		Map<Integer, List<IRegion>> areas = breadthFirstSearch(skynet.getVertex(0));
		
		calculateRemainingPoints(areas);
		calculateSchoolpoints(townsquare);
	}

	private void calculateRemainingPoints(Map<Integer, List<IRegion>> areas) {
		for (Map.Entry<Integer, List<IRegion>> entry : areas.entrySet()) {
			int type = Character.getNumericValue(entry.getKey().toString().charAt(0));
			switch (type) {
			case 5:
				calculateStreetpoints(entry.getKey(), entry.getValue());
				break;
			case 1:
				calculateStreetpoints(entry.getKey(), entry.getValue()); /* Streetpoints because at end of game unfinished buildings count as much as streets */
				break;
			case 3:
				calculateLawnpoints(entry.getValue());
				break;
			default:
				break;
			}
		}
	}

	private void calculateLawnpoints(List<IRegion> rList) {
		List<IPlayer> settledPlayers = getSettledPlayers(rList);
		List<IPlayer> relevantPlayers = getRelevantPlayers(settledPlayers);
		
		int points = lawnBreadthFirstSearch(rList.get(0)).size() * 3;
		assignPoints(relevantPlayers, points);
		
		freeMeeple(rList);
	}

	@Override
	protected void assignSchoolPoints(ICard card, int points) {
		IRegion region = card.getCenterMiddle();
		IPlayer player = region.getPlayer();
		
		if (player != null) {
			int oldScore = player.getScore();
			player.setScore(oldScore + points);
			region.setPlayer(null);
			player.addMeeple();
		}	
	}
	
	private Set<Integer> lawnBreadthFirstSearch(IRegion s) {
		Map<IRegion, Boolean> visited = new HashMap<>();
		Set<Integer> results = new HashSet<>();
		
		for (IRegion v : skynet.getVertexList())
			visited.put(v, false);
		
		lawnBreadthVisit(s, visited, results);
		
		return results;
	}
	
	private void lawnBreadthVisit(IRegion s, Map<IRegion, Boolean> visited, Set<Integer> results) {
		Queue<IRegion> q = new LinkedList<>();
		IRegion n = s;
		
		q.add(n);
		
		while (!q.isEmpty()) {
			n = q.remove();
			
			if (visited.get(n))
				continue;
			
			visited.replace(n, true);
			
			for (IRegion w : skynet.getAdjacentVertexList(n)) {
				if (w.getClass().equals(RegionBuilding.class) 
						&& IDManager.isAreaClosed(w.getID())) {
					results.add(w.getID());
				}
				
				if (!visited.get(w) && w.getClass().equals(RegionLawn.class) && w.getID() == n.getID())
					q.add(w);
			}
		}
	}

}
