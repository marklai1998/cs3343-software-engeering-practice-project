package com.inventoryManagementSystem.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.inventoryManagementSystem.UserGroup;


public class TestUserGroup {

	@Test
	public void testGetGroupId_01() {

		UserGroup userGroup = UserGroup.DEFAULT;

		int result = userGroup.getGroupId();

		assertEquals(0, result);
	}
	
	@Test
	public void testGetGroupId_02() {

		UserGroup userGroup = UserGroup.MARKETING;

		int result = userGroup.getGroupId();

		assertEquals(1, result);
	}
	@Test
	public void testGetGroupId_03() {

		UserGroup userGroup = UserGroup.MANAGER;

		int result = userGroup.getGroupId();

		assertEquals(2, result);
	}
	@Test
	public void testGetGroupId_04() {

		UserGroup userGroup = UserGroup.ADMIN;

		int result = userGroup.getGroupId();

		assertEquals(3, result);
	}
	
	@Test
	public void testGetGroupName_01() {

		UserGroup userGroup = UserGroup.DEFAULT;

		String  result = userGroup.getGroupName();

		assertEquals("Default", result);
	}
	
	@Test
	public void testGetGroupName_02() {

		UserGroup userGroup = UserGroup.MARKETING;

		String  result = userGroup.getGroupName();

		assertEquals("Marketing", result);
	}
	@Test
	public void testGetGroupName_03() {

		UserGroup userGroup = UserGroup.MANAGER;

		String  result = userGroup.getGroupName();

		assertEquals("Manager", result);
	}
	@Test
	public void testGetGroupName_04() {

		UserGroup userGroup = UserGroup.ADMIN;

		String  result = userGroup.getGroupName();

		assertEquals("Admin", result);
	}
	
	@Test
	public void testGetPermissionLevel_01() {

		UserGroup userGroup = UserGroup.DEFAULT;

		int result = userGroup.getPermissionLevel();

		assertEquals(0, result);
	}
	
	@Test
	public void testGetPermissionLevel_02() {

		UserGroup userGroup = UserGroup.MARKETING;

		int result = userGroup.getPermissionLevel();

		assertEquals(1, result);
	}
	@Test
	public void testGetPermissionLevel_03() {

		UserGroup userGroup = UserGroup.MANAGER;

		int result = userGroup.getPermissionLevel();

		assertEquals(2, result);
	}
	@Test
	public void testGetPermissionLevel_04() {

		UserGroup userGroup = UserGroup.ADMIN;

		int result = userGroup.getPermissionLevel();

		assertEquals(3, result);
	}
	
	@Test
	public void testGetUserGroup_01() {

		UserGroup expectedResult = UserGroup.DEFAULT;

		UserGroup result = UserGroup.getUserGroup(0);

		assertEquals(expectedResult, result);
	}
	
	@Test
	public void testGetUserGroup_02() {

		UserGroup expectedResult = UserGroup.MARKETING;

		UserGroup result =UserGroup.getUserGroup(1);

		assertEquals(expectedResult, result);
	}
	@Test
	public void testGetUserGroup_03() {

		UserGroup expectedResult = UserGroup.MANAGER;

		UserGroup result = UserGroup.getUserGroup(2);

		assertEquals(expectedResult, result);
	}
	@Test
	public void testGetUserGroup_04() {

		UserGroup expectedResult = UserGroup.ADMIN;

		UserGroup result = UserGroup.getUserGroup(3);

		assertEquals(expectedResult, result);
	}
	

	@Test
	public void testGetUserGroup_05() {

		UserGroup expectedResult = null;

		UserGroup result = UserGroup.getUserGroup(-1);

		assertEquals(expectedResult, result);
	}
	@Test
	public void testGetUserGroup_06() {

		UserGroup expectedResult = null;

		UserGroup result = UserGroup.getUserGroup(10);

		assertEquals(expectedResult, result);
	}
}
