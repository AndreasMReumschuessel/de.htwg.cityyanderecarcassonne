package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardJ extends MasterCard {
	
	public CardJ() {
		super();
		this.leftTopOne = new RegionBuilding();
		this.middleTop = new RegionBuilding();
		this.rightTopOne = new RegionBuilding();
		
		this.leftTopTwo = new RegionLawn();
		this.rightTopTwo = new RegionLawn();
		
		this.leftCenter = new RegionLawn();
		this.middleCenter = new RegionStreet();
		this.rightCenter = new RegionStreet();
		
		this.leftBelowTwo = new RegionLawn();
		this.rightBelowTwo = new RegionLawn();
		
		this.leftBelowOne = new RegionLawn();
		this.middleBelow = new RegionStreet();
		this.rightBelowOne = new RegionLawn();
		
		genCardGraph();
		setUniqueIDs();
	}
	
	private void setUniqueIDs() {
		int lawnID1 = IDManager.getLawnID();
		int lawnID2 = IDManager.getLawnID();
		int buildingID = IDManager.getBuildingID();
		int streetID = IDManager.getStreetID();
		
		leftTopOne.setID(buildingID);
		middleTop.setID(buildingID);
		rightTopOne.setID(buildingID);
		
		leftTopTwo.setID(lawnID1);
		rightTopTwo.setID(lawnID1);
		
		leftCenter.setID(lawnID1);
		middleCenter.setID(streetID);
		rightCenter.setID(streetID);
		
		leftBelowTwo.setID(lawnID1);
		rightBelowTwo.setID(lawnID2);
		
		leftBelowOne.setID(lawnID1);
		middleBelow.setID(streetID);
		rightBelowOne.setID(lawnID2);
	}
}
