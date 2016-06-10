package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardX extends MasterCard {
	
	public CardX() {
		super();
		this.leftTopOne = new RegionLawn();
		this.middleTop = new RegionStreet();
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
		int streetID1 = IDManager.getStreetID();
		int streetID2 = IDManager.getStreetID();
		int streetID3 = IDManager.getStreetID();
		int streetID4 = IDManager.getStreetID();
		int crossingID1 = IDManager.getCrossingID();
		
		leftTopOne.setID(lawnID1);
		middleTop.setID(streetID1);
		rightTopOne.setID(lawnID1);
		
		leftTopTwo.setID(lawnID1);
		rightTopTwo.setID(lawnID1);
		
		leftCenter.setID(streetID2);
		middleCenter.setID(crossingID1);
		rightCenter.setID(streetID3);
		
		leftBelowTwo.setID(lawnID1);
		rightBelowTwo.setID(lawnID1);
		
		leftBelowOne.setID(lawnID1);
		middleBelow.setID(streetID4);
		rightBelowOne.setID(lawnID1);
	}
}
