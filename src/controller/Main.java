package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import service.EMandiOperations;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Create a object of the EmandiOperations for the seller and buyer
		EMandiOperations emandi = new EMandiOperations();
		int flag = 0;
		while (true) {
			// View the options to user
			System.out.println("1. SignIn as Buyer\n2. SignIn as Seller\n3. Logout");
			int option = Integer.parseInt(br.readLine());
			// user Cases
			switch (option) {
			case 1: {
				// for the buyers
				emandi.buyerOperation();
				break;
			}
			case 2: {
				// for the sellers
				emandi.sellerOperation();
				break;
			}
			// for the logout
			case 3: {
				flag = 1;
				break;
			}
			}
			if (flag == 1)
				break;
		}

	}

}
