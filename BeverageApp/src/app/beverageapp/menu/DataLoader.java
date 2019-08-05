package app.beverageapp.menu;

import java.util.ArrayList;
import java.util.List;

import app.beverageapp.exception.ItemNotFoundException;

public class DataLoader {

	private List<Item> menuItems = new ArrayList<Item>();
	
	public DataLoader() {
		initDB();
	}

	public void initDB() {
		// 1. create coffee
		Item coffee = new Item();
		coffee.setName("Coffee");
		coffee.addCompulsaryIngredients("coffee, water");
		coffee.addGoodToHaveIngredients("milk, sugar,");
		coffee.setPrice(5.0);
		menuItems.add(coffee);

		// 2. create chai
		Item chai = new Item();
		chai.setName("Chai");
		chai.addCompulsaryIngredients("tea, water");
		chai.addGoodToHaveIngredients("milk, sugar,");
		chai.setPrice(4.0);
		menuItems.add(chai);

		// 3. create coffee
		Item bananaSmoothie = new Item();
		bananaSmoothie.setName("BananaSmoothie");
		bananaSmoothie.addCompulsaryIngredients("banana, water");
		bananaSmoothie.addGoodToHaveIngredients("milk, sugar,");
		bananaSmoothie.setPrice(6.0);
		menuItems.add(bananaSmoothie);

		// 4. create coffee
		Item strawberryShake = new Item();
		strawberryShake.setName("StrawberryShake");
		strawberryShake.addCompulsaryIngredients("Strawberries, water");
		strawberryShake.addGoodToHaveIngredients("milk, sugar,");
		strawberryShake.setPrice(7.0);
		menuItems.add(strawberryShake);

		// 5. create mojito
		Item mojito = new Item();
		mojito.setName("Mojito");
		mojito.addCompulsaryIngredients("lemon, mint, water");
		mojito.addGoodToHaveIngredients("soda, sugar,");
		mojito.setPrice(7.5);
		menuItems.add(mojito);

	}
	
	public List<Item> getAllItems() {
		return menuItems;
	}
	
	public Item getItemByName(String name){
		for(Item item : menuItems) {
			if(item.getName().equalsIgnoreCase(name)) {
				return item;
			}
		}
		throw new ItemNotFoundException("No item found by give name");
	}

	
}
