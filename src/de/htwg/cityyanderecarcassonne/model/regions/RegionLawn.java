package de.htwg.cityyanderecarcassonne.model.regions;

import de.htwg.cityyanderecarcassonne.model.Player;
import de.htwg.cityyanderecarcassonne.model.IRegion;

public class RegionLawn implements IRegion {
	
	private String typename = "Lawn";
	private Player player;
	private int id;
	
	public RegionLawn() {
		this.typename = "Lawn";
	}

	@Override
	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public Player getPlayer() {
		return player;
	}

	@Override
	public void setID(int id) {
		this.id = id;
	}

	@Override
	public int getID() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Type: " + typename + " Player: " + player.getName() + " ID: " + id;
	}
}
