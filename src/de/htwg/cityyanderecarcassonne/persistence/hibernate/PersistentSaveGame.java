package de.htwg.cityyanderecarcassonne.persistence.hibernate;

import de.htwg.cityyanderecarcassonne.controller.GameStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "save_game")
public class PersistentSaveGame implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    public String saveGameId;

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
