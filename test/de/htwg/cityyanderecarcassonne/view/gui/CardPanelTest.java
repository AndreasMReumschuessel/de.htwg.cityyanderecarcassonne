package de.htwg.cityyanderecarcassonne.view.gui;


import java.awt.Container;

import javax.swing.JPanel;

import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.cityyanderecarcassonne.controller.impl.CarcassonneController;
import de.htwg.cityyanderecarcassonne.model.cards.CardB;
import de.htwg.cityyanderecarcassonne.model.cards.Stock;

public class CardPanelTest {

	private ICarcassonneController controller;
	
	@Before
	public void setUp() throws Exception {
		Stock.getInstance().resetStock();
		controller = new CarcassonneController(10, 10);
		controller.create();
	}

	@Test
	public final void testCardPanel() {
		Container cont = new Container();
		JPanel cp = new CardPanel(controller, cont);
		controller.notifyObservers();
	}

	@Test
	public final void testUpdateEvent() {
		Container cont = new Container();
		JPanel cp = new CardPanel(controller, cont);
		
		controller.notifyObservers();
		controller.getCardPossibilitiesMap(new CardB());
		controller.placeCard(new CardB(), "A");
		controller.finish();
	}

}
