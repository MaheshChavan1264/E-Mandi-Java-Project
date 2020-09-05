package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Groceries;

//class for the add products in the grocery for the sellers
public class AddProducts {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public Groceries addproducts() throws NumberFormatException, IOException {
		// take the inputs from the sellers which are added to the grocery list
		System.out.println("Enter the product id");
		int id = Integer.parseInt(br.readLine());
		System.out.println("Enter the product name");
		String name = br.readLine();
		System.out.println("Enter the product quantity");
		double quantity = Double.parseDouble(br.readLine());
		System.out.println("Enter the product price");
		double price = Double.parseDouble(br.readLine());
		// create the object of the grocery
		Groceries grocery = new Groceries(id, name, quantity, price);
		return grocery;
	}
}
