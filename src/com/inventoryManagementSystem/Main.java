package com.inventoryManagementSystem;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            IMSController controller = IMSController.getInstance();
            DisplayHelper.printTextMiddleAligned("CS3343 Inventory Management System");
            if (controller != null) System.out.println("Logged in as: " + controller.getStaff().getName());
            DisplayHelper.printSeparationLine();
            if (controller == null) {
                LoginScreen();
            } else {
                mainMenu();
            }
            DisplayHelper.cls();
        }
    }

    private static void LoginScreen() {
        Scanner scan = new Scanner(System.in);
        CSVHelper users = new CSVHelper("./Data/users.csv");

        System.out.println("User name:");
        String userName = scan.nextLine();
        System.out.println("Password:");
        String password = scan.nextLine();
        String[] matchData = {"*", userName, password, "*"};
        String[] matched = users.matchLine(matchData);
        if (matched == null) {
            System.out.println("Invalid username or password!");
        } else {
            System.out.print(Arrays.toString(matched));
            System.out.println("Login Success!");
            Staff staff = new Staff(Integer.parseInt(matched[0]), matched[1], matched[2]);
            IMSController.initInstance(staff);
        }
        users.close();
        DisplayHelper.pressEnterToContinue();
    }

    private static void mainMenu() {

    }
}
