package com.example.smartair.view;

import java.util.Date;

public class InventoryItem {
    int remainingPuffs, startingPuffs;
    Date purchaseDate, expiryDate;

    public InventoryItem(int startingPuffs, int remainingPuffs, Date purchaseDate, Date expiryDate) {
        this.startingPuffs = startingPuffs;
        this.remainingPuffs = remainingPuffs;
        this.purchaseDate = purchaseDate;
        this.expiryDate = expiryDate;
    }

    public InventoryItem(int startingPuffs, Date purchaseDate, Date expiryDate) {
        this(startingPuffs, startingPuffs, purchaseDate, expiryDate);
    }
}
