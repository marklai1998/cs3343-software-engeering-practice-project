package com.inventoryManagementSystem.Commands;

import com.inventoryManagementSystem.Utils.DisplayHelper;
import com.inventoryManagementSystem.Modals.PriceChange;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ListAllPriceChange implements IMSCommand {
    public int getMinPermission() {
        return 0;
    }

    public String getDescription() {
        return "List all price change";
    }

    public void execute() {
        DisplayHelper.cls();
        DisplayHelper.printHeader();
        PriceChange[] priceChanges = PriceChange.getAllPriceChange();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (PriceChange priceChange : priceChanges) {
            System.out.println("id: " + priceChange.getId());
            System.out.println("Product id: " + priceChange.getProductId());
            System.out.println("Change rate: " + priceChange.getChangeRate());
            System.out.println("Start date: " + dateFormat.format(priceChange.getStartDate()));
            System.out.println("End date: " + dateFormat.format(priceChange.getEndDate()));
            System.out.println();
        }
        DisplayHelper.pressEnterToContinue();
    }
}
