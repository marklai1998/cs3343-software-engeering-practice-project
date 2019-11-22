package com.inventoryManagementSystem.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import com.inventoryManagementSystem.IMSController;
import com.inventoryManagementSystem.Command.UpdateProduct;

public class TestUpdateProduct {

	@Test
	public void testGetMinPermission() {

		UpdateProduct UpdateProductCmd = new UpdateProduct();

		int result = UpdateProductCmd.getMinPermission();

		assertEquals(2, result);
	}

	@Test
	public void testGetDescription() {

		UpdateProduct UpdateProductCmd = new UpdateProduct();

		String result = UpdateProductCmd.getDescription();

		assertEquals("Update product information", result);
	}

	@Test
	public void testUpdateProductExecute() {

//		UpdateProduct UpdateProductCmd = new UpdateProduct();
//		UpdateProductCmd.execute();
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
//			expectedResult = "UpdateProduct Success!";
//
//		else
//			expectedResult = "Invalid username or password!";
//		
//		
//		assertEquals(expectedResult, outContent.toString());

	}

}
