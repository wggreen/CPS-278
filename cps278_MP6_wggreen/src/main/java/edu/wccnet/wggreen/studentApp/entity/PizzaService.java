package edu.wccnet.wggreen.studentApp.entity;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class PizzaService {

	public Map<String, String> populateSize() {
		Map<String, String> sizeList = new LinkedHashMap<String, String>();

		sizeList.put("Small", "Small");
		sizeList.put("Medium", "Medium");
		sizeList.put("Large", "Large");
		sizeList.put("Party", "Party");

		return sizeList;

	}

	public Map<String, String> populateTopping() {
		Map<String, String> toppingList = new LinkedHashMap<String, String>();

		toppingList.put("Mushroom", "Mushroom");
		toppingList.put("Pineapple", "Pineapple");
		toppingList.put("Black olives", "Black olives");
		toppingList.put("Green pepper", "Green pepper");
		toppingList.put("Tomato", "Tomato");
		toppingList.put("Spinach", "Spinach");
		toppingList.put("Pepperoni", "Pepperoni");
		toppingList.put("Sausage", "Sausage");
		toppingList.put("Ham", "Ham");
		toppingList.put("Bacon", "Bacon");

		return toppingList;

	}

	public Map<String, String> populateState() {
		Map<String, String> stateList = new LinkedHashMap<String, String>();

		stateList.put("MI", "MI");
		stateList.put("OH", "OH");
		stateList.put("WI", "WI");
		stateList.put("NJ", "NJ");

		return stateList;

	}
}
