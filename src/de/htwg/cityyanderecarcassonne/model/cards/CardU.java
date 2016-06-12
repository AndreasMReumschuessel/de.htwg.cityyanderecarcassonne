package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardU extends MasterCard {
	
	public CardU() {
		super();
		this.topLeft = new RegionLawn();
		this.topMiddle = new RegionStreet();
		this.topRight = new RegionLawn();
		
		this.leftTop = new RegionLawn();
		this.rightTop = new RegionLawn();
		
		this.leftMiddle = new RegionLawn();
		this.centerMiddle = new RegionStreet();
		this.rightMiddle = new RegionLawn();
		
		this.leftBelow = new RegionLawn();
		this.rightBelow = new RegionLawn();
		
		this.belowLeft = new RegionLawn();
		this.belowMiddle = new RegionStreet();
		this.belowRight = new RegionLawn();
		
		genCardGraph();
		setUniqueIDs();
	}
	
	private void setUniqueIDs() {
		int lawnID1 = IDManager.getLawnID();
		int lawnID2 = IDManager.getLawnID();
		int streetID1 = IDManager.getStreetID();
		
		topLeft.setID(lawnID1);
		topMiddle.setID(streetID1);
		topRight.setID(lawnID2);
		
		leftTop.setID(lawnID1);
		rightTop.setID(lawnID2);
		
		leftMiddle.setID(lawnID1);
		centerMiddle.setID(streetID1);
		rightMiddle.setID(lawnID2);
		
		leftBelow.setID(lawnID1);
		rightBelow.setID(lawnID2);
		
		belowLeft.setID(lawnID1);
		belowMiddle.setID(streetID1);
		belowRight.setID(lawnID2);
	}	
}
