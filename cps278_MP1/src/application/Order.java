package application;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
	private Customer customer;
	private ArrayList<Pizza> pizzas;
	private int numOfPizzas;
	
	public Order() {
		this.customer = new Customer();
		this.numOfPizzas = 0;
		this.pizzas = new ArrayList<>();
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void addPizza(Pizza pizza) {
		this.pizzas.add(pizza);
	}

	public int getNumOfPizzas() {
		return numOfPizzas;
	}

	public void setNumOfPizzas(int numOfPizzas) {
		this.numOfPizzas = numOfPizzas;
	}

	public void displayOrder() {
		System.out.println("Order Confirmation:");
		System.out.println(this.customer.toString());
		System.out.println(numOfPizzas + " pizza/s");
		for (int i = 0; i < this.pizzas.size(); i++) {
			this.pizzas.get(i).displayPizza();
		}
	}

	public void enterCustomer() {
		Scanner kbInput = new Scanner(System.in);

		System.out.println("please enter your information");

		System.out.println("please enter your name");

		this.customer.setName(kbInput.nextLine());

		System.out.println("please enter your address:");

		System.out.println("please enter the street:");

		this.customer.getAddress().setStreet(kbInput.nextLine());

		System.out.println("please enter city:");

		this.customer.getAddress().setCity(kbInput.nextLine());

		System.out.println("please enter state:");

		this.customer.getAddress().setState(kbInput.nextLine());

		System.out.println("please enter zip code:");

		this.customer.getAddress().setZip(kbInput.nextLine());

	}

	public void placeOrder() {
		Scanner kbInput2 = new Scanner(System.in);

		System.out.println("how many pizzas do you want to order?");
		
		this.setNumOfPizzas(kbInput2.nextInt());

		for (int i = 1; i <= this.getNumOfPizzas(); i++) {
			
			Pizza pizza = new Pizza();

			System.out.println("info for pizza-" + i + ":");
			
			System.out.println("Please enter the size");
			
			pizza.setSize(kbInput2.next().charAt(0));

			System.out.println("please enter the number of toppings");

			pizza.setNumOfToppings(kbInput2.nextInt());

			System.out.println("choices are:");
			System.out.println("Mushroom");
			System.out.println("Pineapple");
			System.out.println("Zucchini");
			System.out.println("Tomato");
			System.out.println("Spinach");
			System.out.println("Artichoke");
			
			kbInput2.nextLine();

			for (int j = 1; j <= pizza.getNumOfToppings(); j++) {
				System.out.println("choose topping-" + j + ":");
				String topping = kbInput2.nextLine();
				pizza.addTopping(topping);
			}
			
			this.addPizza(pizza);

		}

	}

	public static void main(String[] args) {
		Order order = new Order();

		order.enterCustomer();

		order.placeOrder();
		
		order.displayOrder();

	}

}
