package com.inventoryManagementSystem.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

import com.inventoryManagementSystem.DisplayHelper;
import com.inventoryManagementSystem.IMSController;
import com.inventoryManagementSystem.Staff;

public class TestDisplayHelper {

	@Test
	public void testPrintHeader_01() {

		IMSController.getInstance().setStaff(null);
		String header = "CS3343 Inventory Management System";
		String spaceLength = "";
		String separationLine = "";
		String expectedResult = "";
		for (int i = 0; i < DisplayHelper.getScreenWidth(); i++)
			separationLine += "=";

		for (int i = 0; i < (DisplayHelper.getScreenWidth() - header.length()) / 2; i++)
			spaceLength += " ";

		expectedResult += spaceLength;
		expectedResult += header;
		expectedResult += "\n";
		expectedResult += separationLine;
		expectedResult += "\n";
		expectedResult += "\r\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		DisplayHelper.printHeader();

		assertEquals(expectedResult, outContent.toString());
	}

	@Test
	public void testPrintHeader_02() {

		IMSController controller = IMSController.getInstance();
		controller.setStaff(new Staff(0, "Test", "Test", 0));

		String header = "CS3343 Inventory Management System";
		String spaceLength = "";
		String separationLine = "";
		String expectedResult = "";
		for (int i = 0; i < DisplayHelper.getScreenWidth(); i++)
			separationLine += "=";

		for (int i = 0; i < (DisplayHelper.getScreenWidth() - header.length()) / 2; i++)
			spaceLength += " ";

		expectedResult += spaceLength;
		expectedResult += header;
		expectedResult += "\n";
		expectedResult += "Logged in as: " + "Test\r\n";
		expectedResult += separationLine;
		expectedResult += "\n";
		expectedResult += "\r\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		DisplayHelper.printHeader();

		assertEquals(expectedResult, outContent.toString());
	}

	@Test
	public void testPrintSeparationLine() {

		String expectedResult = "";
		for (int i = 0; i < DisplayHelper.getScreenWidth(); i++)
			expectedResult += "=";
		expectedResult += "\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		DisplayHelper.printSeparationLine();

		assertEquals(expectedResult, outContent.toString());
	}

	@Test
	public void testPrintTextMiddleAligned() {

		String input = "Test";

		String expectedResult = "";
		for (int i = 0; i < (DisplayHelper.getScreenWidth() - input.length()) / 2; i++)
			expectedResult += " ";

		expectedResult += input;
		expectedResult += "\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		DisplayHelper.printTextMiddleAligned(input);

		assertEquals(expectedResult, outContent.toString());
	}

	@Test
	public void testCls() {

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		DisplayHelper.cls();

		assertEquals("", outContent.toString());
	}

	@Test
	public void testPressEnterToContinue() {
		String expectedResult = "";

		expectedResult += "\r\nPress Enter key to continue...\r\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		ByteArrayInputStream in = new ByteArrayInputStream("\n".getBytes());
		System.setIn(in);
		
		DisplayHelper.pressEnterToContinue();

		assertEquals(expectedResult, outContent.toString());
	}
}
