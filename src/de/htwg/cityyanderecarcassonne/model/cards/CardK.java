package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardK extends MasterCard{
	
	public CardK() {
		super();
		this.topLeft = new RegionLawn();
		this.topMiddle = new RegionStreet();
		this.topRight = new RegionLawn();
		
		this.leftTop = new RegionLawn();
		this.rightTop = new RegionBuilding();
		
		this.leftMiddle = new RegionStreet();
		this.centerMiddle = new RegionStreet();
		this.rightMiddle = new RegionBuilding();
		
		this.leftBelow = new RegionLawn();
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
		int streetID1 = IDManager.getStreetID();
		int buildingID1 = IDManager.getBuildingID();
		
		topLeft.setID(lawnID1);
		topMiddle.setID(streetID1);
		topRight.setID(lawnID2);
		
		leftTop.setID(lawnID1);
		rightTop.setID(buildingID1);
		
		leftMiddle.setID(streetID1);
		centerMiddle.setID(streetID1);
		rightMiddle.setID(buildingID1);
		
		leftBelow.setID(lawnID2);
		rightBelow.setID(buildingID1);
		
		belowLeft.setID(lawnID2);
		belowMiddle.setID(lawnID2);
		belowRight.setID(lawnID2);
		
	}
}
