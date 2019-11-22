package com.inventoryManagementSystem.Command;

import com.inventoryManagementSystem.DisplayHelper;
import com.inventoryManagementSystem.PriceChange;
import com.inventoryManagementSystem.Product;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CreateNewPriceChange implements IMSCommand {
    public int getMinPermission() {
        return 2;
    }

    public String getDescription() {
        return "Create new price change";
    }

    public void execute() {
        DisplayHelper.cls();
        DisplayHelper.printHeader();
        int id = getId();
        int productId = getProductId();
        double changeRate = getChangeRate();
        Date startDate = getStartDate();
        Date endDate = getEndDate(startDate);

        PriceChange newPriceChange = new PriceChange(id, productId, changeRate, startDate, endDate);
        PriceChange.addPriceChange(newPriceChange);

        System.out.println("Success!");
        DisplayHelper.pressEnterToContinue();
    }

    private static int getId() {
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("price change id: ");
                int id = scan.nextInt();

                if (PriceChange.getPriceChange(id) != null) {
                    System.out.println("id already exist!");
                    DisplayHelper.pressEnterToContinue();
                } else return id;
            } catch (Exception e) {
                System.out.println("Invalid input! id must be a number");
                DisplayHelper.pressEnterToContinue();
            }
        }
    }

    private static int getProductId() {
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("Product id: ");
                int id = scan.nextInt();

                if (Product.getProduct(id) == null) {
                    System.out.println("Product doesn't exist!");
                    DisplayHelper.pressEnterToContinue();
                } else return id;
            } catch (Exception e) {
                System.out.println("Invalid input! id must be a number");
                DisplayHelper.pressEnterToContinue();
            }
        }
    }


    private static double getChangeRate() {
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("Change rate: ");

                return scan.nextDouble();
            } catch (Exception e) {
                System.out.println("Invalid input! Change rate must be a number");
                DisplayHelper.pressEnterToContinue();
            }
        }
    }

    private static Date getStartDate() {
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("Start date (format: dd/MM/YYYY): ");
                String input = scan.nextLine();
                return new SimpleDateFormat("dd/MM/yyyy").parse(input);
            } catch (Exception e) {
                System.out.println("Invalid format!");
                DisplayHelper.pressEnterToContinue();
            }
        }
    }

    private static Date getEndDate(Date startDate) {
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("End date (format: dd/MM/YYYY): ");
                String input = scan.nextLine();
                Date endDate =  new SimpleDateFormat("dd/MM/yyyy").parse(input);
                if(endDate.before(startDate)){
                    System.out.println("End date should be later than start date!");
                    DisplayHelper.pressEnterToContinue();
                    continue;
                }
                return endDate;
            } catch (Exception e) {
                System.out.println("Invalid format!");
                DisplayHelper.pressEnterToContinue();
            }
        }
    }
}
