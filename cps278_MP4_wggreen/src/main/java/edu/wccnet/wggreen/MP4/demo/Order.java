package edu.wccnet.wggreen.MP4.demo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pizza_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<Pizza> pizzas = new ArrayList<Pizza>();

	public void add(Pizza pizza) {
		pizzas.add(pizza);
		pizza.setOrder(this);
	}

	public void remove(Pizza pizza) {
		pizzas.remove(pizza);
	}

	public Order(Customer customer) {
		super();
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	@Override
	public String toString() {
		return "Order ID: " + id + ":\nPizza(s):\n" + pizzas + "\nCustomer: " + customer.getId();
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Order() {

	}
}