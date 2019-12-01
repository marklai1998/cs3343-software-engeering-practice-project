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
import com.inventoryManagementSystem.Command.CreateNewUser;

public class TestCreateNewUser {

	@Test
	public void testGetMinPermission() {

		CreateNewUser CreateNewUserCmd = new CreateNewUser();

		int result = CreateNewUserCmd.getMinPermission();

		assertEquals(2, result);
	}

	@Test
	public void testGetDescription() {

		CreateNewUser CreateNewUserCmd = new CreateNewUser();

		String result = CreateNewUserCmd.getDescription();

		assertEquals("Create new user", result);
	}

	@Test
	public void testCreateNewUserExecute() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testStaff.csv");
		Staff.changeDataSet(newDataSet);
		CreateNewUser createNewUserCmd = new CreateNewUser();
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
		expectedResult += "User id: \r\n";
		expectedResult += "Username: \r\n";
		expectedResult += "Password: \r\n";
		expectedResult += "Group id: \r\n";
		expectedResult += "Success!\r\n";
		expectedResult += "\r\n";
		expectedResult += "Press Enter key to continue...\r\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		String input = "10 test10\ntest10\n3";

		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		createNewUserCmd.execute();


		assertEquals(expectedResult, outContent.toString());


	}

}
