package de.htwg.cityyanderecarcassonne.model.regions;
 
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.model.IPlayer;
import de.htwg.cityyanderecarcassonne.model.impl.Player;

public class RegionBuildingTest	{

	private RegionBuilding region;

	@Before
	public void setUp() throws Exception	{
		region = new RegionBuilding();
	}

	@Test
	public void getPlayerTest() {
		IPlayer player = new Player("Henning");
		region.setPlayer(player);
		assertEquals(player, region.getPlayer());
	}

	@Test
	public void getIDTest() {
		region.setID(200);
		assertEquals(200, region.getID());
	}
	
	@Test
	public void toStringTest() {
		IPlayer player = new Player("Henning");
		region.setPlayer(player);
		region.setID(200);
		assertEquals("Type: Building Player: Henning ID: 200", region.toString());
	}
}