package de.htwg.cityyanderecarcassonne.persistence;

import de.htwg.cityyanderecarcassonne.model.IPlayer;

import java.util.List;

public interface ISaveGame {
    String getSaveGameId();
    void setSaveGameId(String saveGameId);

    List<IPlayer> getPlayerList();
    void setPlayerList(List<IPlayer> playerList);
}
