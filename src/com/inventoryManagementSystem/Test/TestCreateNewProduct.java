package com.inventoryManagementSystem.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import com.inventoryManagementSystem.CSVHelper;
import com.inventoryManagementSystem.DisplayHelper;
import com.inventoryManagementSystem.IMSController;
import com.inventoryManagementSystem.Product;
import com.inventoryManagementSystem.Command.CreateNewProduct;

public class TestCreateNewProduct {

	@Test
	public void testGetMinPermission() {

		CreateNewProduct createNewProductCmd = new CreateNewProduct();

		int result =createNewProductCmd.getMinPermission();

		assertEquals(2, result);
	}

	@Test
	public void testGetDescription() {

		CreateNewProduct createNewProductCmd = new CreateNewProduct();

		String result = createNewProductCmd.getDescription();

		assertEquals("Create new product", result);
	}

	
	@Test
	public void testCreateNewProductExecute_01() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testCreateProduct.csv");
		Product.changeDataSet(newDataSet);
		CreateNewProduct createNewProductCmd = new CreateNewProduct();
		IMSController.getInstance().setStaff(null);
		String header = "CS3343 Inventory Management System";
		String spaceLength = "";
		String separationLine = "";
		String expectedResult = "";
		for (int i = 0; i < DisplayHelper.getScreenWidth(); i++)
			separationLine += "=";

		for (int i = 0; i < (DisplayHelper.getScreenWidth() - header.length()) / 2; i++)
			spaceLength += " ";

		expectedResult += spaceLength + header + "\n";
		expectedResult += separationLine + "\n";
		expectedResult += "\r\n";
		expectedResult += "Product id: \r\n";
		expectedResult += "Product name: \r\n";
		expectedResult += "Description: \r\n";
		expectedResult += "Price: \r\n";
		expectedResult += "Cost: \r\n";
		expectedResult += "Stock: \r\n";
		expectedResult += "Success!\r\n";
		expectedResult += "\r\n";
		expectedResult += "Press Enter key to continue...\r\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		String input = "3 test3\ntest3\n5.0 3.0 3";

		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		createNewProductCmd.execute();

		assertEquals(expectedResult, outContent.toString());

	}


	@Test
	public void testCreateNewProductExecute_02() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testCreateProduct.csv");
		Product.changeDataSet(newDataSet);
		CreateNewProduct createNewProductCmd = new CreateNewProduct();
		IMSController.getInstance().setStaff(null);
		String header = "CS3343 Inventory Management System";
		String spaceLength = "";
		String separationLine = "";
		String expectedResult = "";
		for (int i = 0; i < DisplayHelper.getScreenWidth(); i++)
			separationLine += "=";

		for (int i = 0; i < (DisplayHelper.getScreenWidth() - header.length()) / 2; i++)
			spaceLength += " ";

		expectedResult += spaceLength + header + "\n";
		expectedResult += separationLine + "\n";
		expectedResult += "\r\n";
		expectedResult += "Product id: \r\n";
		expectedResult += "Product name: \r\n";
		expectedResult += "Product name cannot be empty!\r\n";
		expectedResult += "\r\nPress Enter key to continue...\r\n";
		expectedResult += "Product name: \r\n";
		expectedResult += "Description: \r\n";
		expectedResult += "Price: \r\n";
		expectedResult += "Cost: \r\n";
		expectedResult += "Stock: \r\n";
		expectedResult += "Success!\r\n";
		expectedResult += "\r\n";
		expectedResult += "Press Enter key to continue...\r\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		String input = "4\n test4\ntest4\n5.0 3.0 3";

		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		createNewProductCmd.execute();

		assertEquals(expectedResult, outContent.toString());

	}
	
	
//	@Test
//	public void testCreateNewProductExecute_03() {
//
//		CreateNewProduct createNewProductCmd = new CreateNewProduct();
//		String header = "CS3343 Inventory Management System";
//		String spaceLength = "";
//		String separationLine = "";
//		String expectedResult = "";
//		for (int i = 0; i < DisplayHelper.getScreenWidth(); i++)
//			separationLine += "=";
//
//		for (int i = 0; i < (DisplayHelper.getScreenWidth() - header.length()) / 2; i++)
//			spaceLength += " ";
//
//		expectedResult += spaceLength + header + "\n";
//		expectedResult += separationLine + "\n";
//		expectedResult += "\r\n";
//		expectedResult += "Product id: \r\n";
//		expectedResult += "Product name: \r\n";
//		expectedResult += "Product already exist!\r\n";
//		expectedResult += "\r\nPress Enter key to continue...\r\n";
//		expectedResult += "Product name: \r\n";
//		expectedResult += "Description: \r\n";
//		expectedResult += "Price: \r\n";
//		expectedResult += "Cost: \r\n";
//		expectedResult += "Stock: \r\n";
//		expectedResult += "Success!\r\n";
//		expectedResult += "\r\n";
//		expectedResult += "Press Enter key to continue...\r\n";
//
//		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//		System.setOut(new PrintStream(outContent));
//
//		String input = "5 test1 test5\ntest5\n 5.0 3.0 3";
//
//		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
//
//
//		createNewProductCmd.execute();
//
//		assertEquals(expectedResult, outContent.toString());
//
//	}
}
