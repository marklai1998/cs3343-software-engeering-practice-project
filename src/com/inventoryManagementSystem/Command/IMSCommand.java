package com.inventoryManagementSystem.Command;

public interface IMSCommand {
    IMSCommand[] allCommands = {new Login(), new ViewProfile(), new ChangePassword(), new Logout()};

    void execute();

    //    permission = -1 mean it's a system command, it wont show on the main menu but can manually call(eg. login)
    int getMinPermission();

    String getDescription();
}
