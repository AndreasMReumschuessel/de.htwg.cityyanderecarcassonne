package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardD extends MasterCard {
	
	public CardD() {
		super();
		this.topLeft = new RegionLawn();
		this.topMiddle = new RegionStreet();
		this.topRight = new RegionLawn();
		
		this.leftTop = new RegionLawn();
		this.rightTop = new RegionBuilding();
		
		this.leftMiddle = new RegionLawn();
		this.centerMiddle = new RegionStreet();
		this.rightMiddle = new RegionBuilding();
		
		this.leftBelow = new RegionLawn();
		this.rightBelow = new RegionBuilding();
		
		this.belowLeft = new RegionLawn();
		this.belowMiddle = new RegionStreet();
		this.belowRight = new RegionLawn();
		
		genCardGraph();
		setUniqueIDs();
	}
	
	private void setUniqueIDs() {
		int lawnID1 = IDManager.getLawnID();
		int lawnID2 = IDManager.getLawnID();
		int streetID = IDManager.getStreetID();
		int buildingID = IDManager.getBuildingID();
		
		topLeft.setID(lawnID1);
		topMiddle.setID(streetID);
		topRight.setID(lawnID2);
		
		leftTop.setID(lawnID1);
		rightTop.setID(buildingID);
		
		leftMiddle.setID(lawnID1);
		centerMiddle.setID(streetID);
		rightMiddle.setID(buildingID);
		
		leftBelow.setID(lawnID1);
		rightBelow.setID(buildingID);
		
		belowLeft.setID(lawnID1);
		belowMiddle.setID(streetID);
		belowRight.setID(lawnID2);
	}
}
