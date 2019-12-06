package com.inventoryManagementSystem.Commands;

import com.inventoryManagementSystem.Utils.DisplayHelper;
import com.inventoryManagementSystem.Modals.Staff;

public class ListAllUsers implements IMSCommand {
    public int getMinPermission() {
        return 2;
    }

    public String getDescription() {
        return "List all users";
    }

    public void execute() {
        DisplayHelper.cls();
        DisplayHelper.printHeader();
        Staff[] staffs = Staff.getAllStaffs();
        for (Staff staff : staffs) {
            System.out.println("User id: " + staff.getId());
            System.out.println("Username: " + staff.getName());
            System.out.println("User group: " + staff.getUserGroup() + "(" + staff.getUserGroup().getGroupId() + ")");
            System.out.println();
        }
        DisplayHelper.pressEnterToContinue();
    }
}
