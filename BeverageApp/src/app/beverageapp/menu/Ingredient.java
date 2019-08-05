package app.beverageapp.menu;

public enum Ingredient {

	MILK("milk", 1.0), SUGAR("sugar", 0.5), SODA("soda", 0.5), MINT("water", 0.5), WATER("water", 0.5);

	private Ingredient(String name, double price) {
		this.name = name;
		this.price = price;
	}

	private String name;
	private double price;

	public static Ingredient getByName(String name) {
		for (Ingredient ingredient : Ingredient.values()) {
			if(ingredient.name.toString().equalsIgnoreCase(name)) {
				return ingredient;
			}
		}
		return null;
	}
	

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

}
