package webstore.domain;

public class Customer {
	private long customerId;
	private String name;
	private String adress;
	private int noOfOrdersMade;
	
	public Customer() {
		super();
		}
	
	public Customer(long customerId, String name) {
		this.setCustomerId(customerId);
		this.setName(name);	
	}

	public double getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getNoOfOrdersMade() {
		return noOfOrdersMade;
	}

	public void setNoOfOrdersMade(int noOfOrdersMade) {
		this.noOfOrdersMade = noOfOrdersMade;
	}
	
	
	
}
