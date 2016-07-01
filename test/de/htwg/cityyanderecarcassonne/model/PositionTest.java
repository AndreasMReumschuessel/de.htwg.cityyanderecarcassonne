package de.htwg.cityyanderecarcassonne.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.model.impl.Position;

public class PositionTest {
	
	private IPosition pos;
	
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
		IPosition p1 = new Position(3, 6);
		IPosition p2 = new Position(3, 6);
		IPosition p3 = new Position(6, 3);
		
		assertTrue(p1.hashCode() == p2.hashCode());
		
		assertFalse(p1.hashCode() == p3.hashCode());
	}
	
	@Test
	public void equalsTest() {
		IPosition p1 = new Position(3, 6);
		IPosition p2 = new Position(3, 6);
		IPosition p3 = new Position(6, 3);
		IPosition p4 = new Position(3, 8);
		
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
		IPosition p = new Position(42, 24);
		
		assertEquals("(42|24)", p.toString());
	}
}
