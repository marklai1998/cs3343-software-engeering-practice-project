package com.inventoryManagementSystem.Commands;

import com.inventoryManagementSystem.*;
import com.inventoryManagementSystem.Modals.Staff;
import com.inventoryManagementSystem.Modals.UserGroup;
import com.inventoryManagementSystem.Utils.DisplayHelper;

public class ViewProfile implements IMSCommand {
    public int getMinPermission() {
        return 0;
    }

    public String getDescription() {
        return "View Profile";
    }

    public void execute() {
        Staff staff = IMSController.getInstance().getStaff();
        DisplayHelper.printHeader();
        UserGroup group = staff.getUserGroup();
        System.out.println("User id: " + staff.getId());
        System.out.println("User name: " + staff.getName());
        System.out.println("Password: " + staff.getPassword());
        System.out.println("User group: " + group.getGroupName() + "(" + group.getGroupId() + ")");
        DisplayHelper.pressEnterToContinue();
        DisplayHelper.cls();
    }
}
