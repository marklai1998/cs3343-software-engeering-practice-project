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
        Scanner scan = new Scanner(System.in);
        int id = getId(scan);
        String productName = getProductName(scan);
        String description = getProductDescription(scan);
        double price = getPrice(scan);
        double cost = getCost(scan);
        int stock = getStock(scan);

        Product newProduct = new Product(id, productName, description, price, cost, stock);
        Product.addProduct(newProduct);

        System.out.println("Success!");
        DisplayHelper.pressEnterToContinue();
    }

    private static int getId(Scanner scan) {
        while (true) {
            try {
                System.out.println("Product id: ");
                int id = scan.nextInt();

                if (Product.getProduct(id) != null) {
                    System.out.println("id already exist!"); 
                    DisplayHelper.pressEnterToContinue();
                } else return id;
            } catch (Exception e) {
            	e.printStackTrace();
                System.out.println("Invalid input! id must be a number");
                DisplayHelper.pressEnterToContinue();
            }
        }
    }

    private static String getProductName(Scanner scan) {
        while (true) {

            System.out.println("Product name: ");
            String productName = scan.nextLine();

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

    private static String getProductDescription(Scanner scan) {
        while (true) {

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

    private static double getPrice(Scanner scan) {
        while (true) {
            try {

                System.out.println("Price: ");
                return scan.nextDouble();
            } catch (Exception e) {
                System.out.println("Invalid input! Price must be a number");
                DisplayHelper.pressEnterToContinue();
            }
        }
    }

    private static double getCost(Scanner scan) {
        while (true) {
            try {

                System.out.println("Cost: ");
                return scan.nextDouble();
            } catch (Exception e) {
                System.out.println("Invalid input! Cost must be a number");
                DisplayHelper.pressEnterToContinue();
            }
        }
    }

    private static int getStock(Scanner scan) {
        while (true) {
            try {

                System.out.println("Stock: ");
                return scan.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Stock must be a number");
                DisplayHelper.pressEnterToContinue();
            }
        }
    }

}
