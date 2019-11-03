package com.inventoryManagementSystem;

class Staff {
    private int id;
    private String name;
    private String password;
//    TODO: implement position;

    Staff(int i, String n, String p) {
        id = i;
        name = n;
        password = p;
    }

    public String getName() {
        return name;
    }
}
