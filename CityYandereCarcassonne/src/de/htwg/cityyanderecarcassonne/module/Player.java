package de.htwg.cityyanderecarcassonne.module;

/**
 * Created by anreumsc on 15.04.2016.
 */

public class Player {

    private String name;
    private int score;

    public Player(String name) {
        setName(name);
        setScore(0);
    }

    public void setScore(int score) {
    	this.score = score;
	}
    
    public int getScore() {
    	return this.score;
	}

	public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}