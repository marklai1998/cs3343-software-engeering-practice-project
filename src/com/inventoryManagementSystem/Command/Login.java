package com.inventoryManagementSystem.Command;

import com.inventoryManagementSystem.CSVHelper;
import com.inventoryManagementSystem.DisplayHelper;
import com.inventoryManagementSystem.IMSController;
import com.inventoryManagementSystem.Staff;

import java.util.Scanner;

public class Login implements IMSCommand {
    public int getMinPermission() {
        return -1;
    }

    public String getDescription() {
        return "Login";
    }

    public void execute() {
        while (true) {
            DisplayHelper.printHeader();
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
                IMSController.getInstance().setStaff(staff);
                break;
            }
            DisplayHelper.pressEnterToContinue();
            DisplayHelper.cls();
        }
    }
}
