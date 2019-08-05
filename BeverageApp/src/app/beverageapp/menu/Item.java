package app.beverageapp.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item {

	private String name;

	private List<String> compulsaryIngredients = new ArrayList<String>();

	private List<String> goodToHaveIngredients = new ArrayList<String>();

	private double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<String> getCompulsaryIngredients() {
		return compulsaryIngredients;
	}

	public List<String> getGoodToHaveIngredients() {
		return goodToHaveIngredients;
	}

	public void addCompulsaryIngredients(String ingredients) {
		for (String ingredient : Arrays.asList(ingredients.split(","))) {
			compulsaryIngredients.add(ingredient.trim());
		}

	}

	public void addGoodToHaveIngredients(String ingredients) {
		for (String ingredient : Arrays.asList(ingredients.split(","))) {
			goodToHaveIngredients.add(ingredient.trim());
		}
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", compulsaryIngredients=" + compulsaryIngredients + ", goodToHaveIngredients="
				+ goodToHaveIngredients + ", price=" + price + "]";
	}

}
