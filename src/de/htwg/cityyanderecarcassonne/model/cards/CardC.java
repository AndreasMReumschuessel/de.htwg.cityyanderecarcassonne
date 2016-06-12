package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardC extends AbstractCardCQRST {
	
	public CardC() {
		super();		
		this.belowLeft = new RegionBuilding();
		this.belowMiddle = new RegionBuilding();
		this.belowRight = new RegionBuilding();
		
		genCardGraph();
		setUniqueIDs();
	}
	
	private void setUniqueIDs() {
		int buildingID = rightBelow.getID();
		
		belowLeft.setID(buildingID);
		belowMiddle.setID(buildingID);
		belowRight.setID(buildingID);
	}
}
