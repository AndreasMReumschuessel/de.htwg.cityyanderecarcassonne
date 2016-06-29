package de.htwg.cityyanderecarcassonne.view.gui;


import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.Player;
import de.htwg.cityyanderecarcassonne.model.cards.CardB;
import de.htwg.cityyanderecarcassonne.model.cards.CardD;
import de.htwg.cityyanderecarcassonne.model.cards.CardL;
import de.htwg.cityyanderecarcassonne.model.cards.Stock;
import de.htwg.cityyanderecarcassonne.view.tui.CardPrinter;

public class CardPrinterGUITest {
	
	@Before
	public void setUp() throws Exception {
		Stock.getInstance().resetStock();
		CardPrinterGUI.getInstance();
	}

	@Test
	public final void testPrintCard() {
		ICard card = new CardB();
		Player player = new Player("Faxe_1L_Fass");
		card.getLeftTop().setPlayer(player);
		card.getLeftMiddle().setPlayer(player);
		card.getLeftBelow().setPlayer(player);
		card.getBelowLeft().setPlayer(player);
		card.getBelowMiddle().setPlayer(player);
		card.getBelowRight().setPlayer(player);
		card.getCenterMiddle().setPlayer(player);
		card.getTopLeft().setPlayer(player);
		card.getTopMiddle().setPlayer(player);
		card.getTopRight().setPlayer(player);
		card.getRightTop().setPlayer(player);
		card.getRightMiddle().setPlayer(player);
		card.getRightBelow().setPlayer(player);
		
		CardPrinterGUI.printCard(new CardD());
		CardPrinterGUI.printCard(card);
	}

	@Test
	public final void testPrintCardPoss() {
		Map<IRegion, String> possList = new HashMap<>();
		ICard card = new CardL();
		possList.put(card.getLeftTop(), "A");
		possList.put(card.getLeftMiddle(), "B");
		possList.put(card.getLeftBelow(), "C");
		possList.put(card.getBelowLeft(), "D");
		possList.put(card.getBelowMiddle(), "E");
		possList.put(card.getBelowRight(), "F");
		possList.put(card.getCenterMiddle(), "G");
		possList.put(card.getTopLeft(), "H");
		possList.put(card.getTopMiddle(), "I");
		possList.put(card.getTopRight(), "J");
		possList.put(card.getRightTop(), "K");
		possList.put(card.getRightMiddle(), "L");
		possList.put(card.getRightBelow(), "M");
		
		CardPrinterGUI.printCardPoss(card, possList);
		CardPrinterGUI.printCardPoss(new CardD(), new HashMap<IRegion, String>());
	}

	@Test
	public final void testPseudoCard() {
		CardPrinterGUI.pseudoCard();
	}

}
