package com.inventoryManagementSystem.Test;

import org.junit.Test;
import static org.junit.Assert.*;
import com.inventoryManagementSystem.Command.CreateNewPriceChange;

public class TestCreateNewPriceChange {

	@Test
	public void testGetMinPermission() {

		CreateNewPriceChange CreateNewPriceChangeCmd = new CreateNewPriceChange();

		int result = CreateNewPriceChangeCmd.getMinPermission();

		assertEquals(2, result);
	}

	@Test
	public void testGetDescription() {

		CreateNewPriceChange CreateNewPriceChangeCmd = new CreateNewPriceChange();

		String result = CreateNewPriceChangeCmd.getDescription();

		assertEquals("Create new price change", result);
	}

	@Test
	public void testCreateNewPriceChangeExecute() {

//		CreateNewPriceChange CreateNewPriceChangeCmd = new CreateNewPriceChange();
//		CreateNewPriceChangeCmd.execute();
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
//			expectedResult = "CreateNewPriceChange Success!";
//
//		else
//			expectedResult = "Invalid username or password!";
//		
//		
//		assertEquals(expectedResult, outContent.toString());

	}

}
