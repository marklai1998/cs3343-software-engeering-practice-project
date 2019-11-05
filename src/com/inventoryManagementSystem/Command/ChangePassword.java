package com.inventoryManagementSystem.Command;

import com.inventoryManagementSystem.CSVHelper;
import com.inventoryManagementSystem.DisplayHelper;
import com.inventoryManagementSystem.IMSController;
import com.inventoryManagementSystem.Staff;

import java.util.Scanner;

public class ChangePassword implements IMSCommand {
    public void execute() {
        Scanner scan = new Scanner(System.in);
        CSVHelper users = new CSVHelper("/com/inventoryManagementSystem/Data/users.csv");
        while (true) {
            DisplayHelper.printHeader();
            System.out.println();
            System.out.println("New password: ");
            String password = scan.nextLine();
            System.out.println("Retype password: ");
            String retypePassword = scan.nextLine();
            if (!password.equals(retypePassword)) {
                System.out.println("2 passwords are not the same!");
                DisplayHelper.pressEnterToContinue();
            } else {
                Staff staff = IMSController.getInstance().getStaff();
                staff.setPassword(password);
                String[] matchData = {String.valueOf(staff.getId()), null, null, null};
                String[] newData = {null, null, password, null};
                users.findOneAndUpdate(matchData, newData);
                System.out.println("Update successful!");
                DisplayHelper.pressEnterToContinue();
                break;
            }
            DisplayHelper.cls();
        }
    }

    public int getMinPermission() {
        return 0;
    }

    public String getDescription() {
        return "Change password";
    }
}
