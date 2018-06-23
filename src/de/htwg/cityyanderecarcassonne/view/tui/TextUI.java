package de.htwg.cityyanderecarcassonne.view.tui;

import de.htwg.cityyanderecarcassonne.controller.GameStatus;
import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IPlayer;
import de.htwg.cityyanderecarcassonne.view.StatusMessage;
import de.htwg.util.observer.Event;
import de.htwg.util.observer.IObserver;

public class TextUI implements IObserver {
	
	private ICarcassonneController controller;
	private StatusMessage sm;
	private TownsquarePrinter tsPrinter;
	private ICard card;

	private boolean consolePrint, variablePrint;
	private String tuiString;
	
	public TextUI (ICarcassonneController controller2, boolean consolePrint, boolean variablePrint) {
		this.controller = controller2;
		controller2.addObserver(this);
		sm = new StatusMessage();

		this.consolePrint = consolePrint;
		this.variablePrint = variablePrint;
		tuiString = "";
	}

	@Override
	public void update(Event e) {
		printTUI();
	}
	
	public boolean processInput(String line) {
		tuiString = "";
		
		if ("q".equals(line)) {
			printBye();
			return false;
		} else if ("h".equals(line)) {
			printCommands();
		} else if ("c".equals(line)) {
			controller.create();
		} else if (line.startsWith("p")) {
			controller.addPlayer(line.substring(1));
		} else if ("sr".equals(line)) {
			controller.startRound();
			if (controller.getStatus() == GameStatus.FINISH)
				return processInput("q");
		} else if ("np".equals(line)) {
			controller.nextPlayer();
		} else if ("fr".equals(line)) {
			controller.finishRound();
		} else if ("rl".equals(line)) {
			controller.rotateCardLeft();
		} else if ("rr".equals(line)) {
			controller.rotateCardRight();
		} else if (line.matches("s[A-Z]+")) {
			controller.placeCard(card, line.replace("s", ""));
		} else if (line.matches("m[A-Z]")) {
			controller.placeMeeple(controller.getCurrentPlayer(), card, line.replace("m", ""));
		} else if (line.startsWith("sg")) {
		    controller.saveSaveGameDB();
        } else if (line.startsWith("lg")) {
            controller.loadSaveGameDB(line.substring(2));
        } else {
			printCommandUnknown();
		}
		
		printPrompt();
		return true;
	}
	
	public void printTUI() {
		GameStatus status = controller.getStatus();
		IPlayer player = controller.getCurrentPlayer();
		
		if (status != GameStatus.WELCOME && status != GameStatus.PLAYER_ADDED && status != GameStatus.FINISH) {
			if (tsPrinter == null)
				tsPrinter = new TownsquarePrinter(controller.getTownsquare());
			
			if (status == GameStatus.ROUND_START || status == GameStatus.CARD_ROTATED || status == GameStatus.CARD_SET_FAIL) {
				card = controller.cardOnHand();
				printOutln(tsPrinter.printCardPossibilitiesTownsquare(controller.getCardPossibilitiesMap(card)));
			} else if ( status == GameStatus.CARD_SET_SUCCESS || status == GameStatus.MEEPLE_SET_FAIL) {
				if (player.getSumMeeples() > 0) {
					card = controller.cardOnHand();
					printOut(tsPrinter.printMeeplePossibilitiesTownsquare(card, controller.getRegionPossibilitiesMap(card)));
				}
			} else {
				printOut(tsPrinter.printNormalTownsquare());
			}
			printOutln();
		}
		printOutln("Status: " + sm.getStatusMessage(status) + controller.getStatusMessage());
		if (player != null)
			printOutln("Current Player: " + player + " --> Remaining Meeples: " + player.getSumMeeples() + " --> Score: " + player.getScore());
		printOutln();
		if (status == GameStatus.ROUND_START || status == GameStatus.CARD_ROTATED || status == GameStatus.CARD_SET_FAIL) {
			card = controller.cardOnHand();
			printOutln("Actual card to place:");
			printOutln(CardPrinter.printCard(card));
			printOutln("Remaining Cards: " + controller.getRemainingCards());
			printOutln();
		}
		printOutln("For commands enter \'h\'.");
		
		if (status == GameStatus.WELCOME) {
			printPrompt();
		}
	}

	public String getTuiString() {
	    return tuiString;
    }
	
	private void printCommands() {
		printOutln("Commands:");
		printOutln("c:           Create a new Game.");
		printOutln("p[Name]:     Add a Player.");
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
		if (consolePrint)
			System.out.print(x);

		if (variablePrint)
			tuiString += x;
	}
}
