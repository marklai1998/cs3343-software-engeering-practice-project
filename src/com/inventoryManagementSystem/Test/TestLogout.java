package com.inventoryManagementSystem.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import com.inventoryManagementSystem.IMSController;
import com.inventoryManagementSystem.Staff;
import com.inventoryManagementSystem.Command.Logout;

public class TestLogout {
	@Test
	public void testGetMinPermission() {

		Logout LogoutCmd = new Logout();

		int result = LogoutCmd.getMinPermission();

		assertEquals(0, result);
	}

	@Test
	public void testGetDescription() {

		Logout LogoutCmd = new Logout();

		String result = LogoutCmd.getDescription();

		assertEquals("Logout", result);
	}

	@Test
	public void testLogoutExecute() {

//		Logout LogoutCmd = new Logout();
//		
//		LogoutCmd.execute();
//		
//		Staff result =  IMSController.getInstance().getStaff();
//		
//		assertEquals(null, result);

	}

}
