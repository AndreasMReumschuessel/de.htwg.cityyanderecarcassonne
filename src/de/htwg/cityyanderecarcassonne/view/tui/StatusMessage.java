package de.htwg.cityyanderecarcassonne.view.tui;

import java.util.Hashtable;

import de.htwg.cityyanderecarcassonne.controller.GameStatus;

public class StatusMessage {
	
    static Hashtable<GameStatus,String> text = new Hashtable<GameStatus, String>();

    public StatusMessage() {
        text.put(GameStatus.WELCOME,"Welcome to City Yandere Carcassonne, senpai! I'am Yandere-chan and help you with the game.");
        text.put(GameStatus.CREATE,"Empty Townquare created!");
        text.put(GameStatus.CARD_SET_SUCCESS,"The card was placed successfully ");
        text.put(GameStatus.CARD_SET_FAIL, "You can't place this card there. ");
        text.put(GameStatus.MEEPLE_SET_SUCCESS,"Your meeple was placed successfully ");
        text.put(GameStatus.MEEPLE_SET_FAIL, "You can't place a meeple there. ");
        text.put(GameStatus.ILLEGAL_ARGUMENT, "This is not a valid entry. ");
        text.put(GameStatus.SHOW_CANDIDATES,"Possible positions for this card are shown. ");
        text.put(GameStatus.ROUND_START,"New Round!");
        text.put(GameStatus.TAKE_CARD,"Took a card from the staple");
        text.put(GameStatus.ROUND_END,"Draw finished!");
    }
    
    public String getStatusMessage(GameStatus gs) {
    	return text.get(gs);
    }
}

