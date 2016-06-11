package de.htwg.cityyanderecarcassonne.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IDManagerTest {

	@Before
	public void setUp() throws Exception {
		IDManager.resetIDCount();
	}

	@Test
	public void testGetBuildingID() {
		assertEquals(10000, IDManager.getBuildingID());
		assertEquals(10001, IDManager.getBuildingID());
	}

	@Test
	public void testGetCrossingID() {
		assertEquals(20000, IDManager.getCrossingID());
		assertEquals(20001, IDManager.getCrossingID());
	}

	@Test
	public void testGetLawnID() {
		assertEquals(30000, IDManager.getLawnID());
		assertEquals(30001, IDManager.getLawnID());
	}

	@Test
	public void testGetSchoolID() {
		assertEquals(40000, IDManager.getSchoolID());
		assertEquals(40001, IDManager.getSchoolID());
	}

	@Test
	public void testGetStreetID() {
		assertEquals(50000, IDManager.getStreetID());
		assertEquals(50001, IDManager.getStreetID());
	}

	@Test
	public void testIdUsed() {
		assertTrue(IDManager.idUsed(10000));
		assertTrue(IDManager.idUsed(30001));
	}

	@Test
	public void testResetIDCount() {
		IDManager.resetIDCount();
		assertEquals(50000, IDManager.getStreetID());
		assertFalse(IDManager.idUsed(30001));
	}

}
