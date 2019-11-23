package com.inventoryManagementSystem.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


import com.inventoryManagementSystem.Command.ChangePassword;

public class TestChangePassword {

	@Test
	public void testGetMinPermission() {

		ChangePassword changePasswordCmd = new ChangePassword();

		int result = changePasswordCmd.getMinPermission();

		assertEquals(0, result);
	}

	@Test
	public void testGetDescription() {

		ChangePassword changePasswordCmd = new ChangePassword();

		String result = changePasswordCmd.getDescription();

		assertEquals("Change password", result);
	}

	@Test
	public void testChangePasswordExecute() {
		
//		ChangePassword changePasswordCmd = new ChangePassword();
//
//		IMSController.getInstance().setStaff(new Staff(0, "test", "test", 0));
//		changePasswordCmd.execute();
//
//
//		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//
//		System.setOut(new PrintStream(outContent));
//
//		String expectedResult = "";
//
//		if (IMSController.getInstance().getStaff() != null)
//			expectedResult = "Update successful!";
//
//		else
//			expectedResult = "Invalid username or password!";
//
//		assertEquals(expectedResult, outContent.toString());

	}

}
