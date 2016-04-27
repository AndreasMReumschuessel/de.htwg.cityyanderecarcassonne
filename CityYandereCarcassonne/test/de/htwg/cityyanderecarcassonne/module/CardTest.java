package de.htwg.cityyanderecarcassonne.module;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CardTest {
	
	private Card card;
    private Region north;
    private Region east;
    private Region south;
    private Region west;
    private Region center;
    Type type = new Type("street");
	
	@Before
	public void setUp() throws Exception {
		card = new Card(north, east, south, west, center);
	}

	@Test
    public void testGetRegionNorth() {
		north = new Region(type);
		card.setRegionNorth(north);
		assertEquals(north,card.getRegionNorth());
    }

	@Test
    public void testGetRegionEast() {
		east = new Region(type);
		card.setRegionEast(east);
		assertEquals(east,card.getRegionEast());
    }

	@Test
    public void testGetRegionSouth() {
		south = new Region(type);
		card.setRegionSouth(south);
		assertEquals(south,card.getRegionSouth());
    }

	@Test
    public void testGetRegionWest() {
		west = new Region(type);
		card.setRegionWest(west);
		assertEquals(west,card.getRegionWest());
    }

	@Test
    public void testGetRegionCenter() {
		center = new Region(type);
		card.setRegionCenter(center);
		assertEquals(center,card.getRegionCenter());
    }

	@Test
    public void testSetRegionNorth() {
		north = new Region(type);
		card.setRegionNorth(north);
		assertEquals(north,card.getRegionNorth());
    }

	@Test
    public void testSetRegionEast() {
		east = new Region(type);
		card.setRegionEast(east);
		assertEquals(east,card.getRegionEast());
    }

	@Test
    public void testSetRegionSouth() {
		south = new Region(type);
		card.setRegionSouth(south);
		assertEquals(south,card.getRegionSouth());
    }

	@Test
    public void testSetRegionWest() {
		west = new Region(type);
		card.setRegionWest(west);
		assertEquals(west,card.getRegionWest());
    }

	@Test
    public void testSetRegionCenter() {
		center = new Region(type);
		card.setRegionCenter(center);
		assertEquals(center,card.getRegionCenter());
    }	
}
