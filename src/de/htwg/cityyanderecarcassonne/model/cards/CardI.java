package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardI extends MasterCard {
	
	public CardI() {
		super();
		this.topLeft = new RegionLawn();
		this.topMiddle = new RegionLawn();
		this.topRight = new RegionLawn();
		
		this.leftTop = new RegionLawn();
		this.rightTop = new RegionBuilding();
		
		this.leftMiddle = new RegionLawn();
		this.centerMiddle = new RegionLawn();
		this.rightMiddle = new RegionBuilding();
		
		this.leftBelow = new RegionLawn();
		this.rightBelow = new RegionBuilding();
		
		this.belowLeft = new RegionBuilding();
		this.belowMiddle = new RegionBuilding();
		this.belowRight = new RegionBuilding();
		
		genCardGraph();
		setUniqueIDs();
	}
	
	private void setUniqueIDs() {
		int lawnID = IDManager.getLawnID();
		int buildingID1 = IDManager.getBuildingID();
		int buildingID2 = IDManager.getBuildingID();
		
		topLeft.setID(lawnID);
		topMiddle.setID(lawnID);
		topRight.setID(lawnID);
		
		leftTop.setID(lawnID);
		rightTop.setID(buildingID1);
		
		leftMiddle.setID(lawnID);
		centerMiddle.setID(lawnID);
		rightMiddle.setID(buildingID1);
		
		leftBelow.setID(lawnID);
		rightBelow.setID(buildingID1);
		
		belowLeft.setID(buildingID2);
		belowMiddle.setID(buildingID2);
		belowRight.setID(buildingID2);
	}
}
