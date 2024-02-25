package edu.wccnet.wggreen.MP5.Service;

import java.util.List;
import edu.wccnet.wggreen.MP5.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers(String sort);

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

}
