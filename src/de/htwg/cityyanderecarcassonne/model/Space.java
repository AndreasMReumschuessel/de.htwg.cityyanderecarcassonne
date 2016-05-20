package de.htwg.cityyanderecarcassonne.model;

public interface Space {

    public Region getRegionNorth();

    public Region getRegionEast();

    public Region getRegionSouth();

    public Region getRegionWest();

    public Region getRegionCenter();

    public void setRegionNorth(Region north);

    public void setRegionEast(Region east);

    public void setRegionSouth(Region south);

    public void setRegionWest(Region west);

    public void setRegionCenter(Region center);
	
}
