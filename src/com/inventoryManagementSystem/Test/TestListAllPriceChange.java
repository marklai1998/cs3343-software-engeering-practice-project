package com.inventoryManagementSystem.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import com.inventoryManagementSystem.IMSController;
import com.inventoryManagementSystem.Command.ListAllPriceChange;

public class TestListAllPriceChange {
	@Test
	public void testGetMinPermission() {

		ListAllPriceChange ListAllPriceChangeCmd = new ListAllPriceChange();

		int result = ListAllPriceChangeCmd.getMinPermission();

		assertEquals(0, result);
	}

	@Test
	public void testGetDescription() {

		ListAllPriceChange ListAllPriceChangeCmd = new ListAllPriceChange();

		String result = ListAllPriceChangeCmd.getDescription();

		assertEquals("List all price change", result);
	}

	@Test
	public void testListAllPriceChangeExecute() {

//		ListAllPriceChange ListAllPriceChangeCmd = new ListAllPriceChange();
//		ListAllPriceChangeCmd.execute();
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
//			expectedResult = "ListAllPriceChange Success!";
//
//		else
//			expectedResult = "Invalid username or password!";
//		
//		
//		assertEquals(expectedResult, outContent.toString());

	}

}
