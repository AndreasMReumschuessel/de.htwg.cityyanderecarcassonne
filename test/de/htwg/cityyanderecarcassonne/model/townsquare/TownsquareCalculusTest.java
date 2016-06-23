package de.htwg.cityyanderecarcassonne.model.townsquare;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.Player;
import de.htwg.cityyanderecarcassonne.model.cards.*;

public class TownsquareCalculusTest {
	private Townsquare ts;
	private Player pa;
	private Player pb;

	@Before
	public void setUp() throws Exception {
		pa = new Player("A");
		pb = new Player("B");
		ts = new Townsquare(50, 50);
		
		ts.setCard(new CardD(), 5, 5);
		ts.setCard(new CardW(), 7, 4);
		ts.setCard(new CardW(), 7, 7);
		
		ICard c1 = new CardU();
		c1.rotateLeft();
		IRegion cr1 = c1.getCenterMiddle();
		ts.placeMeepleOnRegion(pa, cr1);
		ts.setCard(c1, 6, 4);
		
		ICard c2 = new CardU();
		IRegion cr2 = c2.getCenterMiddle();
		ts.placeMeepleOnRegion(pb, cr2);
		ts.setCard(c2, 5, 6);
		
		ICard c3 = new CardU();
		c3.rotateLeft();
		IRegion cr3 = c3.getCenterMiddle();
		ts.placeMeepleOnRegion(pa, cr3);
		ts.setCard(c3, 6, 7);
		
		ICard s1 = new CardV();
		s1.rotateLeft();
		
		ICard s2 = new CardV();
		s2.rotateRight();
		s2.rotateRight();
		
		ts.setCard(s1, 5, 4);
		ts.setCard(s2, 5, 7);
		
		ICard c4 = new CardE();
		c4.rotateLeft();
		IRegion cr4 = c4.getLeftMiddle();		
		ts.setCard(c4, 6, 5);
		ts.placeMeepleOnRegion(pb, cr4);
	}

	@Test
	public final void refreshScoreTest() {
		ts.refreshScore();
		assertEquals(8, pa.getScore());
		assertEquals(4, pb.getScore());
	}

}
