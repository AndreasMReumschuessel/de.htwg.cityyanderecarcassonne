package de.htwg.cityyanderecarcassonne.view.tui;

import de.htwg.cityyanderecarcassonne.controller.GameStatus;
import de.htwg.cityyanderecarcassonne.controller.impl.CarcassonneController;
import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.util.observer.Event;
import de.htwg.util.observer.IObserver;

public class TextUI implements IObserver {
	
	private CarcassonneController controller;
	private StatusMessage sm;
	private TownsquarePrinter printer;
	private ICard card;
	
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
		} else if (line.equals("c")) {
			controller.create();
		} else if (line.equals("sr")) {
			controller.startRound();
		} else if (line.equals("fr")) {
			controller.finishRound();
		} else if (line.equals("rl")) {
			controller.rotateCardLeft();
		} else if (line.equals("rr")) {
			controller.rotateCardRight();
		} else if (line.matches("s[0-9]+")) {
			controller.placeCard(card, Character.getNumericValue(line.charAt(1)), Character.getNumericValue(line.charAt(2)));
		} else {
			printCommandUnknown();
		}
		
		printPrompt();
		return cont;
	}
	
	public void printTUI() {
		GameStatus status = controller.getStatus();
		
		if (status != GameStatus.WELCOME) {
			if (printer == null)
				printer = new TownsquarePrinter(controller.getTownsquare());
			
			//System.out.println(printer.printNormalTownsquare());
			System.out.println(printer.printCardPossibilitiesTownsquare(null));
			System.out.println();
		}
		System.out.println("Status: " + sm.getStatusMessage(status));
		System.out.println();
		if (status == GameStatus.ROUND_START || status == GameStatus.CARD_SET_FAIL || status == GameStatus.MEEPLE_SET_FAIL) {
			card = controller.cardOnHand();
			System.out.println("Actual card to place:");
			System.out.println(card.toString());
			System.out.println();
		}
		System.out.println("For commands enter \'h\'.");
		
		if (status == GameStatus.WELCOME) {
			printPrompt();
		}
	}
	
	private void printCommands() {
		System.out.println("Commands:");
		System.out.println("c:           Create a new Game.");
		System.out.println("sr:          Start a new Round.");
		System.out.println("fr:          Finish current Round.");
		System.out.println("rl:          Rotate Card counterclockwise.");
		System.out.println("rr:          Rotate Card clockwise.");
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
