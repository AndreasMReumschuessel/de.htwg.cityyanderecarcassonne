package de.htwg.cityyanderecarcassonne.module;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
//bla

public class PlayerTest {

	private Player player;
	
	@Before
	public void setUp() throws Exception {
		player = new Player("Gustav");
	}

	@Test
	public void testPlayer() {
		assertEquals("Gustav", player.getName());
		assertEquals(0,player.getScore());
	}

	@Test
	public void testGetName() {
		player.setName("Horst");
		assertEquals("Horst", player.getName());
		player.setName("Manfred");
		assertEquals("Manfred", player.getName());
	}
	
	@Test
	public void testGetScore()	{
		player.setScore(10);
		assertEquals(10,player.getScore());
		player.setScore(20);
		assertEquals(20,player.getScore());
	}
	
	@Test
	public void testSetScore()	{
		player.setScore(100);
		assertEquals(100,player.getScore());
		player.setScore(200);
		assertEquals(200,player.getScore());
	}
	
}