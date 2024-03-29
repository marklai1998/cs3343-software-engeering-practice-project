package com.inventoryManagementSystem.Commands;

import com.inventoryManagementSystem.Utils.DisplayHelper;
import com.inventoryManagementSystem.IMSController;
import com.inventoryManagementSystem.Modals.Staff;

import java.util.Scanner;

public class ChangePassword implements IMSCommand {
    public int getMinPermission() {
        return 0;
    }

    public String getDescription() {
        return "Change password";
    }

    public void execute() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            DisplayHelper.cls();
            DisplayHelper.printHeader();
            System.out.println("New password: ");
            String password = scan.nextLine();


            if (password.equals("")) {
                System.out.println("New password cannot be empty!");
                DisplayHelper.pressEnterToContinue();
                continue;
            }

            if (password.equals(IMSController.getInstance().getStaff().getPassword())) {
                System.out.println("New password cannot be the same as the original!");
                DisplayHelper.pressEnterToContinue();
                continue;
            }

            System.out.println("Retype password: ");
            String retypePassword = scan.nextLine();
            if (!password.equals(retypePassword)) {
                System.out.println("2 passwords are not the same!");
                DisplayHelper.pressEnterToContinue();
                continue;
            }

            Staff staff = IMSController.getInstance().getStaff();
            staff.setPassword(password);

            System.out.println("Update successful!");
            DisplayHelper.pressEnterToContinue();
            break;
        }
    }
}
