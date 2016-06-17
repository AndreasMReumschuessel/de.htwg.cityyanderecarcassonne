package de.htwg.cityyanderecarcassonne.view.tui;

import java.util.List;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IRegion;

public abstract class CardPrinter {

	public static String printCard(ICard card) {
		StringBuilder sb = new StringBuilder();
		String tbBorder;
		String lrBorder;
		
		tbBorder = " ------------ ";
		lrBorder = "|";
		
		sb.append(tbBorder).append('\n');
		sb.append(lrBorder).append("  " + regionToChar(card.getTopLeft()) + " " + regionToChar(card.getTopMiddle()) + " " + regionToChar(card.getTopRight()) + "  ").append(lrBorder).append('\n');
		sb.append(lrBorder).append(regionToChar(card.getLeftTop()) + "        " + regionToChar(card.getRightTop())).append(lrBorder).append('\n');
		sb.append(lrBorder).append(regionToChar(card.getLeftMiddle()) + "   " + regionToChar(card.getCenterMiddle()) + "   " + regionToChar(card.getRightMiddle())).append(lrBorder).append('\n');
		sb.append(lrBorder).append(regionToChar(card.getLeftBelow()) + "        " + regionToChar(card.getRightBelow())).append(lrBorder).append('\n');
		sb.append(lrBorder).append("  " + regionToChar(card.getBelowLeft()) + " " + regionToChar(card.getBelowMiddle()) + " " + regionToChar(card.getBelowLeft()) + "  ").append(lrBorder).append('\n');		
		sb.append(tbBorder).append('\n');
		
		return sb.toString();
	}
	
	private static String regionToChar(IRegion r) {
		String className = r.getClass().getSimpleName();
		String result = " ";
		if ("RegionBuilding".equals(className)) {
			result = "B";
		} else if ("RegionLawn".equals(className)) {
			result = "L";
		} else if ("RegionStreet".equals(className)) {
			result = "S";
		} else if ("RegionCrossing".equals(className)) {
			result = "C";
		} else if ("RegionSchool".equals(className)) {
			result = "K";
		}
		
		if (r.getPlayer() != null)
			result = result + "P";
		else
			result = result + " ";
		return result;
	}
	
	public static String printCardPoss(ICard card, List<IRegion> possList) {
		StringBuilder sb = new StringBuilder();
		String tbBorder;
		String lrBorder;
		
		tbBorder = " ############ ";
		lrBorder = "#";
		
		sb.append(tbBorder).append('\n');
		sb.append(lrBorder).append("  " + regionToChar(card.getTopLeft()) + " " + regionToChar(card.getTopMiddle()) + " " + regionToChar(card.getTopRight()) + "  ").append(lrBorder).append('\n');
		sb.append(lrBorder).append(regionToChar(card.getLeftTop()) + "        " + regionToChar(card.getRightTop())).append(lrBorder).append('\n');
		sb.append(lrBorder).append(regionToChar(card.getLeftMiddle()) + "   " + regionToChar(card.getCenterMiddle()) + "   " + regionToChar(card.getRightMiddle())).append(lrBorder).append('\n');
		sb.append(lrBorder).append(regionToChar(card.getLeftBelow()) + "        " + regionToChar(card.getRightBelow())).append(lrBorder).append('\n');
		sb.append(lrBorder).append("  " + regionToChar(card.getBelowLeft()) + " " + regionToChar(card.getBelowMiddle()) + " " + regionToChar(card.getBelowLeft()) + "  ").append(lrBorder).append('\n');		
		sb.append(tbBorder).append('\n');
		
		return sb.toString();
	}
	
	private static String regionToCharPoss(IRegion r) {
		String className = r.getClass().getSimpleName();
		String result = " ";
		if ("RegionBuilding".equals(className)) {
			result = "B";
		} else if ("RegionLawn".equals(className)) {
			result = "L";
		} else if ("RegionStreet".equals(className)) {
			result = "S";
		} else if ("RegionCrossing".equals(className)) {
			result = "C";
		} else if ("RegionSchool".equals(className)) {
			result = "K";
		}
		
		if (r.getPlayer() != null)
			result = result + "P";
		else
			result = result + " ";
		return result;
	}
}
