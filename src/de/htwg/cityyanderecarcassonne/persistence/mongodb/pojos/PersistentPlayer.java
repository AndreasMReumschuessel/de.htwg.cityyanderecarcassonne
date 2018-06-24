package de.htwg.cityyanderecarcassonne.persistence.mongodb.pojos;

import javax.persistence.*;
import java.io.Serializable;

public class PersistentPlayer {

    private int id;
    private String name;
    private int sumMeeples;
    private int score;

    public PersistentPlayer() {}
    public PersistentPlayer(String name, int sumMeeples, int score) {
        this.name = name;
        this.sumMeeples = sumMeeples;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSumMeeples() {
        return sumMeeples;
    }

    public void setSumMeeples(int sumMeeples) {
        this.sumMeeples = sumMeeples;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
