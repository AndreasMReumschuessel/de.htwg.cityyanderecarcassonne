package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardW extends MasterCard {
	
	public CardW() {
		super();
		this.leftTopOne = new RegionLawn();
		this.middleTop = new RegionLawn();
		this.rightTopOne = new RegionLawn();
		
		this.leftTopTwo = new RegionLawn();
		this.rightTopTwo = new RegionLawn();
		
		this.leftCenter = new RegionStreet();
		this.middleCenter = new RegionCrossing();
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
		int lawnID3 = IDManager.getLawnID();
		int streetID1 = IDManager.getStreetID();
		int streetID2 = IDManager.getStreetID();
		int streetID3 = IDManager.getStreetID();
		int crossingID1 = IDManager.getCrossingID();
		
		leftTopOne.setID(lawnID1);
		middleTop.setID(lawnID1);
		rightTopOne.setID(lawnID1);
		
		leftTopTwo.setID(lawnID1);
		rightTopTwo.setID(lawnID1);
		
		leftCenter.setID(streetID1);
		middleCenter.setID(crossingID1);
		rightCenter.setID(streetID2);
		
		leftBelowTwo.setID(lawnID2);
		rightBelowTwo.setID(lawnID3);
		
		leftBelowOne.setID(lawnID2);
		middleBelow.setID(streetID3);
		rightBelowOne.setID(lawnID3);
	}	
}
