package entities;

public class Producer extends Entity{
	
	String type;
	Integer id;
	Integer version;
	
	public Producer(String type, Integer id, Integer version) {
		this.type = type;
		this.id = id;
		this.version = version;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
