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
		assertEquals(2,north.getType());
		card.setEdgeNorth(north);
		assertEquals(2,card.getEdgeNorth().getType());
    }

	@Test
    public void testGetEdgeEast() {
		east = new Edge(2);
		assertEquals(2,east.getType());
		card.setEdgeEast(east);
		assertEquals(2,card.getEdgeEast().getType());
    }

	@Test
    public void testGetEdgeSouth() {
		south = new Edge(2);
		assertEquals(2,south.getType());
		card.setEdgeSouth(south);
		assertEquals(2,card.getEdgeSouth().getType());
    }

	@Test
    public void testGetEdgeWest() {
		west = new Edge(2);
		assertEquals(2,west.getType());
		card.setEdgeWest(west);
		assertEquals(2,card.getEdgeWest().getType());
    }

	@Test
    public void testGetCenter() {
		center = new Center(2);
		assertEquals(2,center.getType());
		card.setCenter(center);
		assertEquals(2,card.getCenter().getType());
    }

	@Test
    public void testSetEdgeNorth() {
		north = new Edge(2);
		assertEquals(2,north.getType());
		card.setEdgeNorth(north);
		assertEquals(2,card.getEdgeNorth().getType());
    }

	@Test
    public void testSetEdgeEast() {
		east = new Edge(2);
		assertEquals(2,east.getType());
		card.setEdgeEast(east);
		assertEquals(2,card.getEdgeEast().getType());
    }

	@Test
    public void testSetEdgeSouth() {
		south = new Edge(2);
		assertEquals(2,south.getType());
		card.setEdgeSouth(south);
		assertEquals(2,card.getEdgeSouth().getType());
    }

	@Test
    public void testSetEdgeWest() {
		west = new Edge(2);
		assertEquals(2,west.getType());
		card.setEdgeWest(west);
		assertEquals(2,card.getEdgeWest().getType());
    }

	@Test
    public void testSetCenter() {
		center = new Center(2);
		assertEquals(2,center.getType());
		card.setCenter(center);
		assertEquals(2,card.getCenter().getType());
    }
}
