package com.inventoryManagementSystem.Test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import com.inventoryManagementSystem.DisplayHelper;
import com.inventoryManagementSystem.IMSController;
import com.inventoryManagementSystem.Main;
import com.inventoryManagementSystem.Staff;

public class TestMain {

//	@Test
//	public void testMain_01() {
//
//		IMSController controller = IMSController.getInstance();
//		controller.setStaff(new Staff(0, "test", "test", 0));
//
//		Main.main(new String[0]);
//
//	}
//
//	@Test
//	public void testMain_02() {
//
//		IMSController controller = IMSController.getInstance();
//		controller.setStaff(null);
//
//		Main.main(new String[0]);
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
//		expectedResult += spaceLength;
//		expectedResult += header;
//		expectedResult += "\n";
//		expectedResult += separationLine;
//		expectedResult += "\n";
//		expectedResult += "\r\n";
//
//		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//		System.setOut(new PrintStream(outContent));
//		
//		assertEquals(null, outContent.toString());
//	}

}
