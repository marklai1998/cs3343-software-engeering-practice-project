package com.inventoryManagementSystem.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import com.inventoryManagementSystem.CSVHelper;
import com.inventoryManagementSystem.DisplayHelper;
import com.inventoryManagementSystem.Staff;
import com.inventoryManagementSystem.Command.UpdateUserGroup;

public class TestUpdateUserGroup {

	@Test
	public void testGetMinPermission() {

		UpdateUserGroup UpdateUserGroupCmd = new UpdateUserGroup();

		int result = UpdateUserGroupCmd.getMinPermission();

		assertEquals(3, result);
	}

	@Test
	public void testGetDescription() {

		UpdateUserGroup UpdateUserGroupCmd = new UpdateUserGroup();

		String result = UpdateUserGroupCmd.getDescription();

		assertEquals("Update user group", result);
	}

	@Test
	public void testUpdateUserGroupExecute() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testUpdateUserGp.csv");
		Staff.changeDataSet(newDataSet);
		UpdateUserGroup updateUserGroupCmd = new UpdateUserGroup();
		
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
		expectedResult += "Group id: \r\n";
		expectedResult += "Success!\r\n";
		expectedResult += "\r\n";
		expectedResult += "Press Enter key to continue...\r\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		String input = "0\n3";

		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		updateUserGroupCmd.execute();


		assertEquals(expectedResult, outContent.toString());
	}

}
