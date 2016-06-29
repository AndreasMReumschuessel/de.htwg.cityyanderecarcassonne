package de.htwg.cityyanderecarcassonne.view.gui;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.Position;
import de.htwg.cityyanderecarcassonne.model.cards.CardB;
import de.htwg.cityyanderecarcassonne.model.cards.CardD;
import de.htwg.cityyanderecarcassonne.model.townsquare.Townsquare;

public class TownsquareVisualTest {
	
	private TownsquareVisual tsp;
	private ICard dCard;

	@Before
	public void setUp() throws Exception {
		Townsquare ts = new Townsquare(10, 10);
		dCard = new CardD();
		tsp = new TownsquareVisual(ts);
		ts.setCard(dCard, 5, 5);
		ts.setCard(new CardB(), 4, 5);
	}

	@Test
	public final void testBackgroundImageVisual() {
		tsp.backgroundImageVisual();
	}

	@Test
	public final void testNormalTownsquareVisual() {
		tsp.normalTownsquareVisual();
	}

	@Test
	public final void testPossTownsquareVisual() {
		Map<Position, String> possibilities = new HashMap<>();
		possibilities.put(new Position(4,5), "G");
		
		tsp.possTownsquareVisual(possibilities);
	}

	@Test
	public final void testMeepleTownsquareVisual() {
		ICard card = dCard;
		Map<IRegion, String> possList = new HashMap<>();
		possList.put(card.getBelowMiddle(), "C");
		possList.put(card.getLeftMiddle(), "W");
		
		tsp.meepleTownsquareVisual(dCard, possList);
	}

}
