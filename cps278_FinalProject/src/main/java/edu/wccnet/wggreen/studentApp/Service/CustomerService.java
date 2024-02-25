package edu.wccnet.wggreen.studentApp.Service;

import java.util.List;

import edu.wccnet.wggreen.studentApp.entity.Customer;

public interface CustomerService {

	public Customer getCustomer(int id);

	public List<Customer> getCustomers();

}
