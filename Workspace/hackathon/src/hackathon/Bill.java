package hackathon;

public class Bill {
	public Integer id;
	public Integer version;
	public Customer customer;
	public Route route;
	public Integer charge;
	
	public Bill(Integer id, Integer version, Customer customer, Route route, Integer charge){
		this.id = id;
		this.version = version;
		this.customer = customer;
		this.route = route;
		this.charge = charge;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Integer getCharge() {
		return charge;
	}

	public void setCharge(Integer charge) {
		this.charge = charge;
	}
}
