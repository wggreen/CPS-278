package edu.wccnet.wggreen.studentApp.dao;

import java.util.List;

import edu.wccnet.wggreen.studentApp.entity.Customer;

public interface CustomerDAO {

	public Customer getCustomer(int id);

	public List<Customer> getCustomers();

}
