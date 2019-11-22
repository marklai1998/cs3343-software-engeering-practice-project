package com.inventoryManagementSystem.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import com.inventoryManagementSystem.IMSController;
import com.inventoryManagementSystem.Command.RemoveProduct;

public class TestRemoveProduct {

	@Test
	public void testGetMinPermission() {

		RemoveProduct RemoveProductCmd = new RemoveProduct();

		int result = RemoveProductCmd.getMinPermission();

		assertEquals(2, result);
	}

	@Test
	public void testGetDescription() {

		RemoveProduct RemoveProductCmd = new RemoveProduct();

		String result = RemoveProductCmd.getDescription();

		assertEquals("Remove product", result);
	}

	@Test
	public void testRemoveProductExecute() {
//
//		RemoveProduct RemoveProductCmd = new RemoveProduct();
//		RemoveProductCmd.execute();
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
//			expectedResult = "RemoveProduct Success!";
//
//		else
//			expectedResult = "Invalid username or password!";
//		
//		
//		assertEquals(expectedResult, outContent.toString());

	}

}
