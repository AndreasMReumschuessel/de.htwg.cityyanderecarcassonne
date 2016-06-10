package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardK extends MasterCard{
	
	public CardK() {
		super();
		this.leftTopOne = new RegionLawn();
		this.middleTop = new RegionStreet();
		this.rightTopOne = new RegionLawn();
		
		this.leftTopTwo = new RegionLawn();
		this.rightTopTwo = new RegionBuilding();
		
		this.leftCenter = new RegionStreet();
		this.middleCenter = new RegionStreet();
		this.rightCenter = new RegionBuilding();
		
		this.leftBelowTwo = new RegionLawn();
		this.rightBelowTwo = new RegionBuilding();
		
		this.leftBelowOne = new RegionLawn();
		this.middleBelow = new RegionLawn();
		this.rightBelowOne = new RegionLawn();

		System.out.println();
		
		genCardGraph();
		setUniqueIDs();
	}
	
	private void setUniqueIDs() {
		int lawnID1 = IDManager.getLawnID();
		int lawnID2 = IDManager.getLawnID();
		int streetID1 = IDManager.getStreetID();
		int buildingID1 = IDManager.getBuildingID();
		
		leftTopOne.setID(lawnID1);
		middleTop.setID(streetID1);
		rightTopOne.setID(lawnID2);
		
		leftTopTwo.setID(lawnID1);
		rightTopTwo.setID(buildingID1);
		
		leftCenter.setID(streetID1);
		middleCenter.setID(streetID1);
		rightCenter.setID(buildingID1);
		
		leftBelowTwo.setID(lawnID2);
		rightBelowTwo.setID(buildingID1);
		
		leftBelowOne.setID(lawnID2);
		middleBelow.setID(lawnID2);
		rightBelowOne.setID(lawnID2);
		
	}
}
