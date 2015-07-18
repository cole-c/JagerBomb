package entities;

public class Location extends OutputData{
	String city;
	String state;
	
	public Location(Integer id, Integer version, String city, String state){
		this.id = id;
		this.version = version;
		this.city = city;
		this.state = state;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}

}
