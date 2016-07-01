package de.htwg.cityyanderecarcassonne.model.impl;

import de.htwg.cityyanderecarcassonne.model.IPlayer;

public class Player implements IPlayer{

    private String name;
    private int sumMeeples;
    private int score;
    private static final int MAX_MEEPLE = 8; 

    public Player(String name) {
    	this.sumMeeples = MAX_MEEPLE;
        setName(name);
        setScore(0);
    }

    @Override
    public void setScore(int score) {
    	this.score = score;
	}
    
    @Override
    public int getScore() {
    	return this.score;
	}

    @Override
	public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
    	return getName();
    }

    @Override
	public int getSumMeeples() {
		return sumMeeples;
	}
	
    @Override
	public void addMeeple()	{
		if(sumMeeples < MAX_MEEPLE)	{
			sumMeeples++;
		}
	}
	
    @Override
	public void removeMeeple()	{
		if(sumMeeples > 0)	{
			sumMeeples--;
		}
	}
}