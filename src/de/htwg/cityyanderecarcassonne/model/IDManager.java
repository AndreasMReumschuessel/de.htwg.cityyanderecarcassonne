package de.htwg.cityyanderecarcassonne.model;

import java.util.Set;

public final class IDManager {
	
	private static Set<Integer> idpool;
	private static int buildingID;
	private static int crossingID;
	private static int lawnID;
	private static int schoolID;
	private static int streetID;
	
	private IDManager() {
		buildingID = 10000;
		crossingID = 20000;
		lawnID = 30000;
		schoolID = 40000;
		streetID = 50000;
	}
	
	public static int getBuildingID() {
		int r = buildingID;
		idpool.add(r);
		buildingID++;
		return r;
	}
	
	public static int getCrossingID() {
		int r = crossingID;
		idpool.add(r);
		crossingID++;
		return r;
	}
	
	public static int getLawnID() {
		int r = lawnID;
		idpool.add(r);
		lawnID++;
		return r;
	}
	
	public static int getSchoolID() {
		int r = schoolID;
		idpool.add(r);
		schoolID++;
		return r;
	}
	
	public static int getStreetID() {
		int r = streetID;
		idpool.add(r);
		streetID++;
		return r;
	}
	
	public static boolean idUsed(int id) {
		return idpool.contains(id);
	}

}
