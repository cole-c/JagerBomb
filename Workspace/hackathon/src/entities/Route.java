package entities;

import java.util.ArrayList;

public class Route extends OutputData{
	public Location origin;
	public Location destination;
	public ArrayList<Location> locations;
	
	public Route(Integer id, Integer version, Location origin, Location destination, ArrayList<Location> locations){
		this.id = id;
		this.version = version;
		this.origin = origin;
		this.destination = destination;
		this.locations = locations;
	}

	public Location getOrigin() {
		return origin;
	}

	public void setOrigin(Location origin) {
		this.origin = origin;
	}

	public Location getDestination() {
		return destination;
	}

	public void setDestination(Location destination) {
		this.destination = destination;
	}

	public ArrayList<Location> getLocations() {
		return locations;
	}

	public void setLocations(ArrayList<Location> locations) {
		this.locations = locations;
	}
	
}
