package de.htwg.cityyanderecarcassonne.view.tui;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.model.cards.CardA;
import de.htwg.cityyanderecarcassonne.model.cards.CardD;
import de.htwg.cityyanderecarcassonne.model.townsquare.Townsquare;

public class TownsquarePrinterTest {
	
	private TownsquarePrinter tsp;

	@Before
	public void setUp() throws Exception {
		Townsquare ts = new Townsquare(10, 10);
		tsp = new TownsquarePrinter(ts);
		ts.setCard(new CardD(), 5, 5);
	}

	@Test
	public void printCardTest() {
		String card1 = tsp.printCard(new CardA(), true);
		String card2 = tsp.printCard(new CardA(), false);
		
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
		
		assertEquals(card1r, card1);
		assertEquals(card2r, card2);
	}

	@Test
	public void printNormalTownsquareTest() {
		String ts = tsp.printNormalTownsquare();
		
		String tsr = "                                          \n" +
					 "                                          \n" +
					 "                                          \n" +
					 "                                          \n" +
					 "                                          \n" +
					 "                                          \n" +
					 "                                          \n" +
					 "               ------------               \n" +
					 "              |  L  S  L   |              \n" +
					 "              |L         B |              \n" +
					 "              |L    S    B |              \n" +
					 "              |L         B |              \n" +
					 "              |  L  S  L   |              \n" +
					 "               ------------               \n" +
				  	 "                                          \n" +
				  	 "                                          \n" +
				  	 "                                          \n" +
				  	 "                                          \n" +
				  	 "                                          \n" +
				  	 "                                          \n" +
				  	 "                                          \n";

		assertEquals(tsr, ts);
	}

	@Test
	public void printCardPossibilitiesTownsquareTest() {
		tsp.printCardPossibilitiesTownsquare(null);
		assertTrue(true);
	}

}
