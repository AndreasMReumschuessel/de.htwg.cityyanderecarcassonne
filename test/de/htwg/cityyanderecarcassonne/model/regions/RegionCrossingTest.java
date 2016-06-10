package de.htwg.cityyanderecarcassonne.model.regions;
 
import static org.junit.Assert.*;
import de.htwg.cityyanderecarcassonne.model.Player;
import org.junit.Before;
import org.junit.Test;

public class RegionCrossingTest	{

	private RegionCrossing region;

	@Before
	public void setUp() throws Exception	{
		region = new RegionCrossing();
	}

	@Test
	public void getPlayerTest() {
		Player player = new Player("Henning");
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
		Player player = new Player("Henning");
		region.setPlayer(player);
		region.setID(200);
		assertEquals("Type: Crossing Player: Henning ID: 200", region.toString());
	}
} 