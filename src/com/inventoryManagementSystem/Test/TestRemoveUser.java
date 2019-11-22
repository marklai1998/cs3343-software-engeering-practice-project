package com.inventoryManagementSystem.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import com.inventoryManagementSystem.IMSController;
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

//		RemoveUser RemoveUserCmd = new RemoveUser();
//		RemoveUserCmd.execute();
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
//			expectedResult = "RemoveUser Success!";
//
//		else
//			expectedResult = "Invalid username or password!";
//		
//		
//		assertEquals(expectedResult, outContent.toString());

	}

}
