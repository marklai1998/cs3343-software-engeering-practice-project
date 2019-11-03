package com.inventoryManagementSystem;

public class IMSController {
    private static IMSController instance = null;
    private Staff staff;

    private IMSController(Staff s) {
        staff = s;
    }

    static void initInstance(Staff staff) {
        instance = new IMSController(staff);
    }

    static IMSController getInstance() {
        return instance;
    }

    Staff getStaff() {
        return this.staff;
    }
}
