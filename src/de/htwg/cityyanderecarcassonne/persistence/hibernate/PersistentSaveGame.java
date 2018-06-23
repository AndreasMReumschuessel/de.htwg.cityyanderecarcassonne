package de.htwg.cityyanderecarcassonne.persistence.hibernate;

import de.htwg.cityyanderecarcassonne.controller.GameStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "save_game")
public class PersistentSaveGame implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int saveGameId;

    @OneToMany(mappedBy = "savegame")
    @Column(name = "player")
    private List<PersistentPlayer> playerList;

    public List<PersistentPlayer> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<PersistentPlayer> playerList) {
        this.playerList = playerList;
    }
}
