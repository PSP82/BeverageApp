package app.beverageapp.client;

import app.beverageapp.factory.BeverageFactory;

public class BeverageAppTest {

	public static void main(String[] args) {

		BeverageFactory factory = BeverageFactory.getInstance();

//        Modify the below string and run the program to calculate your order cost
		String order = "Chai, -milk, -sugar, -milk";
		
		try {
		final double cost = factory.getInvoiceFromOrder(order);
		System.out.println("Your total cost is: " + cost);
		}catch(Exception ex) {
			System.out.println("Please check your ingredient for item you ordered : "+ex.getMessage());
		}
		

	}

}
