package edu.wccnet.wggreen.studentApp.Service;

import java.util.List;

import edu.wccnet.wggreen.studentApp.entity.Order;

public interface OrderService {

	public List<Order> getOrders(int customerId);

	public void saveOrder(Order theOrder);

	public Order getOrder(int id);

	public void deleteOrder(int id);

}
