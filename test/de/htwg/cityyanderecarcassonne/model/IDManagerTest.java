package de.htwg.cityyanderecarcassonne.model;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IDManagerTest {

	@Rule
	public ExpectedException uoe = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		IDManager.resetIDCount();
	}
	
	@Test
	public void testPrivateConstructor() throws UnsupportedOperationException, Exception {
		Constructor<IDManager> c = IDManager.class.getDeclaredConstructor();
		assertTrue(Modifier.isPrivate(c.getModifiers()));
		
		c.setAccessible(true);
		uoe.expect(InvocationTargetException.class);
		c.newInstance();
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
		IDManager.getBuildingID();
		IDManager.getLawnID();
		IDManager.getLawnID();
		assertTrue(IDManager.idUsed(10000));
		assertTrue(IDManager.idUsed(30001));
	}

	@Test
	public void testResetIDCount() {
		IDManager.resetIDCount();
		assertEquals(50000, IDManager.getStreetID());
		assertFalse(IDManager.idUsed(30001));
	}
	
	@Test
	public void setPlayerTest() {
		int id = IDManager.getBuildingID();
		Player player1 = new Player("Hans");
		Player player2 = new Player("Gundula");
		
		assertTrue(IDManager.setPlayer(id, player1));
		assertFalse(IDManager.setPlayer(id, player1));
		assertTrue(IDManager.setPlayer(id, player2));
		
		assertFalse(IDManager.setPlayer(12, player1));
	}
	
	@Test
	public void isOwnedTest() {
		int id1 = IDManager.getBuildingID();
		int id2 = IDManager.getBuildingID();
		Player player1 = new Player("Yuuki Asuna");
		Player player2 = new Player("Kirigaya Kazuto");
		// Write a PM if you know these two ;D
		
		IDManager.setPlayer(id1, player1);
		IDManager.setPlayer(id1, player2);
		
		assertTrue(IDManager.isOwned(id1));
		assertFalse(IDManager.isOwned(id2));
		
		assertFalse(IDManager.isOwned(10));
	}
	
	@Test
	public void getPlayerListTest() {
		int id1 = IDManager.getBuildingID();
		int id2 = IDManager.getLawnID();
		Player player1 = new Player("Max");
		Player player2 = new Player("Bärbel");
		
		IDManager.setPlayer(id1, player1);
		IDManager.setPlayer(id1, player2);
		IDManager.setPlayer(id2, player1);
		
		assertEquals("[Max, Bärbel]", IDManager.getPlayerList(id1).toString());
		assertEquals("[Max]", IDManager.getPlayerList(id2).toString());
		
		assertEquals(null, IDManager.getPlayerList(32));
	}

}
