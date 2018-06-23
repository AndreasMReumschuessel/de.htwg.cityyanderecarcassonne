package de.htwg.cityyanderecarcassonne.persistence;

import de.htwg.cityyanderecarcassonne.model.IPlayer;

import java.util.List;

public interface IDAO {
    void saveGame(ISaveGame saveGame);
    ISaveGame loadSaveGame(int id);
    //List<SaveGame(Meta)> showSaveGames();
}
