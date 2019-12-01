package com.inventoryManagementSystem.Test;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import com.inventoryManagementSystem.CSVHelper;
import com.inventoryManagementSystem.DisplayHelper;
import com.inventoryManagementSystem.IMSController;
import com.inventoryManagementSystem.PriceChange;
import com.inventoryManagementSystem.Command.CreateNewPriceChange;

public class TestCreateNewPriceChange {

	@Test
	public void testGetMinPermission() {

		CreateNewPriceChange createNewPriceChangeCmd = new CreateNewPriceChange();

		int result = createNewPriceChangeCmd.getMinPermission();

		assertEquals(2, result);
	}

	@Test
	public void testGetDescription() {

		CreateNewPriceChange createNewPriceChangeCmd = new CreateNewPriceChange();

		String result = createNewPriceChangeCmd.getDescription();

		assertEquals("Create new price change", result);
	}

	@Test
	public void testCreateNewPriceChangeExecute_01() {
		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testCreatePriceChange.csv");
		PriceChange.changeDataSet(newDataSet);
		
		CreateNewPriceChange createNewPriceChangeCmd = new CreateNewPriceChange();
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
		expectedResult += "price change id: \r\n";
		expectedResult += "Product id: \r\n";
		expectedResult += "Change rate: \r\n";
		expectedResult += "Start date (format: dd/MM/YYYY): \r\n";
		expectedResult += "End date (format: dd/MM/YYYY): \r\n";
		expectedResult += "Success!\r\n";
		expectedResult += "\r\n";
		expectedResult += "Press Enter key to continue...\r\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		String input = "3 0 0.5" + " 11/11/2019\n20/11/2019\n";

		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		createNewPriceChangeCmd.execute();

		assertEquals(expectedResult, outContent.toString());

	}

	@Test
	public void testCreateNewPriceChangeExecute_02() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testCreatePriceChange.csv");
		PriceChange.changeDataSet(newDataSet);
		CreateNewPriceChange createNewPriceChangeCmd = new CreateNewPriceChange();

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
		expectedResult += "price change id: \r\n";
		expectedResult += "id already exist!\r\n";
		expectedResult += "\r\n";
		expectedResult += "Press Enter key to continue...\r\n";
		expectedResult += "price change id: \r\n";
		expectedResult += "Product id: \r\n";
		expectedResult += "Change rate: \r\n";
		expectedResult += "Start date (format: dd/MM/YYYY): \r\n";
		expectedResult += "End date (format: dd/MM/YYYY): \r\n";
		expectedResult += "Success!\r\n";
		expectedResult += "\r\n";
		expectedResult += "Press Enter key to continue...\r\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		String input = "3 2 0 0.5" + " 11/11/2019\n20/11/2019\n";

		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		createNewPriceChangeCmd.execute();

		assertEquals(expectedResult, outContent.toString());

	}

	@Test
	public void testCreateNewPriceChangeExecute_03() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testCreatePriceChange.csv");
		PriceChange.changeDataSet(newDataSet);
		CreateNewPriceChange createNewPriceChangeCmd = new CreateNewPriceChange();

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
		expectedResult += "price change id: \r\n";
		expectedResult += "Product id: \r\n";
		expectedResult += "Product doesn't exist!\r\n";
		expectedResult += "\r\nPress Enter key to continue...\r\n";
		expectedResult += "Product id: \r\n";
		expectedResult += "Change rate: \r\n";
		expectedResult += "Start date (format: dd/MM/YYYY): \r\n";
		expectedResult += "End date (format: dd/MM/YYYY): \r\n";
		expectedResult += "Success!\r\n";
		expectedResult += "\r\n";
		expectedResult += "Press Enter key to continue...\r\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		String input = "5 5 0 0.5" + " 11/11/2019\n20/11/2019\n";

		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		createNewPriceChangeCmd.execute();

		assertEquals(expectedResult, outContent.toString());

	}

	@Test
	public void testCreateNewPriceChangeExecute_04() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testCreatePriceChange.csv");
		PriceChange.changeDataSet(newDataSet);
		CreateNewPriceChange createNewPriceChangeCmd = new CreateNewPriceChange();

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
		expectedResult += "price change id: \r\n";
		expectedResult += "Product id: \r\n";
		expectedResult += "Change rate: \r\n";
		expectedResult += "Start date (format: dd/MM/YYYY): \r\n";
		expectedResult += "End date (format: dd/MM/YYYY): \r\n";
		expectedResult += "End date should be later than start date!\r\n";
		expectedResult += "\r\nPress Enter key to continue...\r\n";
		expectedResult += "End date (format: dd/MM/YYYY): \r\n";
		expectedResult += "Success!\r\n";
		expectedResult += "\r\n";
		expectedResult += "Press Enter key to continue...\r\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		String input = "6 0 0.5" + " 11/11/2019\n10/11/2019\n20/11/2019\n";

		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		createNewPriceChangeCmd.execute();

		assertEquals(expectedResult, outContent.toString());

	}
}
