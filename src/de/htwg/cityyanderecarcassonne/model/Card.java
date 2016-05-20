package de.htwg.cityyanderecarcassonne.model;

public class Card implements Space{

    private Region north;
    private Region east;
    private Region south;
    private Region west;
    private Region center;

    public Card(Region north, Region east, Region south, Region west, Region center) {
        setRegionNorth(north);
        setRegionEast(east);
        setRegionSouth(south);
        setRegionWest(west);
        setRegionCenter(center);
    }

    public Region getRegionNorth() {
        return north;
    }

    public Region getRegionEast() {
        return east;
    }

    public Region getRegionSouth() {
        return south;
    }

    public Region getRegionWest() {
        return west;
    }

    public Region getRegionCenter() {
        return center;
    }

    public void setRegionNorth(Region north) {
        this.north = north;
    }

    public void setRegionEast(Region east) {
        this.east = east;
    }

    public void setRegionSouth(Region south) {
        this.south = south;
    }

    public void setRegionWest(Region west) {
        this.west = west;
    }

    public void setRegionCenter(Region center) {
        this.center = center;
    }
    
    public void turnCardRight()	{
    	Region tmpNorth = this.getRegionNorth();
    	this.setRegionNorth(west);
    	this.setRegionWest(south);
    	this.setRegionSouth(east);
    	this.setRegionEast(tmpNorth);
    }
    
    public void turnCardLeft()	{
    	Region tmpNorth = this.getRegionNorth();
    	this.setRegionNorth(east);
    	this.setRegionEast(south);
    	this.setRegionSouth(west);
    	this.setRegionWest(tmpNorth);
    } 
}






