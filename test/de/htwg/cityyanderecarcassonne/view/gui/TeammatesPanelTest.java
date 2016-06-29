package de.htwg.cityyanderecarcassonne.view.gui;


import java.awt.Container;


import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.cityyanderecarcassonne.controller.impl.CarcassonneController;
import de.htwg.cityyanderecarcassonne.model.cards.Stock;

public class TeammatesPanelTest {
	
	private ICarcassonneController controller;

	@Before
	public void setUp() throws Exception {
		Stock.getInstance().resetStock();
		controller = new CarcassonneController(10, 10);
		controller.create();
	}

	@Test
	public final void testTeammatesPanel() {
		Container cont = new Container();
		TeammatesPanel cp = new TeammatesPanel(controller, cont);
		cp.insertColors();
	}

}
