package de.htwg.cityyanderecarcassonne.controller;

import java.util.HashMap;
import java.util.Map;

public enum GameStatus {
	WELCOME(0),
	PLAYER_ADDED(1),
	PLAYER_CHANGED(2),
    CREATE(3),
    CARD_ROTATED(4),
    CARD_SET_SUCCESS(5),
    CARD_SET_FAIL(6),
    MEEPLE_SET_SUCCESS(7),
    MEEPLE_SET_FAIL(8),
    ILLEGAL_ARGUMENT(9),
    SHOW_CANDIDATES(10),
    ROUND_START(11),
    TAKE_CARD(12),
    ROUND_END(13),
    FINISH(14);

    private int value;
    private static Map map = new HashMap<>();

    private GameStatus(int value) {
        this.value = value;
    }

    static {
        for (GameStatus gameStatus : GameStatus.values()) {
            map.put(gameStatus.value, gameStatus);
        }
    }

    public static GameStatus valueOf(int gameStatus) {
        return (GameStatus) map.get(gameStatus);
    }

    public int getValue() {
        return value;
    }
}
