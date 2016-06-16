package de.htwg.cityyanderecarcassonne.view.tui;

import java.util.HashMap;
import java.util.Map;
import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.Position;
import de.htwg.cityyanderecarcassonne.model.townsquare.Townsquare;

public final class TownsquarePrinter {
	
	private Townsquare ts;
	private int dimX;
	private int dimY;
	
	public TownsquarePrinter(Townsquare ts) {
		this.ts = ts;
		this.dimX = ts.getDimX();
		this.dimY = ts.getDimY();
	}
	
	public String printCard(ICard card, boolean selected) {
		StringBuilder sb = new StringBuilder();
		String tbBorder;
		String lrBorder;
		
		if (selected) {
			tbBorder = " ############ ";
			lrBorder = "#";
		} else {
			tbBorder = " ------------ ";
			lrBorder = "|";
		}
		sb.append(tbBorder).append('\n');
		sb.append(lrBorder).append("  " + regionToChar(card.getTopLeft()) + " " + regionToChar(card.getTopMiddle()) + " " + regionToChar(card.getTopRight()) + "  ").append(lrBorder).append('\n');
		sb.append(lrBorder).append(regionToChar(card.getLeftTop()) + "        " + regionToChar(card.getRightTop())).append(lrBorder).append('\n');
		sb.append(lrBorder).append(regionToChar(card.getLeftMiddle()) + "   " + regionToChar(card.getCenterMiddle()) + "   " + regionToChar(card.getRightMiddle())).append(lrBorder).append('\n');
		sb.append(lrBorder).append(regionToChar(card.getLeftBelow()) + "        " + regionToChar(card.getRightBelow())).append(lrBorder).append('\n');
		sb.append(lrBorder).append("  " + regionToChar(card.getBelowLeft()) + " " + regionToChar(card.getBelowMiddle()) + " " + regionToChar(card.getBelowLeft()) + "  ").append(lrBorder).append('\n');		
		sb.append(tbBorder).append('\n');
		
		return sb.toString();
	}
	
	private String regionToChar(IRegion r) {
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
	
	public String printNormalTownsquare() {
		StringBuilder sb = new StringBuilder();
		
		int xMin = getXMin();
		int xMax = getXMax();
		int yMin = getYMin();
		int yMax = getYMax();
		
		for (int y = yMin; y < yMax + 1; y++) {
			for (int l = 0; l < 7; l++) {
				for (int x = xMin; x < xMax + 1; x++) {
					ICard cx = ts.getCard(x, y);
					performNormalPrint(l, cx, sb);
				}
				sb.append('\n');
			}
		}
		return sb.toString();
	}
	
	private void performNormalPrint(int l, ICard cx, StringBuilder sb) {
		if (cx != null)
			sb.append(mlToSl(l, printCard(cx, false)));
		else
			sb.append("              ");
	}
	
	public String printCardPossibilitiesTownsquare(Map<Position, String> possibilities) {
		StringBuilder sb = new StringBuilder();
		
		possibilities = new HashMap<Position, String>();
		possibilities.put(new Position(5, 4), "C");
		
		int xMin = getXMin();
		int xMax = getXMax();
		int yMin = getYMin();
		int yMax = getYMax();
		
		for (int y = yMin; y < yMax + 1; y++) {
			for (int l = 0; l < 7; l++) {
				for (int x = xMin; x < xMax + 1; x++) {
					ICard cx = ts.getCard(x, y);
					Position tmppos = new Position(x, y);
					if (possibilities.containsKey(tmppos)) {
						String ident = possibilities.get(tmppos);
						sb.append(mlToSl(l, pseudoCard(ident)));
					} else if (cx != null) {
						sb.append(mlToSl(l, printCard(cx, false)));
					} else {
						sb.append("              ");
					}
				}
				sb.append('\n');
			}
		}
		return sb.toString();
	}
	
	private String mlToSl(int ln, String multi) {
		String[] sl = multi.split("\n");
		return sl[ln];
	}
	
	private int getXMin() {
		int min = dimX;
		for (int y = 0; y < dimY; y++) {
			for (int x = 0; x < dimX; x++) {
				if (ts.getCard(x, y) != null)
					min = Math.min(min, x);
			}
		}
		if (min - 1 < 0)
			return 0;
		else
			return min - 1;
	}
	
	private int getXMax() {
		int max = 0;
		for (int y = 0; y < dimY; y++) {
			for (int x = 0; x < dimX; x++) {
				if (ts.getCard(x, y) != null)
					max = Math.max(max, x);
			}
		}
		if (max + 1 >= dimX)
			return max;
		return max + 1;
	}
	
	private int getYMin() {
		for (int y = 0; y < dimY; y++) {
			for (int x = 0; x < dimX; x++) {
				if (ts.getCard(x, y) != null && y - 1 >= 0)
					return y - 1;
				else if (ts.getCard(x, y) != null && y - 1 < 0)
					return 0;
			}
		}
		return 0;
	}
	
	private int getYMax() {
		int max = 0;
		for (int y = 0; y < dimY; y++) {
			for (int x = 0; x < dimX; x++) {
				if (ts.getCard(x, y) != null)
					max = Math.max(max, y);
			}
		}
		if (max + 1 >= dimX)
			return max;
		return max + 1;
	}
	
	private String pseudoCard(String identifier) {
		StringBuilder sb = new StringBuilder();
		String tbBorder = " ############ ";
		String lrBorder = "#";
		
		String emptyLine = lrBorder + "            " + lrBorder + "\n";
		
		sb.append(tbBorder).append('\n');
		sb.append(emptyLine);
		sb.append(emptyLine);
		sb.append(lrBorder).append("     ");
		if(identifier.length() < 2)
			sb.append(identifier + " ");
		else
			sb.append(identifier);
		sb.append("     ").append(lrBorder).append('\n');
		sb.append(emptyLine);
		sb.append(emptyLine);
		sb.append(tbBorder).append('\n');
		
		return sb.toString();
	}

}
