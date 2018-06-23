package de.htwg.cityyanderecarcassonne.persistence.hibernate;

import de.htwg.cityyanderecarcassonne.model.impl.Player;
import de.htwg.cityyanderecarcassonne.persistence.IDAO;
import de.htwg.cityyanderecarcassonne.model.IPlayer;
import de.htwg.cityyanderecarcassonne.persistence.ISaveGame;
import de.htwg.cityyanderecarcassonne.persistence.savegame.SaveGame;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class HibernateDAO implements IDAO {

    @Override
    public void saveGame(ISaveGame saveGame) {
        Transaction tx = null;
        Session session;

        try {
            session = HibernateUtil.getInstance().getCurrentSession();
            tx = session.beginTransaction();

            PersistentSaveGame pSaveGame = convertSaveGame(saveGame);

            session.saveOrUpdate(pSaveGame);
            saveGame.setSaveGameId(pSaveGame.saveGameId);

            for (PersistentPlayer pplayer : pSaveGame.getPlayerList()) {
                session.saveOrUpdate(pplayer);
            }

            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public ISaveGame loadSaveGame(int id) {
        Transaction tx = null;
        Session session;
        ISaveGame saveGame;
        try {
            session = HibernateUtil.getInstance().getCurrentSession();
            tx = session.beginTransaction();
            saveGame = convertSaveGame(session.get(PersistentSaveGame.class, id));
            tx.commit();
            return saveGame;
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw new RuntimeException(ex.getMessage());
        }
    }

    private PersistentPlayer convertPlayer(PersistentSaveGame pSaveGame, IPlayer player) {
        PersistentPlayer pplayer = new PersistentPlayer();

        pplayer.setName(player.getName());
        pplayer.setSumMeeples(player.getSumMeeples());
        pplayer.setScore(player.getScore());
        pplayer.setSavegame(pSaveGame);

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
        PersistentSaveGame pSaveGame;
        int saveGameId = saveGame.getSaveGameId();

        Session session = HibernateUtil.getInstance().getCurrentSession();

        if (saveGameId > 0 && existsSaveGameById(session, saveGameId)) {
            // SaveGame was saved at least once

            pSaveGame = session.get(PersistentSaveGame.class, saveGameId);

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
        }

        return pSaveGame;
    }

    private ISaveGame convertSaveGame(PersistentSaveGame pSaveGame) {
        ISaveGame saveGame = new SaveGame();
        saveGame.setSaveGameId(pSaveGame.saveGameId);

        List<IPlayer> playerList = new LinkedList<>();
        for (PersistentPlayer pp : pSaveGame.getPlayerList()) {
            playerList.add(convertPlayer(pp));
        }
        saveGame.setPlayerList(playerList);

        return saveGame;
    }

    private boolean existsSaveGameById(Session session, int saveGameId) {
        return (convertSaveGame(session.get(PersistentSaveGame.class, saveGameId)) != null);
    }
}
