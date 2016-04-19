package de.htwg.cityyanderecarcassonne.module;

/**
 * Created by anreumsc on 15.04.2016.
 */
public class Center {

    private int type;
    private Player player;

    public Center(int type) {
        setType(type);
    }

    public int getType() {
        return this.type;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}