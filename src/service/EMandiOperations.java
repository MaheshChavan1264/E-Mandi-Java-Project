package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import model.Groceries;

//this class is for all the operations done in the e-mandi
public class EMandiOperations {
	static List<Groceries> groceryList = new ArrayList<Groceries>();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// method for the buyer
	public void buyerOperation() throws NumberFormatException, IOException {
		if (groceryList.isEmpty()) {
			groceryList.add(new Groceries(1, "Onion", 10, 50));
			groceryList.add(new Groceries(2, "Tomato", 10, 30));
			groceryList.add(new Groceries(3, "Urad dal", 5, 120));
			groceryList.add(new Groceries(4, "Carrot", 6, 70));
			groceryList.add(new Groceries(5, "Wheat Flour", 10, 50));
			System.out.println(groceryList);
		}
		int flag = 0;
		while (true) {
			// view the options for the buyer
			System.out.println("\n\n1. View Groceries\n2. Buy Groceries\n3. Exit");
			int option = Integer.parseInt(br.readLine());
			switch (option) {
			// case for the view available products in grocery
			case 1: {
				System.out.println(String.format("%-15s %-15s %-15s %25s", "Product Id", "Product Name",
						"Product Available Quantity", "Product Price per Kg"));
				for (Groceries gro : groceryList) {
					System.out.println(String.format("%-15s %-15s %-15s %25s", gro.getProductId(), gro.getProductName(),
							gro.getProductQuantity() + " in Kgs", "Rs. " + gro.getProductPrice()));
				}
				break;
			}
			case 2: {
				// case for the add the order for buy from the buyer
				System.out.println("Enter the product Id which you wish to buy");
				int productId = Integer.parseInt(br.readLine());
				System.out.println("Enter the quantity of product that you wish to buy");
				double productQuantity = Double.parseDouble(br.readLine());
				int temp = 0;
				for (Groceries gro : groceryList) {
					if (productId == gro.getProductId()) {
						if (productQuantity <= gro.getProductQuantity()) {
							gro.setProductQuantity(gro.getProductQuantity() - productQuantity);
							System.out.println("Successfully placed your order");
						} else {
							System.out.println("The entered quantity of product is not available. It's out of stock");
						}
						temp = 1;
					}
				}
				if (temp == 0) {
					System.out.println("The entered product id is not available here");
				}
				break;
			}
			case 3: {
				flag = 1;
				break;
			}
			default: {
				System.out.println("Enter valid option");
			}
			}
			if (flag == 1)
				break;
		}

	}

	// method for the seller in which he/she can add the products, update the
	// products, view the products and delete the products
	public void sellerOperation() throws NumberFormatException, IOException {
		Groceries groceries = null;
		int flag = 0;
		while (true) {
			System.out.println("1. Add Products\n2. View Products\n3. Update Products\n4. Delete Products\n5. Exit");
			int option = Integer.parseInt(br.readLine());
			switch (option) {
			case 1: {

				// case for the add products in the grocery
				AddProducts addProducts = new AddProducts();
				groceries = addProducts.addproducts();
				groceryList.add(groceries);
				break;
			}
			case 2: {

				// case for the view products in the grocery
				System.out.println(String.format("%-15s %-15s %-15s %25s", "Product Id", "Product Name",
						"Product Available Quantity", "Product Price per Kg"));
				for (Groceries gro : groceryList) {
					System.out.println(String.format("%-15s %-15s %-15s %25s", gro.getProductId(), gro.getProductName(),
							gro.getProductQuantity() + " in Kgs", "Rs. " + gro.getProductPrice()));
				}
				break;
			}

			case 3: {

				// case for the update products in the grocery
				UpdateProducts updatePd = new UpdateProducts();
				updatePd.updateProducts(groceryList);
				break;
			}
			case 4: {

				// case for the delete products in the grocery
				DeleteProducts deletePd = new DeleteProducts();
				deletePd.deleteProducts(groceryList);
				break;
			}
			case 5: {
				flag = 1;
				break;
			}
			}
			if (flag == 1)
				break;
		}

	}

}
