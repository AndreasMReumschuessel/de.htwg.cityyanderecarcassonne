package de.htwg.cityyanderecarcassonne.model;
//update

public class Type {

	private int ID;
	private String typeName;
	
	public Type()	{
		this.genID(0);
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getID() {
		return ID;
	}

	public void genID(int iD) {
		this.ID = iD;
	}
	
}
