package de.htwg.cityyanderecarcassonne.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.model.Player;
import de.htwg.cityyanderecarcassonne.model.Region;

public class RegionTest {
	
	private Region region;
	private Player player1;
	private String type;

	@Before
	public void setUp() throws Exception {
		region = new Region("lawn");
	}

	@Test
	public void testRegion() {
		type = "street";
		region.setType(type);
		assertEquals(type,region.getType());
		type = "building";
		region.setType(type);
		assertEquals(type,region.getType());
		type = "lawn";
		region.setType(type);
		assertEquals(type,region.getType());
		type = "crossing";
		region.setType(type);
		assertEquals(type,region.getType());
		type = "school";
		region.setType(type);
		assertEquals(type,region.getType());
	}
	
	@Test
	public void testGetType() {
		type = "street";
		region.setType(type);
		assertEquals(type,region.getType());
		type = "building";
		region.setType(type);
		assertEquals(type,region.getType());
		type = "lawn";
		region.setType(type);
		assertEquals(type,region.getType());
		type = "crossing";
		region.setType(type);
		assertEquals(type,region.getType());
		type = "school";
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
	
	@Test
	public void testSetBuilding() {
		type = "building";
		region.setType(type);
		assertEquals("building",region.getType());
	}
	
	@Test
	public void testSetStreet() {
		type = "street";
		region.setType(type);
		assertEquals("street",region.getType());
	}
	
	@Test
	public void testSetLawn() {
		type = "lawn";
		region.setType(type);
		assertEquals("lawn",region.getType());
	}
	
	@Test
	public void testSetCrossing() {
		type = "crossing";
		region.setType(type);
		assertEquals("crossing",region.getType());
	}
	
	@Test
	public void testSetSchool() {
		type = "school";
		region.setType(type);
		assertEquals("school",region.getType());
	}	
}