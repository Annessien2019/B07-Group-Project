package com.example.smartair.model;


import java.util.Date;

public class MedicineLog extends Log {
    private String medicineType;
    private float doseCount;
    private Date date;

    public MedicineLog(String medicineType, float doseCount, Date date) {
        this.medicineType = medicineType;
        this.doseCount = doseCount;
        this.date = date;
    }

    public String getMedicineType() {
        return medicineType;
    }

    public float getDoseCount() {
        return doseCount;
    }

    public Date getDate() {
        return date;
    }
}
