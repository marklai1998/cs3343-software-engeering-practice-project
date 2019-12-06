package com.inventoryManagementSystem.Commands;

import com.inventoryManagementSystem.Utils.DisplayHelper;
import com.inventoryManagementSystem.IMSController;
import com.inventoryManagementSystem.Modals.Staff;

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
            DisplayHelper.cls();
            DisplayHelper.printHeader();
            Scanner scan = new Scanner(System.in);

            System.out.print("User name: ");
            String userName = scan.nextLine();
            System.out.print("Password: ");
            String password = scan.nextLine();
            Staff staff = Staff.getStaff(userName,password);

            if (staff == null) {
                System.out.println("Invalid username or password!");
                DisplayHelper.pressEnterToContinue();
                continue;
            }
            System.out.println("Login Success!");
            DisplayHelper.pressEnterToContinue();
            IMSController.getInstance().setStaff(staff);
            break;
        }
    }
}
