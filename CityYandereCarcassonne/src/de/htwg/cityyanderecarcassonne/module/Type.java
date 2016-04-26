package de.htwg.cityyanderecarcassonne.module;

public class Type {
	
	private String type;
	
	public Type(String type) {
		if (type == "street" || type == "building" || type == "lawn") {
			this.type = type;
		} else {
			this.type = null;
		}
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setStreet() {
		this.type = "street";
	}
	
	public void setBuilding() {
		this.type = "building";
	}
	
	public void setLawn() {
		this.type = "lawn";
	}
}
