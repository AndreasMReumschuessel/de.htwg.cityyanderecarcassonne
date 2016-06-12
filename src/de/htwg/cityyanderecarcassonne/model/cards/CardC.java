package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardC extends MasterCard {
	
	public CardC() {
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
		
		this.belowLeft = new RegionBuilding();
		this.belowMiddle = new RegionBuilding();
		this.belowRight = new RegionBuilding();
		
		genCardGraph();
		setUniqueIDs();
	}
	
	private void setUniqueIDs() {
		int buildingID = IDManager.getBuildingID();
		
		topLeft.setID(buildingID);
		topMiddle.setID(buildingID);
		topRight.setID(buildingID);
		
		leftTop.setID(buildingID);
		rightTop.setID(buildingID);
		
		leftMiddle.setID(buildingID);
		centerMiddle.setID(buildingID);
		rightMiddle.setID(buildingID);
		
		leftBelow.setID(buildingID);
		rightBelow.setID(buildingID);
		
		belowLeft.setID(buildingID);
		belowMiddle.setID(buildingID);
		belowRight.setID(buildingID);
	}
}
