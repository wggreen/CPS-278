package edu.wccnet.wggreen.MP5.Service;

import java.util.List;

import edu.wccnet.wggreen.MP5.entity.Customer;
import edu.wccnet.wggreen.MP5.entity.Order;

public interface OrderService {

	public List<Order> getOrders(int customerId);

	public void saveOrder(Order theOrder);

	public Order getOrder(int id);

	public void deleteOrder(int id);

}
