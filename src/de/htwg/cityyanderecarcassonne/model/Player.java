package de.htwg.cityyanderecarcassonne.model;

public class Player {

    private String name;
    private int sumMeeples;
    private int score;
    private static final int MAX_MEEPLE = 8; 

    public Player(String name) {
    	this.sumMeeples = 8;
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
    
    @Override
    public String toString() {
    	return getName();
    }

	public int getSumMeeples() {
		return sumMeeples;
	}
	
	public void addMeeple()	{
		if(sumMeeples < MAX_MEEPLE)	{
			sumMeeples++;
		}
	}
	
	public void removeMeeple()	{
		if(sumMeeples > 0)	{
			sumMeeples--;
		}
	}
}