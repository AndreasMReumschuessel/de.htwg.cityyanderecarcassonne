package de.htwg.cityyanderecarcassonne.persistence;

import de.htwg.cityyanderecarcassonne.controller.GameStatus;
import de.htwg.cityyanderecarcassonne.model.IPlayer;

import java.util.List;

public interface ISaveGame {
    String getSaveGameId();
    void setSaveGameId(String saveGameId);

    GameStatus getGameStatus();
    void setGameStatus(GameStatus gameStatus);

    List<IPlayer> getPlayerList();
    void setPlayerList(List<IPlayer> playerList);
}
