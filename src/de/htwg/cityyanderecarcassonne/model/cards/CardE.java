package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardE extends MasterCard {
	
	public CardE() {
		super();
		this.leftTopOne = new RegionBuilding();
		this.middleTop = new RegionBuilding();
		this.rightTopOne = new RegionBuilding();
		
		this.leftTopTwo = new RegionLawn();
		this.rightTopTwo = new RegionLawn();
		
		this.leftCenter = new RegionLawn();
		this.middleCenter = new RegionLawn();
		this.rightCenter = new RegionLawn();
		
		this.leftBelowTwo = new RegionLawn();
		this.rightBelowTwo = new RegionLawn();
		
		this.leftBelowOne = new RegionLawn();
		this.middleBelow = new RegionLawn();
		this.rightBelowOne = new RegionLawn();
		
		genCardGraph();
		setUniqueIDs();
	}
	
	private void setUniqueIDs() {
		int lawnID = IDManager.getLawnID();
		int buildingID = IDManager.getBuildingID();
		
		leftTopOne.setID(buildingID);
		middleTop.setID(buildingID);
		rightTopOne.setID(buildingID);
		
		leftTopTwo.setID(lawnID);
		rightTopTwo.setID(lawnID);
		
		leftCenter.setID(lawnID);
		middleCenter.setID(lawnID);
		rightCenter.setID(lawnID);
		
		leftBelowTwo.setID(lawnID);
		rightBelowTwo.setID(lawnID);
		
		leftBelowOne.setID(lawnID);
		middleBelow.setID(lawnID);
		rightBelowOne.setID(lawnID);
	}
}
