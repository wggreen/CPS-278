package edu.wccnet.wggreen.studentApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.wggreen.studentApp.dao.OrderDAO;
import edu.wccnet.wggreen.studentApp.entity.Order;

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
