package com.inventoryManagementSystem;

import java.util.Scanner;

public class DisplayHelper {
	private static final int screenWidth = 50;

	public static int getScreenWidth() {
		return screenWidth;
	}

	public static void printHeader() {
		IMSController controller = IMSController.getInstance();
		DisplayHelper.printTextMiddleAligned("CS3343 Inventory Management System");
		if (controller.getStaff() != null) {
			Staff staff = controller.getStaff();
			System.out.println("Logged in as: " + staff.getName());
		}
		DisplayHelper.printSeparationLine();
		System.out.println();
	}

	public static void printSeparationLine() {
		for (int i = 0; i < screenWidth; i++)
			System.out.print('=');
		System.out.print("\n");
	}

	public static void printTextMiddleAligned(String text) {
		int spaceLength = (screenWidth - text.length()) / 2;
		for (int i = 0; i < spaceLength; i++)
			System.out.print(' ');
		System.out.print(text + "\n");
	}

	public static void cls() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e) {
//            Do nothing
		}
	}

	public static void pressEnterToContinue() {
		System.out.println();
		System.out.println("Press Enter key to continue...");
		Scanner scan = new Scanner(System.in);
		try {
			scan.nextLine();
		} catch (Exception e) {
//          Do nothing
		}
	}
}
