package com.inventoryManagementSystem;

class Staff {
    private int id;
    private String name;
    private String password;
    private UserGroup userGroup;

    Staff(int id, String name, String password, int groupId) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.userGroup = UserGroup.getUserGroup(groupId);
    }

    UserGroup getUserGroup() {
        return userGroup;
    }

    String getName() {
        return name;
    }
}
