package de.htwg.cityyanderecarcassonne.model.regions;

import de.htwg.cityyanderecarcassonne.model.IPlayer;
import de.htwg.cityyanderecarcassonne.model.IRegion;

public abstract class MasterRegion implements IRegion{

	protected String typename;
	protected IPlayer player;
	protected int id;
	protected boolean openBorder;
	
	public MasterRegion() {
		super();
		this.openBorder = true;
	}

	@Override
	public void setPlayer(IPlayer player) {
		this.player = player;
	}

	@Override
	public IPlayer getPlayer() {
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
	public void setOpenBorder(boolean value) {
		openBorder = value;
	}
	
	@Override
	public boolean getOpenBorder() {
		return openBorder;
	}
	
	@Override
	public String toString() {
		return "Type: " + typename + " Player: " + player + " ID: " + id;
	}
}
