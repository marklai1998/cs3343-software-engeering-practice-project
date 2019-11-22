package com.inventoryManagementSystem.Command;

import com.inventoryManagementSystem.DisplayHelper;
import com.inventoryManagementSystem.PriceChange;

import java.util.Scanner;

public class RemovePriceChange implements IMSCommand {
    public int getMinPermission() {
        return 2;
    }

    public String getDescription() {
        return "Remove price change";
    }

    public void execute() {
        DisplayHelper.cls();
        DisplayHelper.printHeader();
        int id = getId();

        PriceChange.removePriceChange(id);

        System.out.println("Success!");
        DisplayHelper.pressEnterToContinue();

    }

    private static int getId() {
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("id: ");
                int id = scan.nextInt();
                if (PriceChange.getPriceChange(id) == null) {
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
