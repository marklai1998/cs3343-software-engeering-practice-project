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
import com.inventoryManagementSystem.Command.ListAllUsers;

public class TestListAllUsers {
	@Test
	public void testGetMinPermission() {

		ListAllUsers ListAllUsersCmd = new ListAllUsers();

		int result = ListAllUsersCmd.getMinPermission();

		assertEquals(2, result);
	}

	@Test
	public void testGetDescription() {

		ListAllUsers ListAllUsersCmd = new ListAllUsers();

		String result = ListAllUsersCmd.getDescription();

		assertEquals("List all users", result);
	}

	@Test
	public void testListAllUsersExecute() {

		ListAllUsers listAllUsersCmd = new ListAllUsers();
		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/staff.csv");
		Staff.changeDataSet(newDataSet);

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
		expectedResult += "User id: 0\r\n" + "Username: user\r\n" + "User group: DEFAULT(0)\r\n" + "\r\n"
				+ "User id: 1\r\n" + "Username: user2\r\n" + "User group: MARKETING(1)\r\n" + "\r\n" + "User id: 2\r\n"
				+ "Username: user3\r\n" + "User group: MANAGER(2)\r\n" + "\r\n" + "User id: 3\r\n"
				+ "Username: user4\r\n" + "User group: ADMIN(3)\r\n" + "\r\n";
		expectedResult += "\r\n";
		expectedResult += "Press Enter key to continue...\r\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		String input = "3 test3\ntest3\n5.0 3.0 3";

		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		listAllUsersCmd.execute();
		assertEquals(expectedResult, outContent.toString());

	}
}
