package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.RegionLawn;

public class CardQR extends Abstract2CardQR {
	
	public CardQR() {
		super();		
		this.belowMiddle = new RegionLawn();
		
		setUniqueIDs();
	}
	
	private void setUniqueIDs() {
		int lawnID1 = IDManager.getLawnID();
		
		belowLeft.setID(lawnID1);
		belowMiddle.setID(lawnID1);
		belowRight.setID(lawnID1);
	}

}
