package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardB extends MasterCard {
	
	public CardB() {
		super();
		this.leftTopOne = new RegionLawn();
		this.middleTop = new RegionLawn();
		this.rightTopOne = new RegionLawn();
		
		this.leftTopTwo = new RegionLawn();
		this.rightTopTwo = new RegionLawn();
		
		this.leftCenter = new RegionLawn();
		this.middleCenter = new RegionSchool();
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
		int schoolID = IDManager.getSchoolID();
		
		leftTopOne.setID(lawnID);
		middleTop.setID(lawnID);
		rightTopOne.setID(lawnID);
		
		leftTopTwo.setID(lawnID);
		rightTopTwo.setID(lawnID);
		
		leftCenter.setID(lawnID);
		middleCenter.setID(schoolID);
		rightCenter.setID(lawnID);
		
		leftBelowTwo.setID(lawnID);
		rightBelowTwo.setID(lawnID);
		
		leftBelowOne.setID(lawnID);
		middleBelow.setID(lawnID);
		rightBelowOne.setID(lawnID);
	}
}
