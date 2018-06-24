package de.htwg.cityyanderecarcassonne.view.tui;

import static org.junit.Assert.*;

import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.controller.impl.CarcassonneController;
import de.htwg.cityyanderecarcassonne.model.cards.Stock;

public class TextUITest {
	
	private static ICarcassonneController controller;
	private static TextUI tui;

	@Before
	public void setUp() throws Exception {
		controller = new CarcassonneController(10, 10);
		tui = new TextUI(controller, true, false);
		Stock.getInstance().resetStock();
	}

	@Test
	public void updateTest() {
		tui.update(null);
		assertTrue(true);
	}

	@Test
	public void processInputTest() {
		assertFalse(tui.processInput("q"));
		assertTrue(tui.processInput("h"));
		assertTrue(tui.processInput("pAmex"));
		assertTrue(tui.processInput("pKotnascher"));
		assertTrue(tui.processInput("c"));
		assertTrue(tui.processInput("sr"));
		assertTrue(tui.processInput("sA"));
		assertTrue(tui.processInput("mA"));
		assertTrue(tui.processInput("rr"));
		assertTrue(tui.processInput("rl"));
		assertTrue(tui.processInput("np"));
		assertTrue(tui.processInput("fr"));
		assertTrue(tui.processInput("lol"));
	}

	@Test
	public void printTUITest() {
		tui.printTUI();
		assertTrue(true);
	}
}
