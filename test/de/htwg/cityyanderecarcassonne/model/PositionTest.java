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
}
