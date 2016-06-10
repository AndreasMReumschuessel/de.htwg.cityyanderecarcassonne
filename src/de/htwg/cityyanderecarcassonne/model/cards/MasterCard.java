package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.graph.AdjacencyListUndirectedGraph;
import de.htwg.cityyanderecarcassonne.model.graph.Graph;
import de.htwg.cityyanderecarcassonne.model.ICard;

public abstract class MasterCard implements ICard {

	protected IRegion leftTopOne;
	protected IRegion middleTop;
	protected IRegion rightTopOne;
	
	protected IRegion leftTopTwo;
	protected IRegion rightTopTwo;
	
	protected IRegion leftCenter;
	protected IRegion middleCenter;
	protected IRegion rightCenter;
	
	protected IRegion leftBelowTwo;
	protected IRegion rightBelowTwo;
	
	protected IRegion leftBelowOne;
	protected IRegion middleBelow;
	protected IRegion rightBelowOne;
	
	private Graph<IRegion> cardGraph;
	
	protected MasterCard() {
		super();
	}
	
	protected void genCardGraph() {
		cardGraph = new AdjacencyListUndirectedGraph<>();
		
		cardGraph.addVertex(leftTopOne);
		cardGraph.addVertex(middleTop);
		cardGraph.addVertex(rightTopOne);
		cardGraph.addVertex(leftTopTwo);
		cardGraph.addVertex(rightTopTwo);
		cardGraph.addVertex(leftCenter);
		cardGraph.addVertex(middleCenter);
		cardGraph.addVertex(rightCenter);
		cardGraph.addVertex(leftBelowTwo);
		cardGraph.addVertex(rightBelowTwo);
		cardGraph.addVertex(leftBelowOne);
		cardGraph.addVertex(middleBelow);
		cardGraph.addVertex(rightBelowOne);
		
		cardGraph.addEdge(leftTopOne, middleTop);
		cardGraph.addEdge(middleTop, rightTopOne);
		cardGraph.addEdge(rightTopOne, rightTopTwo);
		cardGraph.addEdge(rightTopTwo, rightCenter);
		cardGraph.addEdge(rightCenter, rightBelowTwo);
		cardGraph.addEdge(rightBelowTwo, rightBelowOne);
		cardGraph.addEdge(rightBelowOne, middleBelow);
		cardGraph.addEdge(middleBelow, leftBelowOne);
		cardGraph.addEdge(leftBelowOne, leftBelowTwo);
		cardGraph.addEdge(leftBelowTwo, leftCenter);
		cardGraph.addEdge(leftCenter, leftTopTwo);
		cardGraph.addEdge(leftTopTwo, leftTopOne);
		
		cardGraph.addEdge(leftTopOne, leftBelowOne);
		cardGraph.addEdge(rightTopOne, rightBelowOne);
		cardGraph.addEdge(leftTopTwo, rightTopTwo);
		cardGraph.addEdge(leftBelowTwo, rightBelowTwo);
		
		cardGraph.addEdge(middleTop, middleCenter);
		cardGraph.addEdge(rightCenter, middleCenter);
		cardGraph.addEdge(middleBelow, middleCenter);
		cardGraph.addEdge(leftCenter, middleCenter);
	}

	@Override
	public IRegion getLeftTopOne() {
		return leftTopOne;
	}

	@Override
	public IRegion getMiddleTop() {
		return middleTop;
	}

	@Override
	public IRegion getRightTopOne() {
		return rightTopOne;
	}

	@Override
	public IRegion getLeftTopTwo() {
		return leftTopTwo;
	}

	@Override
	public IRegion getRightTopTwo() {
		return rightTopTwo;
	}

	@Override
	public IRegion getLeftCenter() {
		return leftCenter;
	}

	@Override
	public IRegion getMiddleCenter() {
		return middleCenter;
	}

	@Override
	public IRegion getRightCenter() {
		return rightCenter;
	}

	@Override
	public IRegion getLeftBelowTwo() {
		return leftBelowTwo;
	}

	@Override
	public IRegion getRightBelowTwo() {
		return rightBelowTwo;
	}

	@Override
	public IRegion getLeftBelowOne() {
		return leftBelowOne;
	}

	@Override
	public IRegion getMiddleBelow() {
		return middleBelow;
	}

	@Override
	public IRegion getRightBelowOne() {
		return rightBelowOne;
	}

	@Override
	public Graph<IRegion> getCardGraph() {
		return cardGraph;
	}
	
}
