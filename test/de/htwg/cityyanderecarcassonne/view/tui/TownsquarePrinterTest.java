package de.htwg.cityyanderecarcassonne.view.tui;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
