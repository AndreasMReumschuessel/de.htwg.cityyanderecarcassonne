package de.htwg.cityyanderecarcassonne.model.regions;

import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.Player;

public abstract class MasterRegion implements IRegion{

	protected String typename;
	protected Player player;
	protected int id;
	
	public MasterRegion() {
		super();
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
		return "Type: " + typename + " Player: " + player + " ID: " + id;
	}
}
