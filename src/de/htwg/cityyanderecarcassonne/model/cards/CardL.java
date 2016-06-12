package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardL extends MasterCard {
	
	public CardL() {
		super();
		this.topLeft = new RegionLawn();
		this.topMiddle = new RegionStreet();
		this.topRight = new RegionLawn();
		
		this.leftTop = new RegionLawn();
		this.rightTop = new RegionBuilding();
		
		this.leftMiddle = new RegionStreet();
		this.centerMiddle = new RegionCrossing();
		this.rightMiddle = new RegionBuilding();
		
		this.leftBelow = new RegionLawn();
		this.rightBelow = new RegionBuilding();
		
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
		int streetID1 = IDManager.getStreetID();
		int streetID2 = IDManager.getStreetID();
		int streetID3 = IDManager.getStreetID();
		int buildingID1 = IDManager.getBuildingID();
		int crossingID1 = IDManager.getCrossingID();
		
		topLeft.setID(lawnID1);
		topMiddle.setID(streetID1);
		topRight.setID(lawnID2);
		
		leftTop.setID(lawnID1);
		rightTop.setID(buildingID1);
		
		leftMiddle.setID(streetID2);
		centerMiddle.setID(crossingID1);
		rightMiddle.setID(buildingID1);
		
		leftBelow.setID(lawnID3);
		rightBelow.setID(buildingID1);
		
		belowLeft.setID(lawnID3);
		belowMiddle.setID(streetID3);
		belowRight.setID(lawnID2);
	}
}
