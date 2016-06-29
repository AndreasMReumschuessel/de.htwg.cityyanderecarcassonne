package de.htwg.cityyanderecarcassonne.view.gui;

import static org.junit.Assert.*;


import javax.swing.JFrame;

import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.cityyanderecarcassonne.controller.impl.CarcassonneController;
import de.htwg.cityyanderecarcassonne.model.cards.Stock;

public class MenuBarTest {
	
	private ICarcassonneController controller;

	/*
	@Before
	public void setUp() throws Exception {
		Stock.getInstance().resetStock();
		controller = new CarcassonneController(10, 10);
		controller.create();
	}

	@Test
	public final void testMenuBar() {
		JFrame frame = new JFrame();
		MenuBar cp = new MenuBar(controller, frame);
		controller.notifyObservers();
	}

	@Test
	public final void testInfoPrint() {
		JFrame frame = new JFrame();
		MenuBar cp = new MenuBar(controller, frame);
		String info = cp.infoPrint();
		String infor = "City Yandere Carcassonne!\n" +
				       "Created in 2016\n" +
				       "Info...\n" +
			    	   "Info...\n\n" +
			    	   "Developers:\n" +
			    	   "Andreas M. Reumschuessel\n" +
			    	   "Henning Krause";
		    	
		assertEquals(infor, info);
	}*/
}
