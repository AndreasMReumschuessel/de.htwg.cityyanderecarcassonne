package de.htwg.cityyanderecarcassonne;

import java.io.IOException;
import java.util.Scanner;

import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.cityyanderecarcassonne.controller.impl.CarcassonneController;
import de.htwg.cityyanderecarcassonne.view.gui.GraphicalUI;
import de.htwg.cityyanderecarcassonne.view.tui.TextUI;

public final class Carcassonne {
	
	private ICarcassonneController controller;
	private TextUI tui;
	private GraphicalUI gui;

	private static Carcassonne instance = null;
	
	private Carcassonne(int sizeX, int sizeY, boolean consolePrint, boolean variablePrint) {
		controller = new CarcassonneController(sizeX, sizeY);
		tui = new TextUI(controller, consolePrint, variablePrint);

		gui = new GraphicalUI(controller);
	}

	public static Carcassonne getInstance(int sizeX, int sizeY, boolean consolePrint, boolean variablePrint) {
		if (instance == null) {
			return new Carcassonne(sizeX, sizeY, consolePrint, variablePrint);
		}

		return instance;
	}

	public TextUI getTui() {
		return tui;
	}

	public GraphicalUI getGui() {
		return gui;
	}

	public ICarcassonneController getController() {
		return controller;
	}

	public static void main(String[] args) throws IOException {
		Carcassonne game = Carcassonne.getInstance(15, 15, true, false);
		game.tui.printTUI();

		Scanner in;
		boolean continu = true;
        in = new Scanner(System.in);
        while (continu) {
            continu = game.tui.processInput(in.next());
        }
        in.close();
        
        
	}

}
