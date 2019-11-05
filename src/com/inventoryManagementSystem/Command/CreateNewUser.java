package com.inventoryManagementSystem.Command;

import com.inventoryManagementSystem.*;

import java.util.Scanner;

public class CreateNewUser implements IMSCommand {
    public int getMinPermission() {
        return 2;
    }

    public String getDescription() {
        return "Create new user";
    }

    public void execute() {
        DisplayHelper.printHeader();
        int id = getId();
        String username = getUsername();
        String password = getPassword();
        int groupId = getGroupId();
        CSVHelper users = new CSVHelper("/com/inventoryManagementSystem/Data/users.csv");
        String[] newUser = {Integer.toString(id), username, password, Integer.toString(groupId)};
        users.insertOne(newUser);
        System.out.println("Success!");
        DisplayHelper.pressEnterToContinue();
        DisplayHelper.cls();

    }

    private static int getId() {
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("id: ");
                int id = scan.nextInt();
                String[] matcher = {Integer.toString(id), null, null, null};
                CSVHelper users = new CSVHelper("/com/inventoryManagementSystem/Data/users.csv");
                if (users.findOne(matcher) != null) {
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
            String[] matcher = {null, username, null, null};
            CSVHelper users = new CSVHelper("/com/inventoryManagementSystem/Data/users.csv");
            if (users.findOne(matcher) != null) {
                System.out.println("User already exist!");
                DisplayHelper.pressEnterToContinue();
            } else return username;
        }
    }

    private static String getPassword() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Password: ");
        return scan.nextLine();
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
