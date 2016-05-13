package de.htwg.cityyanderecarcassonne.module;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CenterTest {

	private Center center;
	
	@Before
	public void setUp() throws Exception {
		center = new Center(3);
	}
	
	@Test
	public void testCenter() {
		assertEquals(3, center.getType());
	}

	@Test
	public void testGetType() {
		center.setType(1);
		assertEquals(1, center.getType());
		center.setType(2);
		assertEquals(2, center.getType());
	}
	
	@Test
	public void testGetPlayer() {
		Player player1 = new Player("Otto");
		center.setPlayer(player1);
		assertEquals(player1, center.getPlayer());
		
		Player player2 = new Player("Amelie");
		center.setPlayer(player2);
		assertEquals(player2, center.getPlayer());
	}
}