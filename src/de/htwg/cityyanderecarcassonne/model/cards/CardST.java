package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardST extends MasterCard {
	
	public CardST() {
		super();
		this.topLeft = new RegionBuilding();
		this.topMiddle = new RegionBuilding();
		this.topRight = new RegionBuilding();
		
		this.leftTop = new RegionBuilding();
		this.rightTop = new RegionBuilding();
		
		this.leftMiddle = new RegionBuilding();
		this.centerMiddle = new RegionBuilding();
		this.rightMiddle = new RegionBuilding();
		
		this.leftBelow = new RegionBuilding();
		this.rightBelow = new RegionBuilding();
		
		this.belowLeft = new RegionLawn();
		this.belowMiddle = new RegionStreet();
		this.belowRight = new RegionLawn();
		
		genCardGraph();
		setUniqueIDs();
	}
	
	private void setUniqueIDs() {
		int lawnID1 = IDManager.getLawnID();
		int streetID1 = IDManager.getStreetID();
		int buildingID1 = IDManager.getBuildingID();
		
		topLeft.setID(buildingID1);
		topMiddle.setID(buildingID1);
		topRight.setID(buildingID1);
		
		leftTop.setID(buildingID1);
		rightTop.setID(buildingID1);
		
		leftMiddle.setID(buildingID1);
		centerMiddle.setID(buildingID1);
		rightMiddle.setID(buildingID1);
		
		leftBelow.setID(buildingID1);
		rightBelow.setID(lawnID1);
		
		belowLeft.setID(lawnID1);
		belowMiddle.setID(streetID1);
		belowRight.setID(lawnID1);
	}
}
