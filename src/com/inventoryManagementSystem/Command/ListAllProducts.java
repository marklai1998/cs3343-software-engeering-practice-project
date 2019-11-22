package com.inventoryManagementSystem.Command;

import com.inventoryManagementSystem.DisplayHelper;
import com.inventoryManagementSystem.PriceChange;
import com.inventoryManagementSystem.Product;

public class ListAllProducts implements IMSCommand {
    public int getMinPermission() {
        return 0;
    }

    public String getDescription() {
        return "List all products";
    }

    public void execute() {
        DisplayHelper.cls();
        DisplayHelper.printHeader();
        Product[] products = Product.getAllProducts();

        for (Product product : products) {
            PriceChange[] priceChanges = PriceChange.getPriceChange(product);

            double finalChangeRate = 0;
            for (PriceChange priceChange : priceChanges) {
                if (finalChangeRate == 0) finalChangeRate = priceChange.getChangeRate();
                else finalChangeRate = finalChangeRate * priceChange.getChangeRate();
            }

            System.out.println("Product id: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());

            if (finalChangeRate > 0) {
                System.out.println("Original Price: " + product.getPrice());
                System.out.println("Final Price: " + product.getPrice() + "*" + finalChangeRate + "=" + product.getPrice() * finalChangeRate);
            } else {
                System.out.println("Price: " + product.getPrice());
            }

            System.out.println("Cost: " + product.getCost());
            System.out.println("Stock: " + product.getStock());
            System.out.println();
        }
        DisplayHelper.pressEnterToContinue();
    }
}
