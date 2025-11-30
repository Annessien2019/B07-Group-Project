package com.example.smartair.model;

import java.util.Date;

public class CanisterLog extends Log{
    public enum CANISTER_LOG_MARKER {PARENT, CHILD};
    public int amount;
    public Date date;
    public CANISTER_LOG_MARKER marker;

    public CanisterLog(int amount, Date date, CANISTER_LOG_MARKER marker) {
        this.amount = amount;
        this.date = date;
        this.marker = marker;
    }
}
