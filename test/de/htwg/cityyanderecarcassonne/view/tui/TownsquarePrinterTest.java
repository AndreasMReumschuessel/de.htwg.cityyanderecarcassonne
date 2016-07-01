package de.htwg.cityyanderecarcassonne.view.tui;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IPosition;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.cards.CardD;
import de.htwg.cityyanderecarcassonne.model.impl.Position;
import de.htwg.cityyanderecarcassonne.model.townsquare.Townsquare;

public class TownsquarePrinterTest {
	
	private TownsquarePrinter tsp;
	private ICard dCard;

	@Before
	public void setUp() throws Exception {
		Townsquare ts = new Townsquare(10, 10);
		dCard = new CardD();
		tsp = new TownsquarePrinter(ts);
		ts.setCard(dCard, 5, 5);
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
		Map<IPosition, String> possibilities = new HashMap<>();
		possibilities.put(new Position(4,5), "G");
		
		String ts = tsp.printCardPossibilitiesTownsquare(possibilities);
		
		String tsr = "                                          \n" +
					 "                                          \n" +
					 "                                          \n" +
					 "                                          \n" +
					 "                                          \n" +
					 "                                          \n" +
					 "                                          \n" +
					 " ############  ------------               \n" +
					 "#            #|  L  S  L   |              \n" +
					 "#            #|L         B |              \n" +
					 "#     G      #|L    S    B |              \n" +
					 "#            #|L         B |              \n" +
					 "#            #|  L  S  L   |              \n" +
					 " ############  ------------               \n" +
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
	public void printMeeplePossibilitiesTownsquare() {
		ICard card = dCard;
		Map<IRegion, String> possList = new HashMap<>();
		possList.put(card.getBelowMiddle(), "C");
		possList.put(card.getLeftMiddle(), "W");
		
		String ts = tsp.printMeeplePossibilitiesTownsquare(card, possList);
		String tsr = "                                          \n" +
				 "                                          \n" +
				 "                                          \n" +
				 "                                          \n" +
				 "                                          \n" +
				 "                                          \n" +
				 "                                          \n" +
				 "               ############               \n" +
				 "              #  L  S  L   #              \n" +
				 "              #L         B #              \n" +
				 "              #LW   S    B #              \n" +
				 "              #L         B #              \n" +
				 "              #  L  SC L   #              \n" +
				 "               ############               \n" +
			  	 "                                          \n" +
			  	 "                                          \n" +
			  	 "                                          \n" +
			  	 "                                          \n" +
			  	 "                                          \n" +
			  	 "                                          \n" +
			  	 "                                          \n";
	
		assertEquals(tsr, ts);
	}
}
