package edu.wccnet.wggreen.MP5.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.wggreen.MP5.dao.OrderDAO;
import edu.wccnet.wggreen.MP5.entity.Customer;
import edu.wccnet.wggreen.MP5.entity.Order;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	@Override
	@Transactional
	public List<Order> getOrders(int customerId) {
		return orderDAO.getOrders(customerId);
	}

	@Transactional
	public void saveOrder(Order theOrder) {
		orderDAO.saveOrder(theOrder);
	}

	@Transactional
	public Order getOrder(int id) {
		return orderDAO.getOrder(id);
	}

	@Transactional
	public void deleteOrder(int id) {
		orderDAO.deleteOrder(id);
	}

}
