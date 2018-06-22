package de.htwg.cityyanderecarcassonne.persistence.hibernate;

import de.htwg.cityyanderecarcassonne.model.impl.Player;
import de.htwg.cityyanderecarcassonne.persistence.IDAO;
import de.htwg.cityyanderecarcassonne.model.IPlayer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateDAO implements IDAO {

    @Override
    public void savePlayer(IPlayer player) {
        Transaction tx = null;
        Session session = null;

        try {
            session = HibernateUtil.getInstance().getCurrentSession();
            tx = session.beginTransaction();

            PersistentPlayer pplayer = convertPlayer(player);

            session.saveOrUpdate(pplayer);

            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw new HibernateException(ex.getMessage());
        }
    }

    @Override
    public IPlayer loadPlayer(int id) {
        Session session = HibernateUtil.getInstance().getCurrentSession();
        session.beginTransaction();

        PersistentPlayer pplayer = session.get(PersistentPlayer.class, id);

        return convertPlayer(pplayer);
    }

    @Override
    public List<IPlayer> getPlayers() {
        return null;
    }

    @Override
    public void deletePlayer(IPlayer player) {

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
}
