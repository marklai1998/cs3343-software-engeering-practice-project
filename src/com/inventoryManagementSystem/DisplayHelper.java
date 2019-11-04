package com.inventoryManagementSystem;

import java.util.Scanner;

public class DisplayHelper {
    static int screenWidth = 50;

    public static void printHeader() {
        IMSController controller = IMSController.getInstance();
        DisplayHelper.printTextMiddleAligned("CS3343 Inventory Management System");
        if (controller != null) {
            Staff staff = controller.getStaff();
            System.out.println("Logged in as: " + staff.getName());
            System.out.println("User group: " + staff.getUserGroup().getGroupName());
        }
        DisplayHelper.printSeparationLine();
    }

    public static void printSeparationLine() {
        for (int i = 0; i < screenWidth; i++) System.out.print('=');
        System.out.print("\n");
    }

    public  static void printTextMiddleAligned(String text) {
        int spaceLength = (screenWidth - text.length()) / 2;
        for (int i = 0; i < spaceLength; i++) System.out.print(' ');
        System.out.print(text);
        System.out.print("\n");
    }

    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
//            Do nothing
        }
    }

    public  static void pressEnterToContinue() {
        System.out.println("Press Enter key to continue...");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }
}
