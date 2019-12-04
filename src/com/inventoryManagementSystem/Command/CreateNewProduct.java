package com.inventoryManagementSystem.Command;

import com.inventoryManagementSystem.DisplayHelper;
import com.inventoryManagementSystem.Product;
import com.inventoryManagementSystem.Staff;
import com.inventoryManagementSystem.UserGroup;

import java.util.Scanner;

public class CreateNewProduct implements IMSCommand {
    public int getMinPermission() {
        return 2;
    }

    public String getDescription() {
        return "Create new product";
    }

    public void execute() {
        DisplayHelper.cls();
        DisplayHelper.printHeader();
        int id = getId();
        String productName = getProductName();
        String description = getProductDescription();
        double price = getPrice();
        double cost = getCost();
        int stock = getStock();

        Product newProduct = new Product(id, productName, description, price, cost, stock);
        Product.addProduct(newProduct);

        System.out.println("Success!");
        DisplayHelper.pressEnterToContinue();
    }

    private static int getId() {
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("Product id: ");
                int id = scan.nextInt();

                if (Product.getProduct(id) != null) {
                    System.out.println("id already exist!");
                    DisplayHelper.pressEnterToContinue();
                } else return id;
            } catch (Exception e) {
                System.out.println("Invalid input! id must be a number");
                DisplayHelper.pressEnterToContinue();
            }
        }
    }

    private static String getProductName() {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Product name: ");
            String productName = scan.nextLine().replaceAll("\\s+", "");

            if (productName.equals("")) {
                System.out.println("Product name cannot be empty!");
                DisplayHelper.pressEnterToContinue();
                continue;
            }

            if (Product.getProduct(productName) != null) {
                System.out.println("Product already exist!");
                DisplayHelper.pressEnterToContinue();
            } else return productName;
        }
    }

    private static String getProductDescription() {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Description: ");
            String description = scan.nextLine();

            if (description.equals("")) {
                System.out.println("Description cannot be empty!");
                DisplayHelper.pressEnterToContinue();
                continue;
            }
            return description;
        }
    }

    private static double getPrice() {
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("Price: ");
                double price = scan.nextDouble();
                if (price < 0) {
                    System.out.println("Invalid input! Price must be a positive number");
                    DisplayHelper.pressEnterToContinue();
                    continue;
                }
                return price;
            } catch (Exception e) {
                System.out.println("Invalid input! Price must be a number");
                DisplayHelper.pressEnterToContinue();
            }
        }
    }

    private static double getCost() {
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("Cost: ");
                return scan.nextDouble();
            } catch (Exception e) {
                System.out.println("Invalid input! Cost must be a number");
                DisplayHelper.pressEnterToContinue();
            }
        }
    }

    private static int getStock() {
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("Stock: ");
                int stock = scan.nextInt();
                if (stock < 0) {
                    System.out.println("Invalid input! Stock must be a positive number");
                    DisplayHelper.pressEnterToContinue();
                    continue;
                }
                return stock;
            } catch (Exception e) {
                System.out.println("Invalid input! Stock must be a number");
                DisplayHelper.pressEnterToContinue();
            }
        }
    }

}
