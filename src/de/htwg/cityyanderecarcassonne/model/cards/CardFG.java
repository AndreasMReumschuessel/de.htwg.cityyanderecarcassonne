package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardFG extends MasterCard {
	
	public CardFG() {
		super();
		this.leftTopOne = new RegionLawn();
		this.middleTop = new RegionLawn();
		this.rightTopOne = new RegionLawn();
		
		this.leftTopTwo = new RegionBuilding();
		this.rightTopTwo = new RegionBuilding();
		
		this.leftCenter = new RegionBuilding();
		this.middleCenter = new RegionBuilding();
		this.rightCenter = new RegionBuilding();
		
		this.leftBelowTwo = new RegionBuilding();
		this.rightBelowTwo = new RegionBuilding();
		
		this.leftBelowOne = new RegionLawn();
		this.middleBelow = new RegionLawn();
		this.rightBelowOne = new RegionLawn();
		
		genCardGraph();
		setUniqueIDs();
	}
	
	private void setUniqueIDs() {
		int lawnID1 = IDManager.getLawnID();
		int lawnID2 = IDManager.getLawnID();
		int buildingID = IDManager.getBuildingID();
		
		leftTopOne.setID(lawnID1);
		middleTop.setID(lawnID1);
		rightTopOne.setID(lawnID1);
		
		leftTopTwo.setID(buildingID);
		rightTopTwo.setID(buildingID);
		
		leftCenter.setID(buildingID);
		middleCenter.setID(buildingID);
		rightCenter.setID(buildingID);
		
		leftBelowTwo.setID(buildingID);
		rightBelowTwo.setID(buildingID);
		
		leftBelowOne.setID(lawnID2);
		middleBelow.setID(lawnID2);
		rightBelowOne.setID(lawnID2);
	}
}
