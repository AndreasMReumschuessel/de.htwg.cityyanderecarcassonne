package de.htwg.cityyanderecarcassonne.view.gui;

import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.cityyanderecarcassonne.controller.impl.CarcassonneController;
import de.htwg.cityyanderecarcassonne.model.cards.Stock;

public class GraphicalUITest {
	
	private ICarcassonneController controller;

	@Before
	public void setUp() throws Exception {
		Stock.getInstance().resetStock();
		controller = new CarcassonneController(10, 10);
		controller.create();
	}

	@Test
	public final void testGraphicalUI() {
		GraphicalUI gui = new GraphicalUI(controller);
		controller.notifyObservers();
	}

}
