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
import com.inventoryManagementSystem.PriceChange;
import com.inventoryManagementSystem.Command.RemovePriceChange;

public class TestRemovePriceChange {

	@Test
	public void testGetMinPermission() {

		RemovePriceChange RemovePriceChangeCmd = new RemovePriceChange();

		int result = RemovePriceChangeCmd.getMinPermission();

		assertEquals(2, result);
	}

	@Test
	public void testGetDescription() {

		RemovePriceChange RemovePriceChangeCmd = new RemovePriceChange();

		String result = RemovePriceChangeCmd.getDescription();

		assertEquals("Remove price change", result);
	}

	@Test
	public void testRemovePriceChangeExecute() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testRemovePriceChange.csv");
		PriceChange.changeDataSet(newDataSet);
		RemovePriceChange removePriceChangeCmd = new RemovePriceChange();
		
		
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
		expectedResult += "id: \r\n";
		expectedResult += "Success!\r\n";
		expectedResult += "\r\n";
		expectedResult += "Press Enter key to continue...\r\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		String input = "0\n ";

		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		removePriceChangeCmd.execute();
		assertEquals(expectedResult, outContent.toString());

	}

}
