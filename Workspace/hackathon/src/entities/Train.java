package entities;

public class Train extends Entity{
	public Bill bill;
	public Integer step;
	public String active;
	public Location current;
	
	public Train(Integer id, Integer version, Bill bill, Integer step, String active, Location current){
		this.id = id;
		this.version = version;
		this.bill = bill;
		this.step = step;
		this.active = active;
		this.current = current;	
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

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Location getCurrent() {
		return current;
	}

	public void setCurrent(Location current) {
		this.current = current;
	}
}
