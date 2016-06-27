package de.htwg.cityyanderecarcassonne.controller;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class GameStatusTest {

	public GameStatus status = GameStatus.WELCOME;
	
	@Test
	public void enumTest()	{
		Set<String> expected = new HashSet<> (Arrays.asList
				(
				"WELCOME",
				"PLAYER_ADDED",
				"PLAYER_CHANGED",
			    "CREATE",
			    "CARD_ROTATED",
			    "CARD_SET_SUCCESS",
			    "CARD_SET_FAIL",
			    "MEEPLE_SET_SUCCESS",
			    "MEEPLE_SET_FAIL",
			    "ILLEGAL_ARGUMENT",
			    "SHOW_CANDIDATES",
			    "ROUND_START",
			    "TAKE_CARD",
			    "ROUND_END",
			    "FINISH"
				));
		
		Set<String> actual = new HashSet<>();
		for (GameStatus e : GameStatus.values())	{
			actual.add(e.name());
		}
		assertEquals(expected, actual);
	}
	
}
