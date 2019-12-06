package com.inventoryManagementSystem.Commands;

import com.inventoryManagementSystem.IMSController;

public class Logout implements IMSCommand {
    public int getMinPermission() {
        return 0;
    }

    public String getDescription() {
        return "Logout";
    }

    public void execute() {
        IMSController.getInstance().setStaff(null);
    }
}
