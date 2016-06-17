package de.htwg.cityyanderecarcassonne.view.tui;

import de.htwg.cityyanderecarcassonne.controller.GameStatus;
import de.htwg.cityyanderecarcassonne.controller.impl.CarcassonneController;
import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.view.StatusMessage;
import de.htwg.util.observer.Event;
import de.htwg.util.observer.IObserver;

public class TextUI implements IObserver {
	
	private CarcassonneController controller;
	private StatusMessage sm;
	private TownsquarePrinter tsPrinter;
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
		
		if ("q".equals(line)) {
			cont = false;
			printBye();
			return cont;
		} else if ("h".equals(line)) {
			printCommands();
		} else if ("c".equals(line)) {
			controller.create();
		} else if ("sr".equals(line)) {
			controller.startRound();
		} else if ("fr".equals(line)) {
			controller.finishRound();
		} else if ("rl".equals(line)) {
			controller.rotateCardLeft();
		} else if ("rr".equals(line)) {
			controller.rotateCardRight();
		} else if (line.matches("s[A-Z]+")) {
			controller.placeCard(card, line.replace("s", ""));
		} else {
			printCommandUnknown();
		}
		
		printPrompt();
		return cont;
	}
	
	public void printTUI() {
		GameStatus status = controller.getStatus();
		
		if (status != GameStatus.WELCOME) {
			if (tsPrinter == null)
				tsPrinter = new TownsquarePrinter(controller.getTownsquare());
			
			if (status == GameStatus.ROUND_START || status == GameStatus.CARD_SET_FAIL) {
				card = controller.cardOnHand();
				printOutln(tsPrinter.printCardPossibilitiesTownsquare(controller.getPossibilitiesMap(card)));
			} else if (status == GameStatus.CARD_SET_SUCCESS || status == GameStatus.MEEPLE_SET_FAIL) {
				card = controller.cardOnHand();
				printOut(tsPrinter.printMeeplePossibilitiesTownsquare(card, controller.getRegionPossibilities(card)));
				// printOut(printer.printNormalTownsquare());
			} else {
				printOut(tsPrinter.printNormalTownsquare());
			}
			printOutln();
		}
		printOutln("Status: " + sm.getStatusMessage(status));
		printOutln();
		if (status == GameStatus.ROUND_START || status == GameStatus.CARD_SET_FAIL) {
			card = controller.cardOnHand();
			printOutln("Actual card to place:");
			printOutln(CardPrinter.printCard(card));
			printOutln();
		}
		printOutln("For commands enter \'h\'.");
		
		if (status == GameStatus.WELCOME) {
			printPrompt();
		}
	}
	
	private void printCommands() {
		printOutln("Commands:");
		printOutln("c:           Create a new Game.");
		printOutln("sr:          Start a new Round.");
		printOutln("fr:          Finish current Round.");
		printOutln("rl:          Rotate Card counterclockwise.");
		printOutln("rr:          Rotate Card clockwise.");
		printOutln("h:           Show Yandere-chan\'s command list.");
		printOutln("q:           Quit City Yandere Carcassonne.");
		printOutln("s[Position]: Let Yandere-chan place that card for you on [Position]. E.g. sB places the card on possibility B.");
	}
	
	private void printPrompt() {
		printOut("> ");
	}
	
	private void printCommandUnknown() {
		printOutln("Yandere-chan doesn't know that command. Enter \'h\'");
	}
	
	private void printBye() {
		printOutln("Thanks for playing! See you later.");
	}
	
	private void printOutln() {
		printOutln("");
	}
	
	private void printOutln(String x) {
		printOut(x + '\n');
	}
	
	private void printOut(String x) {
		System.out.print(x);
	}
}
