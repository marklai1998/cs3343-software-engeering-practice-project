package com.inventoryManagementSystem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PriceChange {
    private int id;
    private int productId;
    private double changeRate;
    private Date startDate;
    private Date endDate;
    private static CSVHelper priceChangeData = new CSVHelper("/com/inventoryManagementSystem/Data/priceChange.csv");

    public PriceChange(int id, int productId, double changeRate, Date startDate, Date endDate) {
        this.id = id;
        this.productId = productId;
        this.changeRate = changeRate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
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

    public static void addPriceChange(PriceChange priceChange) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String[] newPriceChange = {Integer.toString(priceChange.getId()), Integer.toString(priceChange.getProductId()), Double.toString(priceChange.getChangeRate()), dateFormat.format(priceChange.getStartDate()), dateFormat.format(priceChange.getEndDate())};
        priceChangeData.insertOne(newPriceChange);
    }

    public static PriceChange[] getAllPriceChange() {
        try {
            DisplayHelper.printHeader();
            ArrayList<String[]> allData = priceChangeData.getCsvBuffer();

            PriceChange[] allPriceChange = new PriceChange[allData.size()];
            for (int i = 0; i < allData.size(); i++) {
                String[] productData = allData.get(i);
                PriceChange priceChange = new PriceChange(Integer.parseInt(productData[0]), Integer.parseInt(productData[1]), Double.parseDouble(productData[2]), new SimpleDateFormat("dd/MM/yyyy").parse(productData[3]), new SimpleDateFormat("dd/MM/yyyy").parse(productData[4]));
                allPriceChange[i] = priceChange;
            }
            return allPriceChange;
        } catch (Exception e) {
//            Do nothing
        }
        return new PriceChange[0];
    }

    public static PriceChange getPriceChange(int id) {
        try {
            String[] matcher = {Integer.toString(id), null, null, null, null};
            String[] matchedData = priceChangeData.findOne(matcher);
            if (matchedData == null) return null;
            return new PriceChange(Integer.parseInt(matchedData[0]), Integer.parseInt(matchedData[1]), Double.parseDouble(matchedData[2]), new SimpleDateFormat("dd/MM/yyyy").parse(matchedData[3]), new SimpleDateFormat("dd/MM/yyyy").parse(matchedData[4]));
        } catch (Exception e) {
//            Do nothing
        }
        return null;
    }

    public static PriceChange[] getPriceChange(Product product) {
        try {
            String[] matcher = {null, Integer.toString(product.getId()), null, null, null};
            String[][] result = priceChangeData.find(matcher);

            Date now = new Date(System.currentTimeMillis());
            ArrayList<PriceChange> allPriceChange = new ArrayList<>();
            for (String[] productData : result) {
                Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(productData[3]);
                Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(productData[4]);

                if (startDate.before(now) && endDate.after(now)) {
                    PriceChange priceChange = new PriceChange(Integer.parseInt(productData[0]), Integer.parseInt(productData[1]), Double.parseDouble(productData[2]), startDate, endDate);
                    allPriceChange.add(priceChange);
                }
            }
            return allPriceChange.toArray(new PriceChange[0]);
        } catch (Exception e) {
//            Do nothing
        }
        return new PriceChange[0];
    }

    public static void removePriceChange(int id) {
        String[] matcher = {Integer.toString(id), null, null, null, null};
        priceChangeData.findOneAndRemove(matcher);
    }

    public static void updatePriceChange(PriceChange priceChange) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String[] matcher = {Integer.toString(priceChange.getId()), null, null, null, null};
        String[] update = {null, Integer.toString(priceChange.getProductId()), Double.toString(priceChange.getChangeRate()), dateFormat.format(priceChange.getStartDate()), dateFormat.format(priceChange.getEndDate())};
        priceChangeData.findOneAndUpdate(matcher, update);
    }
}
