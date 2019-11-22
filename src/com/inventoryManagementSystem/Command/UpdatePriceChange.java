package com.inventoryManagementSystem.Command;

import com.inventoryManagementSystem.DisplayHelper;
import com.inventoryManagementSystem.PriceChange;
import com.inventoryManagementSystem.Product;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UpdatePriceChange implements IMSCommand {
    public int getMinPermission() {
        return 2;
    }

    public String getDescription() {
        return "Update price change information";
    }

    public void execute() {
        DisplayHelper.cls();
        DisplayHelper.printHeader();
        int id = getId();
        PriceChange priceChange = PriceChange.getPriceChange(id);

        int productId = getProductId(priceChange.getProductId());
        double changeRate = getChangeRate(priceChange.getChangeRate());
        Date startDate = getStartDate(priceChange.getStartDate());
        Date endDate = getEndDate(startDate, priceChange.getEndDate());

        PriceChange newPriceChange = new PriceChange(id, productId, changeRate, startDate, endDate);
        PriceChange.updatePriceChange(newPriceChange);

        System.out.println("Success!");
        DisplayHelper.pressEnterToContinue();
    }

    private static int getId() {
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("price change id: ");
                int id = scan.nextInt();

                if (PriceChange.getPriceChange(id) == null) {
                    System.out.println("Price change not exist!");
                    DisplayHelper.pressEnterToContinue();
                } else return id;
            } catch (Exception e) {
                System.out.println("Invalid input! id must be a number");
                DisplayHelper.pressEnterToContinue();
            }
        }
    }

    private static int getProductId(int productId) {
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("Product id (" + productId + ") :");
                int id = scan.nextInt();

                if (Product.getProduct(id) == null) {
                    System.out.println("Product doesn't exist!");
                    DisplayHelper.pressEnterToContinue();
                } else return id;
            } catch (Exception e) {
                return productId;
            }
        }
    }


    private static double getChangeRate(double changeRate) {
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("Change rate (" + changeRate + ") :");

                return scan.nextDouble();
            } catch (Exception e) {
                return changeRate;
            }
        }
    }

    private static Date getStartDate(Date startDate) {
        while (true) {
            try {
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Scanner scan = new Scanner(System.in);
                System.out.println("Start date (format: dd/MM/YYYY) (" + dateFormat.format(startDate) + ") : ");
                String input = scan.nextLine();
                return new SimpleDateFormat("dd/MM/yyyy").parse(input);
            } catch (Exception e) {
                return startDate;
            }
        }
    }

    private static Date getEndDate(Date startDate, Date originalEndDate) {
        while (true) {
            try {
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Scanner scan = new Scanner(System.in);
                System.out.println("End date (format: dd/MM/YYYY) (" + dateFormat.format(originalEndDate) + ") :");
                String input = scan.nextLine();
                Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(input);
                if (endDate.before(startDate)) {
                    System.out.println("End date should be later than start date!");
                    DisplayHelper.pressEnterToContinue();
                    continue;
                }
                return endDate;
            } catch (Exception e) {
                return originalEndDate;
            }
        }
    }
}
