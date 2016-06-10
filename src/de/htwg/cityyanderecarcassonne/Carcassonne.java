package de.htwg.cityyanderecarcassonne;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IDManager;
import de.htwg.cityyanderecarcassonne.model.cards.CardH;

public class Carcassonne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hey");
		System.out.println(IDManager.getBuildingID());
		System.out.println(IDManager.getLawnID());
		System.out.println("-------------");
		
		ICard card = new CardH();
		
		System.out.println(card.getLeftTopOne().getID());
		System.out.println(card.getMiddleCenter().getID());
		
		System.out.println(card.getLeftTopTwo().getID());
		System.out.println(card.getRightTopTwo().getID());
		
		System.out.println(card.getLeftCenter().getID());
	}

}
