package de.htwg.cityyanderecarcassonne.persistence.mongodb;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import de.htwg.cityyanderecarcassonne.model.IPlayer;
import de.htwg.cityyanderecarcassonne.persistence.IDAO;
import de.htwg.cityyanderecarcassonne.persistence.ISaveGame;
import de.htwg.cityyanderecarcassonne.persistence.mongodb.pojos.PersistentPlayer;
import de.htwg.cityyanderecarcassonne.persistence.mongodb.pojos.PersistentSaveGame;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

import org.bson.codecs.pojo.PojoCodecProvider;

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
        PersistentSaveGame pSaveGame = new PersistentSaveGame();//convertSaveGame(saveGame)
        collection.insertOne(pSaveGame);
    }

    @Override
    public ISaveGame loadSaveGame(int id) {
        return null;
    }

    /*private PersistentSaveGame convertSaveGame(ISaveGame saveGame) {
        PersistentSaveGame pSaveGame;
        int saveGameId = saveGame.getSaveGameId();

        if (saveGameId > 0 && existsSaveGameById(saveGameId)) {
            // SaveGame was saved at least once

            pSaveGame = session.get(PersistentSaveGame.class, saveGameId); // get savegame

            List<PersistentPlayer> pPlayerList = pSaveGame.getPlayerList();
            for (PersistentPlayer pp : pPlayerList) {
                for (IPlayer p : saveGame.getPlayerList()) {
                    if (p.getName().equals(pp.getName())) {
                        pp.setScore(p.getScore());
                        pp.setSumMeeples(p.getSumMeeples());
                    }
                }
            }

        } else {
            // SaveGame is a new Entry to the Database

            pSaveGame = new PersistentSaveGame();

            List<PersistentPlayer> pPlayerList = new LinkedList<>();
            for (IPlayer p : saveGame.getPlayerList()) {
                pPlayerList.add(convertPlayer(pSaveGame, p));
            }
            pSaveGame.setPlayerList(pPlayerList);
        }*/
}
