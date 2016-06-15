package de.htwg.cityyanderecarcassonne.view.tui;

import de.htwg.cityyanderecarcassonne.controller.impl.CarcassonneController;
import de.htwg.util.observer.Event;
import de.htwg.util.observer.IObserver;

public class TextUI implements IObserver {
	
	private CarcassonneController controller;
	private StatusMessage sm;
	
	public TextUI (CarcassonneController controller) {
		this.controller = controller;
		controller.addObserver(this);
		sm = new StatusMessage();
	}

	@Override
	public void update(Event e) {
		printTUI();
	}
	
	public boolean processInput(String line) {
		boolean cont = true;
		
		if (line.equals("q")) {
			cont = false;
			return cont;
		} else if (line.equals("h")) {
			printCommands();
		} else if (line.matches("s[A-Z]")) {
			System.out.println("Set card on " + line.substring(1));
		} else {
			printCommandUnknown();
		}
		
		printPrompt();
		return cont;
	}
	
	public void printTUI() {
		System.out.println(controller.getTownsquareString());
		System.out.println();
		System.out.println("Status: " + sm.getStatusMessage(controller.getStatus()));
		System.out.println();
		System.out.println("For commands enter \'h\'.");
		printPrompt();
	}
	
	private void printCommands() {
		System.out.println("Commands:");
		System.out.println("h:           Show Yandere-chan\'s command list.");
		System.out.println("q:           Quit City Yandere Carcassonne.");
		System.out.println("s[Position]: Let Yandere-chan place that card for you on [Position]. E.g. sB places the card on possibility B.");
	}
	
	private void printPrompt() {
		System.out.print("> ");
	}
	
	private void printCommandUnknown() {
		System.out.println("Yandere-chan doesn't know that command. Enter \'h\'");
	}

}
