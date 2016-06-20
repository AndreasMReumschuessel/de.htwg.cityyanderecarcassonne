package de.htwg.cityyanderecarcassonne.controller;

public enum GameStatus {
	WELCOME,
	PLAYER_ADDED,
	PLAYER_CHANGED,
    CREATE,
    CARD_SET_SUCCESS,
    CARD_SET_FAIL,
    MEEPLE_SET_SUCCESS,
    MEEPLE_SET_FAIL,
    ILLEGAL_ARGUMENT,
    SHOW_CANDIDATES,
    ROUND_START,
    TAKE_CARD,
    ROUND_END,
    FINISH
}
