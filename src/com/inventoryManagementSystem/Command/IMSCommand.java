package com.inventoryManagementSystem.Command;

public interface IMSCommand {
    IMSCommand[] allCommands = {
            new Login(),
            new ListAllActions(),
            new ViewProfile(),
            new ChangePassword(),
            new ListAllUsers(),
            new UpdateUserGroup(),
            new CreateNewUser(),
            new RemoveUser(),
            new ListAllProducts(),
            new CreateNewProduct(),
            new UpdateProduct(),
            new RemoveProduct(),
            new ListAllPriceChange(),
            new Logout()
    };

    void execute();

    //    permission = -1 mean it's a system command, it wont show on the main menu but can manually call(eg. login)
    int getMinPermission();

    String getDescription();
}
