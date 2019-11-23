package com.inventoryManagementSystem.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.inventoryManagementSystem.CSVHelper;
import com.inventoryManagementSystem.Staff;
import com.inventoryManagementSystem.UserGroup;

public class TestStaff {
	@Test
	public void testGetUserGroup_01() {

		Staff staff = new Staff(0, "test", "test", 0);

		UserGroup result = staff.getUserGroup();

		assertEquals(UserGroup.DEFAULT, result);
	}

	@Test
	public void testGetUserGroup_02() {

		Staff staff = new Staff(0, "test", "test", 1);

		UserGroup result = staff.getUserGroup();

		assertEquals(UserGroup.MARKETING, result);
	}

	@Test
	public void testGetUserGroup_03() {

		Staff staff = new Staff(0, "test", "test", 2);

		UserGroup result = staff.getUserGroup();

		assertEquals(UserGroup.MANAGER, result);
	}

	@Test
	public void testGetUserGroup_04() {

		Staff staff = new Staff(0, "test", "test", 3);

		UserGroup result = staff.getUserGroup();

		assertEquals(UserGroup.ADMIN, result);
	}

	@Test
	public void testGetUserGroup_05() {

		Staff staff = new Staff(0, "test", "test", 4);

		UserGroup result = staff.getUserGroup();

		assertEquals(null, result);
	}

	@Test
	public void testGetName_01() {

		Staff staff = new Staff(0, "test", "test", 4);

		String result = staff.getName();

		assertEquals("test", result);
	}

	@Test
	public void testGetId_01() {

		Staff staff = new Staff(0, "test", "test", 4);

		int result = staff.getId();

		assertEquals(0, result);
	}

	@Test
	public void testGetPassword_01() {

		Staff staff = new Staff(0, "test", "test", 4);

		String result = staff.getPassword();

		assertEquals("test", result);
	}

	@Test
	public void testGetStaff_01() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testStaff.csv");
		Staff.changeDataSet(newDataSet);

		Staff result = Staff.getStaff(0);
		Staff expectedResult = new Staff(0, "test", "test", 0);

		assertEquals(true, result.equals(expectedResult));
	}

	@Test
	public void testGetStaff_02() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testStaff.csv");
		Staff.changeDataSet(newDataSet);

		Staff result = Staff.getStaff(-1);
		Staff expectedResult = null;

		assertEquals(expectedResult, result);
	}

	@Test
	public void testGetStaff_03() {
		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testStaff.csv");
		Staff.changeDataSet(newDataSet);

		Staff result = Staff.getStaff("test");
		Staff expectedResult = new Staff(0, "test", "test", 0);

		assertEquals(true, result.equals(expectedResult));
	}

	@Test
	public void testGetStaff_04() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testStaff.csv");
		Staff.changeDataSet(newDataSet);

		Staff result = Staff.getStaff("test0");
		Staff expectedResult = null;

		assertEquals(expectedResult, result);
	}

	@Test
	public void testGetStaff_05() {
		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testStaff.csv");
		Staff.changeDataSet(newDataSet);

		Staff result = Staff.getStaff("test", "test");
		Staff expectedResult = new Staff(0, "test", "test", 0);

		assertEquals(true, result.equals(expectedResult));
	}

	@Test
	public void testGetStaff_06() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testStaff.csv");
		Staff.changeDataSet(newDataSet);

		Staff result = Staff.getStaff("test0", "test0");
		Staff expectedResult = null;

		assertEquals(expectedResult, result);
	}

	@Test
	public void testAddStaff_01() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testStaff.csv");
		Staff.changeDataSet(newDataSet);

		Staff staff = new Staff(4, "test4", "test4", 0);

		Staff.addStaff(staff);

		String result = Staff.getStaff(4).getName();

		assertEquals("test4", result);
	}

	@Test
	public void testRemoveStaff_01() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testStaff.csv");
		Staff.changeDataSet(newDataSet);

		Staff.removeStaff(4);

		Staff result = Staff.getStaff(4);

		assertEquals(null, result);
	}

	@Test
	public void testGetAllStaff_01() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testStaff.csv");
		Staff.changeDataSet(newDataSet);

		Staff[] result = Staff.getAllStaffs();

		assertEquals(4, result.length);
	}

	@Test
	public void testSetUserGroup_01() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testStaff.csv");
		Staff.changeDataSet(newDataSet);

		Staff.setUserGroup(0, 1);
		UserGroup result= Staff.getStaff(0).getUserGroup();
		
		assertEquals(UserGroup.MARKETING, result);
	}
	

	@Test
	public void testSetUserGroup_02() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testStaff.csv");
		Staff.changeDataSet(newDataSet);

		Staff.setUserGroup(0, 0);
		UserGroup result= Staff.getStaff(0).getUserGroup();
		
		assertEquals(UserGroup.DEFAULT, result);
	}
	@Test
	public void testSetPassword_01() {
		
		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testStaff.csv");
		Staff.changeDataSet(newDataSet);

		Staff staff = new Staff(0,"test","test",0);

		staff.setPassword("admin");
		
		Staff result = Staff.getStaff(0);
		
		assertEquals("admin", result.getPassword());
	}
	@Test
	public void testSetPassword_02() {
		
		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testStaff.csv");
		Staff.changeDataSet(newDataSet);

		Staff staff = new Staff(0,"test","test",0);

		staff.setPassword("test");
		
		Staff result = Staff.getStaff(0);
		
		assertEquals("test", result.getPassword());
	}
}
