package hackathon;

import entities.Bill;
import entities.Location;

public class Train {
	public Integer id;
	public Integer version;
	public Bill bill;
	public Integer step;
	public boolean active;
	public Location current;
	
	public Train(Integer id, Integer version, Bill bill, Integer step, boolean active, Location current){
		this.id = id;
		this.version = version;
		this.bill = bill;
		this.step = step;
		this.active = active;
		this.current = current;	
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

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Location getCurrent() {
		return current;
	}

	public void setCurrent(Location current) {
		this.current = current;
	}
}
