package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.regions.RegionLawn;

public class Abstract2CardQR extends AbstractCardQR {

	public Abstract2CardQR() {
		super();		
		this.belowLeft = new RegionLawn();
		this.belowRight = new RegionLawn();
	}
}
