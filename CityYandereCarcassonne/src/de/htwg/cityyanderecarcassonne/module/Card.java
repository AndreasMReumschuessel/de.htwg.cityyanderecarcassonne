package de.htwg.cityyanderecarcassonne.module;

/**
 * Created by anreumsc on 15.04.2016.
 */
public class Card {

    private Edge north;
    private Edge east;
    private Edge south;
    private Edge west;
    private Center center;

    public Card(Edge north, Edge east, Edge south, Edge west, Center center) {
        setEdgeNorth(north);
        setEdgeEast(east);
        setEdgeSouth(south);
        setEdgeWest(west);
        setCenter(center);
    }

    public Edge getEdgeNorth() {
        return north;
    }

    public Edge getEdgeEast() {
        return east;
    }

    public Edge getEdgeSouth() {
        return south;
    }

    public Edge getEdgeWest() {
        return west;
    }

    public Center getCenter() {
        return center;
    }

    public void setEdgeNorth(Edge north) {
        this.north = north;
    }

    public void setEdgeEast(Edge east) {
        this.east = east;
    }

    public void setEdgeSouth(Edge south) {
        this.south = south;
    }

    public void setEdgeWest(Edge west) {
        this.west = west;
    }

    public void setCenter(Center center) {
        this.center = center;
    }
}