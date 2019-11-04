package com.inventoryManagementSystem.Command;

public interface IMSCommand {
    IMSCommand[] allCommands = {new ChangePassword(), new Logout()};

    void execute();

    int getMinPermission();

    String getDescription();
}