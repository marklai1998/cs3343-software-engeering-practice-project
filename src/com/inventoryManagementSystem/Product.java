package com.inventoryManagementSystem;

import java.util.ArrayList;

public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private double cost;
    private int stock;
    private static CSVHelper productData = new CSVHelper("/com/inventoryManagementSystem/Data/product.csv");
    ;

    public Product(int id, String name, String description, double price, double cost, int stock) {
        this.cost = cost;
        this.description = description;
        this.price = price;
        this.name = name;
        this.id = id;
        this.stock = stock;
    }

    public double getCost() {
        return cost;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public int getStock() {
        return stock;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public static Product[] getAllProducts() {
        DisplayHelper.printHeader();
        ArrayList<String[]> allData = productData.getCsvBuffer();

        Product[] products = new Product[allData.size()];
        for (int i = 0; i < allData.size(); i++) {
            String[] productData = allData.get(i);
            Product staff = new Product(Integer.parseInt(productData[0]), productData[1], productData[2], Integer.parseInt(productData[3]), Integer.parseInt(productData[4]), Integer.parseInt(productData[5]));
            products[i] = staff;
        }
        return products;
    }

}
