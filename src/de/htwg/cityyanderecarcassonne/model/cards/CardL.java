package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardL extends MasterCard {
	
	public CardL() {
		super();
		this.leftTopOne = new RegionLawn();
		this.middleTop = new RegionStreet();
		this.rightTopOne = new RegionLawn();
		
		this.leftTopTwo = new RegionLawn();
		this.rightTopTwo = new RegionBuilding();
		
		this.leftCenter = new RegionStreet();
		this.middleCenter = new RegionCrossing();
		this.rightCenter = new RegionBuilding();
		
		this.leftBelowTwo = new RegionLawn();
		this.rightBelowTwo = new RegionBuilding();
		
		this.leftBelowOne = new RegionLawn();
		this.middleBelow = new RegionStreet();
		this.rightBelowOne = new RegionLawn();
		
		System.out.println();
		
		genCardGraph();
		setUniqueIDs();
	}
	
	private void setUniqueIDs() {
		int lawnID1 = IDManager.getLawnID();
		int lawnID2 = IDManager.getLawnID();
		int lawnID3 = IDManager.getLawnID();
		int streetID1 = IDManager.getStreetID();
		int streetID2 = IDManager.getStreetID();
		int streetID3 = IDManager.getStreetID();
		int buildingID1 = IDManager.getBuildingID();
		int crossingID1 = IDManager.getCrossingID();
		
		leftTopOne.setID(lawnID1);
		middleTop.setID(streetID1);
		rightTopOne.setID(lawnID2);
		
		leftTopTwo.setID(lawnID1);
		rightTopTwo.setID(buildingID1);
		
		leftCenter.setID(streetID2);
		middleCenter.setID(crossingID1);
		rightCenter.setID(buildingID1);
		
		leftBelowTwo.setID(lawnID3);
		rightBelowTwo.setID(buildingID1);
		
		leftBelowOne.setID(lawnID3);
		middleBelow.setID(streetID3);
		rightBelowOne.setID(lawnID2);
	}
}
