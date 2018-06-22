package de.htwg.cityyanderecarcassonne.persistence;

import de.htwg.cityyanderecarcassonne.model.IPlayer;

import java.util.List;

public interface IDAO {

    void savePlayer(IPlayer player);
    IPlayer loadPlayer(int id);
    List<IPlayer> getPlayers();
    void deletePlayer(IPlayer player);

    //saveSaveGame(SaveGame);
    //SaveGame loadSaveGame(int id);
    //List<SaveGame(Meta)> showSaveGames();
}
