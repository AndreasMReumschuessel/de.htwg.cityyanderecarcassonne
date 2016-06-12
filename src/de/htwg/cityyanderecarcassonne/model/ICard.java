package de.htwg.cityyanderecarcassonne.model;

import de.htwg.cityyanderecarcassonne.model.graph.Graph;

public interface ICard {
	
	IRegion getTopLeft();
	
	IRegion getTopMiddle();
	
	IRegion getTopRight();
	
	IRegion getLeftTop();
	
	IRegion getRightTop();
	
	IRegion getLeftMiddle();
	
	IRegion getCenterMiddle();
	
	IRegion getRightMiddle();
	
	IRegion getLeftBelow();
	
	IRegion getRightBelow();
	
	IRegion getBelowLeft();
	
	IRegion getBelowMiddle();
	
	IRegion getBelowRight();
	
	Graph<IRegion> getCardGraph();
	
	void rotateLeft();
	
	void rotateRight();
}
