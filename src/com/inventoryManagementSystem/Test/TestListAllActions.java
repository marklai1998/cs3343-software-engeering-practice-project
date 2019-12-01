package com.inventoryManagementSystem.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

import com.inventoryManagementSystem.DisplayHelper;
import com.inventoryManagementSystem.IMSController;
import com.inventoryManagementSystem.Staff;
import com.inventoryManagementSystem.Command.ListAllActions;

public class TestListAllActions {

	@Test
	public void testGetMinPermission() {

		ListAllActions ListAllActionsCmd = new ListAllActions();

		int result = ListAllActionsCmd.getMinPermission();

		assertEquals(-1, result);
	}

	@Test
	public void testGetDescription() {

		ListAllActions ListAllActionsCmd = new ListAllActions();

		String result = ListAllActionsCmd.getDescription();

		assertEquals("List all actions", result);
	}

//	@Test
//	public void testListAllActionsExecute() {
//		
//		IMSController controller = IMSController.getInstance();
//		controller.setStaff(new Staff(1,"test","test",1));
//		
//		ListAllActions ListAllActionsCmd = new ListAllActions();
//
//		String header = "CS3343 Inventory Management System";
//		String spaceLength = "";
//		String separationLine = "";
//		String expectedResult = "";
//		for (int i = 0; i < DisplayHelper.getScreenWidth(); i++)
//			separationLine += "=";
//
//		for (int i = 0; i < (DisplayHelper.getScreenWidth() - header.length()) / 2; i++)
//			spaceLength += " ";
//
//		expectedResult += spaceLength + header + "\n";
//		expectedResult += separationLine + "\n";
//		expectedResult += "\r\n";
//		expectedResult += "Please select action:\r\n";
//		expectedResult += "Username: \r\n";
//		expectedResult += "Password: \r\n";
//		expectedResult += "Group id: \r\n";
//		expectedResult += "Success!\r\n";
//		expectedResult += "\r\n";
//		expectedResult += "Press Enter key to continue...\r\n";
//
//		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//		System.setOut(new PrintStream(outContent));
//
//		String input = "";
//
//		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
//		System.setIn(in);
//
//		ListAllActionsCmd.execute();
//
//		assertEquals(expectedResult, outContent.toString());
//
//	}

}
