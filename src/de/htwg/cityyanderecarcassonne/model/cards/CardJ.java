package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardJ extends MasterCard {
	
	public CardJ() {
		super();
		this.topLeft = new RegionBuilding();
		this.topMiddle = new RegionBuilding();
		this.topRight = new RegionBuilding();
		
		this.leftTop = new RegionLawn();
		this.rightTop = new RegionLawn();
		
		this.leftMiddle = new RegionLawn();
		this.centerMiddle = new RegionStreet();
		this.rightMiddle = new RegionStreet();
		
		this.leftBelow = new RegionLawn();
		this.rightBelow = new RegionLawn();
		
		this.belowLeft = new RegionLawn();
		this.belowMiddle = new RegionStreet();
		this.belowRight = new RegionLawn();
		
		genCardGraph();
		setUniqueIDs();
	}
	
	private void setUniqueIDs() {
		int lawnID1 = IDManager.getLawnID();
		int lawnID2 = IDManager.getLawnID();
		int buildingID = IDManager.getBuildingID();
		int streetID = IDManager.getStreetID();
		
		topLeft.setID(buildingID);
		topMiddle.setID(buildingID);
		topRight.setID(buildingID);
		
		leftTop.setID(lawnID1);
		rightTop.setID(lawnID1);
		
		leftMiddle.setID(lawnID1);
		centerMiddle.setID(streetID);
		rightMiddle.setID(streetID);
		
		leftBelow.setID(lawnID1);
		rightBelow.setID(lawnID2);
		
		belowLeft.setID(lawnID1);
		belowMiddle.setID(streetID);
		belowRight.setID(lawnID2);
	}
}
