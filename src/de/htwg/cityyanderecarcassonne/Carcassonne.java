package de.htwg.cityyanderecarcassonne;

import java.util.Scanner;

import de.htwg.cityyanderecarcassonne.controller.impl.CarcassonneController;
import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.ITownsquare;
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
		ITownsquare map = new Townsquare(100, 100);
		
		System.out.println(" 1. D " + map.setCard(new CardD(), 50, 50));
		System.out.println(" 2. L " + map.setCard(new CardL(), 50, 51));
		System.out.println(" 3. M " + map.setCard(new CardMN(), 51, 51));
		System.out.println(" 4. O " + map.setCard(new CardOP(), 49, 51));
		System.out.println(" 5. U " + map.setCard(new CardU(), 50, 49));
		System.out.println(" 6. I " + map.setCard(new CardI(), 51, 49));
		System.out.println(" 7. C " + map.setCard(new CardC(), 51, 50));
		System.out.println(" 8. E " + map.setCard(new CardE(), 49, 49));
		System.out.println(" 9. B " + map.setCard(new CardB(), 48, 50));
		System.out.println("10. I " + map.setCard(new CardI(), 49, 50));
		System.out.println(" 1. D " + map.setCard(new CardD(), 50, 50));
		
		System.out.println("Possibilities for Card H: " + map.getPossibilities(new CardH()));
		System.out.println("Possibilities for Card I: " + map.getPossibilities(new CardI()));
		
		ICard tmp = new CardA();
		tmp.getBelowLeft().setPlayer(new Player("Borat"));
		System.out.println(tmp.toString());
		
		ITownsquare map2 = new Townsquare(2, 2);
		map2.setCard(new CardD(), 0, 1);
		map2.setCard(new CardOP(), 1, 1);
		System.out.println(map.toString());
		*/
		
		controller = new CarcassonneController(10, 10);
		tui = new TextUI(controller);
		//controller.notifyObservers();
		controller.placeCard(new CardD(), 5, 5);
		controller.placeCard(new CardC(), 6, 5);
		/*controller.placeCard(new CardC(), 7, 5);
		controller.placeCard(new CardC(), 8, 5);
		controller.placeCard(new CardC(), 9, 5);
		controller.placeCard(new CardC(), 10, 5);
		controller.placeCard(new CardU(), 5, 6);
		controller.placeCard(new CardU(), 5, 7);
		controller.placeCard(new CardU(), 5, 8);
		controller.placeCard(new CardU(), 5, 9);
		controller.placeCard(new CardU(), 5, 10);*/
		
		boolean continu = true;
        in = new Scanner(System.in);
        while (continu) {
            continu = tui.processInput(in.next());
        }
        in.close();
	}

}
