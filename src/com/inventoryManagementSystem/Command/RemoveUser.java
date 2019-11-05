package com.inventoryManagementSystem.Command;

import com.inventoryManagementSystem.CSVHelper;
import com.inventoryManagementSystem.DisplayHelper;
import com.inventoryManagementSystem.UserGroup;

import java.util.Scanner;

public class RemoveUser implements IMSCommand {
    public int getMinPermission() {
        return 3;
    }

    public String getDescription() {
        return "Remove user";
    }

    public void execute() {
        DisplayHelper.printHeader();
        System.out.println();
        int id = getId();
        CSVHelper users = new CSVHelper("/com/inventoryManagementSystem/Data/users.csv");
        String[] matcher = {Integer.toString(id), null, null, null};
        users.findOneAndRemove(matcher);
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
                if (users.findOne(matcher) == null) {
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
