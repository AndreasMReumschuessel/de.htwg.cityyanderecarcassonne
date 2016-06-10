package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardI extends MasterCard {
	
	public CardI() {
		super();
		this.leftTopOne = new RegionLawn();
		this.middleTop = new RegionLawn();
		this.rightTopOne = new RegionLawn();
		
		this.leftTopTwo = new RegionLawn();
		this.rightTopTwo = new RegionBuilding();
		
		this.leftCenter = new RegionLawn();
		this.middleCenter = new RegionLawn();
		this.rightCenter = new RegionBuilding();
		
		this.leftBelowTwo = new RegionLawn();
		this.rightBelowTwo = new RegionBuilding();
		
		this.leftBelowOne = new RegionBuilding();
		this.middleBelow = new RegionBuilding();
		this.rightBelowOne = new RegionBuilding();
		
		genCardGraph();
		setUniqueIDs();
	}
	
	private void setUniqueIDs() {
		int lawnID = IDManager.getLawnID();
		int buildingID1 = IDManager.getBuildingID();
		int buildingID2 = IDManager.getBuildingID();
		
		leftTopOne.setID(lawnID);
		middleTop.setID(lawnID);
		rightTopOne.setID(lawnID);
		
		leftTopTwo.setID(lawnID);
		rightTopTwo.setID(buildingID2);
		
		leftCenter.setID(lawnID);
		middleCenter.setID(lawnID);
		rightCenter.setID(buildingID2);
		
		leftBelowTwo.setID(lawnID);
		rightBelowTwo.setID(buildingID2);
		
		leftBelowOne.setID(buildingID1);
		middleBelow.setID(buildingID1);
		rightBelowOne.setID(buildingID1);
	}
}
