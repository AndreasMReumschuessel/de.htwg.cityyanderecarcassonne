package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardH extends MasterCard {
	
	public CardH() {
		super();
		this.leftTopOne = new RegionLawn();
		this.middleTop = new RegionLawn();
		this.rightTopOne = new RegionLawn();
		
		this.leftTopTwo = new RegionBuilding();
		this.rightTopTwo = new RegionBuilding();
		
		this.leftCenter = new RegionBuilding();
		this.middleCenter = new RegionLawn();
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
		int lawnID = IDManager.getLawnID();
		int buildingID1 = IDManager.getBuildingID();
		int buildingID2 = IDManager.getBuildingID();
		
		leftTopOne.setID(lawnID);
		middleTop.setID(lawnID);
		rightTopOne.setID(lawnID);
		
		leftTopTwo.setID(buildingID1);
		rightTopTwo.setID(buildingID2);
		
		leftCenter.setID(buildingID1);
		middleCenter.setID(lawnID);
		rightCenter.setID(buildingID2);
		
		leftBelowTwo.setID(buildingID1);
		rightBelowTwo.setID(buildingID2);
		
		leftBelowOne.setID(lawnID);
		middleBelow.setID(lawnID);
		rightBelowOne.setID(lawnID);
	}
}
