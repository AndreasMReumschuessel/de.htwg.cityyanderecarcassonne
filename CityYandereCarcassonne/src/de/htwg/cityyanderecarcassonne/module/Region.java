package de.htwg.cityyanderecarcassonne.module;

/**
 * Created by hekrause on 27.04.2016.
 */
public class Region {

    private Type type;
    private Player player;

    public Region(Type type) {
        setType(type);
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Player getPlayer() {
        return this.player;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }
}
