package de.htwg.cityyanderecarcassonne.persistence.mongodb.pojos;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.util.List;

@BsonDiscriminator
public class PersistentSaveGame {
    private ObjectId saveGameId;

    private int gameStatus;
    private List<PersistentPlayer> playerList;

    public PersistentSaveGame() {}

    @BsonId
    public ObjectId getSaveGameId() {
        return saveGameId;
    }

    public void setSaveGameId(ObjectId saveGameId) {
        this.saveGameId = saveGameId;
    }

    public int getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(int gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<PersistentPlayer> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<PersistentPlayer> playerList) {
        this.playerList = playerList;
    }
}
