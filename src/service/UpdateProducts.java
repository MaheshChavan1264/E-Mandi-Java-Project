package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import model.Groceries;

//this class is for the update products of the grocery which are updated from the sellers
//this option is only for the seller
public class UpdateProducts {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// method to update the products
	public List<Groceries> updateProducts(List<Groceries> groceryList) throws NumberFormatException, IOException {
		System.out.println("Enter the product name which is want to update");
		String name = br.readLine();
		int flag = 0;
		int index = 0;
		// find the products is present or not in the grocery products
		for (Groceries gro : groceryList) {
			if (name.equals(gro.getProductName())) {
				flag = 1;
				index = groceryList.indexOf(gro);
			} else {
				System.out.println("Enter the valid product name");
			}
		}
		// if products is found in the grocery then update the product with new product
		if (flag == 1) {
			System.out.println("Enter the new Product id");
			int newProductId = Integer.parseInt(br.readLine());
			System.out.println("Enter the new Product Name");
			String newProduct = br.readLine();
			System.out.println("Enter the new Product quantity");
			double newQuantity = Double.parseDouble(br.readLine());
			System.out.println("Enter the new product price");
			double newPrice = Double.parseDouble(br.readLine());
			Groceries gro1 = new Groceries(newProductId, newProduct, newQuantity, newPrice);
			groceryList.set(index, gro1);
		}
		return groceryList;
	}

}
