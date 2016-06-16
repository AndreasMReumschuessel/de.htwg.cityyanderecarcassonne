package de.htwg.cityyanderecarcassonne.model;
//update

public class Player {

    private String name;
    private int sumMeeples;
    private int score;
    private final int maxMeeple = 8; 

    public Player(String name) {
        setName(name);
        setScore(0);
        sumMeeples = 8;
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
		if(sumMeeples < maxMeeple)	{
			sumMeeples++;
		}
	}
	
	public void removeMeeple()	{
		if(sumMeeples > 0)	{
			sumMeeples--;
		}
	}
}