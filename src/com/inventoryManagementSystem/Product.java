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
            Product product = new Product(Integer.parseInt(productData[0]), productData[1], productData[2], Double.parseDouble(productData[3]), Double.parseDouble(productData[4]), Integer.parseInt(productData[5]));
            products[i] = product;
        }
        return products;
    }

    public static void addProduct(Product product) {
        String[] newProduct = {Integer.toString(product.getId()), product.getName(), product.getDescription(), Double.toString(product.getPrice()), Double.toString(product.getCost()), Integer.toString(product.getStock())};
        productData.insertOne(newProduct);
    }

    public static void removeProduct(int id) {
        String[] matcher = {Integer.toString(id), null, null, null, null, null};
        productData.findOneAndRemove(matcher);
    }

    public static Product getProduct(int id) {
        String[] matcher = {Integer.toString(id), null, null, null, null, null};
        String[] matchedData = productData.findOne(matcher);
        if (matchedData == null) return null;
        return new Product(Integer.parseInt(matchedData[0]), matchedData[1], matchedData[2], Integer.parseInt(matchedData[3]), Integer.parseInt(matchedData[4]), Integer.parseInt(matchedData[5]));
    }

    public static Product getProduct(String name) {
        String[] matcher = {null, name, null, null, null, null};
        String[] matchedData = productData.findOne(matcher);
        if (matchedData == null) return null;
        return new Product(Integer.parseInt(matchedData[0]), matchedData[1], matchedData[2], Integer.parseInt(matchedData[3]), Integer.parseInt(matchedData[4]), Integer.parseInt(matchedData[5]));
    }
}
