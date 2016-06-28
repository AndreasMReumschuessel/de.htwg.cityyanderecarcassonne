package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Image;

import de.htwg.cityyanderecarcassonne.model.ICard;

public class CardPrinterGUI {
	private static CardPrinterGUI instance = null;
	
	private CardPrinterGUI() {
		
	}
	
	public static CardPrinterGUI getInstance()	{
		if(instance == null)	{
			instance = new CardPrinterGUI();
		}
		return instance;
	}
	
	public static Image printCard(ICard card) {
		return null;
	}

}
