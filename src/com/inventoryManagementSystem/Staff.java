package com.inventoryManagementSystem;

public class Staff {
    private int id;
    private String name;
    private String password;
    private UserGroup userGroup;

    public Staff(int id, String name, String password, int groupId) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.userGroup = UserGroup.getUserGroup(groupId);
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
