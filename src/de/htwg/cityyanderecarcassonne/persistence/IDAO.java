package de.htwg.cityyanderecarcassonne.persistence;

public interface IDAO {
    void saveGame(ISaveGame saveGame);
    ISaveGame loadSaveGame(String id);
    //List<SaveGame(Meta)> showSaveGames();
}
