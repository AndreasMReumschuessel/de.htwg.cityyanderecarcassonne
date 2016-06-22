package de.htwg.cityyanderecarcassonne;

import java.util.Scanner;

import de.htwg.cityyanderecarcassonne.controller.impl.CarcassonneController;
import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.Player;
import de.htwg.cityyanderecarcassonne.model.cards.*;
import de.htwg.cityyanderecarcassonne.model.townsquare.Townsquare;
import de.htwg.cityyanderecarcassonne.view.tui.TextUI;

public final class Carcassonne {
	
	private static CarcassonneController controller;
	private static TextUI tui;
	private static Scanner in;
	
	private Carcassonne() {
		
	}

	public static void main(String[] args) {
		/*
		Player pa = new Player("A");
		Player pb = new Player("B");
		Townsquare ts = new Townsquare(10, 10);
		ts.setCard(new CardD(), 5, 5);
		ICard c1 = new CardU();
		c1.rotateLeft();
		IRegion cr1 = c1.getCenterMiddle();
		ts.placeMeepleOnRegion(pa, cr1);
		ICard c2 = new CardU();
		IRegion cr2 = c2.getCenterMiddle();
		ts.placeMeepleOnRegion(pb, cr2);
		ICard c3 = new CardU();
		c3.rotateLeft();
		IRegion cr3 = c3.getCenterMiddle();
		ts.placeMeepleOnRegion(pa, cr3);
		ts.setCard(new CardW(), 7, 4);
		ts.setCard(new CardW(), 7, 7);
		ts.setCard(c1, 6, 4);
		ts.setCard(c2, 5, 6);
		ts.setCard(c3, 6, 7);
		ICard s1 = new CardV();
		s1.rotateLeft();
		ICard s2 = new CardV();
		s2.rotateRight();
		s2.rotateRight();
		ts.setCard(s1, 5, 4);
		ts.setCard(s2, 5, 7);
		ts.refreshScore();
		*/
		
		controller = new CarcassonneController(150, 150);
		tui = new TextUI(controller);
		tui.printTUI();
		
		boolean continu = true;
        in = new Scanner(System.in);
        while (continu) {
            continu = tui.processInput(in.next());
        }
        in.close();
        
        
	}

}
