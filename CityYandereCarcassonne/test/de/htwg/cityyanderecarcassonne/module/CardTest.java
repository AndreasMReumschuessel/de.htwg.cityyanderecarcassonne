package de.htwg.cityyanderecarcassonne.module;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CardTest {
	
	private Card card;
    private Edge north;
    private Edge east;
    private Edge south;
    private Edge west;
    private Center center;
	
	@Before
	public void setUp() throws Exception {
		card = new Card(north, east, south, west, center);
	}

	@Test
    public void testGetEdgeNorth() {
		north = new Edge(2);
		card.setEdgeNorth(north);
		assertEquals(north,card.getEdgeNorth());
    }

	@Test
    public void testGetEdgeEast() {
		east = new Edge(2);
		card.setEdgeEast(east);
		assertEquals(east,card.getEdgeEast());
    }

	@Test
    public void testGetEdgeSouth() {
		south = new Edge(2);
		card.setEdgeSouth(south);
		assertEquals(south,card.getEdgeSouth());
    }

	@Test
    public void testGetEdgeWest() {
		west = new Edge(2);
		card.setEdgeWest(west);
		assertEquals(west,card.getEdgeWest());
    }

	@Test
    public void testGetCenter() {
		center = new Center(2);
		card.setCenter(center);
		assertEquals(center,card.getCenter());
    }

	@Test
    public void testSetEdgeNorth() {
		north = new Edge(2);
		card.setEdgeNorth(north);
		assertEquals(north,card.getEdgeNorth());
    }

	@Test
    public void testSetEdgeEast() {
		east = new Edge(2);
		card.setEdgeEast(east);
		assertEquals(east,card.getEdgeEast());
    }

	@Test
    public void testSetEdgeSouth() {
		south = new Edge(2);
		card.setEdgeSouth(south);
		assertEquals(south,card.getEdgeSouth());
    }

	@Test
    public void testSetEdgeWest() {
		west = new Edge(2);
		card.setEdgeWest(west);
		assertEquals(west,card.getEdgeWest());
    }

	@Test
    public void testSetCenter() {
		center = new Center(2);
		card.setCenter(center);
		assertEquals(center,card.getCenter());
    }
}
