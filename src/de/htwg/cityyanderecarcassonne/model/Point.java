package de.htwg.cityyanderecarcassonne.model;
//update

public class Point {
	
    private Player player;
    private Type type;

    public Point(String typeName) {
    	type = new Type();
    	type.setTypeName(typeName);
    }

    public Type getType() {
        return this.type;
    }
    
    public String getTypeName() {
        return this.type.getTypeName();
    }
    
    public int getTypeID() {
        return this.type.getID();
    }

    public void setTypeName(String typeName) {
    	this.type.setTypeName(typeName);
    }

    public Player getPlayer() {
        return this.player;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }

}
