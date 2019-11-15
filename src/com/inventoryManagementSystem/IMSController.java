package com.inventoryManagementSystem;

import com.inventoryManagementSystem.Command.IMSCommand;

import java.util.ArrayList;

public class IMSController {
    private static IMSController instance = new IMSController();
    private Staff staff = null;


    public static IMSController getInstance() {
        return instance;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Staff getStaff() {
        return this.staff;
    }

    public IMSCommand[] getAvailableCommands(IMSCommand[] allCommands) {
        if (this.staff == null) return new IMSCommand[0];
        ArrayList<IMSCommand> availableCommands = new ArrayList<>();
        for (IMSCommand command : allCommands) {
            if (command.getMinPermission() >= 0 && command.getMinPermission() <= staff.getUserGroup().getPermissionLevel()) {
                availableCommands.add(command);
            }
        }
        return availableCommands.toArray(new IMSCommand[0]);
    }

    public void run(IMSCommand command) {
        if (command.getMinPermission() < 0 || command.getMinPermission() <= staff.getUserGroup().getPermissionLevel()) {
            command.execute();
        } else {
            System.out.println("Permission Denied");
            DisplayHelper.pressEnterToContinue();
        }
    }
}
