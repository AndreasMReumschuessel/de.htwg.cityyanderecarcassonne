package de.htwg.cityyanderecarcassonne.model;

import de.htwg.cityyanderecarcassonne.model.graph.Graph;

public interface ICard {
	
	IRegion getLeftTopOne();
	
	IRegion getMiddleTop();
	
	IRegion getRightTopOne();
	
	IRegion getLeftTopTwo();
	
	IRegion getRightTopTwo();
	
	IRegion getLeftCenter();
	
	IRegion getMiddleCenter();
	
	IRegion getRightCenter();
	
	IRegion getLeftBelowTwo();
	
	IRegion getRightBelowTwo();
	
	IRegion getLeftBelowOne();
	
	IRegion getMiddleBelow();
	
	IRegion getRightBelowOne();
	
	Graph<IRegion> getCardGraph();
}
