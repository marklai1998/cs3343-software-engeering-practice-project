package com.inventoryManagementSystem.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import com.inventoryManagementSystem.IMSController;
import com.inventoryManagementSystem.Command.RemovePriceChange;

public class TestRemovePriceChange {

	@Test
	public void testGetMinPermission() {

		RemovePriceChange RemovePriceChangeCmd = new RemovePriceChange();

		int result = RemovePriceChangeCmd.getMinPermission();

		assertEquals(2, result);
	}

	@Test
	public void testGetDescription() {

		RemovePriceChange RemovePriceChangeCmd = new RemovePriceChange();

		String result = RemovePriceChangeCmd.getDescription();

		assertEquals("Remove price change", result);
	}

	@Test
	public void testRemovePriceChangeExecute() {

//		RemovePriceChange RemovePriceChangeCmd = new RemovePriceChange();
//		RemovePriceChangeCmd.execute();
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
//			expectedResult = "RemovePriceChange Success!";
//
//		else
//			expectedResult = "Invalid username or password!";
//		
//		
//		assertEquals(expectedResult, outContent.toString());

	}

}
