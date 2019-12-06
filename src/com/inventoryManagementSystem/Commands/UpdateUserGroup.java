package com.inventoryManagementSystem.Commands;

import com.inventoryManagementSystem.Utils.DisplayHelper;
import com.inventoryManagementSystem.Modals.Staff;
import com.inventoryManagementSystem.Modals.UserGroup;

import java.util.Scanner;

public class UpdateUserGroup implements IMSCommand {
    public int getMinPermission() {
        return 3;
    }

    public String getDescription() {
        return "Update user group";
    }

    public void execute() {
        DisplayHelper.printHeader();
        int id = getId();
        int newGroupId = getGroupId();

        Staff.setUserGroup(id, newGroupId);

        System.out.println("Success!");
        DisplayHelper.pressEnterToContinue();
        DisplayHelper.cls();

    }

    private static int getId() {
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("User id: ");
                int id = scan.nextInt();
                if (Staff.getStaff(id)== null) {
                    System.out.println("id doesn't exist!");
                    DisplayHelper.pressEnterToContinue();
                } else return id;
            } catch (Exception e) {
                System.out.println("Invalid input! id must be a number");
                DisplayHelper.pressEnterToContinue();
            }
        }
    }

    private static int getGroupId() {
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("Group id: ");
                int groupId = scan.nextInt();
                if (UserGroup.getUserGroup(groupId) == null) {
                    System.out.println("group id not exist!");
                    DisplayHelper.pressEnterToContinue();
                } else return groupId;
            } catch (Exception e) {
                System.out.println("Invalid input! group id must be a number");
                DisplayHelper.pressEnterToContinue();
            }
        }
    }
}
