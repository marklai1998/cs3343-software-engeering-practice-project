package com.inventoryManagementSystem;

import com.inventoryManagementSystem.Commands.ListAllActions;
import com.inventoryManagementSystem.Commands.Login;

public class Main {
    public static void main(String[] args) {
        while (true) {
            IMSController controller = IMSController.getInstance();
            if (controller.getStaff() == null) controller.run(new Login());
            else controller.run(new ListAllActions());
        }
    }
}
