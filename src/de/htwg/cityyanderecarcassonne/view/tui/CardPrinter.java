package de.htwg.cityyanderecarcassonne.view.tui;

import java.util.Map;

import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IRegion;

public abstract class CardPrinter {
	
	private CardPrinter() {
		throw new UnsupportedOperationException();
	}

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
		String result = convertRegionName(className);
		
		if (r.getPlayer() != null)
			result = result + "P";
		else
			result = result + " ";
		return result;
	}
	
	public static String printCardPoss(ICard card, Map<IRegion, String> possList) {
		StringBuilder sb = new StringBuilder();
		String tbBorder;
		String lrBorder;
		
		tbBorder = " ############ ";
		lrBorder = "#";
		
		sb.append(tbBorder).append('\n');
		sb.append(lrBorder).append("  " + regionToCharPoss(card.getTopLeft(), possList) + " " + regionToCharPoss(card.getTopMiddle(), possList) + " " + regionToCharPoss(card.getTopRight(), possList) + "  ").append(lrBorder).append('\n');
		sb.append(lrBorder).append(regionToCharPoss(card.getLeftTop(), possList) + "        " + regionToCharPoss(card.getRightTop(), possList)).append(lrBorder).append('\n');
		sb.append(lrBorder).append(regionToCharPoss(card.getLeftMiddle(), possList) + "   " + regionToCharPoss(card.getCenterMiddle(), possList) + "   " + regionToCharPoss(card.getRightMiddle(), possList)).append(lrBorder).append('\n');
		sb.append(lrBorder).append(regionToCharPoss(card.getLeftBelow(), possList) + "        " + regionToCharPoss(card.getRightBelow(), possList)).append(lrBorder).append('\n');
		sb.append(lrBorder).append("  " + regionToCharPoss(card.getBelowLeft(), possList) + " " + regionToCharPoss(card.getBelowMiddle(), possList) + " " + regionToCharPoss(card.getBelowLeft(), possList) + "  ").append(lrBorder).append('\n');		
		sb.append(tbBorder).append('\n');
		
		return sb.toString();
	}
	
	private static String regionToCharPoss(IRegion r, Map<IRegion, String> possList) {
		String className = r.getClass().getSimpleName();
		String ident = possList.get(r);
		String result = convertRegionName(className);
		
		if (ident != null)
			result = result + ident;
		else
			result = result + " ";
		return result;
	}
	
	private static String convertRegionName(String className) {
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
		
		return result;
	}
}
