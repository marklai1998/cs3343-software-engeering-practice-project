package com.inventoryManagementSystem.Command;

import com.inventoryManagementSystem.DisplayHelper;
import com.inventoryManagementSystem.IMSController;

import java.util.Scanner;

public class ListAllActions implements IMSCommand {
    public int getMinPermission() {
        return -1;
    }

    public String getDescription() {
        return "List all Actions";
    }

    public void execute() {
        DisplayHelper.printHeader();

        System.out.println("Please select action:");
        System.out.println();
        IMSCommand[] availableCommands = IMSController.getInstance().getAvailableCommands();
        for (int i = 0; i < availableCommands.length; i++) {
            System.out.println((i + 1) + ". " + availableCommands[i].getDescription());
        }
        System.out.println();
        DisplayHelper.printSeparationLine();
        System.out.print("Action number: ");
        int actionNumber = getActionNumber();
        IMSController.getInstance().run(availableCommands[actionNumber - 1]);
        DisplayHelper.cls();
    }

    private int getActionNumber() {
        try {
            Scanner scan = new Scanner(System.in);
            return scan.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input!");
            DisplayHelper.pressEnterToContinue();
        }
        return -1;
    }
}
