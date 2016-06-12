package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardFG extends MasterCard {
	
	public CardFG() {
		super();
		this.topLeft = new RegionLawn();
		this.topMiddle = new RegionLawn();
		this.topRight = new RegionLawn();
		
		this.leftTop = new RegionBuilding();
		this.rightTop = new RegionBuilding();
		
		this.leftMiddle = new RegionBuilding();
		this.centerMiddle = new RegionBuilding();
		this.rightMiddle = new RegionBuilding();
		
		this.leftBelow = new RegionBuilding();
		this.rightBelow = new RegionBuilding();
		
		this.belowLeft = new RegionLawn();
		this.belowMiddle = new RegionLawn();
		this.belowRight = new RegionLawn();
		
		genCardGraph();
		setUniqueIDs();
	}
	
	private void setUniqueIDs() {
		int lawnID1 = IDManager.getLawnID();
		int lawnID2 = IDManager.getLawnID();
		int buildingID = IDManager.getBuildingID();
		
		topLeft.setID(lawnID1);
		topMiddle.setID(lawnID1);
		topRight.setID(lawnID1);
		
		leftTop.setID(buildingID);
		rightTop.setID(buildingID);
		
		leftMiddle.setID(buildingID);
		centerMiddle.setID(buildingID);
		rightMiddle.setID(buildingID);
		
		leftBelow.setID(buildingID);
		rightBelow.setID(buildingID);
		
		belowLeft.setID(lawnID2);
		belowMiddle.setID(lawnID2);
		belowRight.setID(lawnID2);
	}
}
