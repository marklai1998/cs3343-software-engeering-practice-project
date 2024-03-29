package com.inventoryManagementSystem.Commands;

import com.inventoryManagementSystem.Utils.DisplayHelper;
import com.inventoryManagementSystem.Modals.Product;

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
        int id = getId();
        Product product = Product.getProduct(id);

        String productName = getProductName(product.getName());
        String description = getProductDescription(product.getDescription());
        double price = getPrice(product.getPrice());
        double cost = getCost(product.getCost());
        int stock = getStock(product.getStock());

        Product newProduct = new Product(id, productName, description, price, cost, stock);
        Product.updateProduct(newProduct);

        System.out.println("Success!");
        DisplayHelper.pressEnterToContinue();
    }

    private static int getId() {
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("Product id: ");
                int id = scan.nextInt();

                if (Product.getProduct(id) == null) {
                    System.out.println("Product not exist!");
                    DisplayHelper.pressEnterToContinue();
                } else return id;
            } catch (Exception e) {
                System.out.println("Invalid input! id must be a number");
                DisplayHelper.pressEnterToContinue();
            }
        }
    }

    private static String getProductName(String name) {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Product name (" + name + ") :");
            String newName = scan.nextLine();

            if (newName.equals("")) return name;

            if (Product.getProduct(newName) != null) {
                System.out.println("Product already exist!");
                DisplayHelper.pressEnterToContinue();
            }
            return newName;
        }
    }

    private static String getProductDescription(String description) {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Description (" + description + ") :");
            String newDescription = scan.nextLine();

            if (newDescription.equals("")) return description;
            return newDescription;
        }
    }

    private static double getPrice(double price) {
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("Price (" + price + ") :");
                return Double.parseDouble(scan.nextLine());
            } catch (Exception e) {
                return price;
            }
        }
    }

    private static double getCost(double cost) {
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("Cost (" + cost + ") :");
                return Double.parseDouble(scan.nextLine());
            } catch (Exception e) {
                return cost;
            }
        }
    }

    private static int getStock(int stock) {
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("Stock (" + stock + ") :");
                return Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                return stock;
            }
        }
    }

}
