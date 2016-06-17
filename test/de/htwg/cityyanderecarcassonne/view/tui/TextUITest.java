package de.htwg.cityyanderecarcassonne.view.tui;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.controller.impl.CarcassonneController;

public class TextUITest {
	
	private static CarcassonneController controller;
	private static TextUI tui;

	@Before
	public void setUp() throws Exception {
		controller = new CarcassonneController(10, 10);
		tui = new TextUI(controller);
	}

	@Test
	public void updateTest() {
		tui.update(null);
		assertTrue(true);
	}

	@Test
	public void processInputTest() {
		assertFalse(tui.processInput("q"));
	}

	@Test
	public void printTUITest() {
		tui.printTUI();
		assertTrue(true);
	}

}
