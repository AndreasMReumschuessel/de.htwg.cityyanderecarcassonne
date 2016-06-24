package de.htwg.cityyanderecarcassonne.model.scorecalculus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.ITownsquare;
import de.htwg.cityyanderecarcassonne.model.Player;
import de.htwg.cityyanderecarcassonne.model.regions.RegionCrossing;
import de.htwg.cityyanderecarcassonne.model.regions.RegionLawn;
import de.htwg.cityyanderecarcassonne.model.townsquare.TownsquareGraph;

public class CalculusRunningGame extends ScoreCalculus {

	public CalculusRunningGame(ITownsquare townsquare) {
		super(townsquare);
	}

	@Override
	public void refreshScore() {
		skynet = TownsquareGraph.getFullGraph();
		
		Map<Integer, List<IRegion>> areas = breadthFirstSearch(skynet.getVertex(0));
		
		calcScoreClosedAreas(areas);
		calculateSchoolpoints(townsquare);
	}
	
	private void calcScoreClosedAreas(Map<Integer, List<IRegion>> areas) {
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
	
	private boolean deniedRegions(Class<? extends IRegion> r) {
		return r.equals(RegionLawn.class) || r.equals(RegionCrossing.class);
	}
	
	protected void assignSchoolPoints(ICard card, int points) {
		if (points == 9) {
			IRegion region = card.getCenterMiddle();
			Player player = region.getPlayer();
			
			int oldScore = player.getScore();
			player.setScore(oldScore + points);
			region.setPlayer(null);
			player.addMeeple();
		}
	}

}
