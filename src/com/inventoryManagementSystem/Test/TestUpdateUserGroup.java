package com.inventoryManagementSystem.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import com.inventoryManagementSystem.IMSController;
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

//		UpdateUserGroup UpdateUserGroupCmd = new UpdateUserGroup();
//		UpdateUserGroupCmd.execute();
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
//			expectedResult = "UpdateUserGroup Success!";
//
//		else
//			expectedResult = "Invalid username or password!";
//		
//		
//		assertEquals(expectedResult, outContent.toString());

	}

}
