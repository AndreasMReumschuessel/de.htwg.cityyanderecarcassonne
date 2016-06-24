package de.htwg.cityyanderecarcassonne;

import java.util.Scanner;

import de.htwg.cityyanderecarcassonne.controller.impl.CarcassonneController;
import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.IScoreCalculus;
import de.htwg.cityyanderecarcassonne.model.Player;
import de.htwg.cityyanderecarcassonne.model.cards.*;
import de.htwg.cityyanderecarcassonne.model.scorecalculus.CalculusRunningGame;
import de.htwg.cityyanderecarcassonne.model.townsquare.Townsquare;
import de.htwg.cityyanderecarcassonne.view.tui.TextUI;

public final class Carcassonne {
	
	private static CarcassonneController controller;
	private static TextUI tui;
	private static Scanner in;
	
	private Carcassonne() {
		
	}

	public static void main(String[] args) {		
		
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
