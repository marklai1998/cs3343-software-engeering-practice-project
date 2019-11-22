package com.inventoryManagementSystem.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import com.inventoryManagementSystem.IMSController;
import com.inventoryManagementSystem.Command.ListAllProducts;

public class TestListAllProducts {
	@Test
	public void testGetMinPermission() {

		ListAllProducts ListAllProductsCmd = new ListAllProducts();

		int result = ListAllProductsCmd.getMinPermission();

		assertEquals(0, result);
	}

	@Test
	public void testGetDescription() {

		ListAllProducts ListAllProductsCmd = new ListAllProducts();

		String result = ListAllProductsCmd.getDescription();

		assertEquals("List all products", result);
	}

	@Test
	public void testListAllProductsExecute() {

//		ListAllProducts ListAllProductsCmd = new ListAllProducts();
//		ListAllProductsCmd.execute();
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
//			expectedResult = "ListAllProducts Success!";
//
//		else
//			expectedResult = "Invalid username or password!";
		
		
//		assertEquals(expectedResult, outContent.toString());

	}
}
