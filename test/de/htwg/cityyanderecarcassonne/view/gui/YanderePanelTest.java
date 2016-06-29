package de.htwg.cityyanderecarcassonne.view.gui;


import java.awt.Container;

import javax.swing.JPanel;

import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.cityyanderecarcassonne.controller.impl.CarcassonneController;
import de.htwg.cityyanderecarcassonne.model.cards.Stock;

public class YanderePanelTest {
	
	private ICarcassonneController controller;
	/*
	@Before
	public void setUp() throws Exception {
		Stock.getInstance().resetStock();
		controller = new CarcassonneController(10, 10);
		controller.create();
	}

	@Test
	public final void testYanderePanel() {
		Container cont = new Container();
		JPanel cp = new YanderePanel(controller, cont);
		controller.notifyObservers();
	}

	@Test
	public final void testUpdateEvent() {
		controller.notifyObservers();
	}*/
}
