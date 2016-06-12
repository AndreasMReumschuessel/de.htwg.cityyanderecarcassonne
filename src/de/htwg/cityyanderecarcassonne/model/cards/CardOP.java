package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardOP extends MasterCard {
	
	public CardOP() {
		super();
		this.topLeft = new RegionBuilding();
		this.topMiddle = new RegionBuilding();
		this.topRight = new RegionBuilding();
		
		this.leftTop = new RegionBuilding();
		this.rightTop = new RegionLawn();
		
		this.leftMiddle = new RegionBuilding();
		this.centerMiddle = new RegionStreet();
		this.rightMiddle = new RegionStreet();
		
		this.leftBelow = new RegionBuilding();
		this.rightBelow = new RegionLawn();
		
		this.belowLeft = new RegionLawn();
		this.belowMiddle = new RegionStreet();
		this.belowRight = new RegionLawn();
		
		genCardGraph();
		//TODO: Edge from rightTopTwo to leftBelowOne
		setUniqueIDs();
	}
	
	private void setUniqueIDs() {
		int lawnID1 = IDManager.getLawnID();
		int lawnID2 = IDManager.getLawnID();
		int streetID1 = IDManager.getStreetID();
		int buildingID1 = IDManager.getBuildingID();
		
		topLeft.setID(buildingID1);
		topMiddle.setID(buildingID1);
		topRight.setID(buildingID1);
		
		leftTop.setID(buildingID1);
		rightTop.setID(lawnID1);
		
		leftMiddle.setID(buildingID1);
		centerMiddle.setID(streetID1);
		rightMiddle.setID(streetID1);
		
		leftBelow.setID(buildingID1);
		rightBelow.setID(lawnID2);
		
		belowLeft.setID(lawnID1);
		belowMiddle.setID(streetID1);
		belowRight.setID(lawnID2);
	}
}
