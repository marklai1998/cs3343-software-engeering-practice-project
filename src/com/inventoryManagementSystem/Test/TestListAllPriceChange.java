package com.inventoryManagementSystem.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import com.inventoryManagementSystem.CSVHelper;
import com.inventoryManagementSystem.DisplayHelper;
import com.inventoryManagementSystem.IMSController;
import com.inventoryManagementSystem.PriceChange;
import com.inventoryManagementSystem.Command.ListAllPriceChange;

public class TestListAllPriceChange {
	@Test
	public void testGetMinPermission() {

		ListAllPriceChange ListAllPriceChangeCmd = new ListAllPriceChange();

		int result = ListAllPriceChangeCmd.getMinPermission();

		assertEquals(0, result);
	}

	@Test
	public void testGetDescription() {

		ListAllPriceChange ListAllPriceChangeCmd = new ListAllPriceChange();

		String result = ListAllPriceChangeCmd.getDescription();

		assertEquals("List all price change", result);
	}

	@Test
	public void testListAllPriceChangeExecute() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/priceChange.csv");
		PriceChange.changeDataSet(newDataSet);
		ListAllPriceChange listAllPriceChangeCmd = new ListAllPriceChange();
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
		expectedResult += "id: 0\r\n" + "Product id: 0\r\n" + "Change rate: 0.9\r\n" + "Start date: 10/11/2019\r\n"
				+ "End date: 20/11/2019\r\n" + "\r\n" + "id: 1\r\n" + "Product id: 1\r\n" + "Change rate: 0.5\r\n"
				+ "Start date: 10/11/2019\r\n" + "End date: 11/11/2019";
		expectedResult += "\r\n\r\n\r\n";
		expectedResult += "Press Enter key to continue...\r\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		String input = " ";

		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		listAllPriceChangeCmd.execute();

		assertEquals(expectedResult, outContent.toString());

	}

}
