package de.htwg.cityyanderecarcassonne.module;

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
        if("street".equals(type))	{
     	   this.setStreet();
        } else if("building".equals(type))	{
     	   this.setBuilding();
        } else if("lawn".equals(type))	{
     	   this.setLawn();
        } else if("crossing".equals(type))	{
      	   this.setCrossing();
        } else if("school".equals(type))	{
      	   this.setSchool(); 
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