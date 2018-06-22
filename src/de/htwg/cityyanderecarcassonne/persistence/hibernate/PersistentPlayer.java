package de.htwg.cityyanderecarcassonne.persistence.hibernate;

import de.htwg.cityyanderecarcassonne.model.IPlayer;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "player")
public class PersistentPlayer implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "name")
    private String name;

    @Column(name = "sumMeeples")
    private int sumMeeples;

    @Column(name = "score")
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
