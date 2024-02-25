package edu.wccnet.wggreen.studentApp.Service;

import java.util.List;

import edu.wccnet.wggreen.studentApp.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers(String sort);

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

}
