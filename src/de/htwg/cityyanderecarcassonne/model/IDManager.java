package de.htwg.cityyanderecarcassonne.model;

import java.util.HashSet;
import java.util.Set;

public final class IDManager {
	
	private static Set<Integer> idpool = new HashSet<>();
	private static int buildingID  = 10000;
	private static int crossingID = 20000;
	private static int lawnID = 30000;
	private static int schoolID = 40000;
	private static int streetID = 50000;
	
	private IDManager() {}
	
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
	
	public static void resetIDCount()	{
		buildingID  = 10000;
		crossingID = 20000;
		lawnID = 30000;
		schoolID = 40000;
		streetID = 50000;
	}

}
