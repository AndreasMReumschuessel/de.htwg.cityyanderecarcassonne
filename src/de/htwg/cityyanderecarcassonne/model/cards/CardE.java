package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardE extends MasterCard {
	
	public CardE() {
		super();
		this.topLeft = new RegionBuilding();
		this.topMiddle = new RegionBuilding();
		this.topRight = new RegionBuilding();
		
		this.leftTop = new RegionLawn();
		this.rightTop = new RegionLawn();
		
		this.leftMiddle = new RegionLawn();
		this.centerMiddle = new RegionLawn();
		this.rightMiddle = new RegionLawn();
		
		this.leftBelow = new RegionLawn();
		this.rightBelow = new RegionLawn();
		
		this.belowLeft = new RegionLawn();
		this.belowMiddle = new RegionLawn();
		this.belowRight = new RegionLawn();
		
		genCardGraph();
		setUniqueIDs();
	}
	
	private void setUniqueIDs() {
		int lawnID = IDManager.getLawnID();
		int buildingID = IDManager.getBuildingID();
		
		topLeft.setID(buildingID);
		topMiddle.setID(buildingID);
		topRight.setID(buildingID);
		
		leftTop.setID(lawnID);
		rightTop.setID(lawnID);
		
		leftMiddle.setID(lawnID);
		centerMiddle.setID(lawnID);
		rightMiddle.setID(lawnID);
		
		leftBelow.setID(lawnID);
		rightBelow.setID(lawnID);
		
		belowLeft.setID(lawnID);
		belowMiddle.setID(lawnID);
		belowRight.setID(lawnID);
	}
}
