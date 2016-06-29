package de.htwg.cityyanderecarcassonne.view.tui;

import java.util.Map;
import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.Position;
import de.htwg.cityyanderecarcassonne.model.townsquare.Townsquare;

public final class TownsquarePrinter {
	
	private Townsquare ts;
	
	public TownsquarePrinter(Townsquare ts) {
		this.ts = ts;
	}
	
	public String printNormalTownsquare() {
		StringBuilder sb = new StringBuilder();
		
		int xMin = ts.getXMin();
		int xMax = ts.getXMax();
		int yMin = ts.getYMin();
		int yMax = ts.getYMax();
		
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
			sb.append(mlToSl(l, CardPrinter.printCard(cx)));
		else
			sb.append("              ");
	}
	
	public String printCardPossibilitiesTownsquare(Map<Position, String> possibilities) {
		StringBuilder sb = new StringBuilder();
		
		int xMin = ts.getXMin();
		int xMax = ts.getXMax();
		int yMin = ts.getYMin();
		int yMax = ts.getYMax();
		
		for (int y = yMin; y < yMax + 1; y++) {
			for (int l = 0; l < 7; l++) {
				for (int x = xMin; x < xMax + 1; x++) {
					ICard cx = ts.getCard(x, y);
					Position tmppos = new Position(x, y);
					performPossPrint(possibilities, tmppos, l, cx, sb);
				}
				sb.append('\n');
			}
		}
		return sb.toString();
	}
	
	private void performPossPrint(Map<Position, String> possibilities, Position tmppos, int l, ICard cx, StringBuilder sb) {
		if (possibilities.containsKey(tmppos)) {
			String ident = possibilities.get(tmppos);
			sb.append(mlToSl(l, pseudoCard(ident)));
		} else if (cx != null) {
			sb.append(mlToSl(l, CardPrinter.printCard(cx)));
		} else {
			sb.append("              ");
		}
	}
	
	public String printMeeplePossibilitiesTownsquare(ICard card, Map<IRegion, String> possList) {
		StringBuilder sb = new StringBuilder();
		
		int xMin = ts.getXMin();
		int xMax = ts.getXMax();
		int yMin = ts.getYMin();
		int yMax = ts.getYMax();
		
		for (int y = yMin; y < yMax + 1; y++) {
			for (int l = 0; l < 7; l++) {
				for (int x = xMin; x < xMax + 1; x++) {
					ICard cx = ts.getCard(x, y);
					performMeeplePrint(l, card, cx, possList, sb);
				}
				sb.append('\n');
			}
		}
		return sb.toString();
	}
	
	private void performMeeplePrint(int l, ICard card, ICard cx, Map<IRegion, String> possList, StringBuilder sb) {
		if (cx != null)
			if (card.equals(cx))
				sb.append(mlToSl(l, CardPrinter.printCardPoss(cx, possList)));
			else
				sb.append(mlToSl(l, CardPrinter.printCard(cx)));
		else
			sb.append("              ");
	}
	
	private String mlToSl(int ln, String multi) {
		String[] sl = multi.split("\n");
		return sl[ln];
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
