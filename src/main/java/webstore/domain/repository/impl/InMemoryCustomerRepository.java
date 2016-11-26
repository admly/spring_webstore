package webstore.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import webstore.domain.Customer;
import webstore.domain.repository.CustomerRepository;


@Repository
public class InMemoryCustomerRepository implements CustomerRepository {
	private List<Customer> listOfCustomers = new ArrayList<Customer>();
	
	public InMemoryCustomerRepository() {
		Customer test = new Customer(123, "Dummy");
		test.setAdress("testadress123");
		test.setNoOfOrdersMade(11);
		
		listOfCustomers.add(test);
	}
	
	

	public List<Customer> getAllCustomers() {
		return listOfCustomers;
	}
}
