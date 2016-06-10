package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardC extends MasterCard {
	
	public CardC() {
		super();
		this.leftTopOne = new RegionBuilding();
		this.middleTop = new RegionBuilding();
		this.rightTopOne = new RegionBuilding();
		
		this.leftTopTwo = new RegionBuilding();
		this.rightTopTwo = new RegionBuilding();
		
		this.leftCenter = new RegionBuilding();
		this.middleCenter = new RegionBuilding();
		this.rightCenter = new RegionBuilding();
		
		this.leftBelowTwo = new RegionBuilding();
		this.rightBelowTwo = new RegionBuilding();
		
		this.leftBelowOne = new RegionBuilding();
		this.middleBelow = new RegionBuilding();
		this.rightBelowOne = new RegionBuilding();
		
		genCardGraph();
		setUniqueIDs();
	}
	
	private void setUniqueIDs() {
		int buildingID = IDManager.getBuildingID();
		
		leftTopOne.setID(buildingID);
		middleTop.setID(buildingID);
		rightTopOne.setID(buildingID);
		
		leftTopTwo.setID(buildingID);
		rightTopTwo.setID(buildingID);
		
		leftCenter.setID(buildingID);
		middleCenter.setID(buildingID);
		rightCenter.setID(buildingID);
		
		leftBelowTwo.setID(buildingID);
		rightBelowTwo.setID(buildingID);
		
		leftBelowOne.setID(buildingID);
		middleBelow.setID(buildingID);
		rightBelowOne.setID(buildingID);
	}
}
