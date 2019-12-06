package com.inventoryManagementSystem.Commands;

import com.inventoryManagementSystem.Utils.DisplayHelper;
import com.inventoryManagementSystem.Modals.Staff;

import java.util.Scanner;

public class RemoveUser implements IMSCommand {
    public int getMinPermission() {
        return 3;
    }

    public String getDescription() {
        return "Remove user";
    }

    public void execute() {
        DisplayHelper.cls();
        DisplayHelper.printHeader();
        int id = getId();

        Staff.removeStaff(id);

        System.out.println("Success!");
        DisplayHelper.pressEnterToContinue();

    }

    private static int getId() {
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("User id: ");
                int id = scan.nextInt();
                if (Staff.getStaff(id) == null) {
                    System.out.println("id doesn't exist!");
                    DisplayHelper.pressEnterToContinue();
                } else return id;
            } catch (Exception e) {
                System.out.println("Invalid input! id must be a number");
                DisplayHelper.pressEnterToContinue();
            }
        }
    }
}
