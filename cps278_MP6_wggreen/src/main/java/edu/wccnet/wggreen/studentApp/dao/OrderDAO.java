package edu.wccnet.wggreen.studentApp.dao;

import java.util.List;

import edu.wccnet.wggreen.studentApp.entity.Order;

public interface OrderDAO {

	public List<Order> getOrders(int customerId);

	public void saveOrder(Order theOrder);

	public Order getOrder(int id);

	public void deleteOrder(int id);
}
