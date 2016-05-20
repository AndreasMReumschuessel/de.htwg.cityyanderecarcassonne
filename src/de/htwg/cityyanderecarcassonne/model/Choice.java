package de.htwg.cityyanderecarcassonne.model;

public class Choice implements Space {
	
    private Region north;
    private Region east;
    private Region south;
    private Region west;
    private Region center;

    public Choice(Region north, Region east, Region south, Region west, Region center) {
        setRegionNorth(north);
        setRegionEast(east);
        setRegionSouth(south);
        setRegionWest(west);
        setRegionCenter(center);
    }

	@Override
	public Region getRegionNorth() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Region getRegionEast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Region getRegionSouth() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Region getRegionWest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Region getRegionCenter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRegionNorth(Region north) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRegionEast(Region east) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRegionSouth(Region south) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRegionWest(Region west) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRegionCenter(Region center) {
		// TODO Auto-generated method stub
		
	}

}
