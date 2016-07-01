package de.htwg.cityyanderecarcassonne.model;

public interface IPlayer {
	
    public void setScore(int score);
    
    public int getScore();

	public String getName();

    public void setName(String name);
    
    public String toString();

	public int getSumMeeples();
	
	public void addMeeple();
	
	public void removeMeeple();
}
