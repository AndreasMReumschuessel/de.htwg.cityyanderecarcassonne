package de.htwg.cityyanderecarcassonne.model;

import java.util.List;

import de.htwg.cityyanderecarcassonne.model.graph.Graph;

public interface ICard {
	
	public IRegion getTopLeft();
	
	public IRegion getTopMiddle();
	
	public IRegion getTopRight();
	
	public IRegion getLeftTop();
	
	public IRegion getRightTop();
	
	public IRegion getLeftMiddle();
	
	public IRegion getCenterMiddle();
	
	public IRegion getRightMiddle();
	
	public IRegion getLeftBelow();
	
	public IRegion getRightBelow();
	
	public IRegion getBelowLeft();
	
	public IRegion getBelowMiddle();
	
	public IRegion getBelowRight();
	
	public Graph<IRegion> getCardGraph();
	
	public List<IRegion> getRegionList();
	
	public ICard rotateLeft();
	
	public ICard rotateRight();
	
	public List<IRegion> getRegionPossibilities();
}
