package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardV extends MasterCard {
	
	public CardV() {
		super();
		this.topLeft = new RegionLawn();
		this.topMiddle = new RegionLawn();
		this.topRight = new RegionLawn();
		
		this.leftTop = new RegionLawn();
		this.rightTop = new RegionLawn();
		
		this.leftMiddle = new RegionStreet();
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
		topMiddle.setID(lawnID1);
		topRight.setID(lawnID1);
		
		leftTop.setID(lawnID1);
		rightTop.setID(lawnID1);
		
		leftMiddle.setID(streetID1);
		centerMiddle.setID(streetID1);
		rightMiddle.setID(lawnID1);
		
		leftBelow.setID(lawnID2);
		rightBelow.setID(lawnID1);
		
		belowLeft.setID(lawnID2);
		belowMiddle.setID(streetID1);
		belowRight.setID(lawnID1);
	}
}
