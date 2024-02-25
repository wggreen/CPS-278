package edu.wccnet.wggreen.studentApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.wggreen.studentApp.Controller.NotFoundException;
import edu.wccnet.wggreen.studentApp.dao.CheckoutDAO;
import edu.wccnet.wggreen.studentApp.entity.Checkout;

@Service
public class CheckoutServiceImpl implements CheckoutService {

	@Autowired
	private CheckoutDAO checkoutDAO;

	@Override
	@Transactional
	public Checkout getCheckout(int id) {
		Checkout checkout = checkoutDAO.getCheckout(id);

		if (checkout == null) {
			throw new NotFoundException("checkout id not found. Id: " + id);
		}

		return checkout;
	}

	@Override
	@Transactional
	public List<Checkout> getCheckoutsForCustomer(int customerId) {
		return checkoutDAO.getCheckoutsForCustomer(customerId);
	}

	@Override
	@Transactional
	public void saveCheckout(Checkout checkout) {
		checkoutDAO.saveCheckout(checkout);

	}

}
