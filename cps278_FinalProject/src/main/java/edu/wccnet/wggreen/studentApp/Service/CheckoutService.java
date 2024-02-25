package edu.wccnet.wggreen.studentApp.Service;

import java.util.List;

import edu.wccnet.wggreen.studentApp.entity.Checkout;
import edu.wccnet.wggreen.studentApp.entity.Customer;
import edu.wccnet.wggreen.studentApp.entity.Movie;

public interface CheckoutService {
    public Checkout getCheckout(int id);
    
    public List<Checkout> getCheckoutsForCustomer(int customerId);

    public void saveCheckout(Checkout checkout);
}
