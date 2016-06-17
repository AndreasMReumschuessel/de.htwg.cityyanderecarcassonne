package de.htwg.cityyanderecarcassonne.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PositionTest {
	
	private Position pos;
	
	@Before
	public void setUp() throws Exception {
		pos = new Position(3, 5);
	}
	
	@Test
	public void getXTest() {
		assertEquals(3, pos.getX());
		
		pos.setX(10);
		assertEquals(10, pos.getX());
	}
	
	@Test
	public void getYTest() {
		assertEquals(5, pos.getY());
		
		pos.setY(22);
		assertEquals(22, pos.getY());
	}
	
	@Test
	public void setTest() {
		pos.set(33, 44);
		assertEquals(33, pos.getX());
		assertEquals(44, pos.getY());
	}
	
	@Test
	public void hashCodeTest() {
		Position p1 = new Position(3, 6);
		Position p2 = new Position(3, 6);
		Position p3 = new Position(6, 3);
		
		assertTrue(p1.hashCode() == p2.hashCode());
		
		assertFalse(p1.hashCode() == p3.hashCode());
	}
	
	@Test
	public void equalsTest() {
		Position p1 = new Position(3, 6);
		Position p2 = new Position(3, 6);
		Position p3 = new Position(6, 3);
		Position p4 = new Position(3, 8);
		
		assertTrue(p1.equals(p2));
		assertTrue(p2.equals(p1));
		assertTrue(p1.equals(p1));
		
		assertFalse(p1.equals(p3));
		assertFalse(p3.equals(p1));
		assertFalse(p1.equals(null));
		assertFalse(p1.equals("Hallo"));
		assertFalse(p2.equals(p4));
	}
	
	@Test
	public void toStringTest() {
		Position p = new Position(42, 24);
		
		assertEquals("(42|24)", p.toString());
	}
}
