package com.inventoryManagementSystem.Test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import com.inventoryManagementSystem.IMSController;
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
	public void testLoginExecute() {

		Login loginCmd = new Login();
		loginCmd.execute();

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	    System.setOut(new PrintStream(outContent));

		Scanner scan = new Scanner(System.in);

		String userName = scan.nextLine();
		String password = scan.nextLine();

		scan.close();

		String expectedResult = "";

		if (IMSController.getInstance().getStaff() != null)
			expectedResult = "Login Success!";

		else
			expectedResult = "Invalid username or password!";
		
		
		assertEquals(expectedResult, outContent.toString());

	}

}
