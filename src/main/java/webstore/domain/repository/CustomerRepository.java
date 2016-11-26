package webstore.domain.repository;

import java.util.List;

import webstore.domain.Customer;

public interface CustomerRepository {
	List <Customer> getAllCustomers();
}
