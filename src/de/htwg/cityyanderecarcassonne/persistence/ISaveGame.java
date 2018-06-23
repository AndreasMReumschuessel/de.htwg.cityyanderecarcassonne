package de.htwg.cityyanderecarcassonne.persistence;

import de.htwg.cityyanderecarcassonne.model.IPlayer;

import java.util.List;

public interface ISaveGame {
    int getSaveGameId();
    void setSaveGameId(int saveGameId);

    List<IPlayer> getPlayerList();
    void setPlayerList(List<IPlayer> playerList);
}
