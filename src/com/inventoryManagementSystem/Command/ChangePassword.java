package com.inventoryManagementSystem.Command;

public class ChangePassword implements IMSCommand {
    public void execute() {

    }

    public int getMinPermission() {
        return 0;
    }

    public String getDescription() {
        return "Change password";
    }
}
