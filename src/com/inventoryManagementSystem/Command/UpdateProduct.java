package com.inventoryManagementSystem.Command;

import com.inventoryManagementSystem.DisplayHelper;
import com.inventoryManagementSystem.Product;

import java.util.Scanner;

public class UpdateProduct implements IMSCommand {
	public int getMinPermission() {
		return 2;
	}

	public String getDescription() {
		return "Update product information";
	}

	public void execute() {
		DisplayHelper.cls();
		DisplayHelper.printHeader();
		Scanner scan = new Scanner(System.in);
		int id = getId(scan);
		Product product = Product.getProduct(id);

		String productName = getProductName(scan, product.getName());
		String description = getProductDescription(scan, product.getDescription());
		double price = getPrice(scan, product.getPrice());
		double cost = getCost(scan, product.getCost());
		int stock = getStock(scan, product.getStock());

		Product newProduct = new Product(id, productName, description, price, cost, stock);
		Product.updateProduct(newProduct);

		System.out.println("Success!");
		DisplayHelper.pressEnterToContinue();
	}

	private static int getId(Scanner scan) {
		while (true) {
			try {
				System.out.println("Product id: ");
				int id = scan.nextInt();

				if (Product.getProduct(id) == null) {
					System.out.println("Product not exist!");
					DisplayHelper.pressEnterToContinue();
				} else
					return id;
			} catch (Exception e) {
				System.out.println("Invalid input! id must be a number");
				DisplayHelper.pressEnterToContinue();
			}
		}
	}

	private static String getProductName(Scanner scan, String name) {
		while (true) {
			System.out.println("Product name (" + name + ") :");
			String newName = scan.nextLine();

			if (newName.equals(""))
				return name;

			if (Product.getProduct(newName) != null) {
				System.out.println("Product already exist!");
				DisplayHelper.pressEnterToContinue();
			}
			return newName;
		}
	}

	private static String getProductDescription(Scanner scan, String description) {
		while (true) {
			System.out.println("Description (" + description + ") :");
			String newDescription = scan.nextLine();

			if (newDescription.equals(""))
				return description;
			return newDescription;
		}
	}

	private static double getPrice(Scanner scan, double price) {
		while (true) {
			try {
				System.out.println("Price (" + price + ") :");
				return Double.parseDouble(scan.nextLine());
			} catch (Exception e) {
				return price;
			}
		}
	}

	private static double getCost(Scanner scan, double cost) {
		while (true) {
			try {
				System.out.println("Cost (" + cost + ") :");
				return Double.parseDouble(scan.nextLine());
			} catch (Exception e) {
				return cost;
			}
		}
	}

	private static int getStock(Scanner scan, int stock) {
		while (true) {
			try {
				System.out.println("Stock (" + stock + ") :");
				return Integer.parseInt(scan.nextLine());
			} catch (Exception e) {
				return stock;
			}
		}
	}

}
