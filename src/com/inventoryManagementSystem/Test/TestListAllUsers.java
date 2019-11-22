package com.inventoryManagementSystem.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import com.inventoryManagementSystem.IMSController;
import com.inventoryManagementSystem.Command.ListAllUsers;

public class TestListAllUsers {
	@Test
	public void testGetMinPermission() {

		ListAllUsers ListAllUsersCmd = new ListAllUsers();

		int result = ListAllUsersCmd.getMinPermission();

		assertEquals(2, result);
	}

	@Test
	public void testGetDescription() {

		ListAllUsers ListAllUsersCmd = new ListAllUsers();

		String result = ListAllUsersCmd.getDescription();

		assertEquals("List all users", result);
	}

	@Test
	public void testListAllUsersExecute() {

//		ListAllUsers ListAllUsersCmd = new ListAllUsers();
//		ListAllUsersCmd.execute();
//		
//		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//
//	    System.setOut(new PrintStream(outContent));
//	    
//	    
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
//		
//		
//		assertEquals(expectedResult, outContent.toString());

	}
}
