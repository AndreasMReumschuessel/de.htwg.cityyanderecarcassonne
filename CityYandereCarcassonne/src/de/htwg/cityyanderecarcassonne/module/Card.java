package de.htwg.cityyanderecarcassonne.module;

/**
 * Created by anreumsc on 15.04.2016.
 * Last modified by hekrause on 27.04.2016
 */
public class Card {

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
}