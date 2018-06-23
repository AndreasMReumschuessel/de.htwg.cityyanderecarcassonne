package de.htwg.cityyanderecarcassonne.persistence.savegame;

import de.htwg.cityyanderecarcassonne.model.IPlayer;
import de.htwg.cityyanderecarcassonne.persistence.ISaveGame;

import java.util.List;

public class SaveGame implements ISaveGame{
    private String saveGameId;
    private List<IPlayer> playerList;

    @Override
    public String getSaveGameId() {
        return saveGameId;
    }

    @Override
    public void setSaveGameId(String saveGameId) {
        this.saveGameId = saveGameId;
    }

    @Override
    public List<IPlayer> getPlayerList() {
        return this.playerList;
    }

    @Override
    public void setPlayerList(List<IPlayer> playerList) {
        this.playerList = playerList;
    }
}
