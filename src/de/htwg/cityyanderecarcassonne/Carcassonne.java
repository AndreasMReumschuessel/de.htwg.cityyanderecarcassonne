package de.htwg.cityyanderecarcassonne;

import java.io.IOException;
import java.util.Scanner;

import de.htwg.cityyanderecarcassonne.controller.impl.CarcassonneController;
import de.htwg.cityyanderecarcassonne.view.tui.TextUI;

public final class Carcassonne {
	
	private static CarcassonneController controller;
	private static TextUI tui;
	private static Scanner in;
	
	private static de.htwg.cityyanderecarcassonne.view.gui.GraphicalUI gui2;
	
	private Carcassonne() {
		
	}

	public static void main(String[] args) throws IOException {		
		
		controller = new CarcassonneController(10, 10);
		tui = new TextUI(controller);
		tui.printTUI();
		
		gui2 = new de.htwg.cityyanderecarcassonne.view.gui.GraphicalUI(controller);
		
		boolean continu = true;
        in = new Scanner(System.in);
        while (continu) {
            continu = tui.processInput(in.next());
        }
        in.close();
        
        
	}

}
