package com.example.smartair.model;

import java.util.ArrayList;
import java.util.Date;

public class Canister {
    public int remainingPuffs, startingPuffs;
    public ArrayList<CanisterLog> logs;
    public Date purchaseDate, expiryDate;

    public Canister(int startingPuffs, int remainingPuffs, Date purchaseDate, Date expiryDate) {
        this.startingPuffs = startingPuffs;
        this.remainingPuffs = remainingPuffs;
        this.purchaseDate = purchaseDate;
        this.expiryDate = expiryDate;
        logs = new ArrayList<CanisterLog>();
        logs.add(new CanisterLog(remainingPuffs, new Date(2024, 12, 24),CanisterLog.CANISTER_LOG_MARKER.CHILD));
    }

    public Canister(int startingPuffs, Date purchaseDate, Date expiryDate) {
        this(startingPuffs, startingPuffs, purchaseDate, expiryDate);
    }
}
