package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import model.Groceries;

//class for the delete the product from the grocery by the seller
public class DeleteProducts {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public List<Groceries> deleteProducts(List<Groceries> groceryList) throws NumberFormatException, IOException {

		System.out.println("Enter the name of which product want to delete");
		String name = br.readLine();
		Groceries gro1 = null;
		for (Groceries gro : groceryList) {
			if (name.equals(gro.getProductName())) {
				gro1 = gro;
			}
		}
		if (groceryList.remove(gro1)) {
			return groceryList;
		}
		return groceryList;
	}

}
