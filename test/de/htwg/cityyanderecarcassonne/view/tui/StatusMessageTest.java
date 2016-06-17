package de.htwg.cityyanderecarcassonne.view.tui;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.controller.GameStatus;

public class StatusMessageTest {
	
	private StatusMessage sm;

	@Before
	public void setUp() throws Exception {
		sm = new StatusMessage();
	}

	@Test
	public void getStatusMessageTest() {
		assertEquals("Welcome to City Yandere Carcassonne, senpai! I'am Yandere-chan and help you with the game.",
					 sm.getStatusMessage(GameStatus.WELCOME));
	}

}
