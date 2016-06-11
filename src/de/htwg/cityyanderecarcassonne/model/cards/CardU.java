package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardU extends MasterCard {
	
	public CardU() {
		super();
		this.leftTopOne = new RegionLawn();
		this.middleTop = new RegionStreet();
		this.rightTopOne = new RegionLawn();
		
		this.leftTopTwo = new RegionLawn();
		this.rightTopTwo = new RegionLawn();
		
		this.leftCenter = new RegionLawn();
		this.middleCenter = new RegionStreet();
		this.rightCenter = new RegionLawn();
		
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
		int streetID1 = IDManager.getStreetID();
		
		leftTopOne.setID(lawnID1);
		middleTop.setID(streetID1);
		rightTopOne.setID(lawnID2);
		
		leftTopTwo.setID(lawnID1);
		rightTopTwo.setID(lawnID2);
		
		leftCenter.setID(lawnID1);
		middleCenter.setID(streetID1);
		rightCenter.setID(lawnID2);
		
		leftBelowTwo.setID(lawnID1);
		rightBelowTwo.setID(lawnID2);
		
		leftBelowOne.setID(lawnID1);
		middleBelow.setID(streetID1);
		rightBelowOne.setID(lawnID2);
	}	
}
