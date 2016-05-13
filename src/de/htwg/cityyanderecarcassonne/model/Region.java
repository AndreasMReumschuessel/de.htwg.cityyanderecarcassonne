package de.htwg.cityyanderecarcassonne.model;

public class Region {

    private String type;
    private Player player;

    public Region(String type) {
    	setType(type);
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        if(type.equals("street"))	{
     	   this.setStreet();
        } else if(type.equals("building"))	{
     	   this.setBuilding();
        } else if(type.equals("lawn"))	{
     	   this.setLawn();
        } else if(type.equals("crossing"))	{
      	   this.setCrossing();
        } else if(type.equals("school"))	{
      	   this.setSchool(); 
        } else	{

        }
    }

    public Player getPlayer() {
        return this.player;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
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
	
	public void setCrossing() {
		this.type = "crossing";
	}
	
	public void setSchool() {
		this.type = "school";
	}
    
}