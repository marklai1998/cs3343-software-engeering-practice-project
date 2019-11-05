package com.inventoryManagementSystem.Command;

import com.inventoryManagementSystem.CSVHelper;
import com.inventoryManagementSystem.DisplayHelper;
import com.inventoryManagementSystem.IMSController;
import com.inventoryManagementSystem.Staff;

import java.util.Scanner;

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
        System.out.println("id: " + staff.getId());
        System.out.println("User name: " + staff.getName());
        System.out.println("Password: " + staff.getPassword());
        System.out.println("User group: " + staff.getUserGroup().getGroupName());
        DisplayHelper.pressEnterToContinue();
        DisplayHelper.cls();
    }
}
