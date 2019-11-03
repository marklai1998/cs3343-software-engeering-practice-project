package com.inventoryManagementSystem;

import com.inventoryManagementSystem.Command.IMSCommand;

import java.util.ArrayList;

public class IMSController {
    private static IMSController instance = null;
    private Staff staff;

    private IMSController(Staff s) {
        staff = s;
    }

    static void initInstance(Staff staff) {
        instance = new IMSController(staff);
    }

    public static void destroyInstance() {
        instance = null;
    }

    static IMSController getInstance() {
        return instance;
    }

    Staff getStaff() {
        return this.staff;
    }

    IMSCommand[] getAvailableCommands() {
        IMSCommand[] allCommands = IMSCommand.allCommands;
        ArrayList<IMSCommand> availableCommands = new ArrayList<>();
        for (IMSCommand command : allCommands) {
            if (command.getMinPermission() <= staff.getUserGroup().getPermissionLevel()) {
                availableCommands.add(command);
            }
        }
        return availableCommands.toArray(new IMSCommand[0]);
    }

    void run(IMSCommand command) {
        if (command.getMinPermission() > staff.getUserGroup().getPermissionLevel()) {
            System.out.println("Permission Denied");
            DisplayHelper.pressEnterToContinue();
        } else {
            command.execute();
        }
    }
}
