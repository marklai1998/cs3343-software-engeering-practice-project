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
import com.inventoryManagementSystem.Product;
import com.inventoryManagementSystem.Staff;
import com.inventoryManagementSystem.Command.UpdatePriceChange;

public class TestUpdatePriceChange {

	@Test
	public void testGetMinPermission() {

		UpdatePriceChange updatePriceChangeCmd = new UpdatePriceChange();

		int result = updatePriceChangeCmd.getMinPermission();

		assertEquals(2, result);
	}

	@Test
	public void testGetDescription() {

		UpdatePriceChange updatePriceChangeCmd = new UpdatePriceChange();

		String result = updatePriceChangeCmd.getDescription();

		assertEquals("Update price change information", result);
	}

	@Test
	public void testUpdatePriceChangeExecute_01() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testUpdatePriceChange.csv");
		PriceChange.changeDataSet(newDataSet);
		CSVHelper productDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testProduct.csv");
		Product.changeDataSet(productDataSet);

		UpdatePriceChange updatePriceChangeCmd = new UpdatePriceChange();

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
		expectedResult += "price change id: \r\n";
		expectedResult += "Product id (0) :\r\n";
		expectedResult += "Change rate (0.8) :\r\n";
		expectedResult += "Start date (format: dd/MM/YYYY) (10/11/2019) : \r\n";
		expectedResult += "End date (format: dd/MM/YYYY) (20/11/2019) :\r\n";
		expectedResult += "Success!\r\n";
		expectedResult += "\r\n";
		expectedResult += "Press Enter key to continue...\r\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		String input = "0 1 0.5" + " 11/11/2019\n20/11/2019\n";

		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		updatePriceChangeCmd.execute();

		assertEquals(expectedResult, outContent.toString());

	}


}
