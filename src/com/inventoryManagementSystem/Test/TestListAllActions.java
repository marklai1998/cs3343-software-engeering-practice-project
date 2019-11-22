package com.inventoryManagementSystem.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import com.inventoryManagementSystem.IMSController;
import com.inventoryManagementSystem.Command.ListAllActions;

public class TestListAllActions {

	@Test
	public void testGetMinPermission() {

		ListAllActions ListAllActionsCmd = new ListAllActions();

		int result = ListAllActionsCmd.getMinPermission();

		assertEquals(-1, result);
	}

	@Test
	public void testGetDescription() {

		ListAllActions ListAllActionsCmd = new ListAllActions();

		String result = ListAllActionsCmd.getDescription();

		assertEquals("List all actions", result);
	}

	@Test
	public void testListAllActionsExecute() {

//		ListAllActions ListAllActionsCmd = new ListAllActions();
//		ListAllActionsCmd.execute();
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
//			expectedResult = "ListAllActions Success!";
//
//		else
//			expectedResult = "Invalid username or password!";
//		
//		
//		assertEquals(expectedResult, outContent.toString());

	}

}
