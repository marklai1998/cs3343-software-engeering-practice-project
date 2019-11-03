package com.inventoryManagementSystem;

public enum UserGroup {
    DEFAULT("Default", 0, 0),
    MARKETING("Marketing", 1, 1),
    MANAGER("Manager", 2, 2),
    ADMIN("Admin", 3, 3);

    private int groupId;
    private int permissionLevel;
    private String groupName;

    UserGroup(String groupName, int groupId, int permissionLevel) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.permissionLevel = permissionLevel;
    }

    public String getGroupName() {
        return groupName;
    }

    public int getGroupId() {
        return groupId;
    }

    public int getPermissionLevel() {
        return permissionLevel;
    }

    public static UserGroup getUserGroup(int id) {
        switch (id) {
            case 0:
                return DEFAULT;
            case 1:
                return MARKETING;
            case 2:
                return MANAGER;
            case 3:
                return ADMIN;
            default:
                return DEFAULT;
        }
    }
}
