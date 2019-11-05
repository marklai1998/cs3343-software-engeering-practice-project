package com.inventoryManagementSystem.Command;

public interface IMSCommand {
    IMSCommand[] allCommands = {
            new Login(),
            new ListAllActions(),
            new ViewProfile(),
            new ChangePassword(),
            new ListAllUser(),
            new UpdateUserGroup(),
            new CreateNewUser(),
            new RemoveUser(),
            new Logout()
    };

    void execute();

    //    permission = -1 mean it's a system command, it wont show on the main menu but can manually call(eg. login)
    int getMinPermission();

    String getDescription();
}
