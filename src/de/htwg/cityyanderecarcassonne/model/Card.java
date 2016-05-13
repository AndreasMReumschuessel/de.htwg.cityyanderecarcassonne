package de.htwg.cityyanderecarcassonne.model;

public class Card {

    private Region north;
    private Region east;
    private Region south;
    private Region west;
    private Region center;

    public Card(Region north, Region east, Region south, Region west, Region center) {
        setRegion(north);
        setRegion(east);
        setRegion(south);
        setRegion(west);
        setRegion(center);
    }
    
    public Region getRegion(Region region)	{    	
    	if("north".equals(region.getType()))	{
            return this.north;
    	} else if("east".equals(region.getType()))	{
            return this.east;
    	} else if("south".equals(region.getType()))	{
            return this.south;
    	} else if("west".equals(region.getType()))	{
    		return this.west;
    	} else	{
            return this.center;
     	}
    }
    
    public void setRegion(Region region)	{
    	if("north".equals(region.getType()))	{
            this.north = region;
    	} else if("east".equals(region.getType()))	{
            this.east = region;
    	} else if("south".equals(region.getType()))	{
            this.south = region;
    	} else if("west".equals(region.getType()))	{
            this.west = region;
    	} else	{
            this.center = region;
    	}
    }
    
    public void turnCardRight()	{
    	Region tmpNorth = this.getRegion(north);
    	this.setRegion(west);
    	this.setRegion(south);
    	this.setRegion(east);
    	this.setRegion(tmpNorth);
    }
    
    public void turnCardLeft()	{
    	Region tmpNorth = this.getRegion(north);
    	this.setRegion(east);
    	this.setRegion(south);
    	this.setRegion(west);
    	this.setRegion(tmpNorth);
    } 
}






