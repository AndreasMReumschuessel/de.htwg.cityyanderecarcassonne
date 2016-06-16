package de.htwg.cityyanderecarcassonne.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.model.Player;

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
	
	@Test
    public void toStringTest() {
    	assertEquals("Gustav", player.toString());
    }
	
	@Test
	public void getSumMeeplesTest()	{
		assertEquals(8, player.getSumMeeples());
	}
	
	@Test
	public void addMeepleTest()	{
		player.removeMeeple();
		player.removeMeeple();
		player.addMeeple();
		assertEquals(7, player.getSumMeeples());
		
		player.addMeeple();
		player.addMeeple();
		player.removeMeeple();
		player.removeMeeple();
		player.removeMeeple();
		player.removeMeeple();
		player.removeMeeple();
		player.removeMeeple();
		player.removeMeeple();
		player.removeMeeple();
		player.removeMeeple();
		
	}
	
	@Test
	public void removeMeepleTest()	{
		player.removeMeeple();
		assertEquals(7, player.getSumMeeples());
	}
}