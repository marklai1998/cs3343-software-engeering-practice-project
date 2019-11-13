package com.inventoryManagementSystem;

import java.util.ArrayList;

public class Staff {
    private int id;
    private String name;
    private String password;
    private UserGroup userGroup;
    private static CSVHelper staffData = new CSVHelper("/com/inventoryManagementSystem/Data/staff.csv");;

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

    public void setPassword(String password) {
        this.password = password;
        String[] matchData = {String.valueOf(this.id), null, null, null};
        String[] newData = {null, null, password, null};
        staffData.findOneAndUpdate(matchData, newData);
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public static void addStaff(Staff staff) {
        String[] newUser = {Integer.toString(staff.getId()), staff.getName(), staff.getPassword(), Integer.toString(staff.getUserGroup().getGroupId())};
        staffData.insertOne(newUser);
    }

    public static Staff[] getAllStaffs() {
        DisplayHelper.printHeader();
        ArrayList<String[]> allData = staffData.getCsvBuffer();

        Staff[] staffs = new Staff[allData.size()];
        for (int i = 0; i < allData.size(); i++) {
            String[] staffData = allData.get(i);
            Staff staff = new Staff(Integer.parseInt(staffData[0]), staffData[1], staffData[2], Integer.parseInt(staffData[3]));
            staffs[i] = staff;
        }
        return staffs;
    }

    public static void removeStaff(int id) {
        String[] matcher = {Integer.toString(id), null, null, null};
        staffData.findOneAndRemove(matcher);
    }

    public static void setUserGroup(int id, int grpupId) {
        String[] matcher = {Integer.toString(id), null, null, null};
        String[] update = {null, null, null, Integer.toString(grpupId)};
        staffData.findOneAndUpdate(matcher, update);
    }

    public static Staff getStaff(int id) {
        String[] matcher = {Integer.toString(id), null, null, null};
        String[] matchedData = staffData.findOne(matcher);
        if (staffData == null) return null;
        return new Staff(Integer.parseInt(matchedData[0]), matchedData[1], matchedData[2], Integer.parseInt(matchedData[3]));
    }

    public static Staff getStaff(String username) {
        String[] matcher = {null, username, null, null};
        String[] matchedData = staffData.findOne(matcher);
        if (matchedData == null) return null;
        return new Staff(Integer.parseInt(matchedData[0]), matchedData[1], matchedData[2], Integer.parseInt(matchedData[3]));
    }

    public static Staff getStaff(String username, String password) {
        String[] matcher = {null, username, password, null};
        String[] matchedData = staffData.findOne(matcher);
        if (matchedData == null) return null;
        return new Staff(Integer.parseInt(matchedData[0]), matchedData[1], matchedData[2], Integer.parseInt(matchedData[3]));
    }
}
