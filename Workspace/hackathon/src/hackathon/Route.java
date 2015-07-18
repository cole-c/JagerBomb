package hackathon;

import java.util.ArrayList;

public class Route {
	public Integer id;
	public Integer version;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
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
