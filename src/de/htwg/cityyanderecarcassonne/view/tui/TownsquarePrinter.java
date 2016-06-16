package de.htwg.cityyanderecarcassonne.view.tui;

import java.util.HashMap;
import java.util.Map;
import de.htwg.cityyanderecarcassonne.model.ICard;
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
					if (cx != null)
						sb.append(mlToSl(l, cx.toString()));
					else
						sb.append("              ");
				}
				sb.append('\n');
			}
		}
		return sb.toString();
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
						sb.append(mlToSl(l, cx.toString()));
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
		sb.append(tbBorder).append('\n');
		sb.append(lrBorder).append("            ").append(lrBorder).append('\n');
		sb.append(lrBorder).append("            ").append(lrBorder).append('\n');
		sb.append(lrBorder).append("     ");
		if(identifier.length() < 2)
			sb.append(identifier + " ");
		else
			sb.append(identifier);
		sb.append("     ").append(lrBorder).append('\n');
		sb.append(lrBorder).append("            ").append(lrBorder).append('\n');
		sb.append(lrBorder).append("            ").append(lrBorder).append('\n');
		sb.append(tbBorder).append('\n');
		
		return sb.toString();
	}

}
