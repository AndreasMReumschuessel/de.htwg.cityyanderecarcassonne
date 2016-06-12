package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardMN extends MasterCard {
	
	public CardMN() {
		super();
		this.topLeft = new RegionBuilding();
		this.topMiddle = new RegionBuilding();
		this.topRight = new RegionBuilding();
		
		this.leftTop = new RegionBuilding();
		this.rightTop = new RegionLawn();
		
		this.leftMiddle = new RegionBuilding();
		this.centerMiddle = new RegionLawn();
		this.rightMiddle = new RegionLawn();
		
		this.leftBelow = new RegionBuilding();
		this.rightBelow = new RegionLawn();
		
		this.belowLeft = new RegionLawn();
		this.belowMiddle = new RegionLawn();
		this.belowRight = new RegionLawn();
		
		genCardGraph();
		setUniqueIDs();
	}
	
	private void setUniqueIDs() {
		int lawnID1 = IDManager.getLawnID();
		int buildingID1 = IDManager.getBuildingID();
		
		topLeft.setID(buildingID1);
		topMiddle.setID(buildingID1);
		topRight.setID(buildingID1);
		
		leftTop.setID(buildingID1);
		rightTop.setID(lawnID1);
		
		leftMiddle.setID(buildingID1);
		centerMiddle.setID(lawnID1);
		rightMiddle.setID(lawnID1);
		
		leftBelow.setID(buildingID1);
		rightBelow.setID(lawnID1);
		
		belowLeft.setID(lawnID1);
		belowMiddle.setID(lawnID1);
		belowRight.setID(lawnID1);
	}	
}
