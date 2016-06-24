package de.htwg.cityyanderecarcassonne.model.scorecalculus;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.IScoreCalculus;
import de.htwg.cityyanderecarcassonne.model.ITownsquare;
import de.htwg.cityyanderecarcassonne.model.Player;
import de.htwg.cityyanderecarcassonne.model.cards.*;
import de.htwg.cityyanderecarcassonne.model.scorecalculus.CalculusRunningGame;
import de.htwg.cityyanderecarcassonne.model.townsquare.Townsquare;

public class ScoreCalculusTest {
	private ITownsquare ts;
	private Player pa;
	private Player pb;
	private Player pc;
	private Player pd;

	@Before
	public void setUp() throws Exception {
		pa = new Player("A");
		pb = new Player("B");
		pc = new Player("C");
		pd = new Player("D");
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
		
		ICard c16 = new CardB();
		IRegion cr16 = c16.getCenterMiddle();
		ts.setCard(c16, 6, 6);
		ts.placeMeepleOnRegion(pa, cr16);
		
		ICard c17 = new CardU();
		ts.setCard(c17, 7, 5);
		
		ICard c18 = new CardV();
		c18.rotateLeft();
		c18.rotateLeft();
		ts.setCard(c18, 7, 6);
		
		ICard c19 = new CardB();
		ts.setCard(c19, 8, 5);
		
		/* ----------------------------- */
		
		ICard c5 = new CardX();
		IRegion cr5 = c5.getBelowMiddle();
		ts.setCard(c5, 8, 7);
		ts.placeMeepleOnRegion(pa, cr5);
		
		ICard c6 = new CardU();
		IRegion cr6 = c6.getCenterMiddle();
		ts.setCard(c6, 8, 9);
		ts.placeMeepleOnRegion(pb, cr6);
		
		ICard c7 = new CardU();
		IRegion cr7 = c7.getCenterMiddle();
		ts.setCard(c7, 8, 11);
		ts.placeMeepleOnRegion(pb, cr7);
		
		ICard c8 = new CardU();
		IRegion cr8 = c8.getCenterMiddle();
		ts.setCard(c8, 8, 13);
		ts.placeMeepleOnRegion(pc, cr8);
		
		ICard c9 = new CardU();
		IRegion cr9 = c9.getCenterMiddle();
		ts.setCard(c9, 8, 15);
		ts.placeMeepleOnRegion(pc, cr9);
		
		ICard c10 = new CardX();
		IRegion cr10 = c10.getTopMiddle();
		ts.setCard(c10, 8, 17);
		ts.placeMeepleOnRegion(pd, cr10);
		
		ICard c11 = new CardU();
		ts.setCard(c11, 8, 8);
		
		ICard c12 = new CardU();
		ts.setCard(c12, 8, 10);
		
		ICard c13 = new CardU();
		ts.setCard(c13, 8, 12);
		
		ICard c14 = new CardU();
		ts.setCard(c14, 8, 14);
		
		ICard c15 = new CardU();
		ts.setCard(c15, 8, 16);
	}

	@Test
	public final void refreshScoreTest() {
		IScoreCalculus sc = new CalculusRunningGame(ts);
		sc.refreshScore();
		assertEquals(17, pa.getScore());
		assertEquals(15, pb.getScore());
		assertEquals(11, pc.getScore());
		assertEquals(0, pd.getScore());
	}

}
