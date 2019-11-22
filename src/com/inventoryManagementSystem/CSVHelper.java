package com.inventoryManagementSystem;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class CSVHelper {
    private String path;

    public CSVHelper(String path) {
    	/* Modified for Testing*/
    	
//        URL url = getClass().getResource(path);
//        this.path = url.getFile();
    	
    	this.path = path;
    	
    	/**********************/
    }
 
    public ArrayList<String[]> getCsvBuffer() {
        try {
            ArrayList<String[]> Buffer = new ArrayList<>(); 
            

        	/* Modified for Testing*/
            
//          BufferedReader csvReader = new BufferedReader(new FileReader(path));
            
			BufferedReader csvReader = new BufferedReader(
					new InputStreamReader(getClass().getResourceAsStream(this.path)));

	    	/**********************/
			
            String row;
            while ((row = csvReader.readLine()) != null) Buffer.add(row.split(","));
            csvReader.close();
            return Buffer;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setCsv(ArrayList<String[]> buffer) {
        try {

        	/* Modified for Testing*/
//            FileWriter csvWriter = new FileWriter(path); 

			URL url = getClass().getResource(this.path);

			File file = new File(url.toURI());
			FileWriter csvWriter = new FileWriter(file);
	    	/**********************/
			
            for (String[] rowData : buffer) {
                csvWriter.append(String.join(",", rowData));
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isRowMatch(String[] row, String[] matcher) {
        for (int i = 0; i < row.length; i++) {
            if (matcher[i] != null && !matcher[i].equals(row[i])) return false;
        }
        return true;
    }

    private String[] mergeRow(String[] originalRow, String[] newRow) {
        String[] mergedRow = new String[newRow.length];
        for (int i = 0; i < newRow.length; i++) {
            mergedRow[i] = newRow[i] == null ? originalRow[i] : newRow[i];
        }
        return mergedRow;
    }

    public String[][] find(String[] matcher) {
        ArrayList<String[]> Buffer = getCsvBuffer();
        ArrayList<String[]> result = new ArrayList<>();
        for (String[] rowData : Buffer) {
            if (isRowMatch(rowData, matcher)) result.add(rowData);
        }
        return result.toArray(new String[0][0]);
    }

    public String[] findOne(String[] matcher) {
        ArrayList<String[]> Buffer = getCsvBuffer();
        for (String[] rowData : Buffer) {
            if (isRowMatch(rowData, matcher)) return rowData;
        }
        return null;
    }

    public void findOneAndUpdate(String[] matcher, String[] update) {
        ArrayList<String[]> buffer = getCsvBuffer();
        for (int row = 0; row < buffer.size(); row++) {
            String[] rowData = buffer.get(row);
            if (isRowMatch(rowData, matcher)) {
                buffer.set(row, mergeRow(rowData, update));
                break;
            }
        }
        setCsv(buffer);
    }

    public void findOneAndRemove(String[] matcher) {
        ArrayList<String[]> buffer = getCsvBuffer();
        for (String[] rowData : buffer) {
            boolean matched = isRowMatch(rowData, matcher);
            if (matched) {
                buffer.remove(rowData);
                break;
            }
        }
        setCsv(buffer);
    }

    public void insertOne(String[] data) {
        ArrayList<String[]> buffer = getCsvBuffer();
        buffer.add(data);
        setCsv(buffer);
    }
}
