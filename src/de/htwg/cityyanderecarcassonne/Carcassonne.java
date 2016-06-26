package de.htwg.cityyanderecarcassonne;

import java.util.Scanner;

import de.htwg.cityyanderecarcassonne.controller.impl.CarcassonneController;
import de.htwg.cityyanderecarcassonne.view.guitwo.GraphicalUI;
import de.htwg.cityyanderecarcassonne.view.tui.TextUI;

public final class Carcassonne {
	
	private static CarcassonneController controller;
	private static TextUI tui;
	private static Scanner in;
	
	private static GraphicalUI gui;
	
	private Carcassonne() {
		
	}

	public static void main(String[] args) {		
		
		controller = new CarcassonneController(150, 150);
		tui = new TextUI(controller);
		tui.printTUI();
		
		gui = new GraphicalUI(controller);
		
		boolean continu = true;
        in = new Scanner(System.in);
        while (continu) {
            continu = tui.processInput(in.next());
        }
        in.close();
        
        
	}

}
