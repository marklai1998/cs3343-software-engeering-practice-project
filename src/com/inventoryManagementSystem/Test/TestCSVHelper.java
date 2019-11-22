package com.inventoryManagementSystem.Test;

import org.junit.Test;

import com.inventoryManagementSystem.CSVHelper;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class TestCSVHelper {

	@Test
	public void testGetCsvBuffer_01() {
		String path = "/com/inventoryManagementSystem/Data/testCSVHelper_01.csv";

		CSVHelper csvHelper = new CSVHelper(path);

		ArrayList<String[]> result = csvHelper.getCsvBuffer();

		ArrayList<String[]> expectedResult = new ArrayList<String[]>();
		String[] matcher1 = { "0", "Harry", "Harry", "0" };
		String[] matcher2 = { "1", "Owen", "owen", "1" };
		String[] matcher3 = { "2", "admin", "admin", "2" };
		String[] matcher4 = { "3", "1", "2", "3" };
		expectedResult.add(matcher1);
		expectedResult.add(matcher2);
		expectedResult.add(matcher3);
		expectedResult.add(matcher4);

		assertArrayEquals(expectedResult.toArray(), result.toArray());
	}

	@Test
	public void testGetCsvBuffer_02() {
		String path = "/com/inventoryManagementSystem/Data/testCSVHelper_02.csv";

		CSVHelper csvHelper = new CSVHelper(path);

		ArrayList<String[]> result = csvHelper.getCsvBuffer();

		ArrayList<String[]> expectedResult = new ArrayList<String[]>();
		String[] matcher1 = { "0", "test1", "test2", "0" };
		String[] matcher2 = { "1", "test3", "12345**", "1" };
		String[] matcher3 = { "2", "abc__/", "def*^", "4" };
		expectedResult.add(matcher1);
		expectedResult.add(matcher2);
		expectedResult.add(matcher3);
		
		

		assertArrayEquals(expectedResult.toArray(), result.toArray());
	}
	
	
	@Test
	public void testSetCsv_01() {
		String path = "/com/inventoryManagementSystem/Data/testCSVHelper_01.csv";

		CSVHelper csvHelper = new CSVHelper(path);

		ArrayList<String[]> buffer = new ArrayList<String[]>();
		String[] row1 = { "0", "Harry", "Harry", "0" };
		String[] row2 = { "1", "Owen", "owen", "1" };
		String[] row3 = { "2", "admin", "admin", "2" };
		String[] row4 = { "3", "1", "2", "3" };
		buffer.add(row1);
		buffer.add(row2);
		buffer.add(row3);
		buffer.add(row4);
		
		csvHelper.setCsv(buffer);
		
		ArrayList<String[]> result = csvHelper.getCsvBuffer();

		assertArrayEquals(buffer.toArray(), result.toArray());
	}

	@Test
	public void testSetCsv_02() {
		String path = "/com/inventoryManagementSystem/Data/testCSVHelper_02.csv";

		CSVHelper csvHelper = new CSVHelper(path);

		ArrayList<String[]> buffer = new ArrayList<String[]>();

		String[] row1 = { "0", "test1", "test2", "0" };
		String[] row2 = { "1", "test3", "12345**", "1" };
		String[] row3 = { "2", "abc__/", "def*^", "4" };
		buffer.add(row1);
		buffer.add(row2);
		buffer.add(row3);

		csvHelper.setCsv(buffer);
		
		ArrayList<String[]> result = csvHelper.getCsvBuffer();
		assertArrayEquals(buffer.toArray(), result.toArray());
	}
	@Test
	public void testFind_01() {
		String path = "/com/inventoryManagementSystem/Data/testCSVHelper_01.csv";

		CSVHelper csvHelper = new CSVHelper(path);

		String[] matcher = { "0", "Harry", "Harry", "0" };
		
		String[][] result = csvHelper.find(matcher);
		
		String[] expectedResult = { "0", "Harry", "Harry", "0" }; 

		assertArrayEquals(expectedResult, result[0]);
	}
	@Test
	public void testFind_02() {
		String path = "/com/inventoryManagementSystem/Data/testCSVHelper_02.csv";

		CSVHelper csvHelper = new CSVHelper(path);

		String[] matcher = { "0", "Owen", "Owen", "1" };
		
		String[] result = csvHelper.findOne(matcher);


		assertArrayEquals(null, result);
	}

	
	@Test
	public void testFindOne_01() {
		String path = "/com/inventoryManagementSystem/Data/testCSVHelper_01.csv";

		CSVHelper csvHelper = new CSVHelper(path);

		String[] matcher = { "0", "Harry", "Harry", "0" };
		
		String[] result = csvHelper.findOne(matcher);

		String[] expectedResult = { "0", "Harry", "Harry", "0" }; 

		assertArrayEquals(expectedResult, result);
	}

	@Test
	public void testFindOne_02() {
		String path = "/com/inventoryManagementSystem/Data/testCSVHelper_01.csv";

		CSVHelper csvHelper = new CSVHelper(path);


		String[] matcher = { "0", "Owen", "Owen", "1" };
		
		String[] result = csvHelper.findOne(matcher);

		String[] expectedResult = null;


		assertArrayEquals(expectedResult, result);
	}
	
	@Test
	public void testFindOneAndUpdate_01() {
		String path = "/com/inventoryManagementSystem/Data/testCSVHelper_01.csv";

		CSVHelper csvHelper = new CSVHelper(path);
		

		String[] matcher = { "1", "Owen", "owen", "1" };
		String[] update = { "1", "Owen", "admin", "2" };
		
		csvHelper.findOneAndUpdate(matcher,update);
		
		String[] result = csvHelper.findOne(update);

		String[] expectedResult = { "1", "Owen", "admin", "2" };
		
		assertArrayEquals(expectedResult, result);
	}
	
	@Test
	public void testFindOneAndUpdate_02() {
		String path = "/com/inventoryManagementSystem/Data/testCSVHelper_02.csv";
	

		CSVHelper csvHelper = new CSVHelper(path);


		String[] matcher = { "2", "abc__/", "def*^", "4" };

		String[] update = { "2", "abc", "defg", "4" };
		
		csvHelper.findOneAndUpdate(matcher,update);

		String[] result = csvHelper.findOne(update);

		String[] expectedResult = { "2", "abc", "defg", "4" };
		assertArrayEquals(expectedResult, result);
	}
	
	@Test
	public void testFindOneAndRemove_01() {
		String path = "/com/inventoryManagementSystem/Data/testCSVHelper_01.csv";

		CSVHelper csvHelper = new CSVHelper(path);

		String[] matcher = { "3", "1", "2", "3" };
		csvHelper.findOneAndRemove(matcher);
		
		String[] result = csvHelper.findOne(matcher);

		String[] expectedResult = null;


		assertArrayEquals(expectedResult, result);
	}
	@Test
	public void testFindOneAndRemove_02() {
		String path = "/com/inventoryManagementSystem/Data/testCSVHelper_02.csv";

		CSVHelper csvHelper = new CSVHelper(path);


		String[] matcher = { "0", "test1", "test2", "0" };
		csvHelper.findOneAndRemove(matcher);
		
		String[] result = csvHelper.findOne(matcher);

		String[] expectedResult = null;


		assertArrayEquals(expectedResult, result);
	}
	@Test
	public void testInsertOne_01() {
		String path = "/com/inventoryManagementSystem/Data/testCSVHelper_01.csv";

		CSVHelper csvHelper = new CSVHelper(path);


		String[] data =  { "3", "1", "2", "3" };
		
		csvHelper.insertOne(data);
		
		String[] result = csvHelper.findOne(data);

		String[] expectedResult =  { "3", "1", "2", "3" };


		assertArrayEquals(expectedResult, result);
	}
	@Test
	public void testInsertOne_02() {
		String path = "/com/inventoryManagementSystem/Data/testCSVHelper_02.csv";

		CSVHelper csvHelper = new CSVHelper(path);
		
		String[] data = { "0", "test1", "test2", "0" };

		csvHelper.insertOne(data);
		
		String[] result = csvHelper.findOne(data);

		String[] expectedResult = { "0", "test1", "test2", "0" };


		assertArrayEquals(expectedResult, result);
	}
	
}
