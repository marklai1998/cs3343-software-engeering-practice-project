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
import com.inventoryManagementSystem.Command.UpdateProduct;

public class TestUpdateProduct {

	@Test
	public void testGetMinPermission() {

		UpdateProduct UpdateProductCmd = new UpdateProduct();

		int result = UpdateProductCmd.getMinPermission();

		assertEquals(2, result);
	}

	@Test
	public void testGetDescription() {

		UpdateProduct UpdateProductCmd = new UpdateProduct();

		String result = UpdateProductCmd.getDescription();

		assertEquals("Update product information", result);
	}

	@Test
	public void testUpdateProductExecute() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testUpdateProduct.csv");
		Product.changeDataSet(newDataSet);
		UpdateProduct updateProductCmd = new UpdateProduct();
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
		expectedResult += "Product name (test) :\r\n";
		expectedResult += "Description (test) :\r\n";
		expectedResult += "Price (10.0) :\r\n";
		expectedResult += "Cost (8.0) :\r\n";
		expectedResult += "Stock (10) :\r\n";
		expectedResult += "Success!\r\n";
		expectedResult += "\r\n";
		expectedResult += "Press Enter key to continue...\r\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		String input = "0 test10\ntest10\n5.0 3.0 3";

		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		updateProductCmd.execute();

		assertEquals(expectedResult, outContent.toString());
	}

}
