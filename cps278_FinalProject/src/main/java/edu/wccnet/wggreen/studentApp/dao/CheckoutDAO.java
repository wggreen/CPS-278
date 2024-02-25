package edu.wccnet.wggreen.studentApp.dao;

import java.util.List;

import edu.wccnet.wggreen.studentApp.entity.Checkout;

public interface CheckoutDAO {
	public Checkout getCheckout(int id);
	
	public List<Checkout> getCheckoutsForCustomer(int customerId);
	
	public void saveCheckout(Checkout checkout);
	
}
