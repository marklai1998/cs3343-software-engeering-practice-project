package com.inventoryManagementSystem.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import com.inventoryManagementSystem.DisplayHelper;
import com.inventoryManagementSystem.IMSController;
import com.inventoryManagementSystem.Staff;
import com.inventoryManagementSystem.Command.ViewProfile;

public class TestViewProfile {

	@Test
	public void testGetMinPermission() {

		ViewProfile ViewProfileCmd = new ViewProfile();

		int result = ViewProfileCmd.getMinPermission();

		assertEquals(0, result);
	}

	@Test
	public void testGetDescription() {

		ViewProfile ViewProfileCmd = new ViewProfile();

		String result = ViewProfileCmd.getDescription();

		assertEquals("View Profile", result);
	}

	@Test
	public void testViewProfileExecute() {

		IMSController.getInstance().setStaff(new Staff(0, "test", "test", 0));

		ViewProfile viewProfileCmd = new ViewProfile();
		String header = "CS3343 Inventory Management System";
		String spaceLength = "";
		String separationLine = "";
		String expectedResult = "";
		for (int i = 0; i < DisplayHelper.getScreenWidth(); i++)
			separationLine += "=";

		for (int i = 0; i < (DisplayHelper.getScreenWidth() - header.length()) / 2; i++)
			spaceLength += " ";

		expectedResult += spaceLength + header + "\n";
		expectedResult += "Logged in as: test\r\n";
		expectedResult += separationLine + "\n";
		expectedResult += "\r\n";
		expectedResult += "User id: 0\r\n" + "User name: test\r\n" + "Password: test\r\n" + "User group: Default(0)\r\n";
		expectedResult += "\r\n";
		expectedResult += "Press Enter key to continue...\r\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		String input = " ";

		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		viewProfileCmd.execute();

		assertEquals(expectedResult, outContent.toString());

	}

}
