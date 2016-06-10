package de.htwg.cityyanderecarcassonne.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.model.regions.RegionLawn;

public class IRegionTest {

	private IRegion region;
	
	@Before
	public void setUp() throws Exception {
		region = new RegionLawn();
	}
	
	@Test
	public void testGetPlayer() {
		Player player;
		
		player = new Player("Otto");
		region.setPlayer(player);
		assertEquals(player, region.getPlayer());
		
		player = new Player("Marie");
		region.setPlayer(player);
		assertEquals(player, region.getPlayer());
	}
	
	@Test
	public void testGetID() {
		int id;
		
		id = 100;
		region.setID(id);
		assertEquals(id, region.getID());
		
		id = 200;
		region.setID(id);
		assertEquals(id, region.getID());
	}
}
