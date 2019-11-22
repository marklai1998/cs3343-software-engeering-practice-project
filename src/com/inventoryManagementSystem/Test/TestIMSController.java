package com.inventoryManagementSystem.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.inventoryManagementSystem.IMSController;
import com.inventoryManagementSystem.Staff;

import com.inventoryManagementSystem.Command.*;

public class TestIMSController {

	@Test
	public void testGetStaff_01() {

		IMSController controller = IMSController.getInstance();

		Staff staff = null;

		controller.setStaff(staff);
		Staff result = controller.getStaff();

		assertEquals(null, result);
	}

	@Test
	public void testSetStaff_01() {

		IMSController controller = IMSController.getInstance();

		Staff staff = new Staff(0, "user", "user", 0);

		controller.setStaff(staff);

		Staff result = controller.getStaff();

		assertEquals(staff, result);
	}

	@Test
	public void testGetAvailableCommands_01() {

		IMSController controller = IMSController.getInstance();

		Staff staff = null;

		controller.setStaff(staff);

		IMSCommand[] actualResult = controller.getAvailableCommands(IMSCommand.allCommands);

		IMSCommand[] expectedResult = new IMSCommand[0];

		assertArrayEquals(expectedResult, actualResult);
	}

	@Test
	public void testGetAvailableCommands_02() {

		Staff staff = new Staff(0, "user", "user", 0);
		IMSController controller = IMSController.getInstance();
		controller.setStaff(staff);

		IMSCommand[] actualResult = controller.getAvailableCommands(IMSCommand.allCommands);

		IMSCommand[] expectedResult = { IMSCommand.allCommands[2], IMSCommand.allCommands[3], IMSCommand.allCommands[8],
				IMSCommand.allCommands[13], IMSCommand.allCommands[16] };

		assertArrayEquals(expectedResult, actualResult);
	}

	@Test
	public void testGetAvailableCommands_03() {

		Staff staff = new Staff(1, "user", "user", 1);
		IMSController controller = IMSController.getInstance();
		controller.setStaff(staff);

		IMSCommand[] actualResult = controller.getAvailableCommands(IMSCommand.allCommands);

		IMSCommand[] expectedResult = { IMSCommand.allCommands[2], IMSCommand.allCommands[3], IMSCommand.allCommands[8],
				IMSCommand.allCommands[13], IMSCommand.allCommands[16] };

		assertArrayEquals(expectedResult, actualResult);
	}

	@Test
	public void testGetAvailableCommands_04() {

		Staff staff = new Staff(2, "user", "user", 2);
		IMSController controller = IMSController.getInstance();
		controller.setStaff(staff);

		IMSCommand[] actualResult = controller.getAvailableCommands(IMSCommand.allCommands);

		IMSCommand[] expectedResult = { IMSCommand.allCommands[2], IMSCommand.allCommands[3], IMSCommand.allCommands[4],
				IMSCommand.allCommands[6], IMSCommand.allCommands[8], IMSCommand.allCommands[9],
				IMSCommand.allCommands[10], IMSCommand.allCommands[11], IMSCommand.allCommands[12],
				IMSCommand.allCommands[13], IMSCommand.allCommands[14], IMSCommand.allCommands[15],
				IMSCommand.allCommands[16] };

		assertArrayEquals(expectedResult, actualResult);
	}

	@Test
	public void testGetAvailableCommands_05() {

		Staff staff = new Staff(3, "user", "user", 3);
		IMSController controller = IMSController.getInstance();
		controller.setStaff(staff);

		IMSCommand[] actualResult = controller.getAvailableCommands(IMSCommand.allCommands);

		IMSCommand[] expectedResult = { IMSCommand.allCommands[2], IMSCommand.allCommands[3], IMSCommand.allCommands[4],
				IMSCommand.allCommands[5], IMSCommand.allCommands[6], IMSCommand.allCommands[7],
				IMSCommand.allCommands[8], IMSCommand.allCommands[9], IMSCommand.allCommands[10],
				IMSCommand.allCommands[11], IMSCommand.allCommands[12], IMSCommand.allCommands[13],
				IMSCommand.allCommands[14], IMSCommand.allCommands[15], IMSCommand.allCommands[16] };

		assertArrayEquals(expectedResult, actualResult);
	}

//	@Test
//	public void testGetAvailableCommands_06() {
//
//		Staff staff = new Staff(4, "user", "user", 4);
//		IMSController controller = IMSController.getInstance();
//		controller.setStaff(staff);
//
//		// Error on getAvailableCommands as UserGroup.getUserGroup return null if
//		// groupId is not 0-3
//
//		IMSCommand[] actualResult = controller.getAvailableCommands(IMSCommand.allCommands);
//
//		IMSCommand[] expectedResult = IMSCommand.allCommands;
//
//		assertArrayEquals(expectedResult, actualResult);
//	}
}
