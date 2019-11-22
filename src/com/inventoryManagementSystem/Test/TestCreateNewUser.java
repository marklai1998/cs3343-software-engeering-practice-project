package com.inventoryManagementSystem.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import com.inventoryManagementSystem.IMSController;
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

//		CreateNewUser CreateNewUserCmd = new CreateNewUser();
//		CreateNewUserCmd.execute();
//
//		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//
//	    System.setOut(new PrintStream(outContent));
//
//		Scanner scan = new Scanner(System.in);
//
//		String userName = scan.nextLine();
//		String password = scan.nextLine();
//
//		scan.close();
//
//		String expectedResult = "";
//
//		if (IMSController.getInstance().getStaff() != null)
//			expectedResult = "CreateNewUser Success!";
//
//		else
//			expectedResult = "Invalid username or password!";
//		
//		
//		assertEquals(expectedResult, outContent.toString());

	}

}
