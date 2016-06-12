package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardX extends MasterCard {
	
	public CardX() {
		super();
		this.topLeft = new RegionLawn();
		this.topMiddle = new RegionStreet();
		this.topRight = new RegionLawn();
		
		this.leftTop = new RegionLawn();
		this.rightTop = new RegionLawn();
		
		this.leftMiddle = new RegionStreet();
		this.centerMiddle = new RegionCrossing();
		this.rightMiddle = new RegionStreet();
		
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
		int lawnID3 = IDManager.getLawnID();
		int lawnID4 = IDManager.getLawnID();
		int streetID1 = IDManager.getStreetID();
		int streetID2 = IDManager.getStreetID();
		int streetID3 = IDManager.getStreetID();
		int streetID4 = IDManager.getStreetID();
		int crossingID1 = IDManager.getCrossingID();
		
		topLeft.setID(lawnID1);
		topMiddle.setID(streetID1);
		topRight.setID(lawnID2);
		
		leftTop.setID(lawnID1);
		rightTop.setID(lawnID2);
		
		leftMiddle.setID(streetID2);
		centerMiddle.setID(crossingID1);
		rightMiddle.setID(streetID3);
		
		leftBelow.setID(lawnID3);
		rightBelow.setID(lawnID4);
		
		belowLeft.setID(lawnID3);
		belowMiddle.setID(streetID4);
		belowRight.setID(lawnID4);
	}
}
