package com.inventoryManagementSystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PriceChange {
    private int productId;
    private double changeRate;
    private Date startDate;
    private Date endDate;
    private static CSVHelper priceChangeData = new CSVHelper("/com/inventoryManagementSystem/Data/priceChange.csv");

    public PriceChange(int productId, double changeRate, Date startDate, Date endDate) {
        this.productId = productId;
        this.changeRate = changeRate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public int getProductId() {
        return productId;
    }

    public double getChangeRate() {
        return changeRate;
    }

    public static PriceChange[] getAllPriceChange() {
        try {
            DisplayHelper.printHeader();
            ArrayList<String[]> allData = priceChangeData.getCsvBuffer();

            PriceChange[] allPriceChange = new PriceChange[allData.size()];
            for (int i = 0; i < allData.size(); i++) {
                String[] productData = allData.get(i);
                PriceChange priceChange = new PriceChange(Integer.parseInt(productData[0]), Double.parseDouble(productData[1]), new SimpleDateFormat("dd/MM/yyyy").parse(productData[2]), new SimpleDateFormat("dd/MM/yyyy").parse(productData[3]));
                allPriceChange[i] = priceChange;
            }
            return allPriceChange;
        } catch (Exception e) {
//            Do nothing
        }
        return new PriceChange[0];
    }
}
