package de.htwg.cityyanderecarcassonne.model;

import java.util.List;

public interface IDao {

    public void addPlayer(IPlayer player);
    public List<IPlayer> getPlayers();
    public void updatePlayer(IPlayer player);
    // public void deletePlayer(IPlayer player);


}
