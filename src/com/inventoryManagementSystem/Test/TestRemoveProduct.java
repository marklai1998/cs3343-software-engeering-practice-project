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
import com.inventoryManagementSystem.Command.RemoveProduct;

public class TestRemoveProduct {

	@Test
	public void testGetMinPermission() {

		RemoveProduct RemoveProductCmd = new RemoveProduct();

		int result = RemoveProductCmd.getMinPermission();

		assertEquals(2, result);
	}

	@Test
	public void testGetDescription() {

		RemoveProduct RemoveProductCmd = new RemoveProduct();

		String result = RemoveProductCmd.getDescription();

		assertEquals("Remove product", result);
	}

	@Test
	public void testRemoveProductExecute() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testProduct.csv");
		Product.changeDataSet(newDataSet);
		RemoveProduct removeProductCmd = new RemoveProduct();
		
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
		expectedResult += "Success!\r\n";
		expectedResult += "\r\n";
		expectedResult += "Press Enter key to continue...\r\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		String input = "0\n ";

		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		removeProductCmd.execute();

		assertEquals(expectedResult, outContent.toString());

	}

}
