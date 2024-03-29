package com.inventoryManagementSystem.Commands;

import com.inventoryManagementSystem.Modals.Staff;
import com.inventoryManagementSystem.Modals.UserGroup;
import com.inventoryManagementSystem.Utils.DisplayHelper;

import java.util.Scanner;

public class CreateNewUser implements IMSCommand {
    public int getMinPermission() {
        return 2;
    }

    public String getDescription() {
        return "Create new user";
    }

    public void execute() {
        DisplayHelper.cls();
        DisplayHelper.printHeader();
        int id = getId();
        String username = getUsername();
        String password = getPassword();
        int groupId = getGroupId();

        Staff newStaff = new Staff(id, username, password, groupId);
        Staff.addStaff(newStaff);

        System.out.println("Success!");
        DisplayHelper.pressEnterToContinue();
    }

    private static int getId() {
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("User id: ");
                int id = scan.nextInt();

                if (Staff.getStaff(id) != null) {
                    System.out.println("id already exist!");
                    DisplayHelper.pressEnterToContinue();
                } else return id;
            } catch (Exception e) {
                System.out.println("Invalid input! id must be a number");
                DisplayHelper.pressEnterToContinue();
            }
        }
    }

    private static String getUsername() {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Username: ");
            String username = scan.nextLine();

            if (username.equals("")) {
                System.out.println("Username cannot be empty!");
                DisplayHelper.pressEnterToContinue();
                continue;
            }

            if (Staff.getStaff(username) != null) {
                System.out.println("User already exist!");
                DisplayHelper.pressEnterToContinue();
            } else return username;
        }
    }

    private static String getPassword() {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Password: ");
            String password = scan.nextLine();

            if (password.equals("")) {
                System.out.println("Password cannot be empty!");
                DisplayHelper.pressEnterToContinue();
                continue;
            }
            return password;
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
