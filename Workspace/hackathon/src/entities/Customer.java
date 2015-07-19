package entities;

public class Customer extends Entity{
	String name;
	Integer payments;
	
	public Customer(Integer id, Integer version, String name, Integer payments) {
		this.id = id;
		this.version = version;
		this.name = name;
		this.payments = payments;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getPayments() {
		return payments;
	}
	
	public void setPayments(Integer payments) {
		this.payments = payments;
	}

}
