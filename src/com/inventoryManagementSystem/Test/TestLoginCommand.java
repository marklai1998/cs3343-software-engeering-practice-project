package com.inventoryManagementSystem.Test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import com.inventoryManagementSystem.CSVHelper;
import com.inventoryManagementSystem.DisplayHelper;
import com.inventoryManagementSystem.IMSController;
import com.inventoryManagementSystem.Staff;
import com.inventoryManagementSystem.Command.Login;

public class TestLoginCommand {

	@Test
	public void testGetMinPermission() {

		Login loginCmd = new Login();

		int result = loginCmd.getMinPermission();

		assertEquals(-1, result);
	}

	@Test
	public void testGetDescription() {

		Login loginCmd = new Login();

		String result = loginCmd.getDescription();

		assertEquals("Login", result);
	}

	@Test
	public void testLoginExecute_01() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/staff.csv");
		Staff.changeDataSet(newDataSet);
		Login loginCmd = new Login();
		String header = "CS3343 Inventory Management System";
		IMSController.getInstance().setStaff(null);
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
		expectedResult += "User name: ";
		expectedResult += "Password: ";
		expectedResult += "Login Success!\r\n";
		expectedResult += "\r\n";
		expectedResult += "Press Enter key to continue...\r\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		String input = "user2\nuser2\n ";

		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		loginCmd.execute();

		assertEquals(expectedResult, outContent.toString());

	}
	
//	@Test
//	public void testLoginExecute_02() {
//
//		Login loginCmd = new Login();
//		String header = "CS3343 Inventory Management System";
//		String spaceLength = "";
//		String separationLine = "";
//		String expectedResult = "";
//		for (int i = 0; i < DisplayHelper.getScreenWidth(); i++)
//			separationLine += "=";
//
//		for (int i = 0; i < (DisplayHelper.getScreenWidth() - header.length()) / 2; i++)
//			spaceLength += " ";
//
//		expectedResult += spaceLength + header + "\n";
//		expectedResult += separationLine + "\n";
//		expectedResult += "\r\n";
//		expectedResult += "User name: ";
//		expectedResult += "Invalid username or password!";
//		expectedResult += "\r\n";
//		expectedResult += "Press Enter key to continue...\r\n";
//		expectedResult += "User name: ";
//		expectedResult += "Password: ";
//		expectedResult += "Login Success!\r\n";
//		expectedResult += "\r\n";
//		expectedResult += "Press Enter key to continue...\r\n";
//
//		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//		System.setOut(new PrintStream(outContent));
//
//		String input = "user0\nuser\nuser\n ";
//
//		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
//		System.setIn(in);
//
//		loginCmd.execute();
//
//		assertEquals(expectedResult, outContent.toString());
//
//	}
	
}
