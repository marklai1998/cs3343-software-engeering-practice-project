package com.inventoryManagementSystem;

import com.inventoryManagementSystem.Command.IMSCommand;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            IMSController controller = IMSController.getInstance();
            DisplayHelper.printHeader();
            if (controller == null) LoginScreen();
            else mainMenu();
            DisplayHelper.cls();
        }
    }

    private static void LoginScreen() {
        Scanner scan = new Scanner(System.in);
        CSVHelper users = new CSVHelper("/com/inventoryManagementSystem/Data/users.csv");

        System.out.print("User name: ");
        String userName = scan.nextLine();
        System.out.print("Password: ");
        String password = scan.nextLine();
        String[] matchData = {null, userName, password, null};
        String[] matched = users.findOne(matchData);
        if (matched == null) System.out.println("Invalid username or password!");
        else {
            System.out.println("Login Success!");
            Staff staff = new Staff(Integer.parseInt(matched[0]), matched[1], matched[2], Integer.parseInt(matched[3]));
            IMSController.initInstance(staff);
        }
        DisplayHelper.pressEnterToContinue();
    }

    private static void mainMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please select action:");
        System.out.println();
        IMSCommand[] availableCommands = IMSController.getInstance().getAvailableCommands();
        for (int i = 0; i < availableCommands.length; i++) {
            System.out.println((i + 1) + ". " + availableCommands[i].getDescription());
        }
        System.out.println();
        DisplayHelper.printSeparationLine();
        System.out.print("Action number: ");
        try {
            int actionNumber = scan.nextInt();
            DisplayHelper.cls();
            IMSController.getInstance().run(availableCommands[actionNumber - 1]);
        } catch (Exception e) {
            System.out.println("Invalid input!");
            DisplayHelper.pressEnterToContinue();
        }
    }
}
