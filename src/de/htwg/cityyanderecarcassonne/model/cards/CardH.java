package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardH extends MasterCard {
	
	public CardH() {
		super();
		this.topLeft = new RegionLawn();
		this.topMiddle = new RegionLawn();
		this.topRight = new RegionLawn();
		
		this.leftTop = new RegionBuilding();
		this.rightTop = new RegionBuilding();
		
		this.leftMiddle = new RegionBuilding();
		this.centerMiddle = new RegionLawn();
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
		int lawnID = IDManager.getLawnID();
		int buildingID1 = IDManager.getBuildingID();
		int buildingID2 = IDManager.getBuildingID();
		
		topLeft.setID(lawnID);
		topMiddle.setID(lawnID);
		topRight.setID(lawnID);
		
		leftTop.setID(buildingID1);
		rightTop.setID(buildingID2);
		
		leftMiddle.setID(buildingID1);
		centerMiddle.setID(lawnID);
		rightMiddle.setID(buildingID2);
		
		leftBelow.setID(buildingID1);
		rightBelow.setID(buildingID2);
		
		belowLeft.setID(lawnID);
		belowMiddle.setID(lawnID);
		belowRight.setID(lawnID);
	}
}
