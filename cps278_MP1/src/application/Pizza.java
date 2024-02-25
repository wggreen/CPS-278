package application;

import java.util.ArrayList;

public class Pizza {
	private char size;
	private ArrayList<String> toppings;
	private int numOfToppings;
	
	public Pizza() {
		this.toppings = new ArrayList<>();
	}

	public char getSize() {
		return size;
	}

	public void setSize(char size) {
		this.size = size;
	}

	public void addTopping(String topping) {
		this.toppings.add(topping);
	}

	public int getNumOfToppings() {
		return numOfToppings;
	}

	public void setNumOfToppings(int numOfToppings) {
		this.numOfToppings = numOfToppings;
	}

	public void displayPizza() {
		System.out.print(this.size + " ");
		for (String topping : this.toppings) {
			System.out.print(topping + " ");
		}
		System.out.println();
	}

}
