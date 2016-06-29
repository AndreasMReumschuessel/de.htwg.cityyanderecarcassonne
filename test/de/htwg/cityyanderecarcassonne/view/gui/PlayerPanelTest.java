package de.htwg.cityyanderecarcassonne.view.gui;


import java.awt.Color;
import java.awt.Container;

import javax.swing.JPanel;

import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.cityyanderecarcassonne.controller.impl.CarcassonneController;
import de.htwg.cityyanderecarcassonne.model.cards.Stock;

public class PlayerPanelTest {
	
	private ICarcassonneController controller;

	@Before
	public void setUp() throws Exception {
		Stock.getInstance().resetStock();
		controller = new CarcassonneController(10, 10);
		controller.addPlayer("Kackstelze");
		controller.addPlayer("Hurtig");
		controller.create();
	}

	@Test
	public final void testPlayerPanel() {
		Container cont = new Container();
		JPanel cp = new PlayerPanel(controller, cont, Color.BLACK, "Kackstelze");
		controller.notifyObservers();
	}

	@Test
	public final void testUpdateEvent() {
		Container cont = new Container();
		JPanel cp = new PlayerPanel(controller, cont, Color.BLACK, "Kackstelze");
		controller.notifyObservers();
		controller.startRound();
		controller.startRound();
		controller.finishRound();
		controller.notifyObservers();
		controller.finish();
	}

}
