package de.htwg.cityyanderecarcassonne.persistence;

import de.htwg.cityyanderecarcassonne.model.IPlayer;

import java.util.List;

public interface IDAO {

    void addPlayer(IPlayer player);
    List<IPlayer> getPlayers();
    void updatePlayer(IPlayer player);
    //void deletePlayer(IPlayer player);


}
