package de.htwg.cityyanderecarcassonne.controller.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.Player;


public class CarcassonneControllerTest {
	
	private CarcassonneController cController;
	
	@Before
	public void setUp() throws Exception {
		cController = new CarcassonneController(100, 110);
	}
	
	@Test
	public void setTownsquareTest() {

	}
	
	@Test
	public void getDimensionXTest() {
		assertEquals(100, cController.getDimensionX());
	}
	
	@Test
	public void getDimensionYTest() {
		assertEquals(110, cController.getDimensionY());
	}
	
	@Test
    public void setStatusTest() {

    }
    
	@Test
    public void getStatusMessageTest() {

    }
    
	@Test
    public void getTownsquareStringTest() {

    }
    
	@Test
    public void getStatusTest() {

    }
	
	@Test
	public void placeCardTest() {

	}

	@Test
	public void takeCardTest() {

	}

	@Test
	public void getPossibilitiesTest() {

	}
	
	@Test
	public void getRegionPossibilitiesTest(ICard card) {

	}

	@Test
	public void placeMeepleTest(Player player,ICard card, IRegion region) {

	}

	@Test
	public void changePlayerTest(Player player) {

	}
	
	@Test
	public void finishRoundTest()	{

	}

	@Test
	public void rotateCardTest(String direction) {

	}
}
