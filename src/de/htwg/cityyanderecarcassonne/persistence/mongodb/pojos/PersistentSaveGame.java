package de.htwg.cityyanderecarcassonne.persistence.mongodb.pojos;

import java.util.List;

public class PersistentSaveGame {
    private List<PersistentPlayer> playerList;

    public PersistentSaveGame() {}

    public List<PersistentPlayer> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<PersistentPlayer> playerList) {
        this.playerList = playerList;
    }
}
