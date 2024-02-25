package edu.wccnet.wggreen.MP5.dao;

import java.util.List;

import edu.wccnet.wggreen.MP5.entity.Order;

public interface OrderDAO {

	public List<Order> getOrders(int customerId);

	public void saveOrder(Order theOrder);

	public Order getOrder(int id);

	public void deleteOrder(int id);
}
