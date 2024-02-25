package edu.wccnet.wggreen.studentApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.wggreen.studentApp.Controller.NotFoundException;
import edu.wccnet.wggreen.studentApp.dao.CustomerDAO;
import edu.wccnet.wggreen.studentApp.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		Customer customer = customerDAO.getCustomer(id);

		if (customer == null) {
			throw new NotFoundException("customer id not found. Id: " + id);
		}

		return customer;
	}

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

}
