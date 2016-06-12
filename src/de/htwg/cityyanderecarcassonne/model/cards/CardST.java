package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class CardST extends Abstract2CardQR {
	
	public CardST() {
		super();		
		this.belowMiddle = new RegionStreet();
		
		genCardGraph();
		setUniqueIDs();
	}
	
	private void setUniqueIDs() {
		int lawnID1 = IDManager.getLawnID();
		int lawnID2 = IDManager.getLawnID();
		int streetID1 = IDManager.getStreetID();
		
		belowLeft.setID(lawnID1);
		belowMiddle.setID(streetID1);
		belowRight.setID(lawnID2);
	}
}
