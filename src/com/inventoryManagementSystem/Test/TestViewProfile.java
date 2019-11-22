package com.inventoryManagementSystem.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import com.inventoryManagementSystem.IMSController;
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

		ViewProfile ViewProfileCmd = new ViewProfile();
		ViewProfileCmd.execute();

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	    System.setOut(new PrintStream(outContent));

		Scanner scan = new Scanner(System.in);

		String userName = scan.nextLine();
		String password = scan.nextLine();

		scan.close();

		String expectedResult = "";

		if (IMSController.getInstance().getStaff() != null)
			expectedResult = "ViewProfile Success!";

		else
			expectedResult = "Invalid username or password!";
		
		
		assertEquals(expectedResult, outContent.toString());

	}

}
