package com.inventoryManagementSystem;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

class CSVHelper {
    BufferedReader csvReader;

    CSVHelper(String path) {
        try {
            InputStream in = getClass().getResourceAsStream(path);
            csvReader = new BufferedReader(new InputStreamReader(in));
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    String[] matchLine(String[] input) {
        try {
            String row;
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                boolean matched = true;
                for (int i = 0; i < data.length; i++) {
                    if (!input[i].equals("*") && !input[i].equals(data[i])) {
                        matched = false;
                        break;
                    }
                }
                if (matched) return data;
            }
        } catch (Exception e) {
//            Do nothing
        }
        return null;
    }

    void close() {
        try {
            csvReader.close();
        } catch (Exception e) {
//            Do nothing
        }
    }
}
