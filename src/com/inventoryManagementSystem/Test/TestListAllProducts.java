package com.inventoryManagementSystem.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import com.inventoryManagementSystem.CSVHelper;
import com.inventoryManagementSystem.DisplayHelper;
import com.inventoryManagementSystem.IMSController;
import com.inventoryManagementSystem.Product;
import com.inventoryManagementSystem.Command.ListAllProducts;

public class TestListAllProducts {
	@Test
	public void testGetMinPermission() {

		ListAllProducts ListAllProductsCmd = new ListAllProducts();

		int result = ListAllProductsCmd.getMinPermission();

		assertEquals(0, result);
	}

	@Test
	public void testGetDescription() {

		ListAllProducts ListAllProductsCmd = new ListAllProducts();

		String result = ListAllProductsCmd.getDescription();

		assertEquals("List all products", result);
	}

	@Test
	public void testListAllProductsExecute() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/product.csv");
		Product.changeDataSet(newDataSet);
		ListAllProducts listAllProductsCmd = new ListAllProducts();

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
		expectedResult += spaceLength + header + "\n";
		expectedResult += separationLine + "\n";
		expectedResult += "\r\n";
		expectedResult += "Product id: 0\r\n" + "Name: apple\r\n" + "Description: i am a apple\r\n" + "Price: 10.0\r\n"
				+ "Cost: 8.0\r\n" + "Stock: 10\r\n" + "\r\n" + "Product id: 1\r\n" + "Name: banana\r\n"
				+ "Description: i am a banana\r\n" + "Price: 20.0\r\n" + "Cost: 10.0\r\n" + "Stock: 8\r\n" + "\r\n"
				+ "Product id: 2\r\n" + "Name: orange\r\n" + "Description: i am a orange\r\n" + "Price: 25.0\r\n"
				+ "Cost: 15.0\r\n" + "Stock: 2\r\n" + "\r\n\r\n";
		expectedResult += "Press Enter key to continue...\r\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		String input = " ";

		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		listAllProductsCmd.execute();
		assertEquals(expectedResult, outContent.toString());

	}
}
