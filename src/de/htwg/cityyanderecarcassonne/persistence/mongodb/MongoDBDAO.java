package de.htwg.cityyanderecarcassonne.persistence.mongodb;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import de.htwg.cityyanderecarcassonne.controller.GameStatus;
import de.htwg.cityyanderecarcassonne.model.IPlayer;
import de.htwg.cityyanderecarcassonne.model.impl.Player;
import de.htwg.cityyanderecarcassonne.persistence.IDAO;
import de.htwg.cityyanderecarcassonne.persistence.ISaveGame;
import de.htwg.cityyanderecarcassonne.persistence.mongodb.pojos.PersistentPlayer;
import de.htwg.cityyanderecarcassonne.persistence.mongodb.pojos.PersistentSaveGame;
import de.htwg.cityyanderecarcassonne.persistence.savegame.SaveGame;
import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

import java.util.LinkedList;
import java.util.List;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoDBDAO implements IDAO {
    private MongoCollection<PersistentSaveGame> collection;

    public MongoDBDAO() {
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://@cyccluster-bxaz4.mongodb.net/test?retryWrites=true"));

        // Create a CodecRegistry containing the PojoCodecProvider instance.
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().register("de.htwg.cityyanderecarcassonne.persistence.mongodb.pojos").build();
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        MongoDatabase db = mongoClient.getDatabase("CYCDatabase").withCodecRegistry(pojoCodecRegistry);

        collection = db.getCollection("SaveGames", PersistentSaveGame.class);
    }

    @Override
    public void saveGame(ISaveGame saveGame) {
        PersistentSaveGame pSaveGame = convertSaveGame(saveGame);

        String saveGameId = saveGame.getSaveGameId();
        if (saveGameId != null && existsSaveGameById(saveGameId)) {
            // SaveGame was saved at least once

            BasicDBObject query = new BasicDBObject("_id", new ObjectId(saveGameId));
            collection.updateOne(query, new Document("$set", pSaveGame));
        } else {
            // SaveGame is a new Entry to the Database

            ObjectId oId = ObjectId.get();
            pSaveGame.setSaveGameId(oId);

            collection.insertOne(pSaveGame);

            saveGame.setSaveGameId(oId.toString());
        }
    }

    @Override
    public ISaveGame loadSaveGame(String id) {
        BasicDBObject query = new BasicDBObject("_id", new ObjectId(id));
        PersistentSaveGame pSaveGame = collection.find(query).first();

        return convertSaveGame(pSaveGame);
    }

    private PersistentPlayer convertPlayer(IPlayer player) {
        PersistentPlayer pplayer = new PersistentPlayer();

        pplayer.setName(player.getName());
        pplayer.setSumMeeples(player.getSumMeeples());
        pplayer.setScore(player.getScore());

        return pplayer;
    }

    private IPlayer convertPlayer(PersistentPlayer pplayer) {
        IPlayer player = new Player(pplayer.getName());
        player.setScore(pplayer.getScore());

        int initMeeple = player.getSumMeeples();
        if (initMeeple > pplayer.getSumMeeples()) {
            for (int i = initMeeple; i > pplayer.getSumMeeples(); i--)
                player.removeMeeple();
        } else {
            for (int i = initMeeple; i < pplayer.getSumMeeples(); i++)
                player.addMeeple();
        }

        return player;
    }

    private PersistentSaveGame convertSaveGame(ISaveGame saveGame) {
        PersistentSaveGame pSaveGame = new PersistentSaveGame();

        pSaveGame.setGameStatus(saveGame.getGameStatus().getValue());

        List<PersistentPlayer> pPlayerList = new LinkedList<>();
        for (IPlayer p : saveGame.getPlayerList()) {
            pPlayerList.add(convertPlayer(p));
        }
        pSaveGame.setPlayerList(pPlayerList);

        return pSaveGame;
    }

    private ISaveGame convertSaveGame(PersistentSaveGame pSaveGame) {
        ISaveGame saveGame = new SaveGame();
        saveGame.setSaveGameId(pSaveGame.getSaveGameId().toString());

        saveGame.setGameStatus(GameStatus.valueOf(pSaveGame.getGameStatus()));

        List<IPlayer> playerList = new LinkedList<>();
        for (PersistentPlayer pp : pSaveGame.getPlayerList()) {
            playerList.add(convertPlayer(pp));
        }
        saveGame.setPlayerList(playerList);

        return saveGame;
    }

     private boolean existsSaveGameById(String saveGameId) {
         BasicDBObject query = new BasicDBObject("_id", new ObjectId(saveGameId));
         return collection.count(query) > 0;
     }
}
