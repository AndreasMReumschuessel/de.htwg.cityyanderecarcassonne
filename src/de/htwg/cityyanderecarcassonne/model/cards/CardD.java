package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardD extends MasterCard {
	
	public CardD() {
		super();
		this.leftTopOne = new RegionLawn();
		this.middleTop = new RegionStreet();
		this.rightTopOne = new RegionLawn();
		
		this.leftTopTwo = new RegionLawn();
		this.rightTopTwo = new RegionBuilding();
		
		this.leftCenter = new RegionLawn();
		this.middleCenter = new RegionStreet();
		this.rightCenter = new RegionBuilding();
		
		this.leftBelowTwo = new RegionLawn();
		this.rightBelowTwo = new RegionBuilding();
		
		this.leftBelowOne = new RegionLawn();
		this.middleBelow = new RegionStreet();
		this.rightBelowOne = new RegionLawn();
		
		genCardGraph();
		setUniqueIDs();
	}
	
	private void setUniqueIDs() {
		int lawnID1 = IDManager.getLawnID();
		int lawnID2 = IDManager.getLawnID();
		int streetID = IDManager.getStreetID();
		int buildingID = IDManager.getBuildingID();
		
		leftTopOne.setID(lawnID1);
		middleTop.setID(streetID);
		rightTopOne.setID(lawnID2);
		
		leftTopTwo.setID(lawnID1);
		rightTopTwo.setID(buildingID);
		
		leftCenter.setID(lawnID1);
		middleCenter.setID(streetID);
		rightCenter.setID(buildingID);
		
		leftBelowTwo.setID(lawnID1);
		rightBelowTwo.setID(buildingID);
		
		leftBelowOne.setID(lawnID1);
		middleBelow.setID(streetID);
		rightBelowOne.setID(lawnID2);
	}
}
