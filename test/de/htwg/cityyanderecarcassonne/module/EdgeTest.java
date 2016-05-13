package de.htwg.cityyanderecarcassonne.module;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EdgeTest {
	
	private Edge edge;

	@Before
	public void setUp() throws Exception {
		edge = new Edge(3);
	}

	@Test
	public void testEdge() {
		assertEquals(3, edge.getType());
	}
	
	@Test
	public void testGetType() {
		edge.setType(1);
		assertEquals(1, edge.getType());
		edge.setType(2);
		assertEquals(2, edge.getType());
	}
	
	@Test
	public void testGetPlayer() {
		Player player1 = new Player("Otto");
		edge.setPlayer(player1);
		assertEquals(player1, edge.getPlayer());
		
		Player player2 = new Player("Amelie");
		edge.setPlayer(player2);
		assertEquals(player2, edge.getPlayer());
	}
}