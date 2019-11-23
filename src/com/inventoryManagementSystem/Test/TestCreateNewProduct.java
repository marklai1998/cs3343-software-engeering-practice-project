package com.inventoryManagementSystem.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import com.inventoryManagementSystem.IMSController;
import com.inventoryManagementSystem.Command.CreateNewProduct;

public class TestCreateNewProduct {

	@Test
	public void testGetMinPermission() {

		CreateNewProduct CreateNewProductCmd = new CreateNewProduct();

		int result = CreateNewProductCmd.getMinPermission();

		assertEquals(2, result);
	}

	@Test
	public void testGetDescription() {

		CreateNewProduct CreateNewProductCmd = new CreateNewProduct();

		String result = CreateNewProductCmd.getDescription();

		assertEquals("Create new product", result);
	}

	@Test
	public void testCreateNewProductExecute() {
//
//		CreateNewProduct CreateNewProductCmd = new CreateNewProduct();
//		CreateNewProductCmd.execute();
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
//			expectedResult = "CreateNewProduct Success!";
//
//		else
//			expectedResult = "Invalid username or password!";
//		
//		
//		assertEquals(expectedResult, outContent.toString());

	}

}
