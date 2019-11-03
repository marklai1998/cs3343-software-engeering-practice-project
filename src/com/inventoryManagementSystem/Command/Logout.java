package com.inventoryManagementSystem.Command;

import com.inventoryManagementSystem.IMSController;

public class Logout implements IMSCommand {
    public void execute() {
        IMSController.destroyInstance();
    }

    public int getMinPermission() {
        return 0;
    }

    public String getDescription() {
        return "Logout";
    }
}
