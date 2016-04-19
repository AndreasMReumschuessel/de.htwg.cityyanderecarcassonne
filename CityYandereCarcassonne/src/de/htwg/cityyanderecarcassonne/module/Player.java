package de.htwg.cityyanderecarcassonne.module;

/**
 * Created by anreumsc on 15.04.2016.
 */
public class Player {

    private String name;

    public Player(String name) {
        setName(name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}