package de.htwg.cityyanderecarcassonne.module;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TypeTest {

	private Type type;
	
	@Before
	public void setUp() throws Exception {
		type = new Type("street");
	}

	@Test
	public void testType() {
		assertEquals("street", type.getType());
		
		type = new Type("wiese");
		assertEquals(null, type.getType());
		
		type = new Type("building");
		assertEquals("building", type.getType());
		
		type = new Type("lawn");
		assertEquals("lawn", type.getType());
	}
	
	@Test
	public void testGetType() {
		type.setBuilding();
		assertEquals("building", type.getType());
		type.setLawn();
		assertEquals("lawn", type.getType());
		type.setStreet();
		assertEquals("street", type.getType());
	}

}
