package de.htwg.cityyanderecarcassonne.model.scorecalculus;

import java.util.List;
import java.util.Map;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.ITownsquare;
import de.htwg.cityyanderecarcassonne.model.Player;

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
				calculateLawnpoints(entry.getKey(), entry.getValue());
			default:
				break;
			}
		}
	}

	private void calculateLawnpoints(Integer id, List<IRegion> rList) {
		// Breitensuche innerhalb der Wiese
		// Merken, welche Burgen abgeschlossen sind
		// Punkte = Anzahl der Burgen mal drei
	}

	@Override
	protected void assignSchoolPoints(ICard card, int points) {
		IRegion region = card.getCenterMiddle();
		Player player = region.getPlayer();
		
		if (player != null) {
			int oldScore = player.getScore();
			player.setScore(oldScore + points);
			region.setPlayer(null);
			player.addMeeple();
		}
	}

}
