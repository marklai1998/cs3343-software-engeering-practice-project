package com.inventoryManagementSystem.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import com.inventoryManagementSystem.CSVHelper;
import com.inventoryManagementSystem.DisplayHelper;
import com.inventoryManagementSystem.IMSController;
import com.inventoryManagementSystem.Staff;
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
	public void testChangePasswordExecute_01() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testStaff.csv");
		Staff.changeDataSet(newDataSet);
		ChangePassword changePasswordCmd = new ChangePassword();
		IMSController controller = IMSController.getInstance();
		
		controller.setStaff(new Staff(0, "test", "test", 0));
		
		String header = "CS3343 Inventory Management System";
		String spaceLength = "";
		String separationLine = "";
		String expectedResult = "";
		for (int i = 0; i < DisplayHelper.getScreenWidth(); i++)
			separationLine += "=";

		for (int i = 0; i < (DisplayHelper.getScreenWidth() - header.length()) / 2; i++)
			spaceLength += " ";

		expectedResult += spaceLength + header + "\n";
		expectedResult += "Logged in as: "+controller.getStaff().getName();
		expectedResult +=  "\r\n"+separationLine + "\n";
		expectedResult += "\r\n";
		expectedResult += "New password: \r\n";
		expectedResult += "Retype password: \r\n";
		expectedResult += "Update successful!\r\n";
		expectedResult += "\r\n";
		expectedResult += "Press Enter key to continue...\r\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		String input = "test1\ntest1\n"+"\n";
		
		
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		changePasswordCmd.execute();

		assertEquals(expectedResult, outContent.toString());

	}

	@Test
	public void testChangePasswordExecute_02() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testStaff.csv");
		Staff.changeDataSet(newDataSet);
		ChangePassword changePasswordCmd = new ChangePassword();
		IMSController controller = IMSController.getInstance();
		
		controller.setStaff(new Staff(0, "test", "test", 0));
		
		String header = "CS3343 Inventory Management System";
		String spaceLength = "";
		String separationLine = "";
		String expectedResult = "";
		for (int i = 0; i < DisplayHelper.getScreenWidth(); i++)
			separationLine += "=";

		for (int i = 0; i < (DisplayHelper.getScreenWidth() - header.length()) / 2; i++)
			spaceLength += " ";

		expectedResult += spaceLength + header + "\n";
		expectedResult += "Logged in as: "+controller.getStaff().getName();
		expectedResult +=  "\r\n"+separationLine + "\n";
		expectedResult += "\r\n";
		expectedResult += "New password: \r\n";
		expectedResult += "New password cannot be empty!\r\n";
		expectedResult += "\r\n";
		expectedResult += "Press Enter key to continue...\r\n";
		expectedResult += spaceLength + header + "\n";
		expectedResult += "Logged in as: "+controller.getStaff().getName();
		expectedResult +=  "\r\n"+separationLine + "\n";
		expectedResult += "\r\nNew password: \r\n";
		expectedResult += "Retype password: \r\n";
		expectedResult += "Update successful!\r\n";
		expectedResult += "\r\n";
		expectedResult += "Press Enter key to continue...\r\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		String input = "\ntest1\ntest1\n"+" ";
		
		
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		changePasswordCmd.execute();

		assertEquals(expectedResult, outContent.toString());

	}

	@Test
	public void testChangePasswordExecute_03() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testStaff.csv");
		Staff.changeDataSet(newDataSet);
		ChangePassword changePasswordCmd = new ChangePassword();
		IMSController controller = IMSController.getInstance();
		
		controller.setStaff(new Staff(0, "test", "test", 0));
		
		String header = "CS3343 Inventory Management System";
		String spaceLength = "";
		String separationLine = "";
		String expectedResult = "";
		for (int i = 0; i < DisplayHelper.getScreenWidth(); i++)
			separationLine += "=";

		for (int i = 0; i < (DisplayHelper.getScreenWidth() - header.length()) / 2; i++)
			spaceLength += " ";

		expectedResult += spaceLength + header + "\n";
		expectedResult += "Logged in as: "+controller.getStaff().getName();
		expectedResult +=  "\r\n"+separationLine + "\n";
		expectedResult += "\r\n";
		expectedResult += "New password: \r\n";
		expectedResult += "New password cannot be the same as the original!\r\n\r\n";
		expectedResult += "Press Enter key to continue...\r\n";
		expectedResult += spaceLength + header + "\n";
		expectedResult += "Logged in as: "+controller.getStaff().getName();
		expectedResult +=  "\r\n"+separationLine + "\n";
		expectedResult += "\r\n";
		expectedResult += "New password: \r\n";
		expectedResult += "Retype password: \r\n";
		expectedResult += "Update successful!\r\n";
		expectedResult += "\r\n";
		expectedResult += "Press Enter key to continue...\r\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		String input = "test\ntest1\ntest1\n"+"\n";
		
		
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		changePasswordCmd.execute();

		assertEquals(expectedResult, outContent.toString());

	}
	
	@Test
	public void testChangePasswordExecute_04() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testStaff.csv");
		Staff.changeDataSet(newDataSet);
		ChangePassword changePasswordCmd = new ChangePassword();
		IMSController controller = IMSController.getInstance();
		
		controller.setStaff(new Staff(0, "test", "test", 0));
		
		String header = "CS3343 Inventory Management System";
		String spaceLength = "";
		String separationLine = "";
		String expectedResult = "";
		for (int i = 0; i < DisplayHelper.getScreenWidth(); i++)
			separationLine += "=";

		for (int i = 0; i < (DisplayHelper.getScreenWidth() - header.length()) / 2; i++)
			spaceLength += " ";

		expectedResult += spaceLength + header + "\n";
		expectedResult += "Logged in as: "+controller.getStaff().getName();
		expectedResult +=  "\r\n"+separationLine + "\n";
		expectedResult += "\r\n";
		expectedResult += "New password: \r\n";
		expectedResult += "Retype password: \r\n";
		expectedResult += "2 passwords are not the same!\r\n\r\n";
		expectedResult += "Press Enter key to continue...\r\n";
		expectedResult += spaceLength + header + "\n";
		expectedResult += "Logged in as: "+controller.getStaff().getName();
		expectedResult +=  "\r\n"+separationLine + "\n";
		expectedResult += "\r\n";
		expectedResult += "New password: \r\n";
		expectedResult += "Retype password: \r\n";
		expectedResult += "Update successful!\r\n";
		expectedResult += "\r\n";
		expectedResult += "Press Enter key to continue...\r\n";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		String input = "test1\ntest2\ntest1\ntest1\n"+"\n";
		
		
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		changePasswordCmd.execute();

		assertEquals(expectedResult, outContent.toString());

	}

}
