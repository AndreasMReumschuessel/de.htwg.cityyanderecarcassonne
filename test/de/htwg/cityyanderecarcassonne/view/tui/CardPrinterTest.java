package de.htwg.cityyanderecarcassonne.view.tui;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.cards.CardA;
import de.htwg.cityyanderecarcassonne.model.cards.CardL;
import de.htwg.cityyanderecarcassonne.model.impl.Player;

public class CardPrinterTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void printCardTest() {
		ICard card = new CardA();
		card.getCenterMiddle().setPlayer(new Player("Blindi"));
		String card2 = CardPrinter.printCard(card);		
		String card2r = " ------------ \n" +
						"|  L  L  L   |\n" +
						"|L         L |\n" +
						"|L    KP   L |\n" +
						"|L         L |\n" +
						"|  L  S  L   |\n" +
						" ------------ \n";
		
		assertEquals(card2r, card2);
	}
	
	@Test
	public void printCardPoss() {
		Map<IRegion, String> possList = new HashMap<>();
		ICard card = new CardL();
		possList.put(card.getBelowLeft(), "A");
		possList.put(card.getCenterMiddle(), "G");
		
		String card1 = CardPrinter.printCardPoss(card, possList);
		String card1r = " ############ \n" +
						"#  L  S  L   #\n" + 
						"#L         B #\n" +
						"#S    CG   B #\n" +
						"#L         B #\n" +
						"#  LA S  L   #\n" +
						" ############ \n";
		
		assertEquals(card1r, card1);
	}

}
