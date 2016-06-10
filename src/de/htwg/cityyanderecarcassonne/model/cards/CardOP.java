package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardOP extends MasterCard {
	
	public CardOP() {
		super();
		this.leftTopOne = new RegionBuilding();
		this.middleTop = new RegionBuilding();
		this.rightTopOne = new RegionBuilding();
		
		this.leftTopTwo = new RegionBuilding();
		this.rightTopTwo = new RegionLawn();
		
		this.leftCenter = new RegionBuilding();
		this.middleCenter = new RegionStreet();
		this.rightCenter = new RegionStreet();
		
		this.leftBelowTwo = new RegionBuilding();
		this.rightBelowTwo = new RegionLawn();
		
		this.leftBelowOne = new RegionLawn();
		this.middleBelow = new RegionStreet();
		this.rightBelowOne = new RegionLawn();
		
		genCardGraph();
		setUniqueIDs();
	}
	
	private void setUniqueIDs() {
		int lawnID1 = IDManager.getLawnID();
		int streetID1 = IDManager.getStreetID();
		int buildingID1 = IDManager.getBuildingID();
		
		leftTopOne.setID(buildingID1);
		middleTop.setID(buildingID1);
		rightTopOne.setID(buildingID1);
		
		leftTopTwo.setID(buildingID1);
		rightTopTwo.setID(lawnID1);
		
		leftCenter.setID(buildingID1);
		middleCenter.setID(streetID1);
		rightCenter.setID(streetID1);
		
		leftBelowTwo.setID(buildingID1);
		rightBelowTwo.setID(lawnID1);
		
		leftBelowOne.setID(lawnID1);
		middleBelow.setID(streetID1);
		rightBelowOne.setID(lawnID1);
	}
}
