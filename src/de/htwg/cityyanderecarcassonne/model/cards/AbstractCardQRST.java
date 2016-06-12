package de.htwg.cityyanderecarcassonne.model.cards;

import de.htwg.cityyanderecarcassonne.model.regions.RegionLawn;

public class AbstractCardQRST extends AbstractCardCQRST {

	public AbstractCardQRST() {
		super();		
		this.belowLeft = new RegionLawn();
		this.belowRight = new RegionLawn();
	}
}
