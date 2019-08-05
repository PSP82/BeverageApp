package app.beverageapp.factory;

import app.beverageapp.exception.InvalidOperationException;
import app.beverageapp.exception.ItemNotFoundException;
import app.beverageapp.menu.DataLoader;
import app.beverageapp.menu.Ingredient;
import app.beverageapp.menu.Item;

public class BeverageFactory {

	private static BeverageFactory INSTANCE = new BeverageFactory();

	private BeverageFactory() {

	}

	public static BeverageFactory getInstance() {
		return INSTANCE;
	}

	public double getInvoiceFromOrder(String order) {

		if (order == null) {
			System.out.println("No item :");
			return 0.0;
		}
		
		String[] orderItems = order.split(",");
		
		String menuitem = orderItems[0];
		DataLoader db = new DataLoader();
		Item item = db.getItemByName(menuitem);
		double price = item.getPrice();

		for (int i = 1; i < orderItems.length; i++) {
			String orderIngName = orderItems[i];
			
			if (orderIngName.contains("-")) {
				orderIngName = orderIngName.replace("-", "").trim();
				Ingredient ing = Ingredient.getByName(orderIngName);
				handleExceptions(item, orderIngName, ing);
				price = price - ing.getPrice();
			} else {
				Ingredient ing = Ingredient.getByName(orderIngName);
				handleExceptions(item, orderIngName, ing);
				price = price + ing.getPrice();
			}

		}
		return price;
	}

	private void handleExceptions(Item item, String orderIngName, Ingredient ing) {
		if(item.getCompulsaryIngredients().contains(orderIngName)) {
			throw new InvalidOperationException(item.getName() +" cannot be made without "+ing.getName());
		}
		if(!item.getGoodToHaveIngredients().contains(orderIngName)) {
			throw new ItemNotFoundException(orderIngName+" is not part of "+item.getName());
		}else {
			item.getGoodToHaveIngredients().remove(orderIngName);
		}
	}
}
