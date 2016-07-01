package de.htwg.cityyanderecarcassonne.model;


public interface IRegion {
	
	void setPlayer(IPlayer player);
	
	IPlayer getPlayer();
	
	void setID(int id);
	
	int getID();

	void setOpenBorder(boolean value);

	boolean getOpenBorder();
}
