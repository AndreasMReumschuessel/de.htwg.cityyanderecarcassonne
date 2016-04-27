package de.htwg.cityyanderecarcassonne.module;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RegionTest {
	
	private Region region;
	private Player player1;
	private Type type;

	@Before
	public void setUp() throws Exception {
		region = new Region(new Type("lawn"));
	}

	@Test
	public void testRegion() {
		type = new Type("street");
		region.setType(type);
		assertEquals(type,region.getType());
		type = new Type("building");
		region.setType(type);
		assertEquals(type,region.getType());
		type = new Type("lawn");
		region.setType(type);
		assertEquals(type,region.getType());
	}
	
	@Test
	public void testGetType() {
		type = new Type("street");
		region.setType(type);
		assertEquals(type,region.getType());
		type = new Type("building");
		region.setType(type);
		assertEquals(type,region.getType());
		type = new Type("lawn");
		region.setType(type);
		assertEquals(type,region.getType());
	}
	
	@Test
	public void testGetPlayer() {
		player1 = new Player("Otto");
		region.setPlayer(player1);
		assertEquals(player1, region.getPlayer());
		player1 = new Player("Marie");
		region.setPlayer(player1);
		assertEquals(player1, region.getPlayer());
	}
}