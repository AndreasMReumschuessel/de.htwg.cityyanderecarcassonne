package de.htwg.cityyanderecarcassonne.model.dao.hibernate;

import de.htwg.cityyanderecarcassonne.model.IPlayer;

import java.io.Serializable;

//@Entity
public class PersistentPlayer implements IPlayer, Serializable {

    @Override
    public void setScore(int score) {

    }

    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public int getSumMeeples() {
        return 0;
    }

    @Override
    public void addMeeple() {

    }

    @Override
    public void removeMeeple() {

    }
}
