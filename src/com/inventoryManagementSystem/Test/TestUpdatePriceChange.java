package com.inventoryManagementSystem.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import com.inventoryManagementSystem.IMSController;
import com.inventoryManagementSystem.Command.UpdatePriceChange;

public class TestUpdatePriceChange {

	@Test
	public void testGetMinPermission() {

		UpdatePriceChange UpdatePriceChangeCmd = new UpdatePriceChange();

		int result = UpdatePriceChangeCmd.getMinPermission();

		assertEquals(2, result);
	}

	@Test
	public void testGetDescription() {

		UpdatePriceChange UpdatePriceChangeCmd = new UpdatePriceChange();

		String result = UpdatePriceChangeCmd.getDescription();

		assertEquals("Update price change information", result);
	}

	@Test
	public void testUpdatePriceChangeExecute() {

//		UpdatePriceChange UpdatePriceChangeCmd = new UpdatePriceChange();
//		UpdatePriceChangeCmd.execute();
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
//			expectedResult = "UpdatePriceChange Success!";
//
//		else
//			expectedResult = "Invalid username or password!";
//		
//		
//		assertEquals(expectedResult, outContent.toString());

	}

}
