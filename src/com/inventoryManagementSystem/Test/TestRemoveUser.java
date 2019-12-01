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
import com.inventoryManagementSystem.Staff;
import com.inventoryManagementSystem.Command.RemoveUser;

public class TestRemoveUser {

	@Test
	public void testGetMinPermission() {

		RemoveUser RemoveUserCmd = new RemoveUser();

		int result = RemoveUserCmd.getMinPermission();

		assertEquals(3, result);
	}

	@Test
	public void testGetDescription() {

		RemoveUser RemoveUserCmd = new RemoveUser();

		String result = RemoveUserCmd.getDescription();

		assertEquals("Remove user", result);
	}

	@Test
	public void testRemoveUserExecute() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testStaff.csv");
		Staff.changeDataSet(newDataSet);
		RemoveUser removeUserCmd = new RemoveUser();
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
		expectedResult += "User id: \r\n";
		expectedResult += "Success!\r\n";
		expectedResult += "\r\n";
		expectedResult += "Press Enter key to continue...\r\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		String input = "0\n ";

		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		removeUserCmd.execute();

		assertEquals(expectedResult, outContent.toString());


	}

}
