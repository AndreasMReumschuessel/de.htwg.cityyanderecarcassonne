package de.htwg.cityyanderecarcassonne.view.tui;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.model.cards.CardA;

public class CardPrinterTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void printCardTest() {
		//String card1 = CardPrinter.printCardPoss(new CardA(), true);
		String card2 = CardPrinter.printCard(new CardA());
		
		String card1r = " ############ \n" +
						"#  L  L  L   #\n" + 
						"#L         L #\n" +
						"#L    K    L #\n" +
						"#L         L #\n" +
						"#  L  S  L   #\n" +
						" ############ \n";
		
		String card2r = " ------------ \n" +
						"|  L  L  L   |\n" +
						"|L         L |\n" +
						"|L    K    L |\n" +
						"|L         L |\n" +
						"|  L  S  L   |\n" +
						" ------------ \n";
		
		//assertEquals(card1r, card1);
		assertEquals(card2r, card2);
	}

}
