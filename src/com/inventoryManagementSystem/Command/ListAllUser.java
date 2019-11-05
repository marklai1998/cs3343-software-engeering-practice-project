package com.inventoryManagementSystem.Command;

import com.inventoryManagementSystem.CSVHelper;
import com.inventoryManagementSystem.DisplayHelper;
import com.inventoryManagementSystem.UserGroup;

import java.util.ArrayList;
import java.util.Scanner;

public class ListAllUser implements IMSCommand {
    public int getMinPermission() {
        return 2;
    }

    public String getDescription() {
        return "List all user";
    }

    public void execute() {
        DisplayHelper.printHeader();
        CSVHelper users = new CSVHelper("/com/inventoryManagementSystem/Data/users.csv");
        ArrayList<String[]> allData = users.getCsvBuffer();
        for (String[] rowData : allData) {
            UserGroup group = UserGroup.getUserGroup(Integer.parseInt(rowData[3]));
            System.out.println("User id: " + rowData[0]);
            System.out.println("Username: " + rowData[1]);
            System.out.println("User group: " + group + "(" + group.getGroupId() + ")");
            System.out.println();
        }
        DisplayHelper.pressEnterToContinue();
        DisplayHelper.cls();

    }
}
