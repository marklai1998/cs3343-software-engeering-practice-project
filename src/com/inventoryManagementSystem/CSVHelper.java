package com.inventoryManagementSystem;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class CSVHelper {
    private String path;

    public CSVHelper(String path) {
        URL url = getClass().getResource(path);
        this.path = url.getFile();
    }

    private ArrayList<String[]> getCsvBuffer() {
        try {
            ArrayList<String[]> Buffer = new ArrayList<>();
            BufferedReader csvReader = new BufferedReader(new FileReader(path));
            String row;
            while ((row = csvReader.readLine()) != null) Buffer.add(row.split(","));
            csvReader.close();
            return Buffer;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String[] findOne(String[] matcher) {
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(path));
            String row;
            String[] matchedData = null;
            while ((row = csvReader.readLine()) != null) {
                String[] rowData = row.split(",");
                boolean matched = true;
                for (int i = 0; i < rowData.length; i++) {
                    if (matcher[i] != null && !matcher[i].equals(rowData[i])) {
                        matched = false;
                        break;
                    }
                }
                if (matched) {
                    matchedData = rowData;
                    break;
                }
            }
            csvReader.close();
            return matchedData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void findOneAndUpdate(String[] matcher, String[] update) {
        try {
            ArrayList<String[]> Buffer = getCsvBuffer();
//            write a new csv with new data
            FileWriter csvWriter = new FileWriter(path);
            for (String[] rowData : Buffer) {
                boolean matched = true;
                for (int i = 0; i < rowData.length; i++) {
                    if (matcher[i] != null && !matcher[i].equals(rowData[i])) {
                        matched = false;
                        break;
                    }
                }
                String[] newRow = new String[rowData.length];
                if (matched) {
                    for (int i = 0; i < newRow.length; i++) {
                        newRow[i] = update[i] == null ? rowData[i] : update[i];
                    }
                } else {
                    newRow = rowData;
                }
                csvWriter.append(String.join(",", newRow));
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertOne(String[] data) {
        try {
            ArrayList<String[]> Buffer = getCsvBuffer();
//            write a new csv with new data
            FileWriter csvWriter = new FileWriter(path);
            for (String[] rowData : Buffer) {
                csvWriter.append(String.join(",", rowData));
                csvWriter.append("\n");
            }
            csvWriter.append(String.join(",", data));
            csvWriter.append("\n");
            csvWriter.flush();
            csvWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
