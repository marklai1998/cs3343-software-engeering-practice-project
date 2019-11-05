package com.inventoryManagementSystem;

import com.inventoryManagementSystem.Command.IMSCommand;
import com.inventoryManagementSystem.Command.Login;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            IMSController controller = IMSController.getInstance();
            if (controller.getStaff() == null) controller.run(new Login());
            else mainMenu();
        }
    }

    private static void mainMenu() {
        DisplayHelper.printHeader();
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
        DisplayHelper.cls();
    }
}
