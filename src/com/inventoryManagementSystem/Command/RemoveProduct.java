package com.inventoryManagementSystem.Command;

import com.inventoryManagementSystem.DisplayHelper;
import com.inventoryManagementSystem.Product;

import java.util.Scanner;

public class RemoveProduct implements IMSCommand {
	public int getMinPermission() {
		return 2;
	}

	public String getDescription() {
		return "Remove product";
	}

	public void execute() {
		DisplayHelper.cls();
		DisplayHelper.printHeader();
		Scanner scan = new Scanner(System.in);
		int id = getId(scan);

		Product.removeProduct(id);

		System.out.println("Success!");
		DisplayHelper.pressEnterToContinue();

	}

	private static int getId(Scanner scan) {
		while (true) {
			try {
				System.out.println("Product id: ");
				int id = scan.nextInt();
				if (Product.getProduct(id) == null) {
					System.out.println("id doesn't exist!");
					DisplayHelper.pressEnterToContinue();
				} else
					return id;
			} catch (Exception e) {
				System.out.println("Invalid input! id must be a number");
				DisplayHelper.pressEnterToContinue();
			}
		}
	}
}
