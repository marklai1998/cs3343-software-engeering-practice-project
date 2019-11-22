package com.inventoryManagementSystem.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import com.inventoryManagementSystem.IMSController;
import com.inventoryManagementSystem.Command.ChangePassword;

public class TestChangePassword {

	@Test
	public void testGetMinPermission() {

		ChangePassword ChangePasswordCmd = new ChangePassword();

		int result = ChangePasswordCmd.getMinPermission();

		assertEquals(0, result);
	}

	@Test
	public void testGetDescription() {

		ChangePassword ChangePasswordCmd = new ChangePassword();

		String result = ChangePasswordCmd.getDescription();

		assertEquals("Change password", result);
	}

	@Test
	public void testChangePasswordExecute() {

//		ChangePassword ChangePasswordCmd = new ChangePassword();
//		ChangePasswordCmd.execute();
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
//			expectedResult = "ChangePassword Success!";
//
//		else
//			expectedResult = "Invalid username or password!";
//		
//		
//		assertEquals(expectedResult, outContent.toString());

	}

}
