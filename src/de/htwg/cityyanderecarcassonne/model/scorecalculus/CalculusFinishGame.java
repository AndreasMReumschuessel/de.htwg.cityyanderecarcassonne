package de.htwg.cityyanderecarcassonne.model.scorecalculus;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void assignSchoolPoints(ICard card, int points) {
		IRegion region = card.getCenterMiddle();
		Player player = region.getPlayer();
		
		int oldScore = player.getScore();
		player.setScore(oldScore + points);
		region.setPlayer(null);
		player.addMeeple();		
	}

}
