package de.htwg.cityyanderecarcassonne.model.cards;

import java.util.LinkedList;
import java.util.List;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.graph.AdjacencyListUndirectedGraph;
import de.htwg.cityyanderecarcassonne.model.regions.RegionCrossing;
import de.htwg.cityyanderecarcassonne.model.IGraph;
import de.htwg.cityyanderecarcassonne.model.ICard;

public abstract class MasterCard implements ICard {

	protected IRegion topLeft;
	protected IRegion topMiddle;
	protected IRegion topRight;
	
	protected IRegion leftTop;
	protected IRegion rightTop;
	
	protected IRegion leftMiddle;
	protected IRegion centerMiddle;
	protected IRegion rightMiddle;
	
	protected IRegion leftBelow;
	protected IRegion rightBelow;
	
	protected IRegion belowLeft;
	protected IRegion belowMiddle;
	protected IRegion belowRight;
	
	private IGraph<IRegion> cardGraph;
	
	protected MasterCard() {
		super();
	}
	
	protected void genCardGraph() {
		cardGraph = new AdjacencyListUndirectedGraph<>();
		
		cardGraph.addVertex(topLeft);
		cardGraph.addVertex(topMiddle);
		cardGraph.addVertex(topRight);
		cardGraph.addVertex(leftTop);
		cardGraph.addVertex(rightTop);
		cardGraph.addVertex(leftMiddle);
		cardGraph.addVertex(centerMiddle);
		cardGraph.addVertex(rightMiddle);
		cardGraph.addVertex(leftBelow);
		cardGraph.addVertex(rightBelow);
		cardGraph.addVertex(belowLeft);
		cardGraph.addVertex(belowMiddle);
		cardGraph.addVertex(belowRight);
		
		cardGraph.addEdge(topLeft, topMiddle);
		cardGraph.addEdge(topMiddle, topRight);
		cardGraph.addEdge(topRight, rightTop);
		cardGraph.addEdge(rightTop, rightMiddle);
		cardGraph.addEdge(rightMiddle, rightBelow);
		cardGraph.addEdge(rightBelow, belowRight);
		cardGraph.addEdge(belowRight, belowMiddle);
		cardGraph.addEdge(belowMiddle, belowLeft);
		cardGraph.addEdge(belowLeft, leftBelow);
		cardGraph.addEdge(leftBelow, leftMiddle);
		cardGraph.addEdge(leftMiddle, leftTop);
		cardGraph.addEdge(leftTop, topLeft);
		
		cardGraph.addEdge(topLeft, belowLeft);
		cardGraph.addEdge(topRight, belowRight);
		cardGraph.addEdge(leftTop, rightTop);
		cardGraph.addEdge(leftBelow, rightBelow);
		
		cardGraph.addEdge(topMiddle, centerMiddle);
		cardGraph.addEdge(rightMiddle, centerMiddle);
		cardGraph.addEdge(belowMiddle, centerMiddle);
		cardGraph.addEdge(leftMiddle, centerMiddle);
		
		cardGraph.addEdge(rightTop, belowLeft); /* Necessary for CardOP */
		
		this.centerMiddle.setOpenBorder(false); /* Important for calculating Score */
	}

	@Override
	public IRegion getTopLeft() {
		return topLeft;
	}

	@Override
	public IRegion getTopMiddle() {
		return topMiddle;
	}

	@Override
	public IRegion getTopRight() {
		return topRight;
	}

	@Override
	public IRegion getLeftTop() {
		return leftTop;
	}

	@Override
	public IRegion getRightTop() {
		return rightTop;
	}

	@Override
	public IRegion getLeftMiddle() {
		return leftMiddle;
	}

	@Override
	public IRegion getCenterMiddle() {
		return centerMiddle;
	}

	@Override
	public IRegion getRightMiddle() {
		return rightMiddle;
	}

	@Override
	public IRegion getLeftBelow() {
		return leftBelow;
	}

	@Override
	public IRegion getRightBelow() {
		return rightBelow;
	}

	@Override
	public IRegion getBelowLeft() {
		return belowLeft;
	}

	@Override
	public IRegion getBelowMiddle() {
		return belowMiddle;
	}

	@Override
	public IRegion getBelowRight() {
		return belowRight;
	}
	
	@Override
	public IGraph<IRegion> getCardGraph() {
		return cardGraph;
	}
	
	@Override
	public ICard rotateLeft() {
		rotate("left");
		return this;
	}
	
	@Override
	public ICard rotateRight() {
		rotate("right");
		return this;
	}
	
	private void rotate(String direction) {
		IRegion lT = getLeftTop();
		IRegion lM = getLeftMiddle();
		IRegion lB = getLeftBelow();
		
		IRegion bL = getBelowLeft();
		IRegion bM = getBelowMiddle();
		IRegion bR = getBelowRight();
		
		IRegion tL = getTopLeft();
		IRegion tM = getTopMiddle();
		IRegion tR = getTopRight();
		
		IRegion rT = getRightTop();
		IRegion rM = getRightMiddle();
		IRegion rB = getRightBelow();
		
		if ("left".equals(direction)) {
			leftTop = tR;
			leftMiddle = tM;
			leftBelow = tL;
			
			belowLeft = lT;
			belowMiddle = lM;
			belowRight = lB;
			
			topLeft = rT;
			topMiddle = rM;
			topRight = rB;
			
			rightTop = bR;
			rightMiddle = bM;
			rightBelow = bL;
		} else {
			leftTop = bL;
			leftMiddle = bM;
			leftBelow = bR;
			
			belowLeft = rB;
			belowMiddle = rM;
			belowRight = rT;
			
			topLeft = lB;
			topMiddle = lM;
			topRight = lT;
			
			rightTop = tL;
			rightMiddle = tM;
			rightBelow = tR;
		}
	}
	
	@Override
	public List<IRegion> getRegionPossibilities() {
		List<IRegion> rP = new LinkedList<>();
		
		for(IRegion region : this.getRegionList()) {
			if(region.getClass().equals(RegionCrossing.class))
				continue;
			if(!IDManager.isOwned(region.getID())) {
				rP.add(region);
			}
		}
		return rP;
	}
	
	private List<IRegion> getRegionList()	{
		List<IRegion> rP = new LinkedList<>();
		
		rP.add(leftTop);
		rP.add(leftMiddle);
		rP.add(leftBelow);
		
		rP.add(belowLeft);
		rP.add(belowMiddle);
		rP.add(belowRight);
		
		rP.add(centerMiddle);
		
		rP.add(topLeft);
		rP.add(topMiddle);
		rP.add(topRight);
		
		rP.add(rightTop);
		rP.add(rightMiddle);
		rP.add(rightBelow);
		
		return rP;
	}
	
	@Override
	public String toString() {
		return "Card name: " + this.getClass().getSimpleName();
	}
}
