package de.htwg.cityyanderecarcassonne.module;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

	private Player player;
	
	@Before
	public void setUp() throws Exception {
		player = new Player("Gustav");
	}

	@Test
	public void testPlayer() {
		assertEquals("Gustav", player.getName());
	}

	@Test
	public void testGetName() {
		player.setName("Horst");
		assertEquals("Horst", player.getName());
		player.setName("Manfred");
		assertEquals("Manfred", player.getName());
	}
}
